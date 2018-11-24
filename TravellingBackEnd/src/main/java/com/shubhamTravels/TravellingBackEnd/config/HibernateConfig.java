package com.shubhamTravels.TravellingBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.shubhamTravels.TravellingBackEnd")
@EnableTransactionManagement
public class HibernateConfig {

	/* final static variable of hibernate config */
	private final static String JDBC_URL = "jdbc:h2:tcp://localhost/~/ShubhamTravels";
	private final static String JDBC_Dialect = "org.hibernate.dialect.H2Dialect";
	private final static String JDBC_Driver = "org.h2.Driver";
	private final static String USER_NAME = "prtk";
	private final static String PASSWORD = "1234";

	// Bean for Creating a Data Source
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(JDBC_Driver);
		dataSource.setUrl(JDBC_URL);
		dataSource.setUsername(USER_NAME);
		dataSource.setPassword(PASSWORD);

		return dataSource;
	}

	// Creating Bean for Session Factory
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		// Providing Hibernate Properties
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.shubhamTravels.TravellingBackEnd");

		return builder.buildSessionFactory();
	}

	// Hibernate Properties
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", JDBC_Dialect);
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");

		return props;
	}

	// Transaction Management Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory factory) {
		HibernateTransactionManager tm = new HibernateTransactionManager(factory);
		return tm;
	}
}
