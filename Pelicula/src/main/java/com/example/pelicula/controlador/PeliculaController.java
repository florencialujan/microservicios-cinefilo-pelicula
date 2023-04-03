package com.example.pelicula.controlador;

import com.example.pelicula.modelo.Pelicula;
import com.example.pelicula.servicio.PeliculaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/peliculas")
@AllArgsConstructor

public class PeliculaController {

    @Autowired
    private final PeliculaService peliculaServicio;

    @PostMapping
    public Pelicula guardarPelicula(@RequestBody Pelicula pelicula) {
        return peliculaServicio.guardarPelicula(pelicula);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pelicula>> mostrarPeliculas() {
        List<Pelicula> peliculas = peliculaServicio.listarPeliculas();
        return new ResponseEntity<>(peliculas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> obtenerPeliculaPorId(@PathVariable Long id) {

        Pelicula pelicula = peliculaServicio.obtenerPeliculaPorId(id).get();
        if (pelicula == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pelicula);
        //return peliculaServicio.getPeliculaById(id);
    }

    @PatchMapping("/{id}")
    public Pelicula actualizarCampos(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        return peliculaServicio.actualizarCamposPelicula(id, campos);
    }
}
