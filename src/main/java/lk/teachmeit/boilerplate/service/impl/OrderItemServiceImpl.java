package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.ItemDao;
import lk.teachmeit.boilerplate.dao.OrderItemDao;
import lk.teachmeit.boilerplate.dto.OrderItemDto;
import lk.teachmeit.boilerplate.model.Item;
import lk.teachmeit.boilerplate.model.OrderBill;
import lk.teachmeit.boilerplate.model.OrderItem;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements ICrudService<OrderItemDto, OrderItem> {

    private final OrderItemDao orderItemDao;
    private final ItemDao itemDao;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public OrderItemServiceImpl(OrderItemDao orderItemDao, ItemDao itemDao) {
        this.orderItemDao = orderItemDao;
        this.itemDao = itemDao;
    }

    @Override
    public OrderItem create(OrderItemDto orderItemDto) {
        OrderItem orderItem = modelMapper.map(orderItemDto, OrderItem.class);
        Item item = itemDao.findById(orderItemDto.getItemId()).get();
        item.setQty(item.getQty()-orderItem.getQty());
        itemDao.save(item);
        orderItem = orderItemDao.save(orderItem);
        return orderItem;
    }

    @Override
    public OrderItem update(OrderItemDto orderItemDto) {
        OrderItem orderItem = modelMapper.map(orderItemDto, OrderItem.class);
        Item item = itemDao.findById(orderItemDto.getItemId()).get();
        item.setQty(item.getQty()-orderItem.getQty());
        itemDao.save(item);
        orderItem = orderItemDao.save(orderItem);
        return orderItem;
    }

    @Override
    public boolean delete(OrderItemDto orderItemDto) {
        OrderItem orderItem = modelMapper.map(orderItemDto, OrderItem.class);
        orderItemDao.delete(orderItem);
        return true;
    }

    @Override
    public boolean delete(long id) {
        orderItemDao.deleteById(id);
        return true;
    }

    @Override
    public OrderItem getById(long id) {
        return orderItemDao.findById(id).get();
    }

    @Override
    public List<OrderItem> getAll() {
        return (List<OrderItem>) orderItemDao.findAll();
    }

    @Override
    public List<OrderItem> getPaginate(long page, long offset) {
        return null;
    }
}
