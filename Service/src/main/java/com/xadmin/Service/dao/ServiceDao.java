package com.xadmin.Service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.Service.bean.Service;


public class ServiceDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/vehiclecare";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1234";
	private String jdbcDriver="com.mysql.jdbc.Driver";

	private static final String INSERT_SERVICE_SQL = "INSERT INTO vehiclecare.service" + "  (serviceName, serviceType, serviceDescription, serviceAvailability, servicePrice) VALUES "
			+ " (?, ?, ?, ?, ?);";

	private static final String SELECT_SERVICE_BY_ID = "select serviceID, serviceName, serviceType, serviceDescription, serviceAvailability, servicePrice from vehiclecare.service where serviceID =?";
	private static final String SELECT_ALL_SERVICE = "select * from vehiclecare.service" ;
	private static final String DELETE_SERVICE_SQL = "delete from vehiclecare.service where serviceID = ?;";
	private static final String UPDATE_SERVICE_SQL = "update vehiclecare.service set serviceName = ?,serviceType= ?, serviceDescription =?, serviceAvailability =?, servicePrice =? where serviceID = ?;";

	public ServiceDao() {}
	
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
	public void insertService(Service service) throws SQLException {
		//******System.out.println(INSERT_FUEL_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL)) {
			preparedStatement.setString(1, service.getServiceName());
			preparedStatement.setString(2, service.getServiceType());
			preparedStatement.setString(3, service.getServiceDescription());
			preparedStatement.setString(4, service.getServiceAvailability());
			preparedStatement.setString(5, service.getServicePrice());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	//select fuel by id

	public Service selectService(int serviceID) {
		Service service = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);) {
			preparedStatement.setInt(1, serviceID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String serviceName = rs.getString("serviceName");
				String serviceType = rs.getString("serviceType");
				String serviceDescription = rs.getString("serviceDescription");
				String serviceAvailability = rs.getString("serviceAvailability");
				String servicePrice = rs.getString("servicePrice");
				service = new Service(serviceID, serviceName, serviceType, serviceDescription, serviceAvailability, servicePrice);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return service;
	}
	
	//select all fuel

	public List<Service> selectAllService() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Service> service = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);) {
			System.out.println(preparedStatement);
			
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int serviceID = rs.getInt("serviceID");
				String serviceName = rs.getString("serviceName");
				String serviceType = rs.getString("serviceType");
				String serviceDescription = rs.getString("serviceDescription");
				String serviceAvailability = rs.getString("serviceAvailability");
				String servicePrice = rs.getString("servicePrice");
				
				service.add(new Service(serviceID, serviceName, serviceType, serviceDescription, serviceAvailability, servicePrice));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return service;
	}

	//delete fuel
	public boolean deleteService(int serviceID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_SERVICE_SQL);) {
			statement.setInt(1, serviceID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	//update fuel
	public boolean updateService(Service service) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_SERVICE_SQL);) {
			System.out.println("updated Service:"+statement);
			statement.setString(1, service.getServiceName());
			statement.setString(2, service.getServiceType());
			statement.setString(3, service.getServiceDescription());
			statement.setString(4, service.getServiceAvailability());
			statement.setString(5, service.getServicePrice());
			statement.setInt(6, service.getServiceID());

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