package com.moviesjjpanqueva.moviesjjpanqueva.domain.repository;

import com.moviesjjpanqueva.moviesjjpanqueva.domain.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculasRepository {

    List<Pelicula> getByPage(int page);
    Optional<Pelicula> getById(int idPelicula);
    Pelicula save (Pelicula pelicula);
    void delete(int idPelicula);

    void update(int idPelicula);

    Pelicula put(Pelicula idPelicula);


}
