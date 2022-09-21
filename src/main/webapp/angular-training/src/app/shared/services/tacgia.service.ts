import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TacgiaService {

  constructor(private http: HttpClient) { }

  getList(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/tacgia')
  }

  createTg(data: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/tacgia', data);
  }

  updateTg(data: any, id: number) {
    return this.http.put<any>('http://localhost:8080/tacgia/' + id, data);
  }
  deleteTg(id: number) {
    return this.http.delete('http://localhost:8080/tacgia/' + id);
  }
}
