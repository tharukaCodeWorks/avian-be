package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.OrderItemDao;
import lk.teachmeit.boilerplate.dto.OrderItemDto;
import lk.teachmeit.boilerplate.model.OrderItem;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements ICrudService<OrderItemDto, OrderItem> {

    private OrderItemDao orderItemDao;

    @Autowired
    public OrderItemServiceImpl(OrderItemDao orderItemDao) {
        this.orderItemDao = orderItemDao;
    }

    @Override
    public OrderItem create(OrderItemDto orderItemDto) {
        return null;
    }

    @Override
    public OrderItem update(OrderItemDto orderItemDto) {
        return null;
    }

    @Override
    public boolean delete(OrderItemDto orderItemDto) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public OrderItem getById(long id) {
        return null;
    }

    @Override
    public List<OrderItem> getAll() {
        return null;
    }

    @Override
    public List<OrderItem> getPaginate(long page, long offset) {
        return null;
    }
}
