package cybersoft.javabackend.crm.respository;

import java.util.List;

import cybersoft.javabackend.crm.dto.UserDTO;
import cybersoft.javabackend.crm.entity.User;

public interface UserResponsitory {
	public List<UserDTO> findAllJoint();
	public List<User> findAll();
	public User findById(int id);
	public int insert(User user );
	public int edit(User user);
	public User findByEmail(String email);
	public void deleteById(int id);
}
