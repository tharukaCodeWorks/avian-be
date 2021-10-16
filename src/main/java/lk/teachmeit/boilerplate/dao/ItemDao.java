package lk.teachmeit.boilerplate.dao;

import lk.teachmeit.boilerplate.enums.ItemType;
import lk.teachmeit.boilerplate.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemDao extends CrudRepository<Item, Long> {
    List<Item> findByItemType(ItemType itemType);
}
