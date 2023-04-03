package com.example.pelicula.modelo;


import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "peliculas")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String genre;

}
