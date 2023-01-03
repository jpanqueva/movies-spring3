package com.moviesjjpanqueva.moviesjjpanqueva.persistence;

import com.moviesjjpanqueva.moviesjjpanqueva.MoviesJjpanquevaApplication;
import com.moviesjjpanqueva.moviesjjpanqueva.domain.Pelicula;
import com.moviesjjpanqueva.moviesjjpanqueva.persistence.crud.MovieCrudRepository;
import com.moviesjjpanqueva.moviesjjpanqueva.persistence.entity.MovieBean;
import com.moviesjjpanqueva.moviesjjpanqueva.persistence.mapper.PeliculaMapper;
import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.Movie;
import com.uwetrottmann.tmdb2.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;
import com.moviesjjpanqueva.moviesjjpanqueva.domain.repository.PeliculasRepository;
@Repository
public class PeliculaRepository implements PeliculasRepository {

    @Autowired
    private MovieCrudRepository movieCrudRepository;
    @Autowired
    private PeliculaMapper mapper;
    @Override
    public List<Pelicula> getByPage(int page) {

        List<MovieBean> peliculas = movieCrudRepository.getByPage(page);
        return mapper.toPelicula(peliculas);
    }

    @Override
    public Optional<Pelicula> getById(int idPelicula) {

        MovieBean response = movieCrudRepository.getMovieById(idPelicula);

        if( response == null ) {
            return Optional.empty();
        }else {

            return Optional.of(mapper.toPelicula(movieCrudRepository.getMovieById(idPelicula)));
        }
    }

    /**
     * No se implementa ya que el api usada no tiene metodos para guardar
     * @param pelicula
     * @return
     */
    @Override
    public Pelicula save(Pelicula pelicula) {

        pelicula.setId(-1);
        return pelicula;
    }

    /**
     * No se implementa ya que el Api no tiene un metodo para eliminar
     * @param idPelicula
     */
    @Override
    public void delete(int idPelicula) {

    }

    /**
     * No se implementa ya que el Api no tiene un metodo para update
     * @param idPelicula
     */
    @Override
    public void update(int idPelicula) {

    }

    /**
     * No se implementa ya que el Api no tiene un metodo para put
     * @param idPelicula
     */
    @Override
    public Pelicula put(Pelicula pelicula) {

        return pelicula;
    }




}
