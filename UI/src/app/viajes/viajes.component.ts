import { Component, OnInit } from '@angular/core';
import { PlanService } from '../services/plan.service';
import { Plan } from '../model/plan';

@Component({
  selector: 'app-viajes',
  templateUrl: './viajes.component.html',
  styleUrls: ['./viajes.component.css']
})
export class ViajesComponent implements OnInit {
  plan : Plan;
  planes : Plan[];
  paisDestino = "argentina";// A modo de ejemplo
  ciudadDestino = "tandil";
  url = 'http://localhost:8080/plan';
  constructor(private planService: PlanService) { }

  ngOnInit(): void {
    //this.getPlanes(); el servicio de planes todavia no esta disponible
      let ds = new Plan(1,"Continental","02/05 Lunes","12:00","17:00","Excursion");
      this.planes = new Array;
      this.planes.push(ds);
      this.planes.push(ds);
      this.planes.push(ds);
      this.planes.push(ds);
  }

  getPlanes() {
    /*this.planService.findAll().subscribe(planes => {
      this.planes = planes as Plan;
    });*/
  }
  agregarViaje(x){
    this.planService.save(x)
      .subscribe(e => this.getPlanes());
  }
  editar(x){
    this.planService.update(x)
      .subscribe(e => this.getPlanes());
  }
}
