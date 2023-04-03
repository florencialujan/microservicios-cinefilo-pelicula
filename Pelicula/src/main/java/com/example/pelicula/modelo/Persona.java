package com.example.pelicula.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    private Long id;
    private String firstName;

    private String lastName;

    private String birthDay;

    private String hasInsurance;

    /*@OneToMany//(cascade = CascadeType.ALL,orphanRemoval = true)

    @JoinColumn(name="idPelicula")*/
    @OneToMany(mappedBy = "idPelicula")
    private List<Pelicula> peliculasFavoritas;



}
