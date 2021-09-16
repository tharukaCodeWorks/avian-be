package lk.teachmeit.boilerplate.dao;

import lk.teachmeit.boilerplate.model.StockItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockItemDao extends CrudRepository<StockItem, Long> {
}
