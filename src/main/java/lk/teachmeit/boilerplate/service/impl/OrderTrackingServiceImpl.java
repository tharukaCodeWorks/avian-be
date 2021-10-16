package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.OrderTrackingDao;
import lk.teachmeit.boilerplate.dto.OrderTrackingDto;
import lk.teachmeit.boilerplate.model.OrderItem;
import lk.teachmeit.boilerplate.model.OrderTracking;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTrackingServiceImpl implements ICrudService<OrderTrackingDto, OrderTracking> {

    private final OrderTrackingDao orderTrackingDao;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public OrderTrackingServiceImpl(OrderTrackingDao orderTrackingDao) {
        this.orderTrackingDao = orderTrackingDao;
    }

    @Override
    public OrderTracking create(OrderTrackingDto orderTrackingDto) throws Exception {
        OrderTracking orderTracking = modelMapper.map(orderTrackingDto, OrderTracking.class);
        orderTracking = orderTrackingDao.save(orderTracking);
        return orderTracking;
    }

    @Override
    public OrderTracking update(OrderTrackingDto orderTrackingDto) throws Exception {
        OrderTracking orderTracking = modelMapper.map(orderTrackingDto, OrderTracking.class);
        orderTracking = orderTrackingDao.save(orderTracking);
        return orderTracking;
    }

    @Override
    public boolean delete(OrderTrackingDto orderTrackingDto) {
        OrderTracking orderTracking = modelMapper.map(orderTrackingDto, OrderTracking.class);
        orderTrackingDao.delete(orderTracking);
        return true;
    }

    @Override
    public boolean delete(long id) {
        orderTrackingDao.deleteById(id);
        return true;
    }

    @Override
    public OrderTracking getById(long id) {
        return orderTrackingDao.findById(id).get();
    }

    @Override
    public List<OrderTracking> getAll() {
        return (List<OrderTracking>) orderTrackingDao.findAll();
    }

    @Override
    public List<OrderTracking> getPaginate(long page, long offset) {
        return null;
    }

    public List<OrderTracking> getByBillId(long billId) {
        return orderTrackingDao.findByOrderBillId(billId);
    }
}
