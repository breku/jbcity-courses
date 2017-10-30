package pl.breku.backend.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by breku on 28.10.17.
 */
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String username;
	@Column
	private String password;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Role> roles;
}
