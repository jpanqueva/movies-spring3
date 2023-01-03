package com.moviesjjpanqueva.moviesjjpanqueva.persistence.crud;

import com.moviesjjpanqueva.moviesjjpanqueva.persistence.entity.MovieBean;
import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.BaseMovie;
import com.uwetrottmann.tmdb2.entities.Movie;
import com.uwetrottmann.tmdb2.entities.MovieResultsPage;
import com.uwetrottmann.tmdb2.services.MoviesService;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieCrudRepository {

    private String getKey(){
        return "b059d5a768cf815b3373a36a0d7355bf";
    }
    public List<MovieBean> getByPage(int page) {

        Tmdb tmdb = new Tmdb(this.getKey());
        MoviesService moviesService = tmdb.moviesService();

        List<MovieBean> listMoviesReturn =  (List<MovieBean>) new ArrayList<MovieBean>();

        try {
            Response<MovieResultsPage> response = moviesService
                    .popular(page,"ES", "ES")
                    .execute();
            if (response.isSuccessful()) {
                MovieResultsPage mrp = response.body();
                for (BaseMovie baseMovie : mrp.results) {

                    MovieBean auxMovie= this.getMovieById(baseMovie.id);
                    listMoviesReturn.add(auxMovie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listMoviesReturn;
    }

    public MovieBean getMovieById(int id) {

        Tmdb tmdb = new Tmdb(this.getKey());
        MoviesService moviesService = tmdb.moviesService();
        MovieBean movieBeen = null;
        try {
            Response<Movie> response = moviesService
                    .summary(id,"ES")
                    .execute();
            if (response.isSuccessful()) {
                Movie movie = response.body();

                MovieBean auxMovie= new MovieBean();

                auxMovie.setTitle(movie.title);
                auxMovie.setId(movie.id);
                auxMovie.setAdult(movie.adult);
                auxMovie.setHomepage(movie.homepage);
                auxMovie.setRuntime(movie.runtime);

                movieBeen = auxMovie;
                System.out.println(movie.title + " is consulta by id!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movieBeen;

    }
}
