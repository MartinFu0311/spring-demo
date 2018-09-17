package spring.martin.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.martin.aop.service.RoleService;
import spring.martin.mapper.RoleMapper;
import spring.martin.pojo.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper = null;

	@Override
	public void printRole(Role role) {
		// TODO Auto-generated method stub
		System.out.println("The method of printRole in RoleServiceImpl invoked!");
		System.out.println("Role name: " + role.getRoleName() + ", note: " + role.getNote());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public Role getRole(Long id) {
		// TODO Auto-generated method stub
		Role role = roleMapper.getRole(id);
		
		return role;
	}

}
