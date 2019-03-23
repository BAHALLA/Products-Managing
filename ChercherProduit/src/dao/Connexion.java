package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	private static Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/produit_manager","root","");
			System.out.println("bd connexion");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}

}
