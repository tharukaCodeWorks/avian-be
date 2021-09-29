package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.OrderItemDto;
import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import lk.teachmeit.boilerplate.model.OrderBill;
import lk.teachmeit.boilerplate.model.OrderItem;
import lk.teachmeit.boilerplate.service.impl.OrderItemServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/order-item")
public class OrderItemController implements IController<OrderItemDto> {

    OrderItemServiceImpl orderItemService;

    public OrderItemController(OrderItemServiceImpl orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    @Override
    public ResponseWrapper create(@RequestBody OrderItemDto item, HttpServletRequest request) {
        try {
            OrderItem res = orderItemService.create(item);
            return new ResponseWrapper(res, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @PutMapping
    @Override
    public ResponseWrapper update(@RequestBody OrderItemDto item, HttpServletRequest request) {
        try {
            OrderItem res = orderItemService.create(item);
            return new ResponseWrapper(res, "success", "Updated");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseWrapper deleteById(@PathVariable long id, HttpServletRequest request) {
        try {
           orderItemService.delete(id);
            return new ResponseWrapper(null, "success", "Deleted");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseWrapper getById(@PathVariable long id, HttpServletRequest request) {
        try {
            OrderItem res = orderItemService.getById(id);
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping
    @Override
    public ResponseWrapper getAll(HttpServletRequest request) {
        try {
            List<OrderItem> res = orderItemService.getAll();
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }
}
