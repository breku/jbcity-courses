package pl.breku.backend.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.breku.backend.config.JbConfiguration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by breku on 28.10.17.
 */
@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig {

	private final JbConfiguration jbConfiguration;

	@Autowired
	public PersistenceJPAConfig(JbConfiguration jbConfiguration) {
		this.jbConfiguration = jbConfiguration;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "pl.breku.backend.database.entity" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(jbConfiguration.getDriverClassName());
		dataSource.setUrl(jbConfiguration.getDatabaseUrl());
		dataSource.setUsername( jbConfiguration.getDatabaseUser());
		dataSource.setPassword( jbConfiguration.getDatabasePassword() );
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", jbConfiguration.getHibernateHbm2ddlAuto());
		properties.setProperty("hibernate.dialect", jbConfiguration.getHibernateDialect());
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.current_session_context_class", "thread");
		return properties;
	}



}
