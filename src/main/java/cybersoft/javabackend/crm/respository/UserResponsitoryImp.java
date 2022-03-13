package cybersoft.javabackend.crm.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.crm.connection.JDBCConnection;
import cybersoft.javabackend.crm.dto.UserDTO;
import cybersoft.javabackend.crm.entity.User;

public class UserResponsitoryImp implements UserResponsitory {
	public List<UserDTO> findAllJoint(){
		String query = "SELECT * FROM users u join roles r on u.role_id = r.id";
		List<UserDTO> listUser = new ArrayList<>();
		Connection conn = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				UserDTO dto = new UserDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setEmail(resultSet.getString("email"));
				dto.setFullname(resultSet.getString("fullname"));
				dto.setPassword(resultSet.getString("password"));
				dto.setRoleDesc(resultSet.getString("description"));
				dto.setRoleId(resultSet.getInt("role_id"));
				dto.setRoleName(resultSet.getString("name"));
				dto.setAvatar(resultSet.getString("avatar"));
				listUser.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}
	
	public List<User> findAll(){
		String query = "SELECT * FROM users";
		List<User> listUser = new ArrayList<>();
		Connection conn = JDBCConnection.getConnection();
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setPassword(resultSet.getString("password"));
				user.setAvatar(resultSet.getString("avatar"));
				user.setRole_id(resultSet.getInt("role_id"));
				listUser.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}
	
	public User findById(int id) {
		User user = null;
		String query = "SELECT * FROM users WHERE id= ?";
		Connection conn = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setPassword(resultSet.getString("password"));
				user.setAvatar(resultSet.getString("avatar"));
				user.setRole_id(resultSet.getInt("role_id"));
				break;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public int insert(User user ) {
		String query = "INSERT INTO users(email,password,fullname,role_id) VALUES (?,?,?,?);";
		Connection conn = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			statement.setInt(4, user.getRole_id());
			System.out.println(statement);
			return statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int edit(User user) {
		String query = "UPDATE users SET email=?,password=?,fullname=?,role_id=?,avatar=? WHERE id = ?;";
		Connection conn = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			statement.setInt(4, user.getRole_id());
			statement.setString(5, user.getAvatar());
			statement.setInt(6, user.getId());
			return statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public User findByEmail(String email) {
		User user = null;
		String query = "SELECT * FROM users WHERE email = ?";
		Connection conn = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setPassword(resultSet.getString("password"));
				user.setAvatar(resultSet.getString("avatar"));
				break;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public void deleteById(int id) {
		String query = "DELETE FROM users WHERE id = ?";
		Connection conn = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
