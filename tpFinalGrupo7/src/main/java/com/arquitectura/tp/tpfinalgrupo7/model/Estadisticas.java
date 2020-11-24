package com.arquitectura.tp.tpfinalgrupo7.model;

import java.io.Serializable;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
public class Estadisticas implements Serializable {
  private Integer cantidadDeViajes;
  private Integer cantidadDeKmsRecorridos;
  private Map<String, Integer> ciudadesVisitadas;
  private Map<String, Integer> paisesVisitados;
  private Long cantidadHorasDeVuelo;
  private Double huellaDeCarbono;
}
