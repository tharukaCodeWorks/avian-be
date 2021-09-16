package lk.teachmeit.boilerplate.dao;

import lk.teachmeit.boilerplate.model.OrderBill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBillDao extends CrudRepository<OrderBill, Long> {
}
