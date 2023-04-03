package com.example.pelicula.servicio;

import com.example.pelicula.modelo.Pelicula;
import com.example.pelicula.repositorio.RepositorioPelicula;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PeliculaService {

    private final RepositorioPelicula repoPelicula;
    private final RestTemplate restTemplate;

    public Pelicula guardarPelicula(Pelicula pelicula){
        return repoPelicula.save(pelicula);
    }


    public List listarPeliculas(){
        return repoPelicula.findAll();
    }

    public Pelicula actualizarCamposPelicula(Long id, Map<String, Object> campos) {

        Optional<Pelicula> peliExistente = repoPelicula.findById(id);
        if(peliExistente.isPresent()){
            campos.forEach((key,value)->{
                Field field = ReflectionUtils.findField(Pelicula.class,key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,peliExistente.get(),value);
            });
            return repoPelicula.save(peliExistente.get());
        }
        return null;


    }
    @GetMapping("/{id}")
    public Optional<Pelicula> obtenerPeliculaPorId(Long id) {

        return repoPelicula.findById(id);
    }


}
