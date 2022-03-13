package cybersoft.javabackend.crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.crm.container.IOCContainer;
import cybersoft.javabackend.crm.dto.UserDTO;
import cybersoft.javabackend.crm.entity.User;
import cybersoft.javabackend.crm.service.RoleService;
import cybersoft.javabackend.crm.service.RoleServiceImp;
import cybersoft.javabackend.crm.service.UserService;
import cybersoft.javabackend.crm.service.UserServiceImp;
import cybersoft.javabackend.crm.util.JspConst;
import cybersoft.javabackend.crm.util.UrlConst;

@WebServlet(name = "userServlet",urlPatterns = {UrlConst.USER_LIST,UrlConst.USER_ADD,UrlConst.USER_EDIT,UrlConst.USER_DELETE})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private RoleService roleService;
	
	public UserController() {
		userService = IOCContainer.getUserService();
		roleService = IOCContainer.getRoleService();
		// projectResponsitory = IOCContainer.getProjectResponsitory();
	}
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		String query =  req.getServletPath();

		switch(query) {
		case UrlConst.USER_LIST:
			req.setAttribute("users", userService.getAll());
			req.getRequestDispatcher(JspConst.USER_LIST).forward(req, resp);
			break;
		case UrlConst.USER_ADD:
			req.setAttribute("roles", roleService.getAll());
			req.getRequestDispatcher(JspConst.USER_ADD).forward(req, resp);
			break;
		case UrlConst.USER_EDIT:
			System.out.println("edit");
			int id = Integer.valueOf(req.getParameter("id"));
			UserDTO userDto = userService.getUserDetail(id);
			System.out.println("userDto" + userDto.getRoleId());
			System.out.println("IDD------"+id);
			req.setAttribute("roles", roleService.getAll());
			req.setAttribute("user", userService.getUserDetail(id));
			req.getRequestDispatcher(JspConst.USER_EDIT).forward(req, resp);
			break;
		case UrlConst.USER_DELETE:
			int id2 = Integer.valueOf(req.getParameter("id"));
			userService.delete(id2);
			req.setAttribute("users", userService.getAll());
			req.getRequestDispatcher(JspConst.USER_LIST).forward(req, resp);
			break;
		}

		}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String action = req.getServletPath();
		
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String avatar = req.getParameter("avatar");
		int roleId = Integer.valueOf(req.getParameter("roleId"));
		
		System.out.println("avatar" + avatar);
		System.out.println("email" + email);
		System.out.println("pass"+ pass);
		System.out.println("fullname" + fullname);
		
		switch(action) {
			case UrlConst.USER_ADD:
				User userAdd = new User(email,pass,fullname,roleId);
//				User existedUser = userService.getByEmail(email);
//				if(existedUser != null) {
//					req.setAttribute("message", "Email đã tồn tại");
//					req.getRequestDispatcher(JspConst.USER_ADD).forward(req, resp);
//					return;
//				}
//				
				if(userService.insert(userAdd) != -1){
					resp.sendRedirect(req.getContextPath()+ "/user");
					return;
				}
				req.getRequestDispatcher(JspConst.USER_ADD).forward(req, resp);
				break;
			case UrlConst.USER_EDIT:
				int id = Integer.valueOf(req.getParameter("id"));
				UserDTO userAdd1 = new UserDTO(email,pass,fullname,roleId,id);
				if(userService.edit(userAdd1) != -1){
					resp.sendRedirect(req.getContextPath()+ "/user");
				}
				else {
					req.getRequestDispatcher(JspConst.USER_EDIT+"?id="+ id).forward(req, resp);
				}
				break;
		}

	}
}
