package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.ItemDto;
import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import lk.teachmeit.boilerplate.enums.ItemType;
import lk.teachmeit.boilerplate.model.Grn;
import lk.teachmeit.boilerplate.model.Item;
import lk.teachmeit.boilerplate.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/item")
public class ItemController implements IController<ItemDto> {

    ItemServiceImpl itemService;

    @Autowired
    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @Override
    public ResponseWrapper create(@RequestBody ItemDto item, HttpServletRequest request) {
        try {
            Item res = itemService.create(item);
            return new ResponseWrapper(res, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @PutMapping
    @Override
    public ResponseWrapper update(@RequestBody ItemDto item, HttpServletRequest request) {
        try {
            Item res = itemService.create(item);
            return new ResponseWrapper(res, "success", "Updated");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseWrapper deleteById(@PathVariable long id, HttpServletRequest request) {
        try {
            itemService.delete(id);
            return new ResponseWrapper(null, "success", "Deleted");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseWrapper getById(@PathVariable long id, HttpServletRequest request) {
        try {
            Item item = itemService.getById(id);
            return new ResponseWrapper(item, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }


    @Override
    public ResponseWrapper getAll( HttpServletRequest request) {
        try {
            List<Item> res = itemService.getAll();
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping
    public ResponseWrapper getAll(@RequestParam(name = "type", required = false) ItemType itemType,  HttpServletRequest request) {
        try {
            List<Item> res;
            if(itemType == null) {
                res = itemService.getAll();
            } else {
                res = itemService.getByItemType(itemType);
            }

            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/latest-10")
    public ResponseWrapper getLatestTen(HttpServletRequest request) {
        try {
            List<Item> res = itemService.getLatest10();
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }
}
