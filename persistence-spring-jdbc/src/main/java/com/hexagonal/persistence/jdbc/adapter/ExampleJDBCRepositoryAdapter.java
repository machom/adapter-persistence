package com.hexagonal.persistence.jdbc.adapter;

import java.util.List;
import java.util.Optional;

import com.hexagonal.domain.Example;
import com.hexagonal.domain.port.ExamplePersistencePort;
import com.hexagonal.persistence.jdbc.repository.ExampleModelRepository;

import lombok.RequiredArgsConstructor;

/**
 * Secundary Adapter, contains implementation for secondary ports defined in
 * pets-domain module. Implementations of these ports are called secondary
 * adapters – they directly communicate with specific datasources (databases,
 * filesystems, etc), they can also call other applications (REST, SOAP, JMS,
 * etc). In simple words, this module should contain implementation details
 * related with providing data (or with communicating with the world) for the
 * the domain
 * 
 * @author Conchi
 *
 */
@RequiredArgsConstructor
public class ExampleJDBCRepositoryAdapter implements ExamplePersistencePort {

	private final ExampleModelRepository exampleModelRepository;

	@Override
	public void addExample(Example example) {
		throw new RuntimeException("RuntimeException");

	}

	@Override
	public void removeExample(Example example) {
		throw new RuntimeException("RuntimeException");

	}

	@Override
	public void updateExample(Example example) {
		throw new RuntimeException("RuntimeException");

	}

	@Override
	public List<Example> getAllExamples() {
		throw new RuntimeException("RuntimeException");
	}

	@Override
	public Optional<Example> getExampleById(Integer id) {
		return exampleModelRepository.findById(id).map(this::adapt);

	}

	/**
	 * 
	 * @param exampleModel
	 * @return
	 */
	private Example adapt(com.hexagonal.persistence.jdbc.model.ExampleModel exampleModel) {
		return new Example(exampleModel.getId(), exampleModel.getName());
	}

}
