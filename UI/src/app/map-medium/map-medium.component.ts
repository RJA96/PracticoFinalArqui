import { Component, OnInit, Input, ApplicationInitStatus, APP_INITIALIZER } from '@angular/core';
import { AppComponent } from '../app.component';
import { Plan } from '../model/plan';

@Component({
  selector: 'app-map-medium',
  templateUrl: './map-medium.component.html',
  styleUrls: ['./map-medium.component.css']
})
export class MapMediumComponent implements OnInit {
  @Input() pais : string;
  @Input() ciudad : string;
  @Input() planes : Plan;

  latitude : number;
  longitude : number;
  markers : any; // los marcadores de los planes

  constructor() { }

  ngOnInit(): void {
    this.pais = encodeURIComponent(this.pais.trim());
    this.ciudad = encodeURIComponent(this.ciudad.trim());
    let username = "tomasarras";
    let type = "json";
    let url = "http://api.geonames.org/search?q="+this.pais+"%20"+this.ciudad+"&username="+username+"&type="+type+"&maxRows=1";
    fetch(url)
    .then( (response) => response.json() )
    .then( (json) => {
      this.latitude = parseFloat(json.geonames[0].lat);
      this.longitude = parseFloat(json.geonames[0].lng);
      this.cargarCoordenadas();
    });
  }

  cargarCoordenadas() {
    // aca se deberia cargar los marcadores asignandole a cada uno las coordenadas de un plan
    // cuando tengamos planes
  }
}
