package cybersoft.javabackend.crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.javabackend.crm.container.IOCContainer;
import cybersoft.javabackend.crm.dto.RoleDTO;
import cybersoft.javabackend.crm.service.RoleService;
import cybersoft.javabackend.crm.service.RoleServiceImp;
import cybersoft.javabackend.crm.service.UserServiceImp;
import cybersoft.javabackend.crm.util.JspConst;
import cybersoft.javabackend.crm.util.UrlConst;

@WebServlet(name="roleServlet",urlPatterns = {UrlConst.ROLE_ADD,UrlConst.ROLE_EDIT,UrlConst.ROLE_LIST,UrlConst.ROLE_DELETE})
public class RoleController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private RoleService roleService;
	
	public RoleController() {
		roleService = IOCContainer.getRoleService();
		// projectResponsitory = IOCContainer.getProjectResponsitory();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query =  req.getServletPath();
		switch(query){
			case UrlConst.ROLE_LIST:
				req.setAttribute("listRole", roleService.getAll());
				req.getRequestDispatcher(JspConst.ROLE_LIST).forward(req, resp);
				break;
			case UrlConst.ROLE_ADD:
				req.getRequestDispatcher(JspConst.ROLE_ADD).forward(req, resp);
				break;
			case UrlConst.ROLE_EDIT:{
				int id = Integer.valueOf(req.getParameter("id"));
				RoleDTO dto = roleService.getDetailRole(id);
				req.setAttribute("role", dto);
				req.getRequestDispatcher(JspConst.ROLE_EDIT).forward(req, resp);
				break;
			}
			case UrlConst.ROLE_DELETE:{
				int id = Integer.valueOf(req.getParameter("id"));
				System.out.println("id"+id);
				roleService.deleteRole(id);
				resp.sendRedirect(req.getContextPath()+UrlConst.ROLE_LIST);
				break;
			}	
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query =  req.getServletPath();
		String role_name = req.getParameter("name");
		String role_description = req.getParameter("description");
		System.out.println("role_name"+role_name);
		System.out.println("role_description"+role_description);
		switch(query) {
			case UrlConst.ROLE_ADD:{
				RoleDTO dto = new RoleDTO();
				dto.setName(role_name);
				dto.setDescription(role_description);
				
				if(roleService.insertRole(dto) != -1) {
					resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_LIST);
				}else {
					req.setAttribute("message", "Thêm mới thất bại!");
					req.getRequestDispatcher(JspConst.ROLE_ADD).forward(req, resp);
				}
				break;
			}
			case UrlConst.ROLE_EDIT:{
				int id = Integer.valueOf(req.getParameter("id"));
				RoleDTO dto = new RoleDTO();
				dto.setId(id);
				dto.setName(role_name);
				dto.setDescription(role_description);
				if(roleService.updateRole(dto) != -1) {
					resp.sendRedirect(req.getContextPath() + UrlConst.ROLE_LIST);
				}else {
					req.setAttribute("message", "Update thất bại!");
					req.getRequestDispatcher(JspConst.ROLE_EDIT).forward(req, resp);
				}
				break;
			}
		}
	}
	
	
}
