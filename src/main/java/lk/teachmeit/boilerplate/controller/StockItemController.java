package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import lk.teachmeit.boilerplate.dto.StockItemDto;
import lk.teachmeit.boilerplate.model.OrderItem;
import lk.teachmeit.boilerplate.model.StockItem;
import lk.teachmeit.boilerplate.service.impl.StockItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/stock-item")
public class StockItemController implements IController<StockItemDto> {

    StockItemServiceImpl stockItemService;

    @Autowired
    public StockItemController(StockItemServiceImpl stockItemService) {
        this.stockItemService = stockItemService;
    }

    @PostMapping
    @Override
    public ResponseWrapper create(@RequestBody StockItemDto item, HttpServletRequest request) {
        try {
            StockItem res = stockItemService.create(item);
            return new ResponseWrapper(res, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @PutMapping
    @Override
    public ResponseWrapper update(@RequestBody StockItemDto item, HttpServletRequest request) {
        try {
            StockItem res = stockItemService.create(item);
            return new ResponseWrapper(res, "success", "Update");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseWrapper deleteById(@PathVariable long id, HttpServletRequest request) {
        try {
            stockItemService.delete(id);
            return new ResponseWrapper(null, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseWrapper getById(@PathVariable long id, HttpServletRequest request) {
        try {
            StockItem res = stockItemService.getById(id);
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping
    @Override
    public ResponseWrapper getAll(HttpServletRequest request) {
        try {
            List<StockItem> res = stockItemService.getAll();
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }
}
