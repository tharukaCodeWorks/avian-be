package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.OrderBillDto;
import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import lk.teachmeit.boilerplate.enums.OrderStatus;
import lk.teachmeit.boilerplate.model.ItemType;
import lk.teachmeit.boilerplate.model.OrderBill;
import lk.teachmeit.boilerplate.model.User;
import lk.teachmeit.boilerplate.service.impl.OrderBillServiceImpl;
import lk.teachmeit.boilerplate.util.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/order-bill")
public class OrderBillController implements IController<OrderBillDto> {

    OrderBillServiceImpl orderBillService;
    TokenProvider tokenProvider;

    @Autowired
    public OrderBillController(OrderBillServiceImpl orderBillService, TokenProvider tokenProvider) {
        this.orderBillService = orderBillService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping
    @Override
    public ResponseWrapper create(@RequestBody OrderBillDto item, HttpServletRequest request) {
        try {
            User user = tokenProvider.getAuthUser(request);
            item.setOrderedById(user.getId());
            item.setOrderedAt(new Date());
            OrderBill res = orderBillService.create(item);
            return new ResponseWrapper(res, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @PutMapping
    @Override
    public ResponseWrapper update(@RequestBody OrderBillDto item, HttpServletRequest request) {
        try {
            User user = tokenProvider.getAuthUser(request);
            item.setOrderedById(user.getId());
            item.setOrderedAt(new Date());
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

    @PutMapping("/{id}/{status}")
    public ResponseWrapper updateStatus(@PathVariable long id, @PathVariable OrderStatus status, HttpServletRequest request) {
        try {
            OrderBill res = orderBillService.updateOrderStatus(id, status);
            return new ResponseWrapper(res, "success", "Updated");
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

    @GetMapping("/my")
    public ResponseWrapper getMyAll(HttpServletRequest request) {
        try {
            User user = tokenProvider.getAuthUser(request);
            List<OrderBill> res = orderBillService.getMyAll(user.getId());
            return new ResponseWrapper(res, "success", "Fteched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/count")
    public ResponseWrapper getOrderCount(HttpServletRequest request) {
        try {
            long res = orderBillService.getOrderCount();
            return new ResponseWrapper(res, "success", "Fteched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }
}
