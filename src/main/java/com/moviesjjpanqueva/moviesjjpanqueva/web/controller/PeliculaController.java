package com.moviesjjpanqueva.moviesjjpanqueva.web.controller;

import com.moviesjjpanqueva.moviesjjpanqueva.domain.Pelicula;
import com.moviesjjpanqueva.moviesjjpanqueva.domain.service.PeliculaService;
import com.moviesjjpanqueva.moviesjjpanqueva.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/getAll/{page}")
    public ResponseEntity<Object> getAll(@PathVariable int page) {
        return ResponseHandler.generateResponse("OK", HttpStatus.OK, peliculaService.getAll(page));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPelicula(@PathVariable int id) {

        Optional<Pelicula> respuesta = peliculaService.getPelicula(id);

        if (respuesta.isPresent()) {

            return ResponseHandler.generateResponse("OK", HttpStatus.OK, respuesta);
        }else {
            return ResponseHandler.generateResponse("Not Found", HttpStatus.NOT_FOUND, null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePelicula(@PathVariable int id) {

        Optional<Pelicula> respuesta = peliculaService.getPelicula(id);

        if (!respuesta.isPresent()) {

            return ResponseHandler.generateResponse("Not Found", HttpStatus.NOT_FOUND, null);
        }else {

            if(peliculaService.delete(id)) {
                return ResponseHandler.generateResponse("OK", HttpStatus.OK, null);
            }else{
                return ResponseHandler.generateResponse("ERROR", HttpStatus.INTERNAL_SERVER_ERROR, null);
            }

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putPelicula(@RequestBody Pelicula input) {


        System.out.println(input);

        Optional<Pelicula> respuesta = peliculaService.getPelicula(input.getId());

        if (!respuesta.isPresent()) {

            return ResponseHandler.generateResponse("Not Found", HttpStatus.NOT_FOUND, null);
        } else {


            Pelicula peliculaResponse = peliculaService.put(input);

            if(peliculaResponse != null) {
                return ResponseHandler.generateResponse("OK", HttpStatus.OK, peliculaResponse);
            }else{
                return ResponseHandler.generateResponse("ERROR", HttpStatus.INTERNAL_SERVER_ERROR, null);
            }

        }

    }
}
