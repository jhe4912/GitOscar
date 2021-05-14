package csus.csc131s06.teamdeuxtwoto.gitoscar;

import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQLHandler;
import csus.csc131s06.teamdeuxtwoto.gitoscar.gui.GUI;
import csus.csc131s06.teamdeuxtwoto.gitoscar.database.SQL;

public class Main
{	
	// Database related things
	private static SQL SQL;
	public static SQL getSQL() { return SQL; }
	
	private static SQLHandler sqlHandler = new SQLHandler();
	public static SQLHandler getSQLHandler() { return sqlHandler; }
	
	public static void main(String[] arg)
	{
		System.out.println("Main Program Started");
		
		SQL = new SQL();
		new GUI();
	}
	
	public static void end()
	{
		SQL.close();
		System.out.println("Main Program Ended");
		System.exit(0);
	}
}
