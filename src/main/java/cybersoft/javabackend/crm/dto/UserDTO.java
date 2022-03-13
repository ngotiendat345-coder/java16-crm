package cybersoft.javabackend.crm.dto;

public class UserDTO {
	private int id;
	private String email;
	private String password;
	private String fullname;
	private String avatar;
	private int roleId;
	private String roleDesc;
	private String roleName;
	
	public UserDTO() {
		
	}
	public UserDTO(String email,String pass, String fullname,int roleId) {
		this.email = email;
		this.password = pass;
		this.fullname = fullname;
		this.roleId = roleId;
	}
	public UserDTO(String email,String pass, String fullname,int roleId, int id) {
		this.email = email;
		this.password = pass;
		this.fullname = fullname;
		this.roleId = roleId;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
