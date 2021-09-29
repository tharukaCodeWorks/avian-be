package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.ItemDao;
import lk.teachmeit.boilerplate.dto.ItemDto;
import lk.teachmeit.boilerplate.model.Item;
import lk.teachmeit.boilerplate.model.ItemType;
import lk.teachmeit.boilerplate.model.StockItem;
import lk.teachmeit.boilerplate.service.S3HelperService;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ICrudService<ItemDto, Item> {

    private S3HelperService s3HelperService;
    private final ItemDao itemDao;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ItemServiceImpl(ItemDao itemDao, S3HelperService s3HelperService) {
        this.itemDao = itemDao;
        this.s3HelperService = s3HelperService;
    }

    @Override
    public Item create(ItemDto itemDto) throws Exception {
        Item itemType = modelMapper.map(itemDto, Item.class);
        String imageLocation = s3HelperService.uploadImage(itemDto.getItemImageMultipart());
        itemType.setItemImage(imageLocation);
        itemType = itemDao.save(itemType);
        return itemType;
    }

    @Override
    public Item update(ItemDto itemDto) throws Exception {
        Item itemType = modelMapper.map(itemDto, Item.class);
        String imageLocation = s3HelperService.uploadImage(itemDto.getItemImageMultipart());
        itemType.setItemImage(imageLocation);
        itemType = itemDao.save(itemType);
        return itemType;
    }

    @Override
    public boolean delete(ItemDto itemDto) {
        Item item = modelMapper.map(itemDto, Item.class);
       itemDao.delete(item);
        return true;
    }

    @Override
    public boolean delete(long id) {
        itemDao.deleteById(id);
        return true;
    }

    @Override
    public Item getById(long id) {
        return itemDao.findById(id).get();
    }

    @Override
    public List<Item> getAll() {
        return (List<Item>) itemDao.findAll();
    }

    @Override
    public List<Item> getPaginate(long page, long offset) {
        return null;
    }
}
