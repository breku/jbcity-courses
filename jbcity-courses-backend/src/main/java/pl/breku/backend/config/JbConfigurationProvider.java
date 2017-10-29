package pl.breku.backend.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.BasicConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.io.FileHandler;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Created by breku on 28.10.17.
 */
@Slf4j
@Component
public class JbConfigurationProvider {

	private static final String CONFIG_NAME = "application-config.xml";


	public XMLConfiguration createConfig() {
		try {
			final String configPath = String.format("/config/%s", CONFIG_NAME);
			log.info("Reading config from={}", configPath);
			final InputStream resourceAsStream = getClass().getResourceAsStream(configPath);
			XMLConfiguration cfg = new BasicConfigurationBuilder<>(XMLConfiguration.class).configure(new Parameters().xml()).getConfiguration();
			FileHandler fh = new FileHandler(cfg);
			fh.load(resourceAsStream);
			return cfg;
		} catch (ConfigurationException e) {
			log.error("Error during loading jbconfiguration", e);
			throw new IllegalStateException(e);
		}
	}
}
