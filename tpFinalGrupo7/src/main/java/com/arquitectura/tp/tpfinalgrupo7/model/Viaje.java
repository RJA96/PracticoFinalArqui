package com.arquitectura.tp.tpfinalgrupo7.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Viaje implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idViaje;

  private LocalDateTime ida;

  private LocalDateTime vuelta;

  private String nombre;

  private String destino;

  private String descripcion;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("usuarioId")
  @JoinColumn(name = "idUsuario")
  private Usuario usuario;

  @ManyToMany(fetch = FetchType.EAGER)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  @JsonProperty("planesIds")
  private List<Plan> planes = new ArrayList<>();

  @JsonIgnore
  public void setVuelos(List<Plan> vuelos) {
    this.planes = vuelos;
  }

  @JsonProperty("planesIds")
  public void setPlanes(List<Integer> planesIds) {
    this.planes = planesIds.stream()
        .map(Vuelo::fromId)
        .collect(Collectors.toList());
  }

  @JsonProperty("usuarioId")
  public void setUsuarioId(Integer usuarioId) {
    this.usuario = Usuario.fromId(usuarioId);
  }

  @JsonIgnore
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
