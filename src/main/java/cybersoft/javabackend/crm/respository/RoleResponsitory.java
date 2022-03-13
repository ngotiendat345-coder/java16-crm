package cybersoft.javabackend.crm.respository;

import java.util.List;

import cybersoft.javabackend.crm.entity.Role;

public interface RoleResponsitory {
	public List<Role> findAll();
	public Role findByRoleId(int id);
	public int insertRole(Role role);
	public int editRole(Role role);
	public void deleteById(int id);
}
