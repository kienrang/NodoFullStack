import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NhaxuatbanService {

  constructor(private http: HttpClient) {

  }
  // Tạo các phương thức
  getList(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/nxb')
  }

  createNXB(data: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/nxb', data);
  }
  deleteNXB(id: number) {
    return this.http.delete('http://localhost:8080/nxb/' + id);
  }
  updateNXB(data: any, id: number) {
    return this.http.put<any>('http://localhost:8080/nxb/' + id, data);
  }
}
