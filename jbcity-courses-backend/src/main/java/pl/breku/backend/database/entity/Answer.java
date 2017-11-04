package pl.breku.backend.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by breku on 25.10.17.
 */
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "answers")
@NoArgsConstructor
public class Answer implements Serializable{

	private static final long serialVersionUID = -9155950082426273919L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String text;

	@Column
	private boolean correct;
}
