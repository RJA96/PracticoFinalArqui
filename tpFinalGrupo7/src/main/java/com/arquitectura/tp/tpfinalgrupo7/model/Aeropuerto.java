package com.arquitectura.tp.tpfinalgrupo7.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Aeropuerto implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idAeropuerto;

  private String nombre;

  private String ciudad;

  private String pais;

  public static Aeropuerto fromId(Integer aeropuertoId) {
    Aeropuerto aeropuerto = new Aeropuerto();
    aeropuerto.idAeropuerto = aeropuertoId;
    return aeropuerto;
  }
}
