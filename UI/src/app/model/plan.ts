export class Plan {
    idPlan: number;
    usuarioId: number;
    reserva: string;
    dia: string;
    horaInicio: string;
    horaFinalizacion: string;
    tipo: string;
  
    constructor(usuarioId: number, reserva: string, dia: string, horaInicio: string,horaFinalizacion : string, tipo: string) {
      this.usuarioId = usuarioId;
      this.reserva = reserva;
      this.dia = dia;
      this.horaInicio = horaInicio;
      this.horaFinalizacion = horaFinalizacion;
      this.tipo = tipo;
    }
  }
  