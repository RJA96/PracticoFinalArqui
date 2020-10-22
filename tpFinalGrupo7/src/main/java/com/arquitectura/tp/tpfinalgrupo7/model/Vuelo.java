package com.arquitectura.tp.tpfinalgrupo7.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class Vuelo extends Plan implements Serializable {
  @OneToOne
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("usuarioId")
  private Usuario usuario;

  private String aerolinea;

  private String aeronave;

  private String asiento;

  private String clase;

  private Integer codReserva;

  @OneToOne
  @JsonIdentityInfo(
      generator = ObjectIdGenerators.PropertyGenerator.class,
      property = "idAeropuerto")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("aeropuertoOrigenId")
  private Aeropuerto origen;

  @OneToOne
  @JsonIdentityInfo(
      generator = ObjectIdGenerators.PropertyGenerator.class,
      property = "idAeropuerto")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("aeropuertoDestinoId")
  private Aeropuerto destino;

  private Float distancia;

  private Integer puerta;

  @OneToMany(fetch = FetchType.EAGER)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idVuelo")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("escalaIds")
  private List<Vuelo> escalas = new ArrayList<>();

  @JsonProperty("usuarioId")
  public void setUsuarioId(Integer usuarioId) {
    this.usuario = Usuario.fromId(usuarioId);
  }

  @JsonIgnore
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  @JsonProperty("aeropuertoOrigenId")
  public void setAeropuertoOrigen(Integer aeropuertoId) {
    this.origen = Aeropuerto.fromId(aeropuertoId);
  }

  @JsonIgnore
  public void setOrigen(Aeropuerto origen) {
    this.origen = origen;
  }

  @JsonProperty("aeropuertoDestinoId")
  public void setAeropuertoDestino(Integer aeropuertoId) {
    this.destino = Aeropuerto.fromId(aeropuertoId);
  }

  @JsonIgnore
  public void setDestino(Aeropuerto destino) {
    this.destino = destino;
  }

  @JsonProperty("escalas")
  public void setEscalasId(List<Integer> escalasId) {
    this.escalas = escalasId.stream().map(Vuelo::fromId).collect(Collectors.toList());
  }

  @JsonIgnore
  public void setEscalas(List<Vuelo> vuelos) {
    this.escalas = vuelos;
  }

  public static Vuelo fromId(Integer id) {
    Vuelo vuelo = new Vuelo();
    vuelo.setId(id);
    return vuelo;
  }

  @Override
  public String getType() {
    return "Vuelo";
  }
}
