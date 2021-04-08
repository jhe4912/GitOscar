package csc130s06.teamdeuxtwoto.gitoscar.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL
{
	public enum Type
	{
		SQLITE, MYSQL
	}
	
	private String address = "";
	private Connection con;
	
	public SQL(Type type, String address)
	{
		switch (type)
		{
			case MYSQL:
				this.address = "jdbc:mysql://" + address;
				System.out.println("Setting up MySQL database access.");
				break;
			
			case SQLITE:
				this.address = "jdbc:sqlite:" + address;
				System.out.println("Setting up SQLite database access.");
				break;
		}
		connect();
	}
	
	public boolean hasConnection() { return this.con != null; }
	
	public void connect()
	{
		try
		{
			this.con = DriverManager.getConnection(address);
			System.out.println("Connection to database has been made.");
		}
		catch (SQLException e)
		{
			System.out.println("Connection to database has not been made."
					+ " See following exception error.");
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		try
		{
			if (this.con != null)
			{
				this.con.close();
				System.out.println("Connection to database has ended.");
			}	
		}
		catch (SQLException e)
		{
			System.out.println("Connection to database couldn't be closed."
					+ " See following exception error.");
			e.printStackTrace();
		}
	}
	
	public void update(String qry)
	{
		try
		{
			PreparedStatement st = this.con.prepareStatement(qry);
			st.execute();
			st.close();
		}
		catch (SQLException e)
		{
			connect();
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String qry)
	{
		ResultSet rs = null;
		
		try
		{
			PreparedStatement st = this.con.prepareStatement(qry);
			rs = st.executeQuery();
		}
		catch (SQLException e)
		{
			connect();
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void refreshConnection()
	{
		try
		{
			if (this.con.isValid(1)) return;
			this.con.close();
		} catch (SQLException e) {}
		
		try
		{
			this.con = DriverManager.getConnection(address);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
