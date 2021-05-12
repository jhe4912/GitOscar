package csus.csc131s06.teamdeuxtwoto.gitoscar;

import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQLHandler;
import csus.csc131s06.teamdeuxtwoto.gitoscar.gui.GUI;

import java.util.Scanner;

import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQL;

public class Main
{
	// Change the file path to wherever you have the database file. Please don't change filename.
	private static final String SQLADDRESS = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/sqlitedb/oscarworthymovies.db");
	public static final String getSQLLiteAddress() { return SQLADDRESS; }
  
	// Database related things
	private static SQL SQL;
	public static SQL getSQL() { return SQL; }
	
	private static SQLHandler sqlHandler = new SQLHandler();
	public static SQLHandler getSQLHandler() { return sqlHandler; }
	
	// Etc Things
	
	private static boolean openTestGUI = true;
	
	public static void main(String[] arg) 
	{
		System.out.println("Program Started");
		
		SQL = new SQL(SQLADDRESS);
		
		if (openTestGUI)
		{
			new GUI();
		}
		else
		{
			Scanner scanner = new Scanner(System.in);
			String s = null;
			
			do
			{
				s = scanner.nextLine();
			}
			while (s == null || !s.equalsIgnoreCase("exit"));
				
			scanner.close();
			end();
		}
	}
	
	public static void end()
	{
		SQL.close();
		System.out.println("Program Ended");
		System.exit(0);
	}
}
