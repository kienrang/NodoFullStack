import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BanDocServiceService {

  constructor(private http: HttpClient) { }

  getList(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/bandoc')
  };

  createBd(data: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/bandoc', data)
  }

  updateBd(data: any, id: number): Observable<any> {
    return this.http.put<any>('http://localhost:8080/bandoc/' + id, data)
  }

  deleteBd(id: number) {
    return this.http.delete('http://localhost:8080/bandoc/' + id);
  }
}
