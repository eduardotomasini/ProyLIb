package com.example.ProyLibreria.Service;

import com.example.ProyLibreria.model.Libro;
import com.example.ProyLibreria.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibroService implements LibroServiceI {

    private final LibroRepository libroRepository;

    @Override
    public Libro actualizarLibro(String id, Libro libroR) {
        Libro libro = libroRepository.findById(id).orElseThrow(null);

        libro.setIsbn(libroR.getIsbn());
        libro.setTitulo(libroR.getTitulo());
        libro.setAnio(libroR.getAnio());
        libro.setEjemplares(libroR.getEjemplares());
        libro.setEjemplaresPrestados(libroR.getEjemplaresPrestados());
        libro.setEjemplaresRestantes(libroR.getEjemplaresRestantes());
        libro.setAlta(libroR.getAlta());
        libro.setAutor(libroR.getAutor());
        libro.setEditorial(libroR.getEditorial());

        return libro;

    }


    @Override
    public Optional<Libro> consultarLibroPorTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }


    @Override
    public String eliminarLibro(String id) {
        libroRepository.deleteById(id);
        return "libro eliminado" + id + " correctamente";
    }

    @Override
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }
}
