import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Plan } from '../model/plan';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PlanService {

  URL = environment.apiUrl + '/plan';

  constructor(private httpClient: HttpClient) { }

  findAll() {
    return this.httpClient.get(this.URL);
  }

  findById(id:number) {
    return this.httpClient.get(this.URL + "/" + id);
  }

  save(json: Plan) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.httpClient.post(this.URL, json, httpOptions);
  }

  update(json : Plan){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.httpClient.put(this.URL, json, httpOptions);
  }
}
