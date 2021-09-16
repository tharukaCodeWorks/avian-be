package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.ItemDao;
import lk.teachmeit.boilerplate.dto.ItemDto;
import lk.teachmeit.boilerplate.model.Item;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ICrudService<ItemDto, Item> {

    private ItemDao itemDao;

    @Autowired
    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public Item create(ItemDto itemDto) {
        return null;
    }

    @Override
    public Item update(ItemDto itemDto) {
        return null;
    }

    @Override
    public boolean delete(ItemDto itemDto) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public Item getById(long id) {
        return null;
    }

    @Override
    public List<Item> getAll() {
        return null;
    }

    @Override
    public List<Item> getPaginate(long page, long offset) {
        return null;
    }
}
