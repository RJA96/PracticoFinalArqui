package com.arquitectura.tp.tpfinalgrupo7.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Usuario implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idUsuario;

  private String nombre;

  private String apellido;

  private String contrasenia;

  private String email;

  @OneToMany(
      mappedBy = "usuario",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.EAGER)
  private List<Viaje> viajes;

  public static Usuario fromId(Integer idUsuario) {
    Usuario usuario = new Usuario();
    usuario.setIdUsuario(idUsuario);
    return usuario;
  }
}
