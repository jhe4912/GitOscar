package csus.csc131s06.teamdeuxtwoto.gitoscar;

import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQLHandler;

import csus.csc131s06.teamdeuxtwoto.gitoscar.gui.GUI;

import java.io.File;

import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQL;

public class Main
{
	// Change the file path to wherever you have the database file. Please don't change filename.
	
	static String filePath = new File("").getAbsolutePath() + "\\sqlitedb\\oscarworthymovies.db";
	private static final String SQLADDRESS = filePath;
	
	public final static String getSQLLiteAddress() { return SQLADDRESS; }
	// Database related things
	private static SQL SQL = null;
	public static SQL getSQL() { return SQL; }
	
	private static SQLHandler sqlHandler = new SQLHandler();
	public static SQLHandler getSQLHandler() { return sqlHandler; }
	
	// Etc Things
	
	public static void main(String[] arg)
	{
		System.out.println("Program Started at - " + filePath);
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
