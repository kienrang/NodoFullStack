import { filter } from 'rxjs/operators';
import { NhaxuatbanService } from './../../../shared/services/nhaxuatban.service';
import { TacgiaService } from './../../../shared/services/tacgia.service';
import { FormBuilder, FormControl } from '@angular/forms';
import { SachService } from './../../../shared/services/sach.service';
import { Component, OnInit } from '@angular/core';
import { number } from 'echarts';

@Component({
  selector: 'app-sach',
  templateUrl: './sach.component.html',
  styleUrls: ['./sach.component.scss']
})
export class SachComponent implements OnInit {

  constructor(
    private service: SachService, private fb: FormBuilder, private serviceTG: TacgiaService, private serviceNXB: NhaxuatbanService) { }

  getAll: any
  listTg: any
  listNXB: any

  checkForm!: boolean
  ngOnInit(): void {
    this.checkForm = false;
    this.service.getList().subscribe(resp => {
      console.log(resp);
      this.getAll = resp;
    })

    this.serviceTG.getList().subscribe(resp => {
      this.listTg = resp;
    })
    this.serviceNXB.getList().subscribe(resp => {
      this.listNXB = resp;
    })

  }

  hienform() {
    this.checkForm = true;
    this.formSach.reset();
  }
  onDelete(id: number) {
    this.service.deleteSach(id).subscribe(resp => {
      console.log("Ok pé")
      this.ngOnInit();
    });

  }

  formSach = this.fb.group({
    id: new FormControl(),
    ten: new FormControl(),
    nhaXuatBan: new FormControl(),
    tacGia: new FormControl(),
    chuDe: new FormControl(),
    namXuatBan: new FormControl(),
    moTa: new FormControl(),
    soLuongConLai: new FormControl(),
    soLuongDangMuon: new FormControl(),
    tongSoLuong: new FormControl(),
  })

  onConfirm(item: any) {
    let c = confirm("Bạn có muốn xóa " + item.ten);
    if (c == true) {
      this.onDelete(item.id);
    }
  }

  onEdit(item: any) {
    this.formSach.patchValue({
      ten: item.ten,
      nhaXuatBan: item.nhaXuatBan,
      tacGia: item.tacGia.ten,
      chuDe: item.chuDe,
      namXuatBan: item.namXuatBan,
      moTa: item.moTa,
      soLuongConLai: item.soLuongConLai,
      soLuongDangMuon: item.soLuongDangMuon,
      tongSoLuong: item.tongSoLuong,
    });
    console.log(item)
    this.checkForm = true;
  }
  onSubmit() {
    if (this.formSach.getRawValue().id) {
      this.service.updateSach(this.formSach.getRawValue(), this.formSach.getRawValue().id).subscribe(resp => {
        this.ngOnInit();
      })
      return;
    }
    this.createSach(this.formSach.getRawValue());
    console.log('Sách', this.formSach.getRawValue());
  }
  createSach(data: any) {
    data.nhaXuatBan = this.getNXB(this.formSach.getRawValue().nhaXuatBan)[0];
    data.tacGia = this.getTacGiaById(this.formSach.getRawValue().tacGia)[0];
    console.log('ádasdasd', data)
    this.service.insertSach(data).subscribe(resp => {
      console.log(resp);
      this.ngOnInit()
    });
  }

  cancelForm() {
    this.checkForm = false;
    this.formSach.reset();
  }

  resetForm() {
    this.formSach.reset();
  }

  getTacGiaById(id: number) {
    return this.listTg.filter((x: { id: number; }) => x.id == id)
  }

  getNXB(id: number) {
    return this.listNXB.filter((x: { id: number; }) => x.id == id)
  }
}
