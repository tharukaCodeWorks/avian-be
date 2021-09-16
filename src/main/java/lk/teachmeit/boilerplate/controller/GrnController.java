package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.GrnDto;
import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/grn")
public class GrnController implements IController<GrnDto> {
    @Override
    public ResponseWrapper create(GrnDto item, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseWrapper update(GrnDto item, HttpServletRequest request) {
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
