package vn.poly.phuongcqph05100.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import vn.poly.phuongcqph05100.dao.CustomerDao;
import vn.poly.phuongcqph05100.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListCustomerController
 */
public class ListCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListCustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		CustomerDao customerDao = new CustomerDao();
		try {
			String action = request.getParameter("action");

			if (action.equals("Hello")) {

				List<Customer> list = customerDao.getListCustomer(null);
				request.setAttribute("listCustomer", list);
				String url = "customer.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}

			if (action.equals("Search")) {
				String maKH = request.getParameter("txtMaKH");

				List<Customer> list = customerDao.getListCustomer(maKH);
				request.setAttribute("listCustomer", list);
				String url = "customer.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}

			else if (action.equals("Delete")) {
				String makh = request.getParameter("txtMaKH");

				boolean daxoa = customerDao.deleteCustomer(makh);
				if (daxoa) {
					String url = "ListCustomerController?txtMaKH=&action=Search";
					RequestDispatcher rd = request.getRequestDispatcher(url);
					rd.forward(request, response);
				}

			}

			else if (action.equals("Update")) {

				String makh = request.getParameter("txtMaKH");
				request.setAttribute("makh", makh);
				String matkhau = request.getParameter("txtMatKhau");
				request.setAttribute("matkhau", matkhau);
				String hovaten = request.getParameter("txtHVT");
				request.setAttribute("hovaten", hovaten);
				String sodienthoai = request.getParameter("txtSoDienThoai");
				request.setAttribute("sodienthoai", sodienthoai);
				String email = request.getParameter("txtEmail");
				request.setAttribute("email", email);

				RequestDispatcher rd = request.getRequestDispatcher("updateCustomer.jsp");
				rd.forward(request, response);
			}

			else if (action.equals("Save")) {
				String makh = request.getParameter("txtMaKH");
				String matkhau = request.getParameter("txtMatKhau");
				String hovaten = request.getParameter("txtHVT");
				String sodienthoai = request.getParameter("txtSoDienThoai");
				String email = request.getParameter("txtEmail");
				Customer customer = new Customer(makh, matkhau, hovaten, sodienthoai, email);
				customerDao.updateCustomer(customer);
				response.sendRedirect(request.getContextPath() + "/ListCustomerController?txtMaKH=&action=Search");
			}

			else if (action.equals("New")) {
				RequestDispatcher rd = request.getRequestDispatcher("newCustomer.jsp");
				rd.forward(request, response);
			}

		} catch (Exception ex) {
			out.print(ex);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
