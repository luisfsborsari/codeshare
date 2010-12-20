package app.controllers;

import java.util.List;

import app.models.Sharedcode;
import app.repositories.SharedcodeRepository;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class SharedcodeController {

	private final Result result;
	private final SharedcodeRepository repository;
	private final Validator validator;
	
	public SharedcodeController(Result result, SharedcodeRepository repository, Validator validator) {
		this.result = result;
		this.repository = repository;
		this.validator = validator;

	}
	
	@Get
	@Path("/sharedcodes")
	public void form() {

	}
	
	
	@Get
	@Path("/sharedcodes/search")
	public List<Sharedcode> search(String tags){
		List<Sharedcode> list =  repository.search(tags);
		return list;
		
	}
	
	@Post
	@Path("/sharedcodes")
	public void create(Sharedcode sharedcode) {

		repository.create(sharedcode);
		result.redirectTo(this).form();
		
	}
	
	@Get
	@Path("/sharedcodes/new")
	public Sharedcode newSharedcode() {
		return new Sharedcode();
	}
	
	@Post
	@Path("/sharedcodes/update")
	public void update(Sharedcode sharedcode) {
		validator.validate(sharedcode);
		validator.onErrorUsePageOf(this).edit(sharedcode);
		repository.update(sharedcode);
		result.redirectTo(this).form();
	}
	
	@Get
	@Path("/sharedcodes/{sharedcode.id}/edit")
	public Sharedcode edit(Sharedcode sharedcode) {
		return repository.find(sharedcode.getId());
	}

	@Get
	@Path("/sharedcodes/{sharedcode.id}")
	public Sharedcode Sharedcode(Sharedcode sharedcode) {
		Sharedcode code = repository.find(sharedcode.getId());
		return code;
	}

	@Post
	@Path("/sharedcodes/delete")
	public void destroy(Sharedcode sharedcode) {
		repository.destroy(repository.find(sharedcode.getId()));
		result.redirectTo(this).form();  
	}
	
}
