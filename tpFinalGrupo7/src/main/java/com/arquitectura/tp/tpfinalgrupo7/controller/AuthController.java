package com.arquitectura.tp.tpfinalgrupo7.controller;

import com.arquitectura.tp.tpfinalgrupo7.controller.request.LoginRequest;
import com.arquitectura.tp.tpfinalgrupo7.controller.request.SignupRequest;
import com.arquitectura.tp.tpfinalgrupo7.controller.response.JwtResponse;
import com.arquitectura.tp.tpfinalgrupo7.controller.response.MessageResponse;
import com.arquitectura.tp.tpfinalgrupo7.model.ERole;
import com.arquitectura.tp.tpfinalgrupo7.model.Role;
import com.arquitectura.tp.tpfinalgrupo7.model.Usuario;
import com.arquitectura.tp.tpfinalgrupo7.model.Viaje;
import com.arquitectura.tp.tpfinalgrupo7.repository.RoleRepository;
import com.arquitectura.tp.tpfinalgrupo7.security.jwt.JwtUtils;
import com.arquitectura.tp.tpfinalgrupo7.security.service.UserDetailsImpl;
import com.arquitectura.tp.tpfinalgrupo7.service.UsuarioService;
import com.arquitectura.tp.tpfinalgrupo7.service.ViajeService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  private UsuarioService usuarioService;

  @PostMapping
  public Usuario save(@RequestBody Usuario usuario) {
    return usuarioService.save(usuario);
  }

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
        userDetails.getId(),
        userDetails.getUsername(),
        userDetails.getEmail(),
        roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (usuarioService.existsByNombre(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (usuarioService.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    Usuario user = new Usuario(signUpRequest.getUsername(),
        signUpRequest.getEmail(),
        encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
          case "admin":
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);

            break;
          default:
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    usuarioService.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
