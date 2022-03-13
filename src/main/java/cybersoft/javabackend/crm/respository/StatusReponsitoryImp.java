package cybersoft.javabackend.crm.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.crm.connection.JDBCConnection;
import cybersoft.javabackend.crm.entity.Role;
import cybersoft.javabackend.crm.entity.Status;

public class StatusReponsitoryImp implements StatusReponsitory {

	@Override
	public List<Status> findAll() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM status";
		Connection conn = JDBCConnection.getConnection();
		List<Status> listStatus = new ArrayList<>();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Status s = new Status();
				s.setId(result.getInt("id"));
				s.setName(result.getString("name"));
				listStatus.add(s);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listStatus;
	}
}
