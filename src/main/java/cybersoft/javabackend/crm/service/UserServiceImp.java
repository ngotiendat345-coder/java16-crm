package cybersoft.javabackend.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import cybersoft.javabackend.crm.container.IOCContainer;
import cybersoft.javabackend.crm.dto.UserDTO;
import cybersoft.javabackend.crm.entity.User;
import cybersoft.javabackend.crm.entity.Role;
import cybersoft.javabackend.crm.respository.RoleResponsitory;
import cybersoft.javabackend.crm.respository.RoleResponsitoryImp;
import cybersoft.javabackend.crm.respository.UserResponsitory;
import cybersoft.javabackend.crm.respository.UserResponsitoryImp;

public class UserServiceImp implements UserService {
	private RoleResponsitory roleResponsitory;
	private UserResponsitory userResponsitory;
	
	public UserServiceImp() {
		 roleResponsitory = IOCContainer.getRoleResponsitory();
		 userResponsitory = IOCContainer.getUserResponsitory();
		// projectResponsitory = IOCContainer.getProjectResponsitory();
	}
	
	public List<UserDTO> getAll(){
		//return userResponsitory.findAllJoint();
		List<User> list = userResponsitory.findAll();
		List<UserDTO> listDTO = new ArrayList<>();
		if(list != null) {
			for(User u: list) {
				UserDTO dto = new UserDTO();
				dto.setId(u.getId());
				dto.setFullname(u.getFullname());
				dto.setEmail(u.getEmail());
				dto.setAvatar(u.getAvatar());
				dto.setPassword(u.getPassword());
				dto.setRoleId(u.getRole_id());
				Role r = roleResponsitory.findByRoleId(u.getRole_id());
				dto.setRoleDesc(r.getDescription());
				dto.setRoleName(r.getName());
				listDTO.add(dto);
			}
		}
		
		return listDTO;
	}
	
	public UserDTO getUserDetail(int id) {
		User u = userResponsitory.findById(id);

		UserDTO dto = null;
		if(u != null) {
			Role r = roleResponsitory.findByRoleId(u.getRole_id());
			dto = new UserDTO();
			dto.setId(u.getId());
			dto.setFullname(u.getFullname());
			dto.setEmail(u.getEmail());
			dto.setAvatar(u.getAvatar());
			dto.setPassword(u.getPassword());
			dto.setRoleId(r.getId());
		}
		return dto;
	}
	
	public int insert(User user) {
		System.out.println("user"+user.getFullname());
		
		try {
			 String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			 user.setPassword(hashed);
			 return userResponsitory.insert(user);
		}catch(Exception e)  {
			e.printStackTrace();
		}
		return -1;
	}
	public void delete(int id) {
		userResponsitory.deleteById(id);
	}
	
	public User getByEmail(String email) {
		return userResponsitory.findByEmail(email);
	}
	public int edit(UserDTO userDto) {
		try {
			User user = userResponsitory.findById(userDto.getId());
			if(user != null) {
				user.setEmail(userDto.getEmail());
				user.setFullname(userDto.getFullname());
				user.setAvatar(userDto.getAvatar());
				user.setRole_id(userDto.getRoleId());
				
				// Náº¾U PASS Ä�Æ¯á»¢C NHáº¬P => THAY Ä�á»”I PASS
				if(!userDto.getPassword().isEmpty()) {
					String hashed = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
					//entity.setPassword(hashed);
					user.setPassword(hashed);
				}
			}
			return userResponsitory.edit(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
