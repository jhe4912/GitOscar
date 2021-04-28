package csus.csc131s06.teamdeuxtwoto.gitoscar.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL
{
	enum Type
	{
		SQLITE, MYSQL
	}
	
	private Type type;
	private String address = "";
	private String user = "";
	private String pass = "";
	private Connection con;
	
	public SQL(String address)
	{
		this.type = Type.SQLITE;
		this.address = "jdbc:sqlite:" + address;
		System.out.println("Setting up SQLite database access.");
		connect();
	}
	
	public SQL(String host, String port, String database, String user, String pass)
	{
		this.type = Type.MYSQL;
		this.address = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true";
		this.user = user;
		this.pass = pass;
		System.out.println("Setting up MySQL database access.");
		connect();
	}
	
	public boolean hasConnection() { return this.con != null; }
	
	public void connect()
	{
		try
		{
			switch (type)
			{
				case MYSQL:
					this.con = DriverManager.getConnection(address, user, pass);
					break;
					
				case SQLITE:
					this.con = DriverManager.getConnection(address);
					break;
			}
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
			switch (type)
			{
				case MYSQL:
					this.con = DriverManager.getConnection(address, user, pass);
					break;
					
				case SQLITE:
					this.con = DriverManager.getConnection(address);
					break;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
