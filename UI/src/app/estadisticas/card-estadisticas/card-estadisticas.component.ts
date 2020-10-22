import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-card-estadisticas',
  templateUrl: './card-estadisticas.component.html',
  styleUrls: ['./card-estadisticas.component.css']
})
export class CardEstadisticasComponent implements OnInit {
  @Input() estadisticas: {
    titulo: string,
    resultados : []
  };

  constructor() { }

  ngOnInit(): void {
  }

}
