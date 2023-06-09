package com.cgi.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.dto.ErrorDTO;
import com.cgi.dto.MoviesDTO;
import com.cgi.model.Movies;
import com.cgi.service.MovieService;


@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorDTO> handleException(Exception e) {
		ErrorDTO errorTO=new ErrorDTO(HttpStatus.BAD_REQUEST.value(), 
				e.getMessage(), 
				System.currentTimeMillis(),
				LocalDate.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorTO);
	}
	
	@PostMapping("/create-movie") 
	public ResponseEntity<Movies> createStudent(@RequestBody MoviesDTO moviesTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(moviesTO));
	}
	
	@GetMapping("/find-all-movies") 
	public ResponseEntity<Collection<MoviesDTO>> listStudents() {
		return ResponseEntity.ok().body(movieService.getAllMovies());
	}
	
	@GetMapping("/{movieId}") 
	public ResponseEntity<MoviesDTO> getMovieByMovieId(@PathVariable("movieId") String movieId) {
		return ResponseEntity.ok().body(movieService.findByMovieId(movieId));
	}

	@DeleteMapping("/delete-movie/{movieId}") 
	public ResponseEntity<List<MoviesDTO>> createStudent(@PathVariable("movieId") String movieId) {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.deleteByMovieId(movieId));
	}
	
	@PutMapping("/update-movie")
	public ResponseEntity<?> updateMovieByMovieId(@RequestBody MoviesDTO moviesTO) {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.updateByMovieId(moviesTO));
	}
}
