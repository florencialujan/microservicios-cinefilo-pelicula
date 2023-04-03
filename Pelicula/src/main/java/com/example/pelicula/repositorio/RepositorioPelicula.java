package com.example.pelicula.repositorio;

import com.example.pelicula.modelo.Pelicula;
import com.example.pelicula.modelo.Persona;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPelicula extends JpaRepository<Pelicula,Long> {

    //public List<Pelicula> findPeliculaByPersona_id(Long persona_id);





}
