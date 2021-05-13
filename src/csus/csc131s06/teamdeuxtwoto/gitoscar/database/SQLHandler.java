package csus.csc131s06.teamdeuxtwoto.gitoscar.database;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import csus.csc131s06.teamdeuxtwoto.gitoscar.Main;
import csus.csc131s06.teamdeuxtwoto.gitoscar.enums.AwardCategory;
import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.Nomination;
import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.SearchQuery;

public class SQLHandler
{
	/*
	 *  Database info:
	 *  Table name = oscars
	 *  Columns (data type): 
	 *    yearFilm (int)
	 *    yearCeremony (int)
	 *    ceremony (int) 
	 *    category (text) 
	 *    name (text)
	 *    film (text)
	 *    winner (text)
	 */
	
	public List<Nomination> getAwardsFromSearchQuery(SearchQuery searchQuery) throws SQLException
	{
		StringBuilder sb = new StringBuilder();
		
		if (searchQuery.getFilmYearStart() > 0 && searchQuery.getFilmYearEnd() > 0)
		{
			int start = searchQuery.getFilmYearStart();
			int end = searchQuery.getFilmYearEnd();
			
			if (start > end)
			{
				int temp = start;
				start = end;
				end = temp;
			}
			
			sb.append(" (yearFilm BETWEEN " + start + " AND " + end +") AND");
		}
		
		if (searchQuery.getCeremonyYear() > 0)
			sb.append(" yearCeremony='" + searchQuery.getCeremonyYear() + "' AND");
		
		if (searchQuery.getCeremonyNumber() > 0)
			sb.append(" ceremony='" + searchQuery.getCeremonyNumber() + "' AND");
		
		if (!searchQuery.getAwardCategorys().isEmpty())
		{
			sb.append(" (");
			for (AwardCategory ac : searchQuery.getAwardCategorys())
				sb.append("category='" + ac.getSQLCatKey() + "' OR ");
			sb.delete(sb.length() - 4, sb.length());
			sb.append(") AND");
		}
			
		
		if (searchQuery.getAwardedTo() != null)
			sb.append(" name='" + searchQuery.getAwardedTo() + "' AND");
		
		if (searchQuery.getFilmName() != null)
			sb.append(" film='" + searchQuery.getFilmName() + "' AND");
		
		if (searchQuery.getResultsToInclude() != null)
		{
			switch (searchQuery.getResultsToInclude())
			{
				case WINNER_ONLY:
					sb.append(" winner='" + 1 + "' AND");
					break;
					
				case NON_WINNER_ONLY:
					sb.append(" winner='" + 0 + "' AND");
					break;
					
				case BOTH:
					sb.append(" (winner='" + 0 + "' OR winner='" + 1 + "') AND");
					break;
			}
		}
		
		if (sb.length() == 0) return null;
		sb.delete(sb.length() - 4, sb.length());
		
		boolean isRestAPIRequest = false;
		
		SQL sql = Main.getSQL();
		if(sql == null) {
			isRestAPIRequest = true;
			sql = new SQL(Main.getSQLLiteAddress());
		}else {
			sql.refreshConnection();
		}
		
		List<Nomination> awardNominations = new ArrayList<>();
		ResultSet rs = sql.query("SELECT * FROM oscars WHERE" + sb.toString());
		System.out.println("Query made to database: SELECT * FROM oscars WHERE" + sb.toString());
		
		while (rs.next())
		{
			awardNominations.add(new Nomination( 
					rs.getInt("ID"), rs.getInt("yearFilm"), rs.getInt("yearCeremony"), rs.getInt("ceremony"), 
					rs.getString("category"), rs.getString("name"),	rs.getString("film"), 
					rs.getBoolean("winner")));
		}
		
		if (isRestAPIRequest) sql.close();
		
		return (!awardNominations.isEmpty()) ? awardNominations : null;
	}
}
