package pl.breku.backend.file;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by breku on 25.10.17.
 */
@Slf4j
@Component
public class FileReader {

	private final Cache<String, List<String>> fileCache = CacheBuilder.newBuilder().build();

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
			return fileCache.get(pathToFile, () -> getFile(pathToFile));
		} catch (ExecutionException e) {
			log.error("Error getting file from cache", e);
			throw new IllegalStateException(e);
		}
	}

	private List<String> getFile(String pathToFile) {
		try {
			final Path path = Paths.get(pathToFile);
			return Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			log.error("Error reading file={}", pathToFile, e);
			throw new IllegalStateException("Error reading file");
		}
	}
}
