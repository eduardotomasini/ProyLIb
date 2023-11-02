package com.example.ProyLibreria.controller;

import com.example.ProyLibreria.Service.LibroService;
import com.example.ProyLibreria.model.Libro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libros")
public class LibroController{

    private final LibroService libroService;


    @RequestMapping("/")
    public String home(){
        return "inicio";
    }


/*
    @GetMapping("/listar")
    public ResponseEntity<List<Libro>> listarLibros() {
        try {
            List<Libro> libros = libroService.listarLibros();
            return new ResponseEntity<>(libros, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/
    @GetMapping("/consultar/{titulo}")
    public ResponseEntity<Optional<Libro>> consultarLibroPorTitulo(@PathVariable String titulo) {
        try {
            Optional<Libro> libro = libroService.consultarLibroPorTitulo(titulo);
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/cargar/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable String id, @RequestBody Libro libroR) {

        try {
            Libro actualizoLibro = libroService.actualizarLibro(id, libroR);

            if (actualizoLibro != null) {
                return new ResponseEntity<>(actualizoLibro, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        } catch (
                Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/listar")
    public ResponseEntity<List> ListarLibros() {
        return ResponseEntity.ok(libroService.listarLibros());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable String id) {
        try {
            String mensaje = libroService.eliminarLibro(id);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
