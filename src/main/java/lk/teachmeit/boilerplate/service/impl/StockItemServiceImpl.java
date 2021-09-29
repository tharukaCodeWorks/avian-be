package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.StockItemDao;
import lk.teachmeit.boilerplate.dto.StockItemDto;
import lk.teachmeit.boilerplate.model.OrderItem;
import lk.teachmeit.boilerplate.model.StockItem;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockItemServiceImpl implements ICrudService<StockItemDto, StockItem> {

    private StockItemDao stockItemDao;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public StockItemServiceImpl(StockItemDao stockItemDao) {
        this.stockItemDao = stockItemDao;
    }

    @Override
    public StockItem create(StockItemDto stockItemDto) {
        StockItem stockItem = modelMapper.map(stockItemDto, StockItem.class);
        stockItem = stockItemDao.save(stockItem);
        return stockItem;
    }

    @Override
    public StockItem update(StockItemDto stockItemDto) {
        StockItem stockItem = modelMapper.map(stockItemDto, StockItem.class);
        stockItem = stockItemDao.save(stockItem);
        return stockItem;
    }

    @Override
    public boolean delete(StockItemDto stockItemDto) {
        StockItem stockItem = modelMapper.map(stockItemDto, StockItem.class);
        stockItemDao.delete(stockItem);
        return true;
    }

    @Override
    public boolean delete(long id) {
        stockItemDao.deleteById(id);
        return true;
    }

    @Override
    public StockItem getById(long id) {
        return stockItemDao.findById(id).get();
    }

    @Override
    public List<StockItem> getAll() {
        return (List<StockItem>) stockItemDao.findAll();
    }

    @Override
    public List<StockItem> getPaginate(long page, long offset) {
        return null;
    }
}
