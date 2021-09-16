package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.OrderBillDao;
import lk.teachmeit.boilerplate.dto.OrderBillDto;
import lk.teachmeit.boilerplate.model.OrderBill;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBillServiceImpl implements ICrudService<OrderBillDto, OrderBill> {

    private OrderBillDao orderBillDao;

    @Autowired
    public OrderBillServiceImpl(OrderBillDao orderBillDao) {
        this.orderBillDao = orderBillDao;
    }

    @Override
    public OrderBill create(OrderBillDto orderBillDto) {
        return null;
    }

    @Override
    public OrderBill update(OrderBillDto orderBillDto) {
        return null;
    }

    @Override
    public boolean delete(OrderBillDto orderBillDto) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public OrderBill getById(long id) {
        return null;
    }

    @Override
    public List<OrderBill> getAll() {
        return null;
    }

    @Override
    public List<OrderBill> getPaginate(long page, long offset) {
        return null;
    }
}
