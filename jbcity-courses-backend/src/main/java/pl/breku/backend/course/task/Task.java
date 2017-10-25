package pl.breku.backend.course.task;

import lombok.Data;

import java.util.List;

/**
 * Created by breku on 25.10.17.
 */
@Data
public class Task {

	private String question;

	private List<Answer> answers;
}
