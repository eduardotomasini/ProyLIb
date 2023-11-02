package com.example.ProyLibreria.Service;


import com.example.ProyLibreria.model.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroServiceI {

    Libro actualizarLibro(String id, Libro libroR);

    Optional<Libro> consultarLibroPorTitulo(String titulo);


    String eliminarLibro(String id);

    List<Libro> listarLibros();


}
