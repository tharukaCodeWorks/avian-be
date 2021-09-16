package lk.teachmeit.boilerplate.dao;

import lk.teachmeit.boilerplate.model.Grn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrnDao extends CrudRepository<Grn, Long> {
}
