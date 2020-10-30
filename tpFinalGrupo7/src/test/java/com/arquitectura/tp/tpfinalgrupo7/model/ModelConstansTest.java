package com.arquitectura.tp.tpfinalgrupo7.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Disabled;


public class ModelConstansTest {
  //Aeropuerto
  static final Integer idInt = 1;
  static final String nombre = "nombreTest";
  static final String ciudad = "ciudadTest";
  static final String pais = "paisTest";
  //Estadisticas
  static final Integer cantidadDeViajes = 1;
  static final Integer cantidadDeKmsRecorridos = 1;
  static final Map<String, Integer> ciudadesVisitadas = new HashMap<>();
  static final Map<String, Integer> paisesVisitados = new HashMap<>();
  static final Long cantidadHorasDeVuelo = Long.MAX_VALUE;
  static final Double huellaDeCarbono = Double.MAX_VALUE;
  //Usuarios
  static final String apellido = "apellidoTest";
  static final String contrasenia = "contraseniaTest";
  static final String email = "emailTest";
  static final List<Viaje> viajes = new ArrayList<>();
  //Viaje
  static final LocalDateTime ida = LocalDateTime.MIN;
  static final LocalDateTime vuelta = LocalDateTime.MAX;
  static final String destino = "destinoTest";
  static final String descripcion = "descripcionTest";
  static final List<Plan> planes = new ArrayList<>();
  static final List<Integer> planesInteger = new ArrayList<>();
  static final Usuario usuario = Usuario.builder()
      .idUsuario(idInt)
      .nombre(nombre)
      .apellido(apellido)
      .contrasenia(contrasenia)
      .email(email)
      .viajes(viajes)
      .build();
  //Vuelo
  static final String coordenada = "coordenadaTest";
  static final String aerolinea = "aerolineaTest";
  static final String aeronave = "aeronaveTest";
  static final String asiento = "asientoTest";
  static final String clase = "claseTest";
  static final Integer codReserva = 1;
  static final List<Vuelo> vuelosList = new ArrayList<>();
}
