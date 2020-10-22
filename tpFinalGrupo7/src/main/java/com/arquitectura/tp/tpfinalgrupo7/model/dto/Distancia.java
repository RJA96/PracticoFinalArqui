package com.arquitectura.tp.tpfinalgrupo7.model.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Distancia implements Serializable {
  private List<Integer> distances;
  private int distance; // Leave the primitive value, so the default will be 0
}
