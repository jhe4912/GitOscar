package com.springboot.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import csus.csc131s06.teamdeuxtwoto.gitoscar.Main;
import csus.csc131s06.teamdeuxtwoto.gitoscar.enums.AwardCategory;
import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.Nomination;
import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.SearchQuery;

@RestController
@RequestMapping(value = "/")
public class WebController {

	@RequestMapping(value = "/home")
	public ResponseEntity<ArrayList<String>> HomePrompt() {
		ArrayList<String> message = new ArrayList<>();

		message.add("Search for your favorite oscar nominated movies!");
		message.add("");
		message.add("* Search Directories available:");
		message.add("   /movies");
		message.add("   /categories");
		message.add("");
		message.add("* Need help searching?");
		message.add("   /helpmesearch");
		message.add("");
		message.add("Credit: Jason He, Cody Milne, Covi Singh, Jabari Crenshaw");

		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	@GetMapping(value = "/movies")
	public ResponseEntity<MovieResponse[]> AllMovies(
			@RequestParam(value = "movieName", required = false) String movieName,
			@RequestParam(value = "yearStart", defaultValue = "0", required = false) int yearStart,
			@RequestParam(value = "yearEnd", defaultValue = "0", required = false) int yearEnd,
			@RequestParam(value = "actor", defaultValue = "***", required = false) String actor) {

		SearchQuery sq = new SearchQuery();
		if (movieName != null) {
			sq.setFilmName(movieName);
		}
		if (yearStart != 0) {
			sq.setFilmYearStart(yearStart);
		}
		if (yearEnd != 0) {
			sq.setFilmYearEnd(yearEnd);
		}
		if (!actor.equals("***")) {
			sq.setAwardedTo(actor);
		}

		try {
			List<Nomination> nominations = Main.getSQLHandler().getAwardsFromSearchQuery(sq);

			if (nominations != null) {
				MovieResponse[] response = new MovieResponse[nominations.size()];
				response = setMovieResponseObjectFields(response, nominations);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@RequestMapping(value = "/categories")
	public ResponseEntity<?> AllMovieCategories(
			@RequestParam(value = "cat", defaultValue = "", required = false) String category) {
		
		if (!category.isEmpty()) {
			AwardCategory ac = AwardCategory.valueOf(category.toUpperCase());

			if (ac != null) {
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
		} else {
			AwardCategory[] ac = new AwardCategory[AwardCategory.values().length];
			int i = 0;
			for (AwardCategory a : AwardCategory.values())
			{
				ac[i] = a;
				i++;
			}
			return ResponseEntity.status(HttpStatus.OK).body(ac);
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@RequestMapping(value = "/helpmesearch")
	public ResponseEntity<ArrayList<String>> HelpSearch(){
		ArrayList<String> help = new ArrayList<>();
		
		help.add("Search help:");
		help.add("*** /movies and /categories will return in JSON format all results matching the provided search filters. No matches found will return HTTP 204 No Content.");
		help.add("");
		help.add("/movies:");
		help.add("* All /movies search filters can be used at once to produce results.");
		help.add("Possible /movies search filters: ?movieName= , ?yearStart= , ?yearEnd=, ?actor=");
		help.add("   /movies Seach example 1:   /movies?yearStart=1990&yearEnd=2005");
		help.add("   /movies Seach example 2:   /movies?actor=Tom Hanks");
		help.add("   /movies Seach example 2:   /movies - (Returns all movies)");
		help.add("");
		help.add("/categories");
		help.add("* Only one /categories search filters can be used at once to produce results.");
		help.add("Possible /categories search filters: ?cat=");
		help.add("* ?cat= is sensitive to blank spaces - i.e. cannot use \"Visual Effects\" must be \"VISUAL_EFFECTS\".");
		help.add("* use /categories to decide which exact values to use as a filter");
		help.add("   /categories Seach example 1:   /categories?cat=BEST_PICTURE");
		help.add("   /categories Seach example 2:   /categories?cat=Actor");
		help.add("   /categories Seach example 3:   /categories - (Returns all categories)");
		
		return ResponseEntity.status(HttpStatus.OK).body(help);
	}

	public MovieResponse[] setMovieResponseObjectFields(MovieResponse[] response, List<Nomination> nominations) {

		for (int i = 0; i < nominations.size(); i++) {
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
}
