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
	 * 加了 role 参数后运行时，如果有了这个环绕通知会出现错误，找不到 role
	 * 目前说不清原因，先注释，注释后可以正常运行
	 * 书上也没有提到环绕通知参数传递怎么处理
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
