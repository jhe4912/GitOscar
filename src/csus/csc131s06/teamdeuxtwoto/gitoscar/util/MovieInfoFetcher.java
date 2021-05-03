package csus.csc131s06.teamdeuxtwoto.gitoscar.util;

import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.Nomination;

public class MovieInfoFetcher
{
	public static String getMovieHyperLink(Nomination nomination)
	{
		if (nomination.getFilmName().equals("") || nomination.getFilmName().equals(" ")) 
			return "";
		return "<a href=\"https://www.google.com/search?q=" + nomination.getFilmName().replace(" ", "+") 
				+ "+" + nomination.getFilmYear() + "+film\">" + nomination.getFilmName() + "</a>";
	}
}
