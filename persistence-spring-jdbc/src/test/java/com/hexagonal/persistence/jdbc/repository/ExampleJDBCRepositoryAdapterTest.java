package com.hexagonal.persistence.jdbc.repository;

import static java.util.Optional.empty;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hexagonal.domain.Example;
import com.hexagonal.persistence.jdbc.adapter.ExampleJDBCRepositoryAdapter;
import com.hexagonal.persistence.jdbc.model.ExampleModel;

@RunWith(MockitoJUnitRunner.class)
public class ExampleJDBCRepositoryAdapterTest {

	private static final Integer EXAMPLE_ID = 1;
	private static final String EXAMPLE_NAME = "name";

	@Mock
	private ExampleModelRepository exampleModelRepositoryMock;

	@InjectMocks
	private ExampleJDBCRepositoryAdapter underTest;

	@Test
	public void findsExample() {

		final Example expectedExample = new Example(EXAMPLE_ID, EXAMPLE_NAME);

		ExampleModel exampleModel = new ExampleModel(EXAMPLE_ID, EXAMPLE_NAME);

		when(exampleModelRepositoryMock.findById(EXAMPLE_ID)).thenReturn(Optional.of(exampleModel));

		Optional<Example> example = underTest.getExampleById(EXAMPLE_ID);

		assertEquals(Optional.of(expectedExample), example);
	}

	@Test
	public void notFindsExample() {
		when(exampleModelRepositoryMock.findById(EXAMPLE_ID)).thenReturn(empty());

		Optional<Example> example = underTest.getExampleById(EXAMPLE_ID);

		assertThat(example, is(empty()));
	}

}
