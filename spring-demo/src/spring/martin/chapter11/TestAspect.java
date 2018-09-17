package spring.martin.chapter11;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.martin.aop.service.RoleService;
import spring.martin.config.ApplicationConfig;
import spring.martin.pojo.Role;

public class TestAspect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleService roleService = (RoleService)applicationContext.getBean("roleServiceImpl");
		Role role = new Role(1L, "Administrator", "Super!");
		roleService.printRole(role);
		applicationContext.close();
		
	}

}
