package com.example.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.demo.config.SpringBootTestConfig;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ContextConfiguration(classes={SpringBootTestConfig.class})
@TestPropertySource(value = "classpath:application.properties")
class DemoApplicationTests {

	@Autowired
	private SQLServerDataSource ds;

	@Test
	void contextLoads() {
	}

	@Test
	public void databaseTest() 
	{
		System.out.println("test");

		try (Connection con = ds.getConnection()) 
		{
			System.out.println("testX");
			Statement statement = con.createStatement();
			statement.execute("SELECT * FROM Person");
			ResultSet rs = statement.getResultSet();

			while (rs.next())
			{
				System.out.println("PERSON: " + rs.getString("First") + ", " + rs.getString("Last"));
			}

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		System.out.println("test2");
	}

}
