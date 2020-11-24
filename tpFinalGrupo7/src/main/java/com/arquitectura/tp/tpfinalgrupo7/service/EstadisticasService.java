package com.arquitectura.tp.tpfinalgrupo7.service;

import com.arquitectura.tp.tpfinalgrupo7.model.Estadisticas;
import com.arquitectura.tp.tpfinalgrupo7.model.Usuario;
import com.arquitectura.tp.tpfinalgrupo7.model.Viaje;
import com.arquitectura.tp.tpfinalgrupo7.model.Vuelo;
import com.arquitectura.tp.tpfinalgrupo7.model.dto.Distancia;
import com.arquitectura.tp.tpfinalgrupo7.repository.UsuarioRepository;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@NoArgsConstructor
public class EstadisticasService {

    private ViajeService viajeService;
    private UsuarioRepository usuarioRepository;
    private RestTemplate restTemplate = new RestTemplate();
    private final Double HUELLA_POR_KM = 0.1;


    @Autowired
    public EstadisticasService(ViajeService viajeService, UsuarioRepository usuarioRepository) {
        this.viajeService = viajeService;
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Distance between two or more cities
     * @param cities E.g: buenos aires|Olavarria|tandil
     * @return
     */
    protected int getDistanceBetweenCities(String cities) {
        try {
            Distancia distance = restTemplate.getForObject("https://www.distancia.co/route.json?stops=" + cities, Distancia.class);
            return distance.getDistance();
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalArgumentException("Una de las ciudades proporcionadas no existe");
        }
    }

    /**
     * Search for cities in the Vuelos and in the escalas of those ones and sums the kms
     * @param viajeId of Viaje
     * @return traveled kms
     */
    public int getTraveledKmsByViaje(Integer viajeId) {
        List<Vuelo> vuelos = getVuelosByViaje(viajeId);
        int distance = 0;
        for(Vuelo v: vuelos) {
            String cities = v.getOrigen().getCiudad();
            for (Vuelo escala : v.getEscalas()) {
                cities = cities + "|"+ escala.getOrigen().getCiudad() + "|" + escala.getDestino().getCiudad();
            }
            cities = cities + "|" + v.getDestino().getCiudad();
            distance += getDistanceBetweenCities(cities);
        }
        return distance;
    }

    private List<Vuelo> getVuelosByViaje(Integer viajeId) {
        Viaje viaje = viajeService.findById(viajeId);
        return viaje.getPlanes().stream()
                .filter(x -> x.getType().equals("Vuelo"))
                .map(x -> (Vuelo) x)
                .collect(Collectors.toList());
    }

    /**
     * Search for cities in the Vuelos and in the escalas of those ones
     * @param viajeId
     * @return Set of visited cities
     */
    public Set<String> getVisitedCitiesByViaje(Integer viajeId) {
        List<Vuelo> vuelos = getVuelosByViaje(viajeId);
        Set<String> cities = new HashSet<>();
        for(Vuelo v: vuelos) {
            cities.add(v.getOrigen().getCiudad());
            for (Vuelo escala : v.getEscalas()) {
                cities.add(escala.getOrigen().getCiudad());
                cities.add(escala.getDestino().getCiudad());
            }
            cities.add(v.getDestino().getCiudad());
        }
        return cities;
    }

    public Double getHuellaCarbono(Integer viajeId) {
        List<Vuelo> vuelos = getVuelosByViaje(viajeId);
        Integer kilometros = getTraveledKmsByViaje(viajeId);
        return kilometros * HUELLA_POR_KM;
    }

    public Long getHorasVuelo(Integer viajeId) {
        List<Vuelo> vuelos = getVuelosByViaje(viajeId);
        Long duracion = 0L;
        for(Vuelo v: vuelos) {
            duracion += ChronoUnit.HOURS.between(v.getInicio(),v.getFin());
        }
        return duracion;
    }

    public int getCantidadDeViajesByUser(Integer userId) {
        Optional<Usuario> byId = usuarioRepository.findById(userId);
        if(byId.isPresent()) {
            return byId.get().getViajes().size();
        }
        throw new IllegalArgumentException("User doesn't exists for given ID");
    }

    public Set<String> getVisitedCountriesByViaje(Integer viajeId) {
        List<Vuelo> vuelos = getVuelosByViaje(viajeId);
        Set<String> cities = new HashSet<>();
        for(Vuelo v: vuelos) {
            cities.add(v.getOrigen().getPais());
            for (Vuelo escala : v.getEscalas()) {
                cities.add(escala.getOrigen().getPais());
                cities.add(escala.getDestino().getPais());
            }
            cities.add(v.getDestino().getPais());
        }
        return cities;
    }

    public Estadisticas getAllEstadisticasByUserId(int userId) {
        Usuario user = this.usuarioRepository.findById(userId)
                .orElseThrow(IllegalArgumentException::new);
        // Cantidad de viajes
        List<Viaje> viajes = user.getViajes();

        // Cantidad de kms
        int cantidadDeKmsRecorridos = viajes.stream()
                .map(x -> this.getTraveledKmsByViaje(x.getIdViaje()))
                .reduce((x, y) -> x + y)
                .orElse(0);

        // Ciudades visitadas
        List<Vuelo> vuelosDeViajes = viajes.stream().map(x -> x.getPlanes())
                .reduce((x, y) -> {
                    x.addAll(y);
                    return x;
                })
                .orElse(Collections.emptyList())
                .stream()
                .filter(x -> x.getType().equals("Vuelo"))
                .map(x -> (Vuelo) x)
                .collect(Collectors.toList());

        Map<String, Integer> ciudadesVisitadas = new HashMap<>();
        vuelosDeViajes.forEach(x -> {
            Integer obj = ciudadesVisitadas.get(x.getDestino().getCiudad());
            if(Objects.nonNull(obj)) {
                ciudadesVisitadas.put(x.getDestino().getCiudad(), obj++);
            } else ciudadesVisitadas.put(x.getDestino().getCiudad(), 1);
        });

        // Paises visitados
        Map<String, Integer> paisesVisitados = new HashMap<>();
        vuelosDeViajes.forEach(x -> {
            Integer obj = paisesVisitados.get(x.getDestino().getPais());
            if(Objects.nonNull(obj)) {
                paisesVisitados.put(x.getDestino().getPais(), obj++);
            } else paisesVisitados.put(x.getDestino().getPais(), 1);
        });

        // Huella de carbono
        double huellaDeCarbono = viajes.stream()
                .map(x -> getHuellaCarbono(x.getIdViaje()))
                .reduce((x,y) -> x+y)
                .orElse(0D);

        // Horas de vuelo
        Long horasDeVuelo = viajes.stream()
                .map(x -> getHorasVuelo(x.getIdViaje()))
                .reduce((x,y) -> x+y)
                .orElse(0L);

        Estadisticas estadisticas = new Estadisticas();
        estadisticas.setCantidadDeKmsRecorridos(cantidadDeKmsRecorridos);
        estadisticas.setCantidadDeViajes(viajes.size());
        estadisticas.setCantidadHorasDeVuelo(horasDeVuelo);
        estadisticas.setHuellaDeCarbono(huellaDeCarbono);
        estadisticas.setPaisesVisitados(paisesVisitados);
        estadisticas.setCiudadesVisitadas(ciudadesVisitadas);
        return estadisticas;
    }
}
