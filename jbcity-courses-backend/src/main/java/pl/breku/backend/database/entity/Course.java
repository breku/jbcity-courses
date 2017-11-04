package pl.breku.backend.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by breku on 14.09.17.
 */
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "courses")
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Task> tasks;
}
