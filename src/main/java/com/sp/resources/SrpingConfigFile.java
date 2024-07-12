package com.sp.resources;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sp.dao.AccountDaoImpl;

@Configuration
@EnableTransactionManagement
public class SrpingConfigFile {
	
	@Bean
	public DriverManagerDataSource dmds() {
		
		DriverManagerDataSource dmdsonbj=new DriverManagerDataSource();
		dmdsonbj.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmdsonbj.setUrl("jdbc:mysql://localhost:3306/mydb?useSSL=false");
		dmdsonbj.setUsername("root");
		dmdsonbj.setPassword("Rooh@#2001");
		return dmdsonbj;
		
		
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean  lcemft() {
		LocalContainerEntityManagerFactoryBean lc=new LocalContainerEntityManagerFactoryBean();
		lc.setDataSource(dmds());
		lc.setPackagesToScan("com.sp.entity");
		lc.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties  pros=new Properties();
		pros.setProperty("hibernate.hbm2ddl.auto", "update");
		pros.setProperty("hibernate.show_sql", "true");
		lc.setJpaProperties(pros);
		return lc;
	}
	
	@Bean
	public JpaTransactionManager jtm(EntityManagerFactory emf) {
		JpaTransactionManager  jpatm=new JpaTransactionManager();
		jpatm.setEntityManagerFactory(emf);
		return jpatm;
	}

	@Bean 
	public AccountDaoImpl adi() {
		
		return new AccountDaoImpl();
		
	}
	
}
