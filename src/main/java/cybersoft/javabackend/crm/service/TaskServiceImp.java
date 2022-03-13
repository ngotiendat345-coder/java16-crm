package cybersoft.javabackend.crm.service;

import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.crm.container.IOCContainer;
import cybersoft.javabackend.crm.dto.TaskDto;
import cybersoft.javabackend.crm.entity.Job;
import cybersoft.javabackend.crm.entity.Status;
import cybersoft.javabackend.crm.entity.Task;
import cybersoft.javabackend.crm.respository.TaskResponsitory;
import cybersoft.javabackend.crm.respository.TaskResponsitoryImp;
import cybersoft.javabackend.crm.respository.JobResponsitory;
import cybersoft.javabackend.crm.respository.StatusReponsitory;

public class TaskServiceImp implements TaskService {
	private TaskResponsitory projectResponsitory;
	private JobResponsitory jobResponsitory;
	private StatusReponsitory statusResponsitory;
	
	public TaskServiceImp() {
		projectResponsitory = IOCContainer.getProjectResponsitory();
		statusResponsitory = IOCContainer.getStatusReponsitory();
		jobResponsitory = IOCContainer.getJobResponsitory();
	}
	
	public List<TaskDto> getAllJoint() {
		// TODO Auto-generated method stub
		return projectResponsitory.findAllJoint();
	}
	
	@Override
	public List<Job> getJobs() {
		// TODO Auto-generated method stub
		return jobResponsitory.findAll();
	}

	@Override
	public List<Status> getStatus() {
		// TODO Auto-generated method stub
		return statusResponsitory.findAll();
	}

	public List<TaskDto> getAll(){
		List<Task> listProject = projectResponsitory.findAll();
		List<TaskDto> listProjectDto = new ArrayList<>();
		
		if(listProject != null) {
			for(Task p : listProject) {
				TaskDto dto = new TaskDto();
				dto.setId(p.getId());
				dto.setName(p.getName());
				dto.setStartDate(p.getStartDate());
				dto.setEndDate(p.getEndDate());
				dto.setUserId(p.getUserId());
				dto.setJobId(p.getJobId());
				dto.setStatusId(p.getStatusId());
				listProjectDto.add(dto);
			}
		}
		return listProjectDto;
	}
	public TaskDto getById(int id) {
		Task t = projectResponsitory.findProjectById(id);
		TaskDto dto = null;
		if(t != null) {
			dto = new TaskDto();
			dto.setId(t.getId());
			dto.setName(t.getName());
			dto.setStartDate(t.getStartDate());
			dto.setEndDate(t.getEndDate());
			dto.setUserId(t.getUserId());
			dto.setJobId(t.getJobId());
			dto.setStatusId(t.getStatusId());
		}
		return dto;
	}
	public int insert(TaskDto dto) {
		System.out.println("dto.getUserId()" + dto.getUserId());
		Task t = new Task();
		t.setId(dto.getId());
		t.setName(dto.getName());
		t.setStartDate(dto.getStartDate());
		t.setEndDate(dto.getEndDate());
		t.setUserId(dto.getUserId());
		t.setJobId(dto.getJobId());
		t.setStatusId(dto.getStatusId());
		
		return projectResponsitory.insertProject(t);
	}
	public int update(TaskDto dto) {
		Task t = new Task();
		t.setId(dto.getId());
		t.setName(dto.getName());
		t.setStartDate(dto.getStartDate());
		t.setEndDate(dto.getEndDate());
		t.setUserId(dto.getUserId());
		t.setJobId(dto.getJobId());
		t.setStatusId(dto.getStatusId());
		
		return projectResponsitory.editProject(t);
	}
	public void delete(int id) {
		projectResponsitory.deleteById(id);
	}

}
