package cybersoft.javabackend.crm.container;

import cybersoft.javabackend.crm.respository.TaskResponsitory;
import cybersoft.javabackend.crm.respository.TaskResponsitoryImp;
import cybersoft.javabackend.crm.respository.JobResponsitory;
import cybersoft.javabackend.crm.respository.JobResponsitoryImp;
import cybersoft.javabackend.crm.respository.RoleResponsitory;
import cybersoft.javabackend.crm.respository.RoleResponsitoryImp;
import cybersoft.javabackend.crm.respository.StatusReponsitory;
import cybersoft.javabackend.crm.respository.StatusReponsitoryImp;
import cybersoft.javabackend.crm.respository.UserResponsitory;
import cybersoft.javabackend.crm.respository.UserResponsitoryImp;
import cybersoft.javabackend.crm.service.AuthService;
import cybersoft.javabackend.crm.service.AuthServiceImp;
import cybersoft.javabackend.crm.service.TaskService;
import cybersoft.javabackend.crm.service.TaskServiceImp;
import cybersoft.javabackend.crm.service.RoleService;
import cybersoft.javabackend.crm.service.RoleServiceImp;
import cybersoft.javabackend.crm.service.UserService;
import cybersoft.javabackend.crm.service.UserServiceImp;

public class IOCContainer {
	private static TaskResponsitory projectResponsitory = null;
	private static RoleResponsitory roleResponsitory = null;
	private static UserResponsitory userResponsitory = null;
	private static StatusReponsitory statusResponsitory = null;
	private static JobResponsitory jobResponsitory = null;
	
	private static TaskService projectService = null;
	private static RoleService roleService = null;
	private static UserService userService = null;
	
	private static AuthService authService = null;
	
	public static StatusReponsitory getStatusReponsitory() {
		if(statusResponsitory == null) {
			statusResponsitory = new StatusReponsitoryImp();
		}
		return statusResponsitory;
	}
	
	public static JobResponsitory getJobResponsitory() {
		if(jobResponsitory == null) {
			jobResponsitory = new JobResponsitoryImp();
		}
		return jobResponsitory;
	}
	public static AuthService getAuthService() {
		if(authService == null) {
			authService = new AuthServiceImp();
		}
		return authService;
	}
	
	public static TaskService getProjectService() {
		if(projectService == null) {
			projectService = new TaskServiceImp();
		}
		return projectService;
	}
	public static RoleService getRoleService() {
		if(roleService == null) {
			roleService = new RoleServiceImp();
		}
		return roleService;
	}
	
	public static UserService getUserService() {
		if(userService == null) {
			userService = new UserServiceImp();
		}
		return userService;
	}
	
	public static TaskResponsitory getProjectResponsitory() {
		if(projectResponsitory == null) {
			projectResponsitory = new TaskResponsitoryImp();
		}
		return projectResponsitory;
	}
	
	public static RoleResponsitory getRoleResponsitory() {
		if(roleResponsitory == null) {
			roleResponsitory = new RoleResponsitoryImp();
		}
		return roleResponsitory;
	}
	
	public static UserResponsitory getUserResponsitory() {
		if(userResponsitory == null) {
			userResponsitory = new UserResponsitoryImp();
		}
		return userResponsitory;
	}
}
