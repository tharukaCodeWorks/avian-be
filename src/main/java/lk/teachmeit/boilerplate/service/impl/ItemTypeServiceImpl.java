package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.ItemTypeDao;
import lk.teachmeit.boilerplate.dto.ItemTypeDto;
import lk.teachmeit.boilerplate.model.ItemType;
import lk.teachmeit.boilerplate.model.StockItem;
import lk.teachmeit.boilerplate.service.S3HelperService;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTypeServiceImpl implements ICrudService<ItemTypeDto, ItemType> {

    private final S3HelperService s3HelperService;
    private final ItemTypeDao itemTypeDao;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ItemTypeServiceImpl(ItemTypeDao itemTypeDao, S3HelperService s3HelperService) {
        this.itemTypeDao = itemTypeDao;
        this.s3HelperService = s3HelperService;
    }

    @Override
    public ItemType create(ItemTypeDto itemTypeDto) throws Exception {
        ItemType itemType = modelMapper.map(itemTypeDto, ItemType.class);
        String imageLocation = s3HelperService.uploadImage(itemTypeDto.getItemTypeImageMultipart());
        itemType.setItemTypeName(imageLocation);
        itemType = itemTypeDao.save(itemType);
        return itemType;
    }

    @Override
    public ItemType update(ItemTypeDto itemTypeDto) throws Exception {
        ItemType itemType = modelMapper.map(itemTypeDto, ItemType.class);
        String imageLocation = s3HelperService.uploadImage(itemTypeDto.getItemTypeImageMultipart());
        itemType.setItemTypeName(imageLocation);
        itemType = itemTypeDao.save(itemType);
        return itemType;
    }

    @Override
    public boolean delete(ItemTypeDto itemTypeDto) {
        ItemType stockItem = modelMapper.map(itemTypeDto, ItemType.class);
        itemTypeDao.delete(stockItem);
        return true;
    }

    @Override
    public boolean delete(long id) {
        itemTypeDao.deleteById(id);
        return true;
    }

    @Override
    public ItemType getById(long id) {
        return itemTypeDao.findById(id).get();
    }

    @Override
    public List<ItemType> getAll() {
        return (List<ItemType>) itemTypeDao.findAll();
    }

    @Override
    public List<ItemType> getPaginate(long page, long offset) {
        return null;
    }
}
