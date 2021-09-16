package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.OrderItemDto;
import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/order-item")
public class OrderItemController implements IController<OrderItemDto> {
    @Override
    public ResponseWrapper create(OrderItemDto item, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseWrapper update(OrderItemDto item, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseWrapper deleteById(long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseWrapper getById(long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseWrapper getAll(HttpServletRequest request) {
        return null;
    }
}
