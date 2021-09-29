package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.ItemTypeDto;
import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import lk.teachmeit.boilerplate.model.Item;
import lk.teachmeit.boilerplate.model.ItemType;
import lk.teachmeit.boilerplate.service.impl.ItemTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/item-type")
public class ItemTypeController implements IController<ItemTypeDto>{

    ItemTypeServiceImpl itemTypeService;

    @Autowired
    public ItemTypeController(ItemTypeServiceImpl itemTypeService) {
        this.itemTypeService = itemTypeService;
    }

    @PostMapping
    @Override
    public ResponseWrapper create(@ModelAttribute ItemTypeDto item, HttpServletRequest request) {
        try {
            ItemType res = itemTypeService.create(item);
            return new ResponseWrapper(res, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", e.getMessage());
        }
    }

    @PutMapping
    @Override
    public ResponseWrapper update(@ModelAttribute ItemTypeDto item, HttpServletRequest request) {
        try {
            ItemType res = itemTypeService.create(item);
            return new ResponseWrapper(res, "success", "Updated");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseWrapper deleteById(@PathVariable long id, HttpServletRequest request) {
        try {
            itemTypeService.delete(id);
            return new ResponseWrapper(null, "success", "Deleted");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseWrapper getById(@PathVariable long id, HttpServletRequest request) {
        try {
            ItemType res = itemTypeService.getById(id);
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping
    @Override
    public ResponseWrapper getAll(HttpServletRequest request) {
        try {
            List<ItemType> res = itemTypeService.getAll();
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }
}
