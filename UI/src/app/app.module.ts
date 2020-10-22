import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from './modal/modal.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { VtableComponent } from './vtable/vtable.component';
import { TableModule } from 'primeng/table';
import { DropdownModule } from 'primeng/dropdown';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ViajeService } from './services/viaje.service';
import { VueloService } from './services/vuelo.service';
import { BurgerOptionsComponent } from './burger-options/burger-options.component';
import { EstadisticasComponent } from './estadisticas/estadisticas.component';
import { CardEstadisticasComponent } from './estadisticas/card-estadisticas/card-estadisticas.component';
import { MapMediumComponent } from './map-medium/map-medium.component';
import { ViajesComponent } from './viajes/viajes.component';
import { InfoViajeComponent } from './info-viaje/info-viaje.component';
import { AgmCoreModule } from '@agm/core';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ModalComponent,
    NavComponent,
    FooterComponent,
    VtableComponent,
    BurgerOptionsComponent,
    EstadisticasComponent,
    CardEstadisticasComponent,
    MapMediumComponent,
    ViajesComponent,
    InfoViajeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    NgbModule,
    TableModule,
    DropdownModule,
    FormsModule,
    HttpClientModule,
    AgmCoreModule.forRoot({
      apiKey : "AIzaSyCeaTl0-32_CVLkgkkl1Q-dp4LkEEsbepI"// google maps
    })
  ],
  providers: [ ViajeService, VueloService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
