package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.ItemTypeDao;
import lk.teachmeit.boilerplate.dto.ItemTypeDto;
import lk.teachmeit.boilerplate.model.ItemType;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTypeServiceImpl implements ICrudService<ItemTypeDto, ItemType> {

    private ItemTypeDao itemTypeDao;

    @Autowired
    public ItemTypeServiceImpl(ItemTypeDao itemTypeDao) {
        this.itemTypeDao = itemTypeDao;
    }

    @Override
    public ItemType create(ItemTypeDto itemTypeDto) {
        return null;
    }

    @Override
    public ItemType update(ItemTypeDto itemTypeDto) {
        return null;
    }

    @Override
    public boolean delete(ItemTypeDto itemTypeDto) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public ItemType getById(long id) {
        return null;
    }

    @Override
    public List<ItemType> getAll() {
        return null;
    }

    @Override
    public List<ItemType> getPaginate(long page, long offset) {
        return null;
    }
}
