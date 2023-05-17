package com.example.app.Security.RepositoryJWT;

import com.example.app.Security.ModelsJWT.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    Optional<User> findByUsername(String username);
    Page<User> findAll(Pageable pageable);

    Boolean existsByUsername(String username);

    Page<User> findByActive(Boolean active, Pageable paging);

    //1 Filter
    Page<User> findByUsernameContainingAndActive(String username, Boolean active, Pageable paging);//0001
    Page<User> findByNombreContainingAndActive(String nombre, Boolean active, Pageable paging);//0010
    Page<User> findByApellidoPContainingAndActive(String apellidoP, Boolean active, Pageable paging);//0100
    Page<User> findByApellidoMContainingAndActive(String apellidoM, Boolean active, Pageable paging);//1000

    //2 Filters
    Page<User> findByUsernameContainingAndNombreContainingAndActive(String username, String nombre, Boolean active, Pageable paging);//0011
    Page<User> findByUsernameContainingAndApellidoPContainingAndActive(String username, String apellidoP, Boolean active, Pageable paging);//0101
    Page<User> findByNombreContainingAndApellidoPContainingAndActive(String nombre, String apellidoP, Boolean active, Pageable paging);//0110
    Page<User> findByUsernameContainingAndApellidoMContainingAndActive(String username, String apellidoM, Boolean active, Pageable paging);//1001
    Page<User> findByNombreContainingAndApellidoMContainingAndActive(String nombre, String apellidoM, Boolean active, Pageable paging);//1010
    Page<User> findByApellidoPContainingAndApellidoMContainingAndActive(String apellidoP, String apellidoM, Boolean active, Pageable paging);//1100

    //3 Filters
    Page<User> findByUsernameContainingAndNombreContainingAndApellidoPContainingAndActive(String username, String nombre, String apellidoP, Boolean active, Pageable paging);//0111
    Page<User> findByUsernameContainingAndNombreContainingAndApellidoMContainingAndActive(String username, String nombre, String apellidoM, Boolean active, Pageable paging);//1011
    Page<User> findByUsernameContainingAndApellidoPContainingAndApellidoMContainingAndActive(String username, String apellidoP, String apellidoM, Boolean active, Pageable paging);//1101
    Page<User> findByNombreContainingAndApellidoPContainingAndApellidoMContainingAndActive(String nombre, String apellidoP, String apellidoM, Boolean active, Pageable paging);//1110

    //4 Filters
    Page<User> findByUsernameContainingAndNombreContainingAndApellidoPContainingAndApellidoMContainingAndActive(String username, String nombre, String apellidoP, String apellidoM, Boolean active, Pageable paging);//1111
}