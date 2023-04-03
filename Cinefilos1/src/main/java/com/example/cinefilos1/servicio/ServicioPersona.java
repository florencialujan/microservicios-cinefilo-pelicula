package com.example.cinefilos1.servicio;

import com.example.cinefilos1.modelo.Pelicula;
import com.example.cinefilos1.modelo.Persona;
import com.example.cinefilos1.repositorio.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.*;

@Service
@AllArgsConstructor

public class ServicioPersona {


    @Autowired
    private PersonaRepository repoPersona;

    private final RestTemplate restTemplate;
    public Persona guardarPersona(Persona persona){
        return repoPersona.save(persona);
    }

    public Optional mostrarPersona(Long id){
        return Optional.ofNullable(repoPersona.findById(id).orElseThrow(() -> {
            throw new RuntimeException();
        }));

    }

    public List listarPersonas(){
        return repoPersona.findAll();
    }

    public boolean eliminarPersona(Long id){
        try{
            repoPersona.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Persona actualizarCamposPersona(Long id, Map<String, Object> campos) {
        Optional<Persona> personaExistente = repoPersona.findById(id);
        if(personaExistente.isPresent()){
            campos.forEach((key,value)->{
                Field field = ReflectionUtils.findField(Persona.class,key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,personaExistente.get(),value);
            });
            return repoPersona.save(personaExistente.get());
        }
        return null;
    }





    public ResponseEntity<Optional<Persona>> agregarPeliculaFavorita(Long idPersona, Long idPelicula, Pelicula p){

        Optional<Persona> personaEncontrada= repoPersona.findById(idPersona);


        if(personaEncontrada.isPresent()){
            personaEncontrada.get().agregarPeliculaFavorita(p);
            personaEncontrada.get().agregarPeliculaFavorita(p);
            repoPersona.save(personaEncontrada.get());
            return ResponseEntity.ok(personaEncontrada);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Optional<Persona>> quitarPeliculaFavorita(Long idPersona, Long idPelicula, Pelicula p) {

        Optional<Persona> personaEncontrada= repoPersona.findById(idPersona);

        if(personaEncontrada.isPresent()){

            personaEncontrada.get().quitarPeliculaFavorita(p);
            repoPersona.save(personaEncontrada.get());
            return ResponseEntity.ok(personaEncontrada);

        }
        return ResponseEntity.notFound().build();
    }

    public List<Persona> listarPersonasOrdenadasPorNombre() {
        List<Persona> personas = repoPersona.findAll();
        Collections.sort(personas, Comparator.comparing(Persona::getFirstName));
        return personas;
    }

    public List<Persona> listarPersonasOrdenadasPorApellido() {
        List<Persona> personas = repoPersona.findAll();
        Collections.sort(personas, Comparator.comparing(Persona::getLastName));
        return personas;
    }


    public Object listarPeliculas(Long idPersona) {
        Optional<Persona> personaEncontrada= repoPersona.findById(idPersona);

        if(personaEncontrada.isPresent()){
            return ResponseEntity.ok(personaEncontrada.get().getPeliculasFavoritas());
        }
        return ResponseEntity.notFound().build();

    }
}
