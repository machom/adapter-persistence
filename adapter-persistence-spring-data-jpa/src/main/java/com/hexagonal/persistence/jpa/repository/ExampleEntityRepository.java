
package com.hexagonal.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexagonal.persistence.jpa.entity.JpaExampleEntity;

@Repository
public interface ExampleEntityRepository extends JpaRepository<JpaExampleEntity, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<JpaExampleEntity> findById(Integer id);
}
