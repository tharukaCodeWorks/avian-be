package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import lk.teachmeit.boilerplate.enums.OrderStatus;
import lk.teachmeit.boilerplate.model.OrderBill;
import lk.teachmeit.boilerplate.service.impl.ReportsControllerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/reports")
public class ReportsController {
    @Autowired
    private ReportsControllerServiceImpl reportsControllerService;

    @GetMapping("/sales/{orderStatus}")
    public ResponseWrapper fetchOrders(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate, @PathVariable("orderStatus")OrderStatus orderStatus) {
        try {
            List<OrderBill> orderBills = reportsControllerService.fetchOrdersByDate(startDate, endDate, orderStatus);
            return new ResponseWrapper(orderBills, "success", "Fetched order bills");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }
}
