package com.arquitectura.tp.tpfinalgrupo7.repository;

import com.arquitectura.tp.tpfinalgrupo7.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

  Optional<Usuario> findByNombre(String nombre);

  Boolean existsByNombre(String nombre);


  Boolean existsByEmail(String email);
}
