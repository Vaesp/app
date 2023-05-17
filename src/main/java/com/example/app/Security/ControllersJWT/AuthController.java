package com.example.app.Security.ControllersJWT;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.app.Security.ModelsJWT.ERole;
import com.example.app.Security.ModelsJWT.Role;
import com.example.app.Security.ModelsJWT.User;
import com.example.app.Security.PayloadJWT.request.LoginRequest;
import com.example.app.Security.PayloadJWT.request.SignupRequest;
import com.example.app.Security.PayloadJWT.response.JwtResponse;
import com.example.app.Security.PayloadJWT.response.MessageResponse;
import com.example.app.Security.RepositoryJWT.RoleRepository;
import com.example.app.Security.RepositoryJWT.UserRepository;
import com.example.app.Security.SecurityJWT.jwt.JwtUtils;
import com.example.app.Services.UserService;
import com.example.app.Security.ServicesJWT.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET}, maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

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

        if (userDetails.getActive()) {
            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    roles));
        } else {
            ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            System.out.println(LocalDateTime.now() + " - LOGIN ERROR: " + response.getStatusCode());
            return response;
        }
    }

    @PostMapping("/signup")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        try {
            if (userRepository.existsByUsername(signupRequest.getUsername())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("El usuario ya fue tomado"));
            }

            User user = new User(
                    signupRequest.getNombre(),
                    signupRequest.getApellidoP(),
                    signupRequest.getApellidoM(),
                    signupRequest.getUsername(),
                    encoder.encode(signupRequest.getPassword()),
                    true,
                    LocalDateTime.now().withNano(0),
                    signupRequest.getUserstamp());

            Set<String> strRoles = signupRequest.getRole();
            Set<Role> roles = new HashSet<>();

            if (strRoles == null) {
                Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                roles.add(userRole);
            } else {
                strRoles.forEach(role -> {
                    switch (role) {
                        case "admin" -> {
                            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                            roles.add(adminRole);
                        }
                        case "moderator" -> {
                            Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                            roles.add(modRole);
                        }
                        default -> {
                            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));
                            roles.add(userRole);
                        }
                    }
                });
            }

            user.setRoles(roles);

            return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(path = "/users/{uId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> updateUser(@PathVariable("uId") long uId, @RequestBody User user) {
        Optional<User> uData = userRepository.findById(uId);
        try {
            if (uData.isPresent()) {
                User _user = uData.get();

                _user.setNombre(user.getNombre());
                _user.setApellidoP(user.getApellidoP());
                _user.setApellidoM(user.getApellidoM());
                _user.setUsername(user.getUsername());
                if (!Objects.equals(user.getPassword(), "")) {
                    _user.setPassword(encoder.encode(user.getPassword()));
                }
                _user.setActive(user.getActive());

                _user.setTimestampEdit(LocalDateTime.now().withNano(0));
                _user.setUserstamp(user.getUserstamp());

                _user.setRoles(user.getRoles());

                return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    private final UserService User;

    @Autowired
    public AuthController(UserService user) {
        User = user;
    }

    @DeleteMapping(path = "/users/{uId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable("uId") Long uId) {
        User.deleteUser(uId);
    }

    @GetMapping(path = "/users/{uId}")
    public ResponseEntity<User> getUserById(@PathVariable("uId") long uId) {
        Optional<User> uData = userRepository.findById(uId);

        if (uData.isPresent()) {
            return new ResponseEntity<>(uData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getUsers(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellidoP,
            @RequestParam(required = false) String apellidoM,
            @RequestParam(defaultValue = "true") Boolean active,
            @RequestParam(defaultValue = "nombre") String filter,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        List<User> user_;
        Pageable paging = PageRequest.of(page, size, Sort.by(direction, filter));
        Page<User> pageReps;

        try {
            if (username != null && nombre != null && apellidoP != null && apellidoM != null && active != null) {
                pageReps = userRepository.findByUsernameContainingAndNombreContainingAndApellidoPContainingAndApellidoMContainingAndActive(username, nombre, apellidoP, apellidoM, active, paging);
            } else if (username != null && nombre != null && apellidoP != null && active != null) {
                pageReps = userRepository.findByUsernameContainingAndNombreContainingAndApellidoPContainingAndActive(username, nombre, apellidoP, active, paging);
            } else if (username != null && nombre != null && apellidoM != null && active != null) {
                pageReps = userRepository.findByUsernameContainingAndNombreContainingAndApellidoMContainingAndActive(username, nombre, apellidoM, active, paging);
            } else if (username != null && apellidoP != null && apellidoM != null && active != null) {
                pageReps = userRepository.findByUsernameContainingAndApellidoPContainingAndApellidoMContainingAndActive(username, apellidoP, apellidoM, active, paging);
            } else if (nombre != null && apellidoP != null && apellidoM != null && active != null) {
                pageReps = userRepository.findByNombreContainingAndApellidoPContainingAndApellidoMContainingAndActive(nombre, apellidoP, apellidoM, active, paging);
            } else if (username != null && nombre != null && active != null) {
                pageReps = userRepository.findByUsernameContainingAndNombreContainingAndActive(username, nombre, active, paging);
            } else if (username != null && apellidoP != null && active != null) {
                pageReps = userRepository.findByUsernameContainingAndApellidoPContainingAndActive(username, apellidoP, active, paging);
            } else if (nombre != null && apellidoP != null && active != null) {
                pageReps = userRepository.findByNombreContainingAndApellidoPContainingAndActive(nombre, apellidoP, active, paging);
            } else if (username != null && apellidoM != null && active != null) {
                pageReps = userRepository.findByUsernameContainingAndApellidoMContainingAndActive(username, apellidoM, active, paging);
            } else if (nombre != null && apellidoM != null && active != null) {
                pageReps = userRepository.findByNombreContainingAndApellidoMContainingAndActive(nombre, apellidoM, active, paging);
            } else if (apellidoP != null && apellidoM != null && active != null) {
                pageReps = userRepository.findByApellidoPContainingAndApellidoMContainingAndActive(apellidoP, apellidoM, active, paging);
            } else if (username != null && active != null) {
                pageReps = userRepository.findByUsernameContainingAndActive(username, active, paging);
            } else if (nombre != null && active != null) {
                pageReps = userRepository.findByNombreContainingAndActive(nombre, active, paging);
            } else if (apellidoP != null && active != null) {
                pageReps = userRepository.findByApellidoPContainingAndActive(apellidoP, active, paging);
            } else if (apellidoM != null && active != null) {
                pageReps = userRepository.findByApellidoMContainingAndActive(apellidoM, active, paging);
            } else if (active != null) {
                pageReps = userRepository.findByActive(active, paging);
            } else {
                pageReps = userRepository.findAll(paging);
            }

            user_ = pageReps.getContent();
            Map<String, Object> response = new HashMap<>();

            response.put("userList", user_);
            response.put("currentPage", pageReps.getNumber());
            response.put("totalItems", pageReps.getTotalElements());
            response.put("totalPages", pageReps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/roles")
    public List<Role> getRoleList() {
        return roleRepository.findAll();
    }
}