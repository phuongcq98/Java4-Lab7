package vn.poly.phuongcqph05100.controller;

import java.io.IOException;
import vn.poly.phuongcqph05100.dao.CustomerDao;
import vn.poly.phuongcqph05100.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewCustomerController
 */
public class NewCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewCustomerController() {
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
		CustomerDao customerDao = new CustomerDao();
		try {
			String action = request.getParameter("action");
			if (action.equals("Insert")) {
				String makh = request.getParameter("txtMaKH");
				String matkhau = request.getParameter("txtMatKhau");
				String hovaten = request.getParameter("txtHVT");
				String sodienthoai = request.getParameter("txtSoDienThoai");
				String email = request.getParameter("txtEmail");
				Customer customer = new Customer(makh, matkhau, hovaten, sodienthoai, email);
				customerDao.insertTaikhoan(customer);
				response.sendRedirect(request.getContextPath() + "/ListCustomerController?txtMaKH=&action=Search");
			} else {
				request.setAttribute("message", "cos looix");
			}
		} catch (Exception ex) {

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
