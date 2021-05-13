package csus.csc131s06.teamdeuxtwoto.gitoscar;

import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQLHandler;

import csus.csc131s06.teamdeuxtwoto.gitoscar.gui.GUI;

import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQL;

public class Main
{
	// Change the file path to wherever you have the database file. Please don't change filename.
	private static final String SQLADDRESS = "C:\\Users\\yyyeeeaaahhh\\Documents\\Eclipse-Workspace\\GitOscar\\sqlitedb\\oscarworthymovies.db";
	public final static String getSQLLiteAddress() { return SQLADDRESS; }
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
		new GUI();
	}
	
	public static void end()
	{
		SQL.close();
		System.out.println("Program Ended");
		System.exit(0);
	}
}
