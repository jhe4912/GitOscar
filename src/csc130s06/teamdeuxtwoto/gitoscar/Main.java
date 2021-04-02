package csc130s06.teamdeuxtwoto.gitoscar;

import csc130s06.teamdeuxtwoto.gitoscar.database.SQLite;

public class Main
{
	// Change the file path to wherever you have the database file
	private static String sqLiteFilePath = "Insert your oscarworthymovies.db filepath here";
	
	private static SQLite sqlite;
	public static SQLite getSQL() { return sqlite; }
	
	public static void main(String[] arg)
	{
		System.out.println("Program Started");
		
		sqlite = new SQLite(sqLiteFilePath);
		sqlite.close();
		
		System.out.println("Program Ended");
	}
}
