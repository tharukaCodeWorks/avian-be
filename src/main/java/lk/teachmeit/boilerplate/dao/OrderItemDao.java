package lk.teachmeit.boilerplate.dao;

import lk.teachmeit.boilerplate.model.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemDao extends CrudRepository<OrderItem, Long> {
}
