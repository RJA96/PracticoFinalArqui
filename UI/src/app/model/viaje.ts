export class Viaje {
  idViaje: number;
  usuarioId: number;
  ida: Date;
  vuelta: Date;
  vuelosIds: number[];
  nombre: string;
  destino: string;
  descripcion: string;

  constructor(usuarioId: number, ida: Date, vuelta: Date, vuelosIds: number[], nombre: string, destino: string, descripcion: string, idViaje?: number) {
    this.usuarioId = usuarioId;
    this.ida = ida;
    this.vuelta = vuelta;
    this.vuelosIds = vuelosIds;
    this.nombre = nombre;
    this.destino = destino;
    this.descripcion = descripcion;
    this.idViaje = idViaje;
  }
}
