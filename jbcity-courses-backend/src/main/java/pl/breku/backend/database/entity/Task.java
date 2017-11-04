package pl.breku.backend.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by breku on 25.10.17.
 */
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tasks")
@NoArgsConstructor
public class Task implements Serializable{

	private static final long serialVersionUID = -9114493516018039037L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String question;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Answer> answers;
}
