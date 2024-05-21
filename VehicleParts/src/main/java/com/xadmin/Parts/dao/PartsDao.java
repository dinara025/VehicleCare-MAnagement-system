package com.xadmin.Parts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.Parts.bean.Parts;

public class PartsDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/vehiclecare";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1234";
	private String jdbcDriver="com.mysql.jdbc.Driver";

	private static final String INSERT_PARTS_SQL = "INSERT INTO vehiclecare.parts" + "  (partName, partdescription, category, supplier, quantity,unitPrice) VALUES "
			+ " (?, ?, ?, ?, ?,?);";

	private static final String SELECT_PARTS_BY_ID = "select partID, partName, partdescription, category, supplier, quantity,unitPrice from vehiclecare.parts where partID =?";
	private static final String SELECT_ALL_PARTS = "select * from vehiclecare.parts" ;
	private static final String DELETE_PARTS_SQL = "delete from vehiclecare.parts where partID = ?;";
	private static final String UPDATE_PARTS_SQL = "update vehiclecare.parts set partName = ?,partdescription= ?, category =?, supplier =?, quantity =?,unitPrice =? where partID = ?;";

	public PartsDao() {}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
    //insert fuel
	public void insertParts(Parts parts) throws SQLException {
		//******System.out.println(INSERT_FUEL_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PARTS_SQL)) {
			preparedStatement.setString(1, parts.getPartName());
			preparedStatement.setString(2, parts.getPartdescription());
			preparedStatement.setString(3, parts.getCategory());
			preparedStatement.setString(4, parts.getSupplier());
			preparedStatement.setString(5, parts.getQuantity());
			preparedStatement.setString(6, parts.getUnitPrice());
			

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	//select fuel by id

	public Parts selectParts(int partID) {
		Parts parts = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PARTS_BY_ID);) {
			preparedStatement.setInt(1, partID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String partName = rs.getString("partName");
				String partdescription = rs.getString("partdescription");
				String category = rs.getString("category");
				String supplier = rs.getString("supplier");
				String quantity = rs.getString("quantity");
				String unitPrice = rs.getString("unitPrice");
				parts = new Parts(partID, partName, partdescription, category, supplier, quantity,unitPrice);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return parts;
	}
	
	//select all fuel

	public List<Parts> selectAllParts() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Parts> parts = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PARTS);) {
			System.out.println(preparedStatement);
			
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int partID = rs.getInt("partID");
				String partName = rs.getString("partName");
				String partdescription = rs.getString("partdescription");
				String category = rs.getString("category");
				String supplier = rs.getString("supplier");
				String quantity = rs.getString("quantity");
				String unitPrice = rs.getString("unitPrice");
				
				parts.add(new Parts(partID, partName, partdescription, category, supplier, quantity,unitPrice));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return parts;
	}

	//delete fuel
	public boolean deleteParts(int partID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PARTS_SQL);) {
			statement.setInt(1, partID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	//update fuel
	public boolean updateParts(Parts parts) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PARTS_SQL);) {
			System.out.println("updated Parts:"+statement);
			statement.setString(1, parts.getPartName());
			statement.setString(2, parts.getPartdescription());
			statement.setString(3, parts.getCategory());
			statement.setString(4, parts.getSupplier());
			statement.setString(5, parts.getQuantity());
			statement.setString(6, parts.getUnitPrice());
			statement.setInt(7, parts.getPartID());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}