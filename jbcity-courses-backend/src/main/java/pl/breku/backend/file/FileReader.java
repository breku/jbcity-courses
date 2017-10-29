package pl.breku.backend.file;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

	public List<String> readFile(final String folder, final String fileName) {
		log.debug("Reading file={} from folder={}", fileName, folder);
		final String pathToFile = String.format("%s/%s", folder, fileName);
		try {
			final Path path = Paths.get(pathToFile);
			return Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			log.error("Error reading file={}", fileName, e);
			throw new IllegalStateException("Error reading file");
		}
	}
}
