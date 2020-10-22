import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-estadisticas',
  templateUrl: './estadisticas.component.html',
  styleUrls: ['./estadisticas.component.css']
})
export class EstadisticasComponent implements OnInit {

  public estadisticas : any[] = [
    {
      'titulo': 'Paises visitados',
      'resultados': [
        {
          'pais': 'Argentina',
          'porcentaje': '100%'
        },
        {
          'pais': 'Argentina',
          'porcentaje': '100%'
        },
        {
          'pais': 'Argentina',
          'porcentaje': '100%'
        },
        {
          'pais': 'Argentina',
          'porcentaje': '100%'
        }]
  }];



  constructor() {
    this.estadisticas[0] = {
      'titulo': 'Paises visitados',
      'resultados': [
        {
          'pais': 'Argentina',
          'porcentaje': '100%'
        },
        {
          'pais': 'Brasil',
          'porcentaje': '70%'
        },
        {
          'pais': 'Paraguay',
          'porcentaje': '30%'
        },
        {
          'pais': 'Otros',
          'porcentaje': '10%'
        }]
    };
    this.estadisticas.push({
      'titulo': 'Kilometros recorridos',
      'resultados': [
        {
          'pais': 'Argentina',
          'porcentaje': '5128,43'
        },
        {
          'pais': 'Brasil',
          'porcentaje': '3702,39'
        },
        {
          'pais': 'Paraguay',
          'porcentaje': '1487,54'
        },
        {
          'pais': 'Otros',
          'porcentaje': '1353,89'
        }]
    });
    this.estadisticas.push({
      'titulo': 'Cantidad de dias',
      'resultados': [
        {
          'pais': 'Argentina',
          'porcentaje': '4 meses y 25 dias'
        },
        {
          'pais': 'Brasil',
          'porcentaje': '2 meses y 50 dias'
        },
        {
          'pais': 'Paraguay',
          'porcentaje': '2 meses'
        },
        {
          'pais': 'Otros',
          'porcentaje': '25 dias'
        }]
    });
    this.estadisticas.push({
      'titulo': 'Generales',
      'resultados': [
        {
          'pais': 'Años',
          'porcentaje': '1 año y 5 dias'
        },
        {
          'pais': 'Km ',
          'porcentaje': '11.795,66'
        },
        {
          'pais': 'Ciudades',
          'porcentaje': '254'
        },
        {
          'pais': 'Contaminacion',
          'porcentaje': '3 TON/CO2/año'
        }]
    });

  }


  ngOnInit(): void {
  }

}
