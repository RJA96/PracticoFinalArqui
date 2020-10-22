import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EstadisticasComponent } from './estadisticas/estadisticas.component';
import { ViajesComponent } from './viajes/viajes.component';


const routes: Routes = [
  
  {path: '', component: HomeComponent },
  {path: 'Inicio', component: HomeComponent },
  {path: 'Estadisticas', component: EstadisticasComponent},
  {path: 'Viajes', component: ViajesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
