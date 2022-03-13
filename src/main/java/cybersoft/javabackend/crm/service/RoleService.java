package cybersoft.javabackend.crm.service;

import java.util.List;

import cybersoft.javabackend.crm.dto.RoleDTO;

public interface RoleService {
	public List<RoleDTO> getAll();
	public RoleDTO getDetailRole(int id);
	public int insertRole(RoleDTO dto);
	public int updateRole(RoleDTO dto);
	public void deleteRole(int id);
}
