package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.OrderBillDto;
import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import lk.teachmeit.boilerplate.model.ItemType;
import lk.teachmeit.boilerplate.model.OrderBill;
import lk.teachmeit.boilerplate.service.impl.OrderBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/order-bill")
public class OrderBillController implements IController<OrderBillDto> {

    OrderBillServiceImpl orderBillService;

    @Autowired
    public OrderBillController(OrderBillServiceImpl orderBillService) {
        this.orderBillService = orderBillService;
    }

    @PostMapping
    @Override
    public ResponseWrapper create(OrderBillDto item, HttpServletRequest request) {
        try {
            OrderBill res = orderBillService.create(item);
            return new ResponseWrapper(res, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @PutMapping
    @Override
    public ResponseWrapper update(OrderBillDto item, HttpServletRequest request) {
        try {
            OrderBill res = orderBillService.create(item);
            return new ResponseWrapper(res, "success", "Updated");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseWrapper deleteById(@PathVariable long id, HttpServletRequest request) {
        try {
            orderBillService.delete(id);
            return new ResponseWrapper(null, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseWrapper getById(@PathVariable long id, HttpServletRequest request) {
        try {
            OrderBill res = orderBillService.getById(id);
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping
    @Override
    public ResponseWrapper getAll(HttpServletRequest request) {
        try {
            List<OrderBill> res = orderBillService.getAll();
            return new ResponseWrapper(res, "success", "Fteched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }
}
