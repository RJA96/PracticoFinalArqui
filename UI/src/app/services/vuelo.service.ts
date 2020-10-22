import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VueloService {

  URL = environment.apiUrl + '/vuelo'

  constructor(private httpClient: HttpClient) { }

  findById(id:number) {
    return this.httpClient.get(this.URL + "/" + id);
  }
}
