import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Pfe } from './pfe';
@Injectable({
  providedIn: 'root'
})
export class PfeService {
 
 
  private baseUrl = 'http://localhost:8080/pfes'
  private baseUrl2= 'http://localhost:8080/categories'
  constructor(private http: HttpClient) {}
    getPfesList(): Observable<any> {
      return this.http.get(`${this.baseUrl}`);
    }
    deletePfe(id: number): Observable<any> {
      return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
    }
    findByTitle(titre: any): Observable<any> {
      return this.http.get<Pfe[]>(`${this.baseUrl}?titre=${titre}`);
    }
    createPfe(pfe:Object): Observable<any> {
      return this.http.post(this.baseUrl, pfe);
    }
    getCategories(): Observable<any> {
      return this.http.get(`${this.baseUrl2}`);
    }
    findByCategoryId(id:number):Observable<any>{
      return this.http.get<Pfe[]>(`${this.baseUrl}?id=${id}`);
    }
    findByTitleAndCategoryId(id:number,titre:any):Observable<any>{
      return this.http.get<Pfe[]>(`${this.baseUrl}?id_cat=${id}&titre=${titre}`);
    }
    count(id:number){
      if(id === null || id == 0){
        return this.http.get(`${this.baseUrl}/count`);

      }else{
        return this.http.get(`${this.baseUrl}/count?id=${id}`);

      }
    }
}
