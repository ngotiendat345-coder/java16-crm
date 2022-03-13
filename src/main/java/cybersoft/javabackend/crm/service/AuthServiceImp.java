package cybersoft.javabackend.crm.service;

import org.mindrot.jbcrypt.BCrypt;

import cybersoft.javabackend.crm.container.IOCContainer;
import cybersoft.javabackend.crm.dto.UserDTO;
import cybersoft.javabackend.crm.entity.User;
import cybersoft.javabackend.crm.respository.UserResponsitory;

public class AuthServiceImp implements AuthService {
	private UserResponsitory userResponsitory;
	public AuthServiceImp() {
		userResponsitory = IOCContainer.getUserResponsitory();
	}
	
	public UserDTO login(String email, String password) {
		User user = userResponsitory.findByEmail(email);
		System.out.println("user" + user.getEmail());
		System.out.println("getPassword" + user.getPassword());
		// user != null && user.getPassword().equals(password)
		if(user != null && BCrypt.checkpw(password, user.getPassword())) {
			UserDTO dto = new UserDTO();
			dto.setId(user.getId());
			dto.setEmail(user.getEmail());
			dto.setAvatar(user.getAvatar());
			dto.setFullname(user.getFullname());
			dto.setPassword(user.getPassword());
			dto.setRoleId(user.getRole_id());
			return dto;
		}
		return null;
	}
}
