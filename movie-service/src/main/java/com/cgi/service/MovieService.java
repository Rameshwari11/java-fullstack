package com.cgi.service;

import java.util.List;

import com.cgi.dto.MoviesDTO;
import com.cgi.model.Movies;

public interface MovieService {
	public Movies createMovie(MoviesDTO movies);
	
	public List<MoviesDTO> getAllMovies();
	
	public MoviesDTO findByMovieId(String movieId);
	
	public List<MoviesDTO> deleteByMovieId(String movieId);
	
	public Movies updateByMovieId(MoviesDTO moviesTo);
}
