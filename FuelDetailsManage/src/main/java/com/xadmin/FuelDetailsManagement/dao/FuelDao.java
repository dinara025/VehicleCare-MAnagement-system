package com.xadmin.FuelDetailsManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.FuelDetailsManage.bean.Fuel;


public class FuelDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/vehiclecare";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1234";
	private String jdbcDriver="com.mysql.jdbc.Driver";

	private static final String INSERT_FUEL_SQL = "INSERT INTO vehiclecare.fuel" + "  (fuelType,date,fuelQuantity,tankIdentification,unitPrice,totalCost,supplier,employeeID,note) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_FUEL_BY_ID = "select id, fuelType, date, fuelQuantity, tankIdentification, unitPrice, totalCost, supplier, employeeID, note from vehiclecare.fuel where id =?";
	private static final String SELECT_ALL_FUEL = "select * from vehiclecare.fuel" ;
	private static final String DELETE_FUEL_SQL = "delete from vehiclecare.fuel where id = ?;";
	private static final String UPDATE_FUEL_SQL = "update vehiclecare.fuel set fuelType = ?,date= ?, fuelQuantity =?, tankIdentification =?, unitPrice =?, totalCost =?, supplier =?, employeeID =?, note =? where id = ?;";

	public FuelDao() {}
	
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
	public void insertFuel(Fuel fuel) throws SQLException {
		//******System.out.println(INSERT_FUEL_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FUEL_SQL)) {
			preparedStatement.setString(1, fuel.getFuelType());
			preparedStatement.setString(2, fuel.getDate());
			preparedStatement.setString(3, fuel.getFuelQuantity());
			preparedStatement.setString(4, fuel.getTankIdentification());
			preparedStatement.setString(5, fuel.getUnitPrice());
			preparedStatement.setString(6, fuel.getTotalCost());
			preparedStatement.setString(7, fuel.getSupplier());
			preparedStatement.setString(8, fuel.getEmployeeID());
			preparedStatement.setString(9, fuel.getNote());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	//select fuel by id

	public Fuel selectFuel(int id) {
		Fuel fuel = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FUEL_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String fuelType = rs.getString("fuelType");
				String date = rs.getString("date");
				String fuelQuantity = rs.getString("fuelQuantity");
				String tankIdentification = rs.getString("tankIdentification");
				String unitPrice = rs.getString("unitPrice");
				String totalCost = rs.getString("totalCost");
				String supplier = rs.getString("supplier");
				String employeeID = rs.getString("employeeID");
				String note = rs.getString("note");
				fuel = new Fuel(id, fuelType, date, fuelQuantity, tankIdentification, unitPrice, totalCost, supplier, employeeID, note);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return fuel;
	}
	
	//select all fuel

	public List<Fuel> selectAllFuel() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Fuel> fuel = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FUEL);) {
			System.out.println(preparedStatement);
			
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String fuelType = rs.getString("fuelType");
				String date = rs.getString("date");
				String fuelQuantity = rs.getString("fuelQuantity");
				String tankIdentification = rs.getString("tankIdentification");
				String unitPrice = rs.getString("unitPrice");
				String totalCost = rs.getString("totalCost");
				String supplier = rs.getString("supplier");
				String employeeID = rs.getString("employeeID");
				String note = rs.getString("note");
				fuel.add(new Fuel(id, fuelType, date, fuelQuantity, tankIdentification, unitPrice, totalCost, supplier, employeeID, note));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return fuel;
	}

	//delete fuel
	public boolean deleteFuel(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_FUEL_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	//update fuel
	public boolean updateFuel(Fuel fuel) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_FUEL_SQL);) {
			System.out.println("updated Fuel:"+statement);
			statement.setString(1, fuel.getFuelType());
			statement.setString(2, fuel.getDate());
			statement.setString(3, fuel.getFuelQuantity());
			statement.setString(4, fuel.getTankIdentification());
			statement.setString(5, fuel.getUnitPrice());
			statement.setString(6, fuel.getTotalCost());
			statement.setString(7, fuel.getSupplier());
			statement.setString(8, fuel.getEmployeeID());
			statement.setString(9, fuel.getNote());
			statement.setInt(10, fuel.getid());

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
