package com.example.ProyLibreria.repository;


import com.example.ProyLibreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository <Libro, String> {


    Optional<Libro> findByTitulo(String titulo);
}
