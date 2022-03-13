package cybersoft.javabackend.crm.controller;

import cybersoft.javabackend.crm.connection.*;
import cybersoft.javabackend.crm.util.JspConst;
import cybersoft.javabackend.crm.util.UrlConst;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "homeServlet", urlPatterns = { UrlConst.HOME , UrlConst.HOME2})
public class HomeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
				try(Connection conn = JDBCConnection.getConnection()){
					if(conn != null) {
						System.out.println("Connect thanh cong");
					}
					else {
						System.out.println("Connect that bai");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.getRequestDispatcher(JspConst.HOME).forward(req, resp);
	}
	
}
