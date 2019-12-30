
package com.hexagonal.persistence.jpa.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.common.base.MoreObjects;
import com.hexagonal.persistence.jpa.ExampleEntity;

@Entity(name = "ExampleEntity")
@Table(name = "example_entities")
public final class JpaExampleEntity implements ExampleEntity {

	@Transient
	private static final long serialVersionUID = 1328776989450853491L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer entityId;

	@Column(name = "name", nullable = false)
	private String entityName;

	public JpaExampleEntity() {
		super();
	}

	@Override
	public final boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		final JpaExampleEntity other = (JpaExampleEntity) obj;
		return Objects.equals(entityId, other.entityId);
	}

	@Override
	public final Integer getId() {
		return entityId;
	}

	@Override
	public final String getName() {
		return entityName;
	}

	@Override
	public final int hashCode() {
		return Objects.hash(entityId);
	}

	@Override
	public final void setId(final Integer identifier) {
		entityId = checkNotNull(identifier, "Received a null pointer as identifier");
	}

	@Override
	public final void setName(final String name) {
		entityName = checkNotNull(name, "Received a null pointer as name");
	}

	@Override
	public final String toString() {
		return MoreObjects.toStringHelper(this).add("entityId", entityId).toString();
	}

}
