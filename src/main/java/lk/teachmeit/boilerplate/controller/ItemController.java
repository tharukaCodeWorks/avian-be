package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.ItemDto;
import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/item")
public class ItemController implements IController<ItemDto> {
    @Override
    public ResponseWrapper create(ItemDto item, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseWrapper update(ItemDto item, HttpServletRequest request) {
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
