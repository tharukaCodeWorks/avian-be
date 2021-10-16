package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.OrderBillDao;
import lk.teachmeit.boilerplate.dto.ItemDto;
import lk.teachmeit.boilerplate.dto.OrderBillDto;
import lk.teachmeit.boilerplate.dto.OrderTrackingDto;
import lk.teachmeit.boilerplate.enums.OrderStatus;
import lk.teachmeit.boilerplate.model.*;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderBillServiceImpl implements ICrudService<OrderBillDto, OrderBill> {

    private final OrderBillDao orderBillDao;
    private final ItemServiceImpl ItemServiceImpl;
    private final OrderTrackingServiceImpl orderTrackingService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public OrderBillServiceImpl(OrderBillDao orderBillDao, OrderTrackingServiceImpl orderTrackingService, ItemServiceImpl ItemServiceImpl) {
        this.orderBillDao = orderBillDao;
        this.orderTrackingService = orderTrackingService;
        this.ItemServiceImpl = ItemServiceImpl;
    }

    @Override
    public OrderBill create(OrderBillDto orderBillDto) throws Exception {
        OrderBill orderBill = modelMapper.map(orderBillDto, OrderBill.class);
        orderBill.setOrderStatus(OrderStatus.PENDING);
        orderBill = orderBillDao.save(orderBill);
        Item item = ItemServiceImpl.getById(orderBillDto.getItemId());
        item.setQty(item.getQty()-orderBillDto.getQty());
        ItemDto itemDto = modelMapper.map(item, ItemDto.class);
        ItemServiceImpl.update(itemDto);
        OrderTrackingDto orderTracking = new OrderTrackingDto();
        orderTracking.setOrderBillId(orderBill.getId());
        orderTracking.setOrderStatus(OrderStatus.PENDING);
        orderTracking.setDate(new Date());
        orderTrackingService.create(orderTracking);
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

    public List<OrderBill> getMyAll(Long id) {
        return orderBillDao.findByOrderedById(id);
    }
}
