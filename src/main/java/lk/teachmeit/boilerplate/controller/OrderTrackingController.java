package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.OrderTrackingDto;
import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import lk.teachmeit.boilerplate.model.OrderBill;
import lk.teachmeit.boilerplate.model.OrderTracking;
import lk.teachmeit.boilerplate.service.impl.OrderTrackingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/order-tracking")
public class OrderTrackingController implements  IController<OrderTrackingDto>{

    private final OrderTrackingServiceImpl orderTrackingService;

    @Autowired
    public OrderTrackingController(OrderTrackingServiceImpl orderTrackingService) {
        this.orderTrackingService = orderTrackingService;
    }

    @PostMapping
    @Override
    public ResponseWrapper create(@RequestBody OrderTrackingDto item, HttpServletRequest request) {
        try {
            OrderTracking res = orderTrackingService.create(item);
            return new ResponseWrapper(res, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @PutMapping
    @Override
    public ResponseWrapper update(@RequestBody OrderTrackingDto item, HttpServletRequest request) {
        try {
            OrderTracking res = orderTrackingService.create(item);
            return new ResponseWrapper(res, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseWrapper deleteById(@PathVariable long id, HttpServletRequest request) {
        try {
            orderTrackingService.delete(id);
            return new ResponseWrapper(null, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseWrapper getById(@PathVariable long id, HttpServletRequest request) {
        try {
            OrderTracking res = orderTrackingService.getById(id);
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping
    @Override
    public ResponseWrapper getAll(HttpServletRequest request) {
        try {
            List<OrderTracking> res = orderTrackingService.getAll();
            return new ResponseWrapper(res, "success", "Fteched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/bill/{billId}")
    public ResponseWrapper getOrderTrackingByBillId(@PathVariable long billId){
        try {
            List<OrderTracking> res = orderTrackingService.getByBillId(billId);
            return new ResponseWrapper(res, "success", "Fteched");
        } catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }
}
