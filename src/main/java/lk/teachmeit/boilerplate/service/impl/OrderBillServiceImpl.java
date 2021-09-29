package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.OrderBillDao;
import lk.teachmeit.boilerplate.dto.OrderBillDto;
import lk.teachmeit.boilerplate.model.Grn;
import lk.teachmeit.boilerplate.model.OrderBill;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBillServiceImpl implements ICrudService<OrderBillDto, OrderBill> {

    private final OrderBillDao orderBillDao;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public OrderBillServiceImpl(OrderBillDao orderBillDao) {
        this.orderBillDao = orderBillDao;
    }

    @Override
    public OrderBill create(OrderBillDto orderBillDto) {
        OrderBill orderBill = modelMapper.map(orderBillDto, OrderBill.class);
        orderBill = orderBillDao.save(orderBill);
        return orderBill;
    }

    @Override
    public OrderBill update(OrderBillDto orderBillDto) {
        OrderBill orderBill = modelMapper.map(orderBillDto, OrderBill.class);
        orderBill = orderBillDao.save(orderBill);
        return orderBill;
    }

    @Override
    public boolean delete(OrderBillDto orderBillDto) {
        OrderBill orderBill = modelMapper.map(orderBillDto, OrderBill.class);
        orderBillDao.delete(orderBill);
        return true;
    }

    @Override
    public boolean delete(long id) {
        orderBillDao.deleteById(id);
        return true;
    }

    @Override
    public OrderBill getById(long id) {
        return orderBillDao.findById(id).get();
    }

    @Override
    public List<OrderBill> getAll() {
        return (List<OrderBill>) orderBillDao.findAll();
    }

    @Override
    public List<OrderBill> getPaginate(long page, long offset) {
        return null;
    }
}
