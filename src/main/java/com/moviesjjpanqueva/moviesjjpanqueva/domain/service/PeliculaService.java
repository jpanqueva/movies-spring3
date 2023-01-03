package com.moviesjjpanqueva.moviesjjpanqueva.domain.service;

import com.moviesjjpanqueva.moviesjjpanqueva.domain.Pelicula;
import com.moviesjjpanqueva.moviesjjpanqueva.domain.repository.PeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
    @Autowired
    private PeliculasRepository peliculaRepository;

    public List<Pelicula> getAll(int page) {
        return peliculaRepository.getByPage(page);
    }

    public Optional<Pelicula> getPelicula(int peliculaId) {
        return peliculaRepository.getById(peliculaId);
    }

    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }
    public boolean delete(int peliculaId) {

        return getPelicula(peliculaId).map(pelicula -> {
            peliculaRepository.delete(peliculaId);
            return true;
        }).orElse(false);

    }

    public boolean update(int peliculaId) {

        return getPelicula(peliculaId).map(pelicula -> {
            peliculaRepository.update(peliculaId);
            return true;
        }).orElse(false);

    }

    public Pelicula put(Pelicula peliculaInput) {

        return getPelicula(peliculaInput.getId()).map(pelicula -> {
            return peliculaRepository.put(peliculaInput);
        }).orElse(null);

    }



}
