package com.example.cinefilos1.repositorio;

import com.example.cinefilos1.modelo.Persona;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
/*
    public abstract Persona findPersonaByFirstName();
*/
    @Override
    @EntityGraph(attributePaths = "peliculasFavoritas")
    List<Persona> findAll();
}
