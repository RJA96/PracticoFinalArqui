package com.arquitectura.tp.tpfinalgrupo7.utils;

import com.arquitectura.tp.tpfinalgrupo7.model.Usuario;
import com.arquitectura.tp.tpfinalgrupo7.repository.UsuarioRepository;
import com.arquitectura.tp.tpfinalgrupo7.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  private UsuarioService usuarioService;

  @Autowired
  public DataLoader(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }


  @Override
  public void run(ApplicationArguments args) throws Exception {
    //usuarioService.save(Usuario.builder().apellido("admin").email("admin@gmail.com").nombre("admin").contrasenia("admin").build());
  }
}
