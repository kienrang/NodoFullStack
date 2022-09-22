import { NhaxuatbanService } from './../../../shared/services/nhaxuatban.service';
import { FormControl, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nhaxuatban',
  templateUrl: './nhaxuatban.component.html',
  styleUrls: ['./nhaxuatban.component.scss']
})
export class NhaxuatbanComponent implements OnInit {

  constructor(
    private service: NhaxuatbanService, private fb: FormBuilder) { }

  getAll: any

  checkStatus = false;

  checkForm!: boolean
  ngOnInit(): void {
    this.checkForm = false;
    this.service.getList().subscribe(resp => {
      this.getAll = resp;
      console.log(resp)
    })
  }

  hienform() {
    this.checkForm = true;
    this.formNXB.reset();
  }
  onDelete(id: number) {
    this.service.deleteNXB(id).subscribe(resp => {
      console.log("Ok pé")
      this.ngOnInit();
    });

  }

  formNXB = this.fb.group({
    id: [''],
    ten: ['', [Validators.required]],
    diaChi: ['', [Validators.required]],
    moTa: [''],
    trangThai: ['', [Validators.required]]
  })

  onConfirm(item: any) {
    let c = confirm("Bạn có muốn xóa " + item.ten);
    if (c == true) {
      this.onDelete(item.id);
    }
  }

  onEdit(item: any) {
    this.formNXB.patchValue({
      id: item.id,
      ten: item.ten,
      diaChi: item.diaChi,
      moTa: item.moTa,
      trangThai: item.trangThai
    }
    );
    this.checkStatus = !this.checkStatus
    this.checkForm = true;
    console.log(item);
  }
  onSubmit() {
    if (this.formNXB.getRawValue().id) {
      this.service.updateNXB(this.formNXB.getRawValue(), this.formNXB.getRawValue().id).subscribe(resp => {
        console.log(this.formNXB.getRawValue());
        this.ngOnInit();
      })
      return;
    }
    // this.createNXB(this.formNXB.value);
    console.log(this.formNXB.value)
  }
  createNXB(data: any) {
    this.service.createNXB(data).subscribe(resp => {
      console.log(resp);
      this.ngOnInit()
    })
  }

  cancelForm() {
    this.checkForm = false;
    this.formNXB.reset();
  }

  resetForm() {
    this.formNXB.reset();
  }

}
