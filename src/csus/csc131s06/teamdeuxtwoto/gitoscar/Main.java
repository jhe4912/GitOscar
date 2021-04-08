package csus.csc131s06.teamdeuxtwoto.gitoscar;

import java.sql.SQLException;
import java.util.List;

import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQLHandler;
import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQL;
import csus.csc131s06.teamdeuxtwoto.gitoscar.enums.AwardCategory;

public class Main
{
	// Change the file path to wherever you have the database file. Please don't change filename.
	private static final String SQLADDRESS = "Insert your oscarworthymovies.db filepath here";
	
	// Database related things
	private static SQL SQL;
	public static SQL getSQL() { return SQL; }
	
	private static SQLHandler sqlHandler = new SQLHandler();
	public static SQLHandler getSQLHandler() { return sqlHandler; }
	
	// Etc Things
	
	
	public static void main(String[] arg)
	{
		System.out.println("Program Started");
		
		SQL = new SQL(SQLADDRESS);
		
		// Following is sql test code. Will delete later.
		try
		{
			List<String> oscarList = sqlHandler.getAllAwardsFromCategory(AwardCategory.ACTOR);
			if (oscarList != null)
			{
				System.out.println("");
				
				for (String s : oscarList)
				{
					System.out.println(s);
				}
				
				System.out.println("");
			}
			else
			{
				System.out.println("\nInvalid ceremony number.\n ");
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
