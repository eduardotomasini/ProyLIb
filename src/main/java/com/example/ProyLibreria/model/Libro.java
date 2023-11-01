package com.example.ProyLibreria.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String isbn;
    private String titulo;
    private Integer anio;
    private Integer ejemplares;
    private Integer ejemplaresPrestados;
    private Integer ejemplaresRestantes;
    private Boolean alta;
    @OneToOne
    private Autor autor;
    @OneToOne
    private Editorial editorial;

}
