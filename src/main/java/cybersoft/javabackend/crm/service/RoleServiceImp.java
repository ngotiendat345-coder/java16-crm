package cybersoft.javabackend.crm.service;

import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.crm.container.IOCContainer;
import cybersoft.javabackend.crm.dto.RoleDTO;
import cybersoft.javabackend.crm.dto.UserDTO;
import cybersoft.javabackend.crm.entity.Role;
import cybersoft.javabackend.crm.entity.User;
import cybersoft.javabackend.crm.respository.RoleResponsitory;
import cybersoft.javabackend.crm.respository.RoleResponsitoryImp;
import cybersoft.javabackend.crm.respository.UserResponsitoryImp;

public class RoleServiceImp implements RoleService {
	private RoleResponsitory roleResponsitory;
	
	public RoleServiceImp() {
		roleResponsitory = IOCContainer.getRoleResponsitory();
	}
	
	public List<RoleDTO> getAll(){
		List<RoleDTO> listDTO = new ArrayList<>();
		List<Role> list = roleResponsitory.findAll();
		
		if(list != null) {
			for(Role r: list) {
				RoleDTO dto = new RoleDTO(r.getId(),r.getName(),r.getDescription());
				System.out.println("r.getId()"+r.getId());
				listDTO.add(dto);
			}
		}
		
		return listDTO;
	}
	
	public RoleDTO getDetailRole(int id) {
		Role r = roleResponsitory.findByRoleId(id);
		RoleDTO dto = new RoleDTO(r.getId(),r.getName(),r.getDescription());;
		return dto;
	}
	public int insertRole(RoleDTO dto) {
		Role r = new Role();
		r.setName(dto.getName());
		r.setDescription(dto.getDescription());
		return roleResponsitory.insertRole(r);
	}
	
	public int updateRole(RoleDTO dto) {
		Role r = new Role();
		r.setName(dto.getName());
		r.setDescription(dto.getDescription());
		r.setId(dto.getId());
		return roleResponsitory.editRole(r);
	}
	
	public void deleteRole(int id) {
		roleResponsitory.deleteById(id);
	}
}
