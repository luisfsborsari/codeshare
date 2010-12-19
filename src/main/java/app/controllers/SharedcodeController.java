package app.controllers;

import java.util.List;

import app.models.Sharedcode;
import app.repositories.SharedcodeRepository;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
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
	public List<Sharedcode> index() {
		return repository.findAll();
	}
	
	@Post
	@Path("/sharedcodes")
	public void create(Sharedcode sharedcode) {
		validator.validate(sharedcode);
		validator.onErrorUsePageOf(this).newSharedcode();
		repository.create(sharedcode);
		result.redirectTo(this).index();
	}
	
	@Get
	@Path("/sharedcodes/new")
	public Sharedcode newSharedcode() {
		return new Sharedcode();
	}
	
	@Put
	@Path("/sharedcodes")
	public void update(Sharedcode sharedcode) {
		validator.validate(sharedcode);
		validator.onErrorUsePageOf(this).edit(sharedcode);
		repository.update(sharedcode);
		result.redirectTo(this).index();
	}
	
	@Get
	@Path("/sharedcodes/{sharedcode.id}/edit")
	public Sharedcode edit(Sharedcode sharedcode) {
		return repository.find(sharedcode.getId());
	}

	@Get
	@Path("/sharedcodes/{sharedcode.id}")
	public Sharedcode show(Sharedcode sharedcode) {
		return repository.find(sharedcode.getId());
	}

	@Delete
	@Path("/sharedcodes/{sharedcode.id}")
	public void destroy(Sharedcode sharedcode) {
		repository.destroy(repository.find(sharedcode.getId()));
		result.redirectTo(this).index();  
	}
	
}
