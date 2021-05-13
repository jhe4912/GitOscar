package com.springboot.app;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csus.csc131s06.teamdeuxtwoto.gitoscar.Main;
import csus.csc131s06.teamdeuxtwoto.gitoscar.enums.AwardCategory;
import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.Nomination;
import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.SearchQuery;

@RestController
@RequestMapping(value = "/")
public class WebController {
	
	@RequestMapping(value = "/home")
	public ResponseEntity<String[]> HomePrompt(){
		String[] message = new String[9];
		message[0] = "Search for your favorite oscar nominated movies!";
		message[1] = "|";
		message[2] = "Directories available:";
		message[3] = "/movies/all";
		message[4] = "/movies/{movie name}";
		message[5] = "/categories/all";
		message[6] = "/categories/{category name}";
		message[7] = "|";
		message[8] = "Credit: Jason He, Cody Milne, Covi Singh, Jabari Crenshaw";
		
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@RequestMapping(value = "/movies/all")
	public ResponseEntity<MovieResponse[]> AllMovies() {
		
		SearchQuery sq = new SearchQuery();
		sq.reset();
		
		try {
			List<Nomination> nominations = Main.getSQLHandler().getAwardsFromSearchQuery(sq);
			MovieResponse[] response = new MovieResponse[nominations.size()];
			
			response = setMovieResponseObjectFields(response, nominations);
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	@GetMapping(value = "/movies/{movieName}")
	public ResponseEntity<MovieResponse[]> MoviesByName(@PathVariable("movieName") String movieName) {
		
		SearchQuery sq = new SearchQuery();
		sq.setFilmName(movieName);
		
		try {
			List<Nomination> nominations = Main.getSQLHandler().getAwardsFromSearchQuery(sq);
			MovieResponse[] response = new MovieResponse[nominations.size()];
			
			if(nominations != null) {
				response = setMovieResponseObjectFields(response, nominations);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	@RequestMapping(value = "/categories/all")
	public ResponseEntity<String[]> AllMovieCategories() {
		
		return ResponseEntity.status(HttpStatus.OK).body(AwardCategory.getAllAwardPrint());
		
	}
	
	@GetMapping(value = "/categories/{categoryEnum}")
	public ResponseEntity<MovieResponse[]> getCategoryByEnum(@PathVariable("categoryEnum") String categoryEnum) {
		
		AwardCategory ac = AwardCategory.valueOf(categoryEnum.toUpperCase());
		
		if(ac != null) {
			SearchQuery sq = new SearchQuery();
			sq.addAwardCategory(ac);
			
			try {
				List<Nomination> nominations = Main.getSQLHandler().getAwardsFromSearchQuery(sq);
				MovieResponse[] response = new MovieResponse[nominations.size()];
	
				response = setMovieResponseObjectFields(response, nominations);
				return ResponseEntity.status(HttpStatus.OK).body(response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
	public MovieResponse[] setMovieResponseObjectFields(MovieResponse[] response, List<Nomination> nominations) {
		
		for(int i = 0; i < nominations.size(); i++) {
			response[i] = new MovieResponse();
			
			response[i].setFilmName(nominations.get(i).getFilmName());
			response[i].setFilmYear(nominations.get(i).getFilmYear());
			response[i].setCategory(nominations.get(i).getCategory().toString());
			response[i].setWinner(nominations.get(i).isWinner());
			response[i].setCeremonyYear(nominations.get(i).getCeremonyYear());
			response[i].setCeremonyNumber(nominations.get(i).getCeremonyNumber());
			response[i].setNomineeName(nominations.get(i).getAwardedTo());
		}
		
		return response;
	}
	
	/*
	public MovieResponse[] setCategoryId() {
		
		String[] awardsList = AwardCategory.getAllAwardPrint();
		MovieResponse[] response = new MovieResponse[awardsList.length];
		
		for(int i = 0; i < awardsList.length; i++) {
			response[i] = new MovieResponse();
			response[i].setCategory(awardsList[i]);
			response[i].setId(i);
		}
		
		return response;
		
	}
	
	public CategoryResponse[] setCategoryIdOnly() {
		
		String[] awardsList = AwardCategory.getAllAwardPrint();
		CategoryResponse[] response = new CategoryResponse[awardsList.length];
		
		for(int i = 0; i < awardsList.length; i++) {
			response[i] = new CategoryResponse();
			response[i].setCategory(awardsList[i]);
			response[i].setId(i);
		}
		
		return response;
	}
	
	@RequestMapping("/year")
	public int[] AllMovieYears() {
		
	}
	
	
	@GetMapping(value = "/movies/bycategoryid/{categoryId}")
	public ResponseEntity<> MoviesByCategoryID(@PathVariable("categoryId") int categoryId) {
		
		return ResponseEntity.status(HttpStatus.OK).body(setCategoryIdOnly());
		
	}
	
	@GetMapping(value = "/categories/byid/{id}")
	public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable("id") int id) {
		
		CategoryResponse[] initMovieId = setCategoryIdOnly();
		
		for(int i = 0; i < initMovieId.length; i++) {
			if(initMovieId[i].getId() == id) {
				return ResponseEntity.status(HttpStatus.OK).body(initMovieId[i]);
			}
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	*/
		
}
