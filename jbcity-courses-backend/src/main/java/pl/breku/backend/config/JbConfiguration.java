package pl.breku.backend.config;

import org.apache.commons.configuration2.XMLConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by breku on 29.10.17.
 */
@Component
public class JbConfiguration {

	private final XMLConfiguration xmlConfiguration;

	@Autowired
	public JbConfiguration(JbConfigurationProvider jbConfigurationProvider) {
		this.xmlConfiguration = jbConfigurationProvider.createConfig();
	}

	public String getDriverClassName() {
		return xmlConfiguration.getString("database.spring-datasource-driver");
	}

	public String getDatabaseUrl() {
		return xmlConfiguration.getString("database.spring-datasource-url");
	}

	public String getDatabaseUser() {
		return xmlConfiguration.getString("database.spring-datasource-username");
	}

	public String getDatabasePassword() {
		return xmlConfiguration.getString("database.spring-datasource-password");
	}

	public String getHibernateHbm2ddlAuto() {
		return xmlConfiguration.getString("database.hibernate.hbm2ddl-auto");
	}

	public String getHibernateDialect() {
		return xmlConfiguration.getString("database.hibernate.dialect");
	}


	public String getCoursesSailorPath() {
		return xmlConfiguration.getString("courses.sailor.path");
	}
}
