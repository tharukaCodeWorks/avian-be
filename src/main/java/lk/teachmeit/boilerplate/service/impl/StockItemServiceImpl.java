package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.StockItemDao;
import lk.teachmeit.boilerplate.dto.StockItemDto;
import lk.teachmeit.boilerplate.model.StockItem;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockItemServiceImpl implements ICrudService<StockItemDto, StockItem> {

    private StockItemDao stockItemDao;

    @Autowired
    public StockItemServiceImpl(StockItemDao stockItemDao) {
        this.stockItemDao = stockItemDao;
    }

    @Override
    public StockItem create(StockItemDto stockItemDto) {
        return null;
    }

    @Override
    public StockItem update(StockItemDto stockItemDto) {
        return null;
    }

    @Override
    public boolean delete(StockItemDto stockItemDto) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public StockItem getById(long id) {
        return null;
    }

    @Override
    public List<StockItem> getAll() {
        return null;
    }

    @Override
    public List<StockItem> getPaginate(long page, long offset) {
        return null;
    }
}
