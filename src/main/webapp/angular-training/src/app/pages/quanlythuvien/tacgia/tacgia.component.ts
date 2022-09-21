import { TacgiaService } from './../../../shared/services/tacgia.service';
import { FormControl, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tacgia',
  templateUrl: './tacgia.component.html',
  styleUrls: ['./tacgia.component.scss']
})
export class TacgiaComponent implements OnInit {

  checkForm: boolean | undefined
  constructor(private service: TacgiaService, private fb: FormBuilder) { }

  getAll: any

  ngOnInit(): void {
    this.checkForm = false;
    this.service.getList().subscribe(resp => {
      this.getAll = resp;
      console.log(resp)
    })
  }

  hienform() {
    this.checkForm = true;
    this.formTg.reset();
  }
  onDelete(id: number) {
    this.service.deleteTg(id).subscribe(resp => {
      console.log("Ok pé")
      this.ngOnInit();
    });

  }

  formTg = this.fb.group({
    id: new FormControl(),
    ten: new FormControl(),
    sdt: new FormControl(),
    diaChi: new FormControl(),
    moTa: new FormControl(),
  })

  onConfirm(item: any) {
    let c = confirm("Bạn có muốn xóa " + item.ten);
    if (c == true) {
      this.onDelete(item.id);
    }
  }

  onEdit(item: any) {
    this.formTg.patchValue(item);
    this.checkForm = true;
    console.log(item);
  }
  onSubmit() {
    if (this.formTg.getRawValue().id) {
      this.service.updateTg(this.formTg.getRawValue(), this.formTg.getRawValue().id).subscribe(resp => {
        console.log(this.formTg.getRawValue());
        this.ngOnInit();
      })
      return;
    }
    this.createBD(this.formTg.value);
    console.log(this.formTg.value)
  }
  createBD(data: any) {
    this.service.createTg(data).subscribe(resp => {
      console.log(resp);
      this.ngOnInit()
    })
  }

  cancelForm() {
    this.checkForm = false;
    this.formTg.reset();
  }

  resetForm() {
    this.formTg.reset();
  }

}
