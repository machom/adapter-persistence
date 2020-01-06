package com.hexagonal.persistence.jdbc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hexagonal.persistence.jdbc.model.ExampleModel;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ExampleModelRepositoryImpl implements ExampleModelRepository {

	private static final String QUERY_FIND_BY_ID = "select id, name from example_entities where id = ?";

	private static final RowMapper<ExampleModel> rowMapper = (rs, i) -> new ExampleModel(rs.getInt("id"),
			rs.getString("name"));

	private final JdbcTemplate jdbcTemplate;

	@Override
	public Optional<ExampleModel> findById(Integer id) {
		List<ExampleModel> query = jdbcTemplate.query(QUERY_FIND_BY_ID, new Object[] { id }, rowMapper);
		if (query.size() > 1)
			throw new RuntimeException("Too many results from findById. ");
		return query.size() == 1 ? Optional.of(query.get(0)) : Optional.empty();
	}

}
