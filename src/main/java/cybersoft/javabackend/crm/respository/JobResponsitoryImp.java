package cybersoft.javabackend.crm.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.crm.connection.JDBCConnection;
import cybersoft.javabackend.crm.entity.Job;
import cybersoft.javabackend.crm.entity.Role;

public class JobResponsitoryImp implements JobResponsitory {

	@Override
	public List<Job> findAll() {
		String query = "SELECT * FROM jobs";
		Connection conn = JDBCConnection.getConnection();
		List<Job> listJob = new ArrayList<>();
				try {
					PreparedStatement statement = conn.prepareStatement(query);
					ResultSet result = statement.executeQuery();
					while(result.next()) {
						Job j = new Job();
						j.setId(result.getInt("id"));
						j.setName(result.getString("name"));
						j.setStartDate(result.getString("start_date"));
						j.setEndDate(result.getString("end_date"));
						listJob.add(j);
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return listJob;		
	}

}
