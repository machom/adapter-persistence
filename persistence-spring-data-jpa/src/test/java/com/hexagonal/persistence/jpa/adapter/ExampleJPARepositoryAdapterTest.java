package com.hexagonal.persistence.jpa.adapter;

import static java.util.Optional.empty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hexagonal.domain.Example;
import com.hexagonal.persistence.jpa.entity.JpaExampleEntity;
import com.hexagonal.persistence.jpa.repository.ExampleEntityRepository;

@RunWith(MockitoJUnitRunner.class)
public class ExampleJPARepositoryAdapterTest {

	private static final Integer EXAMPLE_ID = 1;
	private static final String EXAMPLE_NAME = "name";

	@Mock
	private ExampleEntityRepository exampleEntityRepositoryMock;

	@InjectMocks
	private ExampleJPARepositoryAdapter underTest;

	@Test
	public void findsExample() {

		final Example expectedExample = new Example(EXAMPLE_ID, EXAMPLE_NAME);

		JpaExampleEntity jpaExampleEntity = new JpaExampleEntity(EXAMPLE_ID, EXAMPLE_NAME);

		when(exampleEntityRepositoryMock.findById(EXAMPLE_ID)).thenReturn(Optional.of(jpaExampleEntity));

		Optional<Example> example = underTest.getExampleById(EXAMPLE_ID);

		assertEquals(Optional.of(expectedExample), example);
	}

	@Test
	public void notFindsExample() {
		when(exampleEntityRepositoryMock.findById(EXAMPLE_ID)).thenReturn(empty());

		Optional<Example> example = underTest.getExampleById(EXAMPLE_ID);

		assertThat(example, is(empty()));
	}

	@Test
	public void givenExampleId_whenCallingGetExampleById_thenFindByIdToRepository() {
		final JpaExampleEntity testJpaExampleEntity = JpaExampleEntity.builder().id(EXAMPLE_ID).name(EXAMPLE_NAME)
				.build();
		when(exampleEntityRepositoryMock.findById(EXAMPLE_ID)).thenReturn(Optional.of(testJpaExampleEntity));

		underTest.getExampleById(EXAMPLE_ID).ifPresent(example -> {

			verify(exampleEntityRepositoryMock, only()).findById(EXAMPLE_ID);
			assertThat(example.getId()).isEqualTo(EXAMPLE_ID);
			assertThat(example.getName()).isEqualTo(EXAMPLE_NAME);
		});

	}

}
