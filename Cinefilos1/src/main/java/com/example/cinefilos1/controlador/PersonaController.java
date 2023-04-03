package com.example.cinefilos1.controlador;

import com.example.cinefilos1.modelo.Pelicula;
import com.example.cinefilos1.modelo.Persona;
import com.example.cinefilos1.servicio.ServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")

public class PersonaController {

    @Autowired
    private ServicioPersona servicioPersona;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/all")
    public  ResponseEntity <List<Persona>> obtenerPersonas(){

        List<Persona> personas = servicioPersona.listarPersonas();
        return new ResponseEntity<>(personas,HttpStatus.OK);
    }



    @GetMapping("/nombre")
    public ResponseEntity<List<Persona>> obtenerPersonasOrdenadasPorNombre(){
        List<Persona> personas = servicioPersona.listarPersonasOrdenadasPorNombre();
        return new ResponseEntity<>(personas,HttpStatus.OK);
    }
    //personas ordenadas por apellido
    @GetMapping("/apellido")
    public ResponseEntity<List<Persona>> obtenerPersonasOrdenadasPorApellido(){
        List<Persona> personas = servicioPersona.listarPersonasOrdenadasPorApellido();
        return new ResponseEntity<>(personas,HttpStatus.OK);
    }


    //Controlador de guardarPersona
    @PostMapping
    public ResponseEntity <Object> guardarPersona(@RequestBody Persona p){  //Antes era Persona p
        //return new ResponseEntity(servicioPersona.guardarPersona(p), HttpStatus.CREATED); antes
        servicioPersona.guardarPersona(p);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Controlador de obtenerPersona
    @GetMapping("/{id}")
    public ResponseEntity obtenerPersona(@PathVariable("id") Long idPersona){

        //public ResponseEntity obtenerPersona(@RequestParam Long idPersona){
        try{
            return ResponseEntity.ok(servicioPersona.mostrarPersona(idPersona));
            //return new ResponseEntity(s.obtenerPersona(idPersona), HttpStatus.OK);
        }catch(Exception e){

            return new ResponseEntity(servicioPersona.mostrarPersona(idPersona), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public Persona actualizarCampos(@PathVariable Long id, @RequestBody Map<String,Object> campos){
        return servicioPersona.actualizarCamposPersona(id,campos);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPersona(@PathVariable("id") Long idPersona){

        boolean respuesta =servicioPersona.eliminarPersona(idPersona);
        if(respuesta){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }



    @PostMapping("/{id}/agregarPelicula/{idPelicula}")
    public ResponseEntity agregarPeliculaFavorita(@PathVariable("id") Long id, @PathVariable("idPelicula") Long idPeli){

        Pelicula pf  = restTemplate.getForObject("http://localhost:8093/api/peliculas/"+idPeli, Pelicula.class);

       return servicioPersona.agregarPeliculaFavorita(id,idPeli,pf);
        
    }

    @DeleteMapping("/{id}/quitarPelicula/{idPelicula}")
    public ResponseEntity<Optional<Persona>> quitarPeliculaFavorita(@PathVariable("id") Long id, @PathVariable("idPelicula") Long idPeli){

        Pelicula pf  = restTemplate.getForObject("http://localhost:8093/api/peliculas/"+idPeli, Pelicula.class);


        //Pasarle persona y pelicula a servicio así hace la relación.-
        return servicioPersona.quitarPeliculaFavorita(id,idPeli,pf);


    }

    @GetMapping("/{id}/listarPeliculas")
    public ResponseEntity mostrarPeliculas(@PathVariable("id") Long idPersona){

        try{
            return ResponseEntity.ok((List<Pelicula>) servicioPersona.listarPeliculas(idPersona));
        }catch(Exception e){

            return new ResponseEntity(servicioPersona.mostrarPersona(idPersona), HttpStatus.NOT_FOUND);
        }
    }





}
