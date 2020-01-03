package com.hexagonal.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexagonal.persistence.jpa.entity.JpaExampleEntity;

public interface ExampleEntityRepository extends JpaRepository<JpaExampleEntity, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<JpaExampleEntity> findById(Integer id);
}
