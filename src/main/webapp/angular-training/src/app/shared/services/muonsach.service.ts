import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MuonsachService {

  constructor(private http: HttpClient) { }

  getListMS(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/muonsach')
  }

  insertMS(data: any): Observable<any> {
    return this.http.post<any>("http://localhost:8080/muonsach", data);
  }
  updateMS(data: any, id: Number): Observable<any> {
    return this.http.put<any>("http://localhost:8080/muonsach/" + id, data);
  }

  deleteMS(id: Number) {
    return this.http.delete("http://localhost:8080/muonsach/" + id);
  }
}
