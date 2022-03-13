package cybersoft.javabackend.crm.service;

import java.util.List;

import cybersoft.javabackend.crm.dto.UserDTO;
import cybersoft.javabackend.crm.entity.User;

public interface UserService {
	public List<UserDTO> getAll();
	public UserDTO getUserDetail(int id);
	public int insert(User user);
	public void delete(int id);
	public User getByEmail(String email);
	public int edit(UserDTO userDto);
}
