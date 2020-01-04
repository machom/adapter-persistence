package com.hexagonal.persistence.jdbc.repository;

import java.util.Optional;

import com.hexagonal.persistence.jdbc.model.ExampleModel;

public interface ExampleModelRepository {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<ExampleModel> findById(Integer id);
}
