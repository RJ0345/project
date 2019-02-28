package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;
import com.lti.model.Customer;

@WebServlet("/customer.info")
public class CustomerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer customer = new Customer();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		customer.setId(id);
		customer.setName(name);
		customer.setEmail(email);

		CustomerDao cdao = new CustomerDao();
		cdao.add(customer);

		response.sendRedirect("Sucessfull.html");
	}

}
