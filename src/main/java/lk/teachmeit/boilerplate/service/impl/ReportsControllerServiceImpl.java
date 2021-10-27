package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.OrderBillDao;
import lk.teachmeit.boilerplate.enums.OrderStatus;
import lk.teachmeit.boilerplate.model.OrderBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportsControllerServiceImpl {
    @Autowired
    private OrderBillDao orderBillDao;
    public List<OrderBill> fetchOrdersByDate(Date startDate, Date endDate, OrderStatus orderStatus) {
        List<OrderBill> orderBills = orderBillDao.findByOrderedAtBetweenAndOrderStatus(startDate, endDate, orderStatus);
        return  orderBills;
    }
}
