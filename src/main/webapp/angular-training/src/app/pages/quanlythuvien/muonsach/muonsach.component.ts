import { MuonsachService } from './../../../shared/services/muonsach.service';
import { BanDocServiceService } from './../../../shared/services/ban-doc-service.service';
import { FormBuilder, FormControl } from '@angular/forms';
import { SachService } from './../../../shared/services/sach.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-muonsach',
  templateUrl: './muonsach.component.html',
  styleUrls: ['./muonsach.component.scss']
})
export class MuonsachComponent implements OnInit {

  constructor(
    private service: MuonsachService, private fb: FormBuilder, private SachService: SachService, private serviceBD: BanDocServiceService) { }

  getAll: any
  listSach: any
  listBD: any

  checkForm!: boolean
  ngOnInit(): void {
    this.checkForm = false;
    this.service.getListMS().subscribe(resp => {
      console.log(resp);
      this.getAll = resp;
    })

    this.SachService.getList().subscribe(resp => {
      this.listSach = resp;
    })
    this.serviceBD.getList().subscribe(resp => {
      this.listBD = resp;
    })

  }

  hienform() {
    this.checkForm = true;
    this.formMS.reset();
  }
  onDelete(id: number) {
    this.service.deleteMS(id).subscribe(resp => {
      console.log("Ok pé")
      this.ngOnInit();
    });

  }

  formMS = this.fb.group({
    id: new FormControl(),
    banDoc: new FormControl(),
    sach: new FormControl(),
    soLuong: new FormControl(),
    ngayMuon: new FormControl(),
    ngayTra: new FormControl(),
    trangThai: new FormControl(),
    ghiChu: new FormControl(),
  })

  onConfirm(item: any) {
    let c = confirm("Bạn có muốn xóa " + item.banDoc.ten + "khỏi danh sách mượn sách không?");
    if (c == true) {
      this.onDelete(item.id);
    }
  }

  onEdit(item: any) {
    this.formMS.patchValue(item);
    console.log(item)
    this.checkForm = true;
  }
  onSubmit() {
    if (this.formMS.getRawValue().id) {
      this.service.updateMS(this.formMS.getRawValue(), this.formMS.getRawValue().id).subscribe(resp => {
        this.ngOnInit();
      })
      return;
    }
    this.createMS(this.formMS.getRawValue());
    // console.log('MS', this.formMS.getRawValue());
  }
  createMS(data: any) {
    data.banDoc = this.getBanDoc(this.formMS.getRawValue().banDoc)[0];
    data.sach = this.getSach(this.formMS.getRawValue().sach)[0];
    console.log('ádasdasd', data)
    this.service.insertMS(data).subscribe(resp => {
      console.log(resp);
      this.ngOnInit()
    });
  }

  cancelForm() {
    this.checkForm = false;
    this.formMS.reset();
  }

  resetForm() {
    this.formMS.reset();
  }

  getBanDoc(id: number) {
    return this.listBD.filter((x: { id: number; }) => x.id == id)
  }

  getSach(id: number) {
    return this.listSach.filter((x: { id: number; }) => x.id == id)
  }

}
