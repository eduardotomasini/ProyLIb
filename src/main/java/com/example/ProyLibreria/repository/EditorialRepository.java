package com.example.ProyLibreria.repository;


import com.example.ProyLibreria.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, String>{

}
