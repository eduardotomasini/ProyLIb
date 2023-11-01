package com.example.ProyLibreria.repository;


import com.example.ProyLibreria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository <Autor, String> {
}
