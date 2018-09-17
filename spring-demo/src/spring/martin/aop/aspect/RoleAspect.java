package spring.martin.aop.aspect;

//import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import spring.martin.pojo.Role;

@Aspect
public class RoleAspect {
	
	@Pointcut("execution(* spring.martin.aop.service.impl.RoleServiceImpl.printRole(..)) && args(role)")
	public void print(Role role) {
		
	}
	
	@Before("print(role)")
	public void before(Role role) {
		System.out.println("Before ...");
	}
	
	@After("print(role)")
	public void after(Role role) {
		System.out.println("After ...");
	}
	
	@AfterReturning("print(role)")
	public void afterReturing(Role role) {
		System.out.println("After returning ...");
	}
	
	@AfterThrowing("print(role)")
	public void afterThrowing(Role role) {
		System.out.println("After throwing ...");
	}
	
	/*
	 * ���� role ����������ʱ����������������֪ͨ����ִ����Ҳ��� role
	 * Ŀǰ˵����ԭ����ע�ͣ�ע�ͺ������������
	 * ����Ҳû���ᵽ����֪ͨ����������ô����
	 * 
	@Around("print(role)")
	public void around(ProceedingJoinPoint joinPoint) {
		System.out.println("Around before ...");
		
		try {
			joinPoint.proceed();
		} catch(Throwable exception) {
			exception.printStackTrace();
		}
		
		System.out.println("Around after ...");
	}
	*/
	
}
