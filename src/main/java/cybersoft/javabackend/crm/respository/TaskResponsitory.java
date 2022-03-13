package cybersoft.javabackend.crm.respository;

import java.util.List;

import cybersoft.javabackend.crm.dto.TaskDto;
import cybersoft.javabackend.crm.entity.Task;

public interface TaskResponsitory {
	public List<Task> findAll();
	public List<TaskDto> findAllJoint();
	public Task findProjectById(int id);
	public int insertProject(Task p);
	public int editProject(Task p);
	public void deleteById(int id);
}
