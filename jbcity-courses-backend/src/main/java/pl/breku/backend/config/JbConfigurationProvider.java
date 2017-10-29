package pl.breku.backend.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.BasicConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.io.FileHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by breku on 28.10.17.
 */
@Slf4j
@Component
public class JbConfigurationProvider {

	private static final String CONFIG_NAME = "application-config.xml";

	@Value("${jb-config-path:/config/}")
	private String jbConfigPath;

	public XMLConfiguration createConfig() {
		try {
			final String configPath = String.format("%s/%s", jbConfigPath, CONFIG_NAME);
			log.info("Reading config from={}", configPath);
			FileInputStream fileInputStream = new FileInputStream(configPath);
			XMLConfiguration cfg = new BasicConfigurationBuilder<>(XMLConfiguration.class).configure(new Parameters().xml()).getConfiguration();
			FileHandler fh = new FileHandler(cfg);
			fh.load(fileInputStream);
			return cfg;
		} catch (ConfigurationException | FileNotFoundException e) {
			log.error("Error during loading jbconfiguration", e);
			throw new IllegalStateException(e);
		}
	}
}
