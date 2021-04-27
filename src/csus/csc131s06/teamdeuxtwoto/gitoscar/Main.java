package csus.csc131s06.teamdeuxtwoto.gitoscar;

import java.sql.SQLException;
import java.util.List;

import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQLHandler;
import csus.csc131s06.teamdeuxtwoto.gitoscar.enums.AwardCategory;
import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQL;
import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.Nomination;
import csus.csc131s06.teamdeuxtwoto.gitoscar.objects.SearchQuery;

public class Main
{
	// Change the file path to wherever you have the database file. Please don't change filename.
	private static final String SQLADDRESS = "C:\\Users\\yyyeeeaaahhh\\Documents\\Eclipse-Workspace\\GitOscar\\sqlitedb\\oscarworthymovies.db";
	
	// Database related things
	private static SQL SQL;
	public static SQL getSQL() { return SQL; }
	
	public static SQLHandler getSQLHandler() { return sqlHandler; }
	
	// Etc Things
	
	
	public static void main(String[] arg)
	{
		System.out.println("Program Started");
		
		SQL = new SQL(SQLADDRESS);
		
		// Following is sql test code. Will delete later.
		try
		{
			SearchQuery query = new SearchQuery();
			query.setAwardCategory(AwardCategory.ACTOR_IN_LEADING_ROLE);
			query.setFilmYear(1999);
			//query.setAwardCategory(AwardCategory.ACTOR_IN_LEADING_ROLE);
			
			
			List<Nomination> oscarList = sqlHandler.getAwardsFromSearchQuery(query);
			if (oscarList != null)
			{
				System.out.println("");
				
				for (Nomination n : oscarList)
				{
					System.out.println(n.print());
				}
				
				System.out.println("");
			}
			else
			{
				System.out.println("\nNo results found based on given parameter.\n ");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
				
		SQL.close();
		
		System.out.println("Program Ended");
	}
}
