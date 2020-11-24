package com.arquitectura.tp.tpfinalgrupo7.service;

import com.arquitectura.tp.tpfinalgrupo7.model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RestController;

public interface UsuarioService extends UserDetailsService {

  Usuario save(Usuario usuario);

  Boolean existsByEmail(String email);

  Boolean existsByNombre(String nombre);

}
