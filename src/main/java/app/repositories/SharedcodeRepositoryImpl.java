package app.repositories;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import app.models.Sharedcode;

@Component
public class SharedcodeRepositoryImpl 
    extends Repository<Sharedcode, Long>
    implements SharedcodeRepository {

	public SharedcodeRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
