package com.xadmin.FuelDetailsManagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.FuelDetailsManage.bean.Fuel;
import com.xadmin.FuelDetailsManagement.dao.FuelDao;




/**
 * Servlet implementation class FuelServlet
 */
@WebServlet("/") //handle all the requests with single servlet
public class FuelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FuelDao fuelDao;   
    

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		fuelDao= new FuelDao();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		
	try {
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertFuel(request, response);
			break;
		case "/delete":
			deleteFuel(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
	        break;
		case "/update":
			updateFuel(request, response);
			break;
		default:
			listFuel(request, response);
            break;
	    }
	}catch(SQLException ex) {
		throw new ServletException(ex);
	    }
	}
	
	//default
	
	  private void listFuel(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException 
		{
		   List<Fuel> listFuel = fuelDao.selectAllFuel();
	       request.setAttribute("listFuel", listFuel);
	       RequestDispatcher dispatcher = request.getRequestDispatcher("fuel-list.jsp");
		   dispatcher.forward(request, response);
			}
		
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("fuel-form.jsp");
			dispatcher.forward(request, response);
		}
		
		private void insertFuel(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			String fuelType = request.getParameter("fuelType");
			String date = request.getParameter("date");
			String fuelQuantity = request.getParameter("fuelQuantity");
			String tankIdentification = request.getParameter("tankIdentification");
			String unitPrice = request.getParameter("unitPrice");
			String totalCost = request.getParameter("totalCost");
			String supplier = request.getParameter("supplier");
			String employeeID = request.getParameter("employeeID");
			String note = request.getParameter("note");
			Fuel newFuel = new Fuel(fuelType, date, fuelQuantity, tankIdentification, unitPrice, totalCost, supplier, employeeID, note);
			fuelDao.insertFuel(newFuel);
			response.sendRedirect("list");
		}
		
		//delete fuel
		
		private void deleteFuel(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			try {
			fuelDao.deleteFuel(id);
			} catch(Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("list");

		}
		
		//edit
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			
			   Fuel existingFuel;
			   try {
			       existingFuel = fuelDao.selectFuel(id);
			       RequestDispatcher dispatcher = request.getRequestDispatcher("fuel-form.jsp");
			       request.setAttribute("fuel", existingFuel);
			       dispatcher.forward(request, response);
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
			

		}
		
		//update
		private void updateFuel(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			String fuelType = request.getParameter("fuelType");
			String date = request.getParameter("date");
			String fuelQuantity = request.getParameter("fuelQuantity");
			String tankIdentification = request.getParameter("tankIdentification");
			String unitPrice = request.getParameter("unitPrice");
			String totalCost = request.getParameter("totalCost");
			String supplier = request.getParameter("supplier");
			String employeeID = request.getParameter("employeeID");
			String note = request.getParameter("note");

			Fuel fuel = new Fuel(id,fuelType, date, fuelQuantity, tankIdentification, unitPrice, totalCost, supplier, employeeID, note);
			fuelDao.updateFuel(fuel);
			response.sendRedirect("list");
		}
		
		

		
		}

	


