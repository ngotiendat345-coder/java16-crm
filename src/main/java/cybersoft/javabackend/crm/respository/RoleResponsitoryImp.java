package cybersoft.javabackend.crm.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.crm.connection.JDBCConnection;
import cybersoft.javabackend.crm.entity.Role;

public class RoleResponsitoryImp implements RoleResponsitory {
	public List<Role> findAll(){
		String query = "SELECT * FROM roles";
		Connection conn = JDBCConnection.getConnection();
		List<Role> listRole = new ArrayList<>();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Role role = new Role();
				role.setId(result.getInt("id"));
				role.setName(result.getString("name"));
				role.setDescription(result.getString("description"));
				listRole.add(role);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listRole;
	}
	public Role findByRoleId(int id) {
		String query = "SELECT * FROM roles WHERE id = ?";
		Connection conn = JDBCConnection.getConnection();
		Role role = null;
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				role = new Role();
				role.setId(result.getInt("id"));
				role.setName(result.getString("name"));
				role.setDescription(result.getString("description"));
				break;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	public int insertRole(Role role) {
		String query = "INSERT INTO roles(name,description) values(?,?);";
		Connection conn = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			return statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int editRole(Role role) {
		String query = "UPDATE roles SET name = ? , description = ? WHERE id = ?;";
		Connection conn = JDBCConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, role.getId());
			return statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void deleteById(int id) {
		String query = "DELETE FROM roles where id = ?";
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
