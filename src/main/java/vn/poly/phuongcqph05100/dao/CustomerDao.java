package vn.poly.phuongcqph05100.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import vn.poly.phuongcqph05100.dao.CustomerDao;
import vn.poly.phuongcqph05100.model.Customer;
import vn.poly.phuongcqph05100.util.HibernateUtil;

public class CustomerDao {

	public List<Customer> getListCustomer(String makh) {

		// Khai bao list
		List<Customer> list = null;

		// Khai bao session
		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			String sql = "from Customer ";

			if (makh != null) {
				sql += " where makh like :makh";
			}

			Query<Customer> query = session.createQuery(sql, Customer.class);

			if (makh != null) {
				query.setParameter("makh", "%" + makh + "%");
			}

			list = query.getResultList();

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public Customer getInforCustomer(String makh) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Customer tk = (Customer) session.get(Customer.class, makh);
		session.close();
		return tk;
	}

	public boolean insertTaikhoan(Customer customer) {

		// Khai bao session
		Session session = null;

		try {

			// Khoi tao session
			session = HibernateUtil.getSessionFactory().openSession();

			// Kiem tra usernameTK
			if (this.getInforCustomer(customer.getMakh()) != null) {
				return false;
			}

			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
			return true;

		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return false;
	}

	public boolean updateCustomer(Customer customer) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();

			if (this.getInforCustomer(customer.getMakh()) == null) {
				return false;
			}

			session.beginTransaction();
			session.update(customer);
			session.getTransaction().commit();
			return true;

		} catch (Exception ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return false;

	}

	public boolean deleteCustomer(String makh) {
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.getInforCustomer(makh);
		if (customer == null) {
			return false;
		}
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			session.delete(customer);
			session.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			session.getTransaction().rollback();
			System.err.println(ex);
			return false;
		}
	}

}
