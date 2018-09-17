package spring.martin.chapter13;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.martin.aop.service.RoleService;
import spring.martin.pojo.Role;

/*
 * 使用 @Transactional 需要做的工作（使用 mybatis-spring）
 * 1. 定义 bean dataSource (这里是 DPCP2)
 * 2. 定义 bean SqlSessionFactory （如果使用 spring data template 那么就定义 jdbcTemplate）
 * 3. 定义 bean transactionManager
 * 4. 定义 bean MapperScannerConfigurer ，扫描 mapper（由注解 @Repository 装饰），便于 @Autowired mapper
 * 5. 启用注解： <tx:annotation-driven transaction-manager="transactionManager" />
 */
public class TestTransactionalAnnotationByXmlConfiguration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
		RoleService roleService = applicationContext.getBean(RoleService.class);
		Role role = roleService.getRole(2L);
		System.out.println(role.getRoleName() + " " + role.getNote());
		
		applicationContext.close();
		
	}

}
