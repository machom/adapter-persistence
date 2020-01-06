package com.hexagonal.persistence.jpa.adapter;

import java.util.List;
import java.util.Optional;

import com.hexagonal.domain.Example;
import com.hexagonal.domain.port.ExamplePersistencePort;
import com.hexagonal.persistence.jpa.entity.JpaExampleEntity;
import com.hexagonal.persistence.jpa.repository.ExampleEntityRepository;

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
public class ExampleJPARepositoryAdapter implements ExamplePersistencePort {

	private final ExampleEntityRepository exampleEntityRepository;

	@Override
	public void addExample(Example example) {
		throw new RuntimeException("Runtime");

	}

	@Override
	public void removeExample(Example example) {
		throw new RuntimeException("Runtime");

	}

	@Override
	public void updateExample(Example example) {
		throw new RuntimeException("Runtime");

	}

	@Override
	public List<Example> getAllExamples() {
		throw new RuntimeException("Runtime");
	}

	@Override
	public Optional<Example> getExampleById(Integer id) {
		return exampleEntityRepository.findById(id).map(this::adapt);

	}

	/**
	 * 
	 * @param jpaExampleEntity
	 * @return
	 */
	private Example adapt(JpaExampleEntity jpaExampleEntity) {
		return new Example(jpaExampleEntity.getId(), jpaExampleEntity.getName());
	}

}
