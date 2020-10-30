package com.arquitectura.tp.tpfinalgrupo7.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public abstract class Plan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  protected Integer id;

  protected String name;

  protected LocalDateTime inicio;

  protected LocalDateTime fin;

  protected String coordenada;

  public abstract String getType();
}
