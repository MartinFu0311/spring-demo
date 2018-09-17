package spring.martin.config;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import spring.martin.aop.aspect.RoleAspect;
import spring.martin.aop.aspect.RoleAspet2;

/*
 * @EnableAspectJAutoProxy ���� AspectJ ��ܵ��Զ�����
 */
@ComponentScan(basePackages = {"spring.martin.aop", "spring.martin.mapper"})
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ApplicationConfig implements TransactionManagementConfigurer {
	
	private DataSource dataSource = null;
	
	@Bean
	public RoleAspect getRoleAspect() {
		RoleAspect roleAspect = new RoleAspect();
		
		return roleAspect;
	}
	
	@Bean
	public RoleAspet2 getRoleAspect2() {
		RoleAspet2 roleAspet2 = new RoleAspet2();
		
		return roleAspet2;
	}
	
	@Bean
	public DataSource initDataSource() {
		if(dataSource != null) {
			return dataSource;
		}
		
		Properties properties = new Properties();
		InputStream stream = ApplicationConfig.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		try {
			properties.load(stream);
			
			//Apache DBCP
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		
		return dataSource;
	}
	
	/*
	 * value û�����õĻ�Ĭ�ϵ� name ò�Ʋ��� sqlSessionFactoryBean����Ϊ initMapperScannerConfigurer
	 * ������ configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean") �ᱨ�Ҳ���
	 * ����Ϊ sqlSessionFactoryBean �� bean
	 */
	@Bean(value = "sqlSessionFactoryBean")
	public SqlSessionFactoryBean initSqlSessionFactory() {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		factoryBean.setDataSource(initDataSource());
		
		return factoryBean;
	}
	
	@Bean
	public MapperScannerConfigurer initMapperScannerConfigurer() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setAnnotationClass(Repository.class);
		configurer.setBasePackage("spring.martin.mapper");
		configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");  //���������Ҫ������ SqlSessionFactory �� bean Ҫ��ͬ������ᱨ��
		
		return configurer;
	}

	@Override
	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		// TODO Auto-generated method stub
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(initDataSource());
		
		return transactionManager;
	}
	
}
