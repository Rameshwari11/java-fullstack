package com.cgi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.dto.MoviesDTO;
import com.cgi.model.Movies;
import com.cgi.repository.MovieRepository;
import com.cgi.service.MovieService;


@Service
public class MovieServiceImpl implements MovieService { 	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Movies createMovie(MoviesDTO MoviesDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Movies movies=modelMapper.map(MoviesDTO, Movies.class);
		movies.setMovieId(UUID.randomUUID().toString());
		return movieRepository.save(movies);
	}
	
	@Override
	public List<MoviesDTO> getAllMovies() {
		List<MoviesDTO> moviesList=new ArrayList<>();
		
		movieRepository.findAll().stream().forEach(movie -> {
			moviesList.add(modelMapper.map(movie, MoviesDTO.class));
		});
		
		return moviesList;
	}
	
	@Override
	public MoviesDTO findByMovieId(String movieId) {
		return modelMapper.map(movieRepository.findByMovieId(movieId).get(), MoviesDTO.class);
	}
	
	@Override
	public List<MoviesDTO> deleteByMovieId(String movieId) {
		List<MoviesDTO> deletedMoviesList=new ArrayList<>();
		
		movieRepository.deleteByMovieId(movieId).get().stream().forEach(movie -> {
			deletedMoviesList.add(modelMapper.map(movie, MoviesDTO.class));
		});
		
		return deletedMoviesList;
	}
	
	@Override
	public Movies updateByMovieId(MoviesDTO MoviesDTO) {
		Movies movies = movieRepository.findByMovieId(MoviesDTO.getMovieId()).get();
		
		if(MoviesDTO.getGenre()!=null) {
			movies.setGenre(MoviesDTO.getGenre());	
		}
		
		
		if(MoviesDTO.getMovieName()!=null) {
			movies.setMovieName(MoviesDTO.getMovieName());	
		}
		
		
		return movieRepository.save(movies);
	}
}
