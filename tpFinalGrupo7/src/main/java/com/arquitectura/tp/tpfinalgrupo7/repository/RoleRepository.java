package com.arquitectura.tp.tpfinalgrupo7.repository;

import com.arquitectura.tp.tpfinalgrupo7.model.ERole;
import com.arquitectura.tp.tpfinalgrupo7.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
