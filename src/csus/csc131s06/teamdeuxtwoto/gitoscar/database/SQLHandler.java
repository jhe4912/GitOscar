package csus.csc131s06.teamdeuxtwoto.gitoscar.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import csus.csc131s06.teamdeuxtwoto.gitoscar.Main;
import csus.csc131s06.teamdeuxtwoto.gitoscar.enums.AwardCategory;
import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.Nomination;

public class SQLHandler
{
	/*
	 *  Database info:
	 *  Table name = oscars
	 *  Columns (data type): 
	 *    yearFilm (int) (data type subject to change)
	 *    yearCeremony (int) (data type subject to change)
	 *    ceremony (int) (data type subject to change)
	 *    category (text) 
	 *    name (text)
	 *    film (text)
	 *    winner (text)
	 */
	
	public List<Nomination> getAllAwardsFromCategory(AwardCategory cat) throws SQLException
	{
		SQL sql = Main.getSQL();
		sql.refreshConnection();
		
		List<Nomination> awardNominations = new ArrayList<>();
		ResultSet rs = sql.query("SELECT * FROM oscars WHERE category='" + cat.getSQLCatKey() + "'");
		
		while (rs.next())
		{
			awardNominations.add(new Nomination(
					rs.getInt("yearFilm"), rs.getInt("yearCeremony"), rs.getInt("ceremony"), 
					rs.getString("category"), rs.getString("name"),	rs.getString("film"), 
					rs.getBoolean("winner")));
		}
		
		return (!awardNominations.isEmpty()) ? awardNominations : null;
	}
}
