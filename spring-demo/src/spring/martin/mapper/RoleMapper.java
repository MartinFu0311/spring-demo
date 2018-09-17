package spring.martin.mapper;

import org.springframework.stereotype.Repository;

import spring.martin.pojo.Role;

@Repository
public interface RoleMapper {

	public Role getRole(Long id);
	
	public int insertRole(Role user);
	
	public int updateRole(Role user);
	
	public int deleteRole(Long id);
	
}
