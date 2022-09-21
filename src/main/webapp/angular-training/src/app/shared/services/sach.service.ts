import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SachService {

  constructor(private http: HttpClient) { }

  getList(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/sach')
  }

  insertSach(data: any): Observable<any> {
    return this.http.post<any>("http://localhost:8080/sach", data);
  }
  updateSach(data: any, id: Number): Observable<any> {
    return this.http.put<any>("http://localhost:8080/sach/" + id, data);
  }

  deleteSach(id: Number) {
    return this.http.delete("http://localhost:8080/sach/" + id);
  }
}
