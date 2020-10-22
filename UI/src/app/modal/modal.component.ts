import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { Viaje } from '../model/viaje';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  mostrarModal = false;
  viaje : Viaje;
  @Input() txtBoton : string;
  error : boolean= false;
  @Input() titulo : string;
  @Input() url : string;
  @Input() viajeAEditar : Viaje;
  @Output() editViaje = new EventEmitter<object>();
  @Output() datosViaje = new EventEmitter<object>();

  constructor() {
    this.viajeAEditar = new Viaje(0, new Date,new Date,[1], 'Nombre..', 'Turquia...', 'Descripcion..');
   }

  getDatos(nombre, destino, ida, vuelta, descripcion){
      console.log(ida.viewModel != "");
      if(ida.viewModel != ""&& vuelta.viewModel != "" && nombre.viewModel != "" && descripcion.viewModel != "" && destino.viewModel != ""){
        this.viaje = new Viaje(1, ida.viewModel, vuelta.viewModel, [1], nombre.viewModel, destino.viewModel, descripcion.viewModel);
        this.mostrarModal = false;
        this.datosViaje.emit(this.viaje); 
      }else{
        this.error = true;
      }
  }

  editarViaje(nombre, destino, ida, vuelta, descripcion){
    if (nombre.viewModel){
      this.viajeAEditar.nombre = nombre.viewModel;
    }
    if (destino.viewModel){
      this.viajeAEditar.destino = destino.viewModel;
    }
    if (ida.viewModel){
      this.viajeAEditar.ida = ida.viewModel;
    }
    if (vuelta.viewModel){
      this.viajeAEditar.vuelta = vuelta.viewModel;
    }
    if (descripcion.viewModel){
      this.viajeAEditar.descripcion = descripcion.viewModel;
    }
    //this.viajeAEditar = new Viaje(1, this.viajeAEditar.ida, this.viajeAEditar.vuelta, [1], this.viajeAEditar.nombre, this.viajeAEditar.destino, this.viajeAEditar.descripcion, this.viajeAEditar.idViaje);
    this.editViaje.emit(this.viajeAEditar);
  }

  ngOnInit(): void {

  }

}
