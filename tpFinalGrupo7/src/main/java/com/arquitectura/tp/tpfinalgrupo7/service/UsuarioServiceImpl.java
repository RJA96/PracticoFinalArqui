package com.arquitectura.tp.tpfinalgrupo7.service;

import com.arquitectura.tp.tpfinalgrupo7.model.Usuario;
import com.arquitectura.tp.tpfinalgrupo7.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  private UsuarioRepository usuarioRepository;
  private BCryptPasswordEncoder encoder;

  @Autowired
  public UsuarioServiceImpl(UsuarioRepository usuarioRepository, BCryptPasswordEncoder encoder) {
    this.usuarioRepository = usuarioRepository;
    this.encoder = encoder;
  }

  @Override
  public Usuario save(Usuario usuario) {
    String clave = encoder.encode(usuario.getContrasenia());
    usuario.setContrasenia(clave);
    return usuarioRepository.save(usuario);
  }

  @Override
  public Boolean existsByEmail(String email) {
    return usuarioRepository.existsByEmail(email);
  }

  @Override
  public Boolean existsByNombre(String nombre) {
    return usuarioRepository.existsByNombre(nombre);
  }

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    Optional<Usuario> usuario = usuarioRepository.findByNombre(name);
    List<GrantedAuthority> roles = new ArrayList<>();
    roles.add(new SimpleGrantedAuthority("ADMIN"));
    if (usuario.isPresent()) {
      UserDetails userDetails =
          new User(usuario.get().getNombre(), usuario.get().getContrasenia(), roles);
    } else {
      return null;
    }
    return null;
  }
}
