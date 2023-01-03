package com.moviesjjpanqueva.moviesjjpanqueva.persistence.mapper;

import com.moviesjjpanqueva.moviesjjpanqueva.domain.Pelicula;
import com.moviesjjpanqueva.moviesjjpanqueva.persistence.entity.MovieBean;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeliculaMapper{
    @Mappings({
            @Mapping(source = "title", target = "nombre"),
            @Mapping(source = "adult", target = "paraAdultos"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "runtime", target = "minutosDuracion"),
            @Mapping(source = "homepage", target = "paginaWeb")
    })
    Pelicula toPelicula(MovieBean movie);
    List<Pelicula> toPelicula(List<MovieBean> movies);

    @InheritInverseConfiguration
    MovieBean toMovie(Pelicula pelicula);

}
