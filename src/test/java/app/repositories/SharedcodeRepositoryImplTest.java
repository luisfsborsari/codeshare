package app.repositories;

import org.junit.Test;

public class SharedcodeRepositoryImplTest {
	
	private SharedcodeRepository repository;
	

	@Test
	public void testSearch() {

		try {
			repository.search("");
			assert (true);
		} catch (Exception e) {
			assert (false);
		}

	}

}
