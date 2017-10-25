package pl.breku.backend.course.task;

import org.springframework.stereotype.Component;
import pl.breku.backend.file.FileReader;

import java.util.List;

/**
 * Created by breku on 25.10.17.
 */
@Component
public class TaskProvider {

	private final FileReader fileReader;

	private final FileToTaskConverter fileToTaskConverter;

	public TaskProvider(FileReader fileReader, FileToTaskConverter fileToTaskConverter) {
		this.fileReader = fileReader;
		this.fileToTaskConverter = fileToTaskConverter;
	}

	public List<Task> getTasks() {
		final List<String> fileLines = fileReader.readFileFromClasspath("/questions/sailor", "1.budowa_jachtu.txt");
		return fileToTaskConverter.convertLinesToTasks(fileLines);
	}
}
