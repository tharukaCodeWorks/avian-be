package lk.teachmeit.boilerplate.dao;

import lk.teachmeit.boilerplate.model.ItemType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTypeDao extends CrudRepository<ItemType, Long> {
}
