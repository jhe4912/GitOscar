package csc130s06.teamdeuxtwoto.gitoscar;

import csc130s06.teamdeuxtwoto.gitoscar.database.SQLite;

public class Main
{
	// Change the file path to wherever you need the database file to be
	private static String sqLiteFilePath = "E:/CSC131/GitOscar/sqlitedb/oscarworthymovies.db";
	
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
