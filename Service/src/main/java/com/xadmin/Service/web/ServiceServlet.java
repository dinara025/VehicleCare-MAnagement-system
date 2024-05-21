package com.xadmin.Service.web;

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

import com.xadmin.Service.bean.Service;
import com.xadmin.Service.dao.ServiceDao;




/**
 * Servlet implementation class FuelServlet
 */
@WebServlet("/") //handle all the requests with single servlet
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServiceDao serviceDao;   
    

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		serviceDao= new ServiceDao();
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
			insertService(request, response);
			break;
		case "/delete":
			deleteService(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
	        break;
		case "/update":
			updateService(request, response);
			break;
		default:
			listService(request, response);
            break;
	    }
	}catch(SQLException ex) {
		throw new ServletException(ex);
	    }
	}
	
	//default
	
	  private void listService(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException 
		{
		   List<Service> listService = serviceDao.selectAllService();
	       request.setAttribute("listService", listService);
	       RequestDispatcher dispatcher = request.getRequestDispatcher("service-list.jsp");
		   dispatcher.forward(request, response);
			}
		
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("service-form.jsp");
			dispatcher.forward(request, response);
		}
		
		private void insertService(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			String serviceName = request.getParameter("serviceName");
			String serviceType = request.getParameter("serviceType");
			String serviceDescription = request.getParameter("serviceDescription");
			String serviceAvailability = request.getParameter("serviceAvailability");
			String servicePrice = request.getParameter("servicePrice");
		
			Service newService = new Service(serviceName, serviceType, serviceDescription, serviceAvailability, servicePrice);
			serviceDao.insertService(newService);
			response.sendRedirect("list");
		}
		
		//delete fuel
		
		private void deleteService(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException 
		{
			int serviceID = Integer.parseInt(request.getParameter("serviceID"));
			try {
			serviceDao.deleteService(serviceID);
			} catch(Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("list");

		}
		
		//edit
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException 
		{
			int serviceID = Integer.parseInt(request.getParameter("serviceID"));
			
			   Service existingService;
			   try {
			       existingService = serviceDao.selectService(serviceID);
			       RequestDispatcher dispatcher = request.getRequestDispatcher("service-form.jsp");
			       request.setAttribute("service", existingService);
			       dispatcher.forward(request, response);
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
			

		}
		
		//update
		private void updateService(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int serviceID = Integer.parseInt(request.getParameter("serviceID"));
			String serviceName = request.getParameter("serviceName");
			String serviceType = request.getParameter("serviceType");
			String serviceDescription = request.getParameter("serviceDescription");
			String serviceAvailability = request.getParameter("serviceAvailability");
			String servicePrice = request.getParameter("servicePrice");
			
			Service service = new Service(serviceID,serviceName, serviceType, serviceDescription, serviceAvailability, servicePrice);
			serviceDao.updateService(service);
			response.sendRedirect("list");
		}
		
		

		
		}

	
