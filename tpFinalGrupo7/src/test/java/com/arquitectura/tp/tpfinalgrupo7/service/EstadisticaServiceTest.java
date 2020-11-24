package com.arquitectura.tp.tpfinalgrupo7.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.arquitectura.tp.tpfinalgrupo7.model.dto.Distancia;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class EstadisticaServiceTest {
  @InjectMocks
  EstadisticasService estadisticasService;

  @Mock
  RestTemplate restTemplate;
  @Test
  public void getDistanceBetweenCitiesShouldReturnOk() {
    Distancia response = new Distancia();
    response.setDistance(1);
    when(restTemplate.getForObject(any(),any())).thenReturn(response);
    Assert.assertNotNull(estadisticasService.getDistanceBetweenCities("Test"));
  }



}
