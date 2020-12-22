package com.jpa.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jpa")
public class DatabaseConfig {
	   @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/hcl");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        return dataSource;
	    }
	   @Bean
	   public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
		   LocalContainerEntityManagerFactoryBean lemf=new LocalContainerEntityManagerFactoryBean();
		   lemf.setDataSource(dataSource());
		   Properties jpaProperties=new Properties();
		   jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        jpaProperties.put("hibernate.show_sql", "true");
	        jpaProperties.put("hibernate.format_sql", "true");
	        jpaProperties.put("hibernate.hbm2ddl.auto","create");
           lemf.setJpaProperties(jpaProperties);
           lemf.setJpaVendorAdapter(jpaVendorAdapter());
		return lemf;
		   
	   }
	   @Bean
	   public JpaVendorAdapter jpaVendorAdapter() {
		   HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		   return adapter;
		   
	   }
	   @Bean
	   public JpaTransactionManager getTransactionManager() {
		  JpaTransactionManager manager= new JpaTransactionManager();
		  manager.setEntityManagerFactory(getEntityManagerFactory().getObject());
		  return manager;
		  
		   
	   }
}
