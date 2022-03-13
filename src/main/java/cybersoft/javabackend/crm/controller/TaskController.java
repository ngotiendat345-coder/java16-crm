package cybersoft.javabackend.crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cybersoft.javabackend.crm.container.IOCContainer;
import cybersoft.javabackend.crm.dto.TaskDto;
import cybersoft.javabackend.crm.dto.UserDTO;
import cybersoft.javabackend.crm.service.TaskService;
import cybersoft.javabackend.crm.util.JspConst;
import cybersoft.javabackend.crm.util.UrlConst;

@WebServlet(name ="projectServlet", urlPatterns = {UrlConst.TASK_LIST,UrlConst.TASK_ADD, UrlConst.TASK_EDIT, UrlConst.TASK_DELETE})
public class TaskController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private TaskService taskService;
	
	public TaskController() {
		taskService = IOCContainer.getProjectService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		String query =  req.getServletPath();
		
		switch(query) {
			case UrlConst.TASK_LIST:
				req.setAttribute("tasks", taskService.getAllJoint());
				req.getRequestDispatcher(JspConst.PROJECT_LIST).forward(req, resp);
				break;
			case UrlConst.TASK_ADD:
				req.setAttribute("jobs", taskService.getJobs());
				req.setAttribute("status", taskService.getStatus());
				req.getRequestDispatcher(JspConst.PROJECT_ADD).forward(req, resp);
				break;
			case UrlConst.TASK_EDIT:
				int id = Integer.valueOf(req.getParameter("id"));
				req.setAttribute("task", taskService.getById(id));
				req.setAttribute("jobs", taskService.getJobs());
				req.setAttribute("status", taskService.getStatus());
				req.getRequestDispatcher(JspConst.PROJECT_EDIT).forward(req, resp);
				break;
			case UrlConst.TASK_DELETE:
				int id2 = Integer.valueOf(req.getParameter("id"));
				System.out.println(id2);
				taskService.delete(id2);
				resp.sendRedirect(req.getContextPath()+ UrlConst.TASK_LIST);
				break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getServletPath();
		System.out.println("name" + req.getParameter("name"));
		System.out.println("start_date" + req.getParameter("start_date"));
		System.out.println("end_date"+ req.getParameter("end_date"));
		// System.out.println("user_id" + user_id);
		System.out.println("status_id" + Integer.valueOf(req.getParameter("status_id")));
		System.out.println("job_id" + Integer.valueOf(req.getParameter("job_id")));
		
		String name = req.getParameter("name");
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		//int user_id =Integer.valueOf(req.getParameter("user_id"));
		int status_id = Integer.valueOf(req.getParameter("status_id"));
		int job_id = Integer.valueOf(req.getParameter("job_id"));
		HttpSession session = req.getSession();
		UserDTO dto = (UserDTO) session.getAttribute("USER_LOGIN");
		

		switch(action) {
			case UrlConst.TASK_ADD:
				TaskDto t = new TaskDto();
				t.setName(name);
				t.setStartDate(start_date);
				t.setEndDate(end_date);
				t.setUserId(3);
				t.setJobId(job_id);
				t.setStatusId(status_id);
				if(taskService.insert(t) != -1){
					resp.sendRedirect(req.getContextPath()+ UrlConst.TASK_LIST);
					return;
				}
				resp.sendRedirect(req.getContextPath()+ UrlConst.TASK_ADD);
				break;
			case UrlConst.TASK_EDIT:
				System.out.println("req.getParameter(\"id\")" + req.getParameter("id"));
				int id = Integer.valueOf(req.getParameter("id"));
				TaskDto t2 = new TaskDto(id, name, start_date, end_date, 3, job_id, status_id);
				if(taskService.update(t2) != -1) {
					resp.sendRedirect(req.getContextPath()+ UrlConst.TASK_LIST);
					return;
				}
				else {
					
					req.getRequestDispatcher(JspConst.USER_EDIT).forward(req, resp);
				}
				break;
		}
	}
	
}
