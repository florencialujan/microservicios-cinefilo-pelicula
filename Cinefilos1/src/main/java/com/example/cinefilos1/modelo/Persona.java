package com.example.cinefilos1.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "Cinefilos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Persona {

    @Id
    @GeneratedValue
    @Column (name = "id")
    private Long id;

    @Column(nullable = false, name = "firstName")
    private String firstName;
    @Column(nullable = false, name = "lastName")
    private String lastName;
    @Column(nullable = false, name = "birthDay")
    private String birthDay;
    @Column(nullable = false, name = "hasInsurance")
    private String hasInsurance;

    @OneToMany(mappedBy = "idPelicula", cascade = CascadeType.ALL,orphanRemoval = false)
    //@JoinColumn(name="idPelicula")
    private List<Pelicula> peliculasFavoritas;


    public void agregarPeliculaFavorita(Pelicula p) {
        this.peliculasFavoritas.add(p);
        System.out.println("Se agrego la peli");
        for(Pelicula a: peliculasFavoritas)
            System.out.println(a);
    }

    public void quitarPeliculaFavorita(Pelicula p){
        this.peliculasFavoritas.remove(p);
        //System.out.println("Se quito la pelicula con id: "+p.getIdPelicula()+"a la persona id: "+this.id.toString());
    }


}
