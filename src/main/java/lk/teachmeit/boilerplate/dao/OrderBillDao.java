package lk.teachmeit.boilerplate.dao;

import lk.teachmeit.boilerplate.enums.OrderStatus;
import lk.teachmeit.boilerplate.model.OrderBill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderBillDao extends CrudRepository<OrderBill, Long> {
    List<OrderBill> findByOrderedById(Long id);
    @Query("SELECT count(*) FROM OrderBill")
    long countOrders();
    List<OrderBill> findByOrderedAtBetweenAndOrderStatus(Date startDate, Date endDate, OrderStatus orderStatus);
}
