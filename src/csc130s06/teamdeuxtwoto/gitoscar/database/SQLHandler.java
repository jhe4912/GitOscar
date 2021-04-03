package csc130s06.teamdeuxtwoto.gitoscar.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import csc130s06.teamdeuxtwoto.gitoscar.Main;

public class SQLHandler
{
	/*
	 *  Database info:
	 *  Table name = oscars
	 *  Columns (data type): 
	 *    yearFilm (text) (data type subject to change)
	 *    yearCeremony (text) (data type subject to change)
	 *    ceremony (text) (data type subject to change)
	 *    category (text) 
	 *    name (text)
	 *    film (text)
	 *    winner (text)
	 */
	
	
	// This method is used only for testing the database.
	public List<String> getAllAwardsFromCeremonyNumber(int ceremony) throws SQLException
	{
		SQLite sql = Main.getSQL();
		sql.refreshConnection();
		
		List<String> awardsAndInfo = new ArrayList<String>();
		ResultSet rs = sql.query("SELECT * FROM oscars WHERE ceremony='" + ceremony + "'");
		
		while (rs.next())
		{
			awardsAndInfo.add(
					"Film year: " + rs.getString("yearFilm") + " - " +
					"Ceremony year: " + rs.getString("yearCeremony") + " - " +
					"Ceremony number: " + rs.getString("ceremony") + " - " +
					"Category: " + rs.getString("category") + " - " +
					"Name: " + rs.getString("name") + " - " +
					"For film: " + rs.getString("film") + " - " +
					"Winner: " + ((rs.getBoolean("winner")) ? "Yes" : "No"));
		}
		
		return (!awardsAndInfo.isEmpty()) ? awardsAndInfo : null;
	}
}
