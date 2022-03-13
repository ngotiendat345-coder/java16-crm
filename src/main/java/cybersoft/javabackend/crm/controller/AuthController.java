package cybersoft.javabackend.crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.javabackend.crm.container.IOCContainer;
import cybersoft.javabackend.crm.dto.UserDTO;
import cybersoft.javabackend.crm.service.AuthService;
import cybersoft.javabackend.crm.util.JspConst;
import cybersoft.javabackend.crm.util.UrlConst;

@WebServlet(name = "authServlet", urlPatterns = {UrlConst.LOGIN , UrlConst.LOGOUT})
public class AuthController extends HttpServlet {
	private AuthService authService;
	
	public AuthController() {
		authService = IOCContainer.getAuthService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		String query =  req.getServletPath();
		switch(query) {
			case UrlConst.LOGIN:
				req.getRequestDispatcher(JspConst.AUTH_LOGIN).forward(req, resp);
				break;
			case UrlConst.LOGOUT:
				HttpSession session = req.getSession();
				session.removeAttribute("USER");
				resp.sendRedirect(req.getContextPath() + "/login");
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query =  req.getServletPath();
		switch(query) {
		case UrlConst.LOGIN:
			String email = req.getParameter("email");
			String pass = req.getParameter("password");
			System.out.println("email " + email);
			System.out.println("pass " + pass);
			UserDTO dto = authService.login(email, pass);
			if(dto == null) {
				req.setAttribute("message", "Dang nhap that bai");
				req.getRequestDispatcher(JspConst.AUTH_LOGIN).forward(req, resp);
			}else {
				HttpSession session = req.getSession();
				session.setAttribute("USER", dto);
				resp.sendRedirect(req.getContextPath() + "/");
			}
		}
	}
	
	
}
