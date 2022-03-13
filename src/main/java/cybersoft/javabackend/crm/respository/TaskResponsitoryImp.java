package cybersoft.javabackend.crm.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.crm.connection.JDBCConnection;
import cybersoft.javabackend.crm.dto.TaskDto;
import cybersoft.javabackend.crm.dto.UserDTO;
import cybersoft.javabackend.crm.entity.Task;

public class TaskResponsitoryImp implements TaskResponsitory {
	
	public List<TaskDto> findAllJoint(){
		String query = "select t.id,t.start_date,t.end_date,t.job_id, t.user_id,t.name,t.status_id,j.name as `job_name`,u.fullname as `user_fullName`,s.name as `status_name` from tasks t left join jobs j on t.job_id = j.id left join users u on t.user_id = u.id left join status s on t.status_id = s.id";
		List<TaskDto> listTask = new ArrayList<>();
		Connection conn = JDBCConnection.getConnection();
		try {
			PreparedStatement statement  = conn.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				TaskDto p = new TaskDto();
				p.setId(resultSet.getInt("id"));
				p.setName(resultSet.getString("name"));
				p.setStartDate(resultSet.getString("start_date"));
				p.setEndDate(resultSet.getString("end_date"));
				p.setUserId(resultSet.getInt("user_id"));
				p.setUserName(resultSet.getString("user_fullName"));
				p.setJobId(resultSet.getInt("job_id"));
				p.setJobName(resultSet.getString("job_name"));
				p.setStatusId(resultSet.getInt("status_id"));
				p.setStatusName(resultSet.getString("status_name"));
				listTask.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listTask;
	}
	public List<Task> findAll(){
		String query = "SELECT * FROM project";
		Connection conn = JDBCConnection.getConnection();
		List<Task> listProject = new ArrayList<>();
		
		try {
			PreparedStatement statement  = conn.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Task p = new Task();
				p.setId(resultSet.getInt("id"));
				p.setName(resultSet.getString("name"));
				p.setStartDate(resultSet.getString("start_date"));
				p.setEndDate(resultSet.getString("end_date"));
				p.setUserId(resultSet.getInt("user_id"));
				p.setJobId(resultSet.getInt("job_id"));
				p.setStatusId(resultSet.getInt("status_id"));
				listProject.add(p);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listProject;
	}
	
	public Task findProjectById(int id) {
		String query = "SELECT * FROM tasks WHERE id = ?";
		Connection conn = JDBCConnection.getConnection();
		Task p = null;
		
		try {
			PreparedStatement statement  = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				p = new Task();
				p.setId(resultSet.getInt("id"));
				p.setName(resultSet.getString("name"));
				p.setStartDate(resultSet.getString("start_date"));
				p.setEndDate(resultSet.getString("end_date"));
				p.setUserId(resultSet.getInt("user_id"));
				p.setJobId(resultSet.getInt("job_id"));
				p.setStatusId(resultSet.getInt("status_id"));
				break;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public int insertProject(Task p) {
		String query = "INSERT INTO tasks(name,start_date,end_date,user_id,job_id,status_id) VALUE(?,?,?,?,?,?)";
		Connection conn = JDBCConnection.getConnection();
		System.out.println(" p.getUserId()" +  p.getUserId());
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, p.getName());
			statement.setString(2, p.getStartDate());
			statement.setString(3, p.getEndDate());
			statement.setInt(4, p.getUserId());
			statement.setInt(5, p.getJobId());
			statement.setInt(6, p.getStatusId());
			return statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int editProject(Task p) {
		String query = "UPDATE tasks SET name = ?, start_date = ? , end_date = ? , user_id = ? , job_id = ? , status_id = ? WHERE id = ?";
		Connection conn = JDBCConnection.getConnection();
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, p.getName());
			statement.setString(2, p.getStartDate());
			statement.setString(3, p.getEndDate());
			statement.setInt(4, p.getUserId());
			statement.setInt(5, p.getJobId());
			statement.setInt(6, p.getStatusId());
			statement.setInt(7, p.getId());
			return statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void deleteById(int id) {
		String query = "DELETE FROM tasks WHERE id = ?";
		Connection conn = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
