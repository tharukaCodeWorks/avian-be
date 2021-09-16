package lk.teachmeit.boilerplate.dao;

import lk.teachmeit.boilerplate.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends CrudRepository<Item, Long> {
}
