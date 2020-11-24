package com.arquitectura.tp.tpfinalgrupo7.model;

import java.util.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class modelTest extends ModelConstansTest {

  @Test
  void testAeropuertoShuldSetAllAtributes() {
    Aeropuerto aeropuerto =
        Aeropuerto.builder().idAeropuerto(idInt).nombre(nombre).ciudad(ciudad).pais(pais).build();
    Aeropuerto aeropuerto1 = new Aeropuerto(idInt, nombre, ciudad, pais);
    Aeropuerto aeropuerto2 = new Aeropuerto();
    Aeropuerto aeropuerto3 = Aeropuerto.builder().idAeropuerto(1).build();
    aeropuerto2.setCiudad(ciudad);
    Assertions.assertEquals(aeropuerto3, Aeropuerto.fromId(idInt));
    Assertions.assertEquals(ciudad, aeropuerto2.getCiudad());
    Assertions.assertEquals(idInt, aeropuerto.getIdAeropuerto());
    Assertions.assertEquals(nombre, aeropuerto.getNombre());
    Assertions.assertEquals(ciudad, aeropuerto.getCiudad());
    Assertions.assertEquals(pais, aeropuerto.getPais());
    Assertions.assertEquals(aeropuerto, aeropuerto1);
  }


  @Test
  void usuarioShuldSetAllAtributes() {
    Usuario usuario =
        Usuario.builder()
            .idUsuario(idInt)
            .nombre(nombre)
            .apellido(apellido)
            .contrasenia(contrasenia)
            .email(email)
            .viajes(viajes)
            .roles(new HashSet<>())
            .build();
    Usuario usuario1 = new Usuario(idInt, nombre, apellido, contrasenia, email, viajes,new HashSet<>());
    Usuario usuario2 = new Usuario();
    usuario2.setIdUsuario(idInt);
    Assertions.assertEquals(usuario2, Usuario.fromId(idInt));
    usuario2.setApellido(apellido);
    Assertions.assertEquals(apellido, usuario2.getApellido());
    Assertions.assertEquals(usuario, usuario1);
    Assertions.assertEquals(idInt, usuario.getIdUsuario());
    Assertions.assertEquals(idInt, usuario1.getIdUsuario());
  }

  @Test
  void viejoShouldSetAllAttributes() {
    Viaje viaje =
        Viaje.builder()
            .idViaje(idInt)
            .ida(ida)
            .vuelta(vuelta)
            .nombre(nombre)
            .destino(destino)
            .descripcion(descripcion)
            .planes(planes)
            .usuario(usuario)
            .build();
    Viaje viaje1 =
        new Viaje(
            idInt,
            ida,
            vuelta,
            nombre,
            destino,
            descripcion,
            usuario,
            planes);
    Viaje viaje2 = new Viaje();
    viaje2.setIdViaje(idInt);
    viaje2.setVuelos(planes);
    viaje2.setPlanes(planesInteger);
    viaje2.setUsuarioId(idInt);
    viaje2.setUsuario(usuario);

    Assertions.assertEquals(viaje,viaje1);
    Assertions.assertEquals(idInt,viaje.getIdViaje());
    Assertions.assertEquals(ida,viaje1.getIda());

    Assertions.assertEquals(usuario,viaje2.getUsuario());
    Assertions.assertEquals(planes,viaje2.getPlanes());
  }

  @Test
  void vueloShouldSetAllAttributes(){
    Vuelo vuelo = new Vuelo();
    vuelo.setId(idInt);
    vuelo.setName(nombre);
    vuelo.setInicio(ida);
    vuelo.setFin(vuelta);
    vuelo.setCoordenada(coordenada);
    vuelo.setUsuario(usuario);
    vuelo.setUsuarioId(usuario.getIdUsuario());
    vuelo.setAeropuertoOrigen(idInt);
    vuelo.setOrigen(Aeropuerto.builder().build());
    vuelo.setAeropuertoDestino(idInt);
    vuelo.setDestino(Aeropuerto.builder().build());
    vuelo.setEscalasId(planesInteger);
    vuelo.setEscalas(vuelosList);

    Vuelo vuelo1 = Vuelo.fromId(idInt);

    Assertions.assertEquals(idInt,vuelo1.getId());
    Assertions.assertEquals("Vuelo",vuelo.getType());
  }

}
