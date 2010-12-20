package app.controllers;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import app.models.Sharedcode;
import app.repositories.SharedcodeRepository;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

public class SharedcodeControllerTest {
	
	private SharedcodeController controller;
	private Sharedcode code;
	
	@Before
	public void inicializa(){
		code = new Sharedcode("nome","tags","Java","public static void m(){}");
	}

/*	@Test
	public void testMock(){
		SharedcodeRepository repo = Mockito.mock(SharedcodeRepository.class);
		
		SharedcodeController cont = new SharedcodeController(mock(Result.class), repo, mock(Validator.class));
		cont.create( code );
		
		Mockito.verify(repo, Mockito.times(1)).create(code);
		
	}*/
	
	@Test
	public void testSearch() {
		try {
			controller.search("");
			assert(true);
		} catch (Exception e) {
			assert(false);
		}
	}

	@Test
	public void testCreate() {
		try {
			controller.create(code);
			if(controller.search("tags") != null)
				assert true;
			else
				assert false;
		} catch (Exception e) {
			assert(false);
		}
	}

	@Test
	public void testNewSharedcode() {
		try {
			if(controller.newSharedcode() != null)
				assert true;
			else
				assert false;
		} catch (Exception e) {
			assert false;
		}
	}

	@Test
	public void testUpdate() {
		try {
			code.setTags("tags2");
			controller.update(code);
			if(controller.search("tags2") != null)
				assert true;
			else
				assert false;
		}
		catch (Exception e) {
			assert false;
		}
		
	}


	@Test
	public void testDestroy() {
		try {
			controller.destroy(code);
			if(controller.edit(code) == null)
				assert true;
			else
				assert false;
		}
		catch (Exception e) {
			assert false;
		}
	}

}
