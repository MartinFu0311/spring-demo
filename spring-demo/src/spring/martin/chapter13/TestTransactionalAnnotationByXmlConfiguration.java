package spring.martin.chapter13;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.martin.aop.service.RoleService;
import spring.martin.pojo.Role;

/*
 * ʹ�� @Transactional ��Ҫ���Ĺ�����ʹ�� mybatis-spring��
 * 1. ���� bean dataSource (������ DPCP2)
 * 2. ���� bean SqlSessionFactory �����ʹ�� spring data template ��ô�Ͷ��� jdbcTemplate��
 * 3. ���� bean transactionManager
 * 4. ���� bean MapperScannerConfigurer ��ɨ�� mapper����ע�� @Repository װ�Σ������� @Autowired mapper
 * 5. ����ע�⣺ <tx:annotation-driven transaction-manager="transactionManager" />
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
