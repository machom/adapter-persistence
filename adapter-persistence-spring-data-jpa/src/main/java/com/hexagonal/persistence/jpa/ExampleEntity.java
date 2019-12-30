
package com.hexagonal.persistence.jpa;

import java.io.Serializable;

public interface ExampleEntity extends Serializable {

	public Integer getId();

	public String getName();

	public void setId(final Integer identifier);

	public void setName(final String name);

}
