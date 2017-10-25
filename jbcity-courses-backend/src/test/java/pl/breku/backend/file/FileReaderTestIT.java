package pl.breku.backend.file;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.breku.backend.AbstractSpringIntegrationTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by breku on 25.10.17.
 */
public class FileReaderTestIT extends AbstractSpringIntegrationTest {


	@Autowired
	private FileReader uut;

	@Test
	public void shouldReadFile() {
		// when
		final List<String> result = uut.readFileFromClasspath("/questions/sailor", "2.pogoda.txt");

		// then
		assertThat(result).isNotEmpty();
	}

}