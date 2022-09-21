import { BanDocServiceService } from './../../../shared/services/ban-doc-service.service';
import { FormControl, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ban-doc',
  templateUrl: './ban-doc.component.html',
  styleUrls: ['./ban-doc.component.scss']
})
export class BanDocComponent implements OnInit {

  checkForm: boolean | undefined
  constructor(private service: BanDocServiceService, private fb: FormBuilder) { }

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
    this.formBD.reset();
  }
  onDelete(id: number) {
    this.service.deleteBd(id).subscribe(resp => {
      console.log("Ok pé")
      this.ngOnInit();
    });

  }

  formBD = this.fb.group({
    id: new FormControl(),
    ten: new FormControl(),
    sdt: new FormControl(),
    diaChi: new FormControl(),
    ngaySinh: new FormControl(),
    ngayTao: new Date(),
    hang: 1
  })

  onConfirm(item: any) {
    let c = confirm("Bạn có muốn xóa " + item.ten);
    if (c == true) {
      this.onDelete(item.id);
    }
  }

  onEdit(item: any) {
    this.formBD.patchValue(item);
    this.checkForm = true;
    console.log(item);
  }
  onSubmit() {
    if (this.formBD.getRawValue().id) {
      this.service.updateBd(this.formBD.getRawValue(), this.formBD.getRawValue().id).subscribe(resp => {
        console.log(this.formBD.getRawValue());
        this.ngOnInit();
      })
      return;
    }
    this.createBD(this.formBD.value);
    console.log(this.formBD.value)
  }
  createBD(data: any) {
    this.service.createBd(data).subscribe(resp => {
      console.log(resp);
      this.ngOnInit()
    })
  }

  cancelForm() {
    this.checkForm = false;
    this.formBD.reset();
  }

  resetForm() {
    this.formBD.reset();
  }


}
