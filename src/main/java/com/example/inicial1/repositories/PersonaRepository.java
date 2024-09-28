package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    // Keywords
    //List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable p);


    // JPQL
    //@Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filter% OR p.apellido LIKE %:filter%")
    //List<Persona> search(@Param("filter") String filter);
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filter% OR p.apellido LIKE %:filter%")
    Page<Persona> search(@Param("filter") String filter, Pageable p);

    //Native SQL
    //@Query(
    //        value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filter% OR persona.apellido LIKE %:filter%",
    //        nativeQuery = true
    //)
    //List<Persona> nativeSearch(@Param("filter") String filter);
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filter% OR persona.apellido LIKE %:filter%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> nativeSearch(@Param("filter") String filter, Pageable p);

}