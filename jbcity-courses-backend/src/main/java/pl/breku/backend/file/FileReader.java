package pl.breku.backend.file;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by breku on 25.10.17.
 */
@Slf4j
@Component
public class FileReader {

	public List<String> readFileFromClasspath(final String folder, final String fileName) {
		log.debug("Reading file={} from folder={}", fileName, folder);
		final String pathToFile = String.format("%s/%s", folder, fileName);
		try {
			final Path path = Paths.get(getClass().getResource(pathToFile).toURI());
			return Files.readAllLines(path);
		} catch (URISyntaxException | IOException e) {
			log.error("Error reading file={}", fileName, e);
			throw new IllegalStateException("Error reading file");
		}
	}
}
