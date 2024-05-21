package com.xadmin.Parts.web;

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

import com.xadmin.Parts.bean.Parts;
import com.xadmin.Parts.dao.PartsDao;






/**
 * Servlet implementation class FuelServlet
 */
@WebServlet("/") //handle all the requests with single servlet
public class PartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PartsDao partsDao;   
    

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		partsDao= new PartsDao();
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
			insertParts(request, response);
			break;
		case "/delete":
			deleteParts(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
	        break;
		case "/update":
			updateParts(request, response);
			break;
		default:
			listParts(request, response);
            break;
	    }
	}catch(SQLException ex) {
		throw new ServletException(ex);
	    }
	}
	
	//default
	
	  private void listParts(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException 
		{
		   List<Parts> listParts =partsDao.selectAllParts();
	       request.setAttribute("listParts", listParts);
	       RequestDispatcher dispatcher = request.getRequestDispatcher("parts-list.jsp");
		   dispatcher.forward(request, response);
			}
		
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("parts-form.jsp");
			dispatcher.forward(request, response);
		}
		
		private void insertParts(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			String partName = request.getParameter("partName");
			String partdescription = request.getParameter("partdescription");
			String category = request.getParameter("category");
			String supplier = request.getParameter("supplier");
			String quantity = request.getParameter("quantity");
			String unitPrice = request.getParameter("unitPrice");
			
		
			Parts newParts = new Parts(partName, partdescription, category, supplier, quantity,unitPrice);
			partsDao.insertParts(newParts);
			response.sendRedirect("list");
		}
		
		//delete fuel
		
		private void deleteParts(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException 
		{
			int partID = Integer.parseInt(request.getParameter("partID"));
			try {
			partsDao.deleteParts(partID);
			} catch(Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("list");

		}
		
		//edit
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException 
		{
			int partID = Integer.parseInt(request.getParameter("partID"));
			
			   Parts existingParts;
			   try {
			       existingParts = partsDao.selectParts(partID);
			       RequestDispatcher dispatcher = request.getRequestDispatcher("parts-form.jsp");
			       request.setAttribute("parts", existingParts);
			       dispatcher.forward(request, response);
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
			

		}
		
		//update
		private void updateParts(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int partID = Integer.parseInt(request.getParameter("partID"));
			String partName = request.getParameter("partName");
			String partdescription = request.getParameter("partdescription");
			String category = request.getParameter("category");
			String supplier = request.getParameter("supplier");
			String quantity = request.getParameter("quantity");
			String unitPrice = request.getParameter("unitPrice");
			
			
			Parts parts = new Parts(partID,partName, partdescription, category, supplier, quantity,unitPrice);
			partsDao.updateParts(parts);
			response.sendRedirect("list");
		}
		
		

		
		}

	
