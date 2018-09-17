package spring.martin.chapter13;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.martin.aop.service.RoleService;
import spring.martin.config.ApplicationConfig;
import spring.martin.pojo.Role;

public class TestTransactionalAnnotationByAnnotationConfiguration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleService roleService = context.getBean(RoleService.class);
		Role role = roleService.getRole(3L);
		System.out.println(role.getRoleName() + " " + role.getNote());
		
		context.close();
		
	}

}
