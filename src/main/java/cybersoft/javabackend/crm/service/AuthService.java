package cybersoft.javabackend.crm.service;

import cybersoft.javabackend.crm.dto.UserDTO;

public interface AuthService {
	public UserDTO login(String email, String password);
}
