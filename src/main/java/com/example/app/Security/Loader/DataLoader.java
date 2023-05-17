package com.example.app.Security.Loader;

import com.example.app.Security.ModelsJWT.ERole;
import com.example.app.Security.ModelsJWT.Role;
import com.example.app.Security.ModelsJWT.User;
import com.example.app.Security.RepositoryJWT.RoleRepository;
import com.example.app.Security.RepositoryJWT.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        insertRoles();
        insertUserData();
        System.out.println(LocalDateTime.now() + " - INICIALIZACIÓN COMPLETA");
    }

    private void insertRoles() {
        if (roleRepository.count() != 3) {
            System.out.println(LocalDateTime.now() + " - Inicializando Roles...");
            Role role1 = new Role(
                    ERole.ROLE_ADMIN
            );
            Role role2 = new Role(
                    ERole.ROLE_MODERATOR
            );
            Role role3 = new Role(
                    ERole.ROLE_USER
            );

            roleRepository.save(role1);
            roleRepository.save(role2);
            roleRepository.save(role3);
        } else {
            System.out.println(LocalDateTime.now() + " - Roles: COMPLETOS");
        }
    }

    private void insertUserData() {
        if (userRepository.count() == 0) {
            System.out.println(LocalDateTime.now() + " - Inicializando Usuarios...");

            User user = new User();
            user.setNombre("admin");
            user.setApellidoP("");
            user.setApellidoM("");
            user.setUsername("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("1234"));
            user.setActive(true);
            user.setTimestamp(LocalDateTime.now().withNano(0));
            user.setUserstamp("SYSTEM");

            Set<Role> roles = new HashSet<>();
            Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));

            roles.add(userRole);
            user.setRoles(roles);
            userRepository.save(user);

            User user2 = new User();
            user2.setNombre("mod");
            user2.setApellidoP("");
            user2.setApellidoM("");
            user2.setUsername("mod");
            user2.setPassword(new BCryptPasswordEncoder().encode("1234"));
            user2.setActive(true);
            user2.setTimestamp(LocalDateTime.now().withNano(0));
            user2.setUserstamp("admin");

            Set<Role> roles2 = new HashSet<>();
            Role userRole2 = roleRepository.findByName(ERole.ROLE_MODERATOR)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));

            roles2.add(userRole2);
            user2.setRoles(roles2);
            userRepository.save(user2);

            User user3 = new User();
            user3.setNombre("user");
            user3.setApellidoP("");
            user3.setApellidoM("");
            user3.setUsername("user");
            user3.setPassword(new BCryptPasswordEncoder().encode("1234"));
            user3.setActive(true);
            user3.setTimestamp(LocalDateTime.now().withNano(0));
            user3.setUserstamp("admin");

            Set<Role> roles3 = new HashSet<>();
            Role userRole3 = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado"));

            roles3.add(userRole3);
            user3.setRoles(roles3);
            userRepository.save(user3);
        } else {
            System.out.println(LocalDateTime.now() + " - Usuarios: " + userRepository.count());
        }
    }
}