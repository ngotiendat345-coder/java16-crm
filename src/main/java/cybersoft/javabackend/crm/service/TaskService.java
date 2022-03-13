package cybersoft.javabackend.crm.service;

import java.util.List;

import cybersoft.javabackend.crm.dto.TaskDto;
import cybersoft.javabackend.crm.entity.Job;
import cybersoft.javabackend.crm.entity.Status;

public interface TaskService {
	public List<TaskDto> getAll();
	public List<TaskDto> getAllJoint();
	public TaskDto getById(int id);
	public int insert(TaskDto dto);
	public int update(TaskDto dto);
	public void delete(int id);
	public List<Job> getJobs();
	public List<Status> getStatus();
}
