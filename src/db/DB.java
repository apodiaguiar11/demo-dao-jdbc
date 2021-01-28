package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	//Conectar com o banco de dados no jdbc � instanciar um objeto do tipo Connection
	
	//O objeto � do tipo Connection do java.sql
	private static Connection conn = null;
	
	//M�todo para conectar com o banco de dados	
	public static Connection getConnection() {
		if(conn==null) {
			try {
				Properties props = loadProperties();//Pegando as propriedades do banco de dados
				String url = props.getProperty("dburl");//Pegando a url que definir no arquivo db.properties
				conn = DriverManager.getConnection(url,props);//Conectamos com o banco de dados
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	//M�todo para fechar a conex�o
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
	}
		
	
	//M�todo para carregar as propriedades que est�o definidas no arquivo db.properties
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	
	public static void closeStatement(Statement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
}
