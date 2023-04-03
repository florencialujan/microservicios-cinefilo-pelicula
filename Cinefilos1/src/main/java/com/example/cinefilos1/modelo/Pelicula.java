package com.example.cinefilos1.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPelicula")
    private Long idPelicula;

    @ManyToOne
    @JoinColumn(name="id")
    Persona persona;



    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String genre;




}
