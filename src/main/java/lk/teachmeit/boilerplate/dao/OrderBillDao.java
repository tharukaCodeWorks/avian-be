package lk.teachmeit.boilerplate.dao;

import lk.teachmeit.boilerplate.model.OrderBill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderBillDao extends CrudRepository<OrderBill, Long> {
    List<OrderBill> findByOrderedById(Long id);
}
