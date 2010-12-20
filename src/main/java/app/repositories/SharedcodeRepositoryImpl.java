package app.repositories;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Sharedcode> search(String tags) {
/*		LinkedList<Sharedcode> lista = new LinkedList<Sharedcode>();
		lista.add(new Sharedcode("Main", "main", "Cobol", "new main"));
		return lista;*/	
		return entityManager.createQuery("From " + Sharedcode.class.getName() + " Where tags LIKE '%" + tags + "%'").getResultList();
	}
}
