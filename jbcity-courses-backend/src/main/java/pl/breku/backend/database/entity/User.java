package pl.breku.backend.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by breku on 28.10.17.
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private long id;
	@Column
	private String username;
	@Column
	private String password;

	@OneToMany
	private List<Role> roles;
}
