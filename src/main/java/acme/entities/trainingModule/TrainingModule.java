
package acme.entities.trainingModule;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.client.data.AbstractEntity;
import acme.entities.project.Project;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrainingModule extends AbstractEntity {

	// Serialisation identifier ----------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ----------------------------------

	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "^[A-Z]{1,3}-[0-9]{3}$")
	private String				code;

	@Past
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				creationMoment;

	@NotBlank
	@Length(max = 100)
	private String				details;

	@NotNull
	private DifficultyLevel		difficultyLevel;

	@Past
	@Temporal(TemporalType.TIMESTAMP)
	private Date				updateMoment;

	@URL
	private String				link;

	@Temporal(TemporalType.TIME)
	@NotNull
	private Date				totalTime;

	/*
	 * @NotNull
	 * 
	 * @Min(1)
	 * private Integer totalTime;
	 */

	// Relationships ----------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Project				project;

}
