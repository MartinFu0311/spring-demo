package spring.martin.aop.aspect;

import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import spring.martin.pojo.Role;

@Aspect
@Order(2)
public class RoleAspet2 {

	@Pointcut("execution(* spring.martin.aop.service.impl.RoleServiceImpl.printRole(..)) && args(role)")
	public void print(Role role) {
		
	}
	
	@Before("print(role)")
	public void before(Role role) {
		System.out.println("Before2 ...");
	}
	
	@After("print(role)")
	public void after(Role role) {
		System.out.println("After2 ...");
	}
	
	@AfterReturning("print(role)")
	public void afterReturning(Role role) {
		System.out.println("AfterReturning2 ...");
	}
	
	@AfterThrowing("print(role)")
	public void afterThrowing(Role role) {
		System.out.println("AfterThrowing2 ...");
	}
	
}
