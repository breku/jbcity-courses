package pl.breku.backend.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.breku.backend.security.RoleType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by basakpie on 2017. 5. 11..
 */
@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roles")
@NoArgsConstructor
public class Role implements Serializable {


	private static final long serialVersionUID = -7569956409775155749L;

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private RoleType type;

}
