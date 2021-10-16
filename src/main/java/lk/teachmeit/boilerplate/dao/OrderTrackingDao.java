package lk.teachmeit.boilerplate.dao;

import lk.teachmeit.boilerplate.model.OrderTracking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderTrackingDao extends CrudRepository<OrderTracking, Long> {
    List<OrderTracking> findByOrderBillId(long billId);
}
