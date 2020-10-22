import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Viaje } from '../model/viaje';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ViajeService {

  URL = environment.apiUrl + '/viaje';

  constructor(private httpClient: HttpClient) { }

  findAll() {
    return this.httpClient.get(this.URL);
  }

  findById(id:number) {
    return this.httpClient.get(this.URL + "/" + id);
  }

  save(json: Viaje) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.httpClient.post(this.URL, json, httpOptions);
  }

  update(json : Viaje){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.httpClient.put(this.URL, json, httpOptions);
  }
}
