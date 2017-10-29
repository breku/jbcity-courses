package pl.breku.backend.course.task;

import org.springframework.stereotype.Component;
import pl.breku.backend.config.JbConfiguration;
import pl.breku.backend.file.FileReader;

import java.util.List;

/**
 * Created by breku on 25.10.17.
 */
@Component
public class TaskProvider {

	private final FileReader fileReader;

	private final FileToTaskConverter fileToTaskConverter;

	private final JbConfiguration jbConfiguration;

	public TaskProvider(FileReader fileReader, FileToTaskConverter fileToTaskConverter, JbConfiguration jbConfiguration) {
		this.fileReader = fileReader;
		this.fileToTaskConverter = fileToTaskConverter;
		this.jbConfiguration = jbConfiguration;
	}

	public List<Task> getTasks() {
		final List<String> fileLines = fileReader.readFile(jbConfiguration.getCoursesSailorPath(), "1.budowa_jachtu.txt");
		return fileToTaskConverter.convertLinesToTasks(fileLines);
	}
}
