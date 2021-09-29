package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.GrnDto;
import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import lk.teachmeit.boilerplate.model.Grn;
import lk.teachmeit.boilerplate.service.impl.GrnServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/grn")
public class GrnController implements IController<GrnDto> {

    GrnServiceImpl grnService;

    @Autowired
    public GrnController(GrnServiceImpl grnService) {
        this.grnService = grnService;
    }

    @PostMapping
    @Override
    public ResponseWrapper create(@RequestBody GrnDto item, HttpServletRequest request) {
        try {
            Grn res = grnService.create(item);
            return new ResponseWrapper(res, "success", "Created");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @PutMapping
    @Override
    public ResponseWrapper update(@RequestBody GrnDto item, HttpServletRequest request) {
        try {
            Grn res = grnService.create(item);
            return new ResponseWrapper(res, "success", "Updated");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseWrapper deleteById(@PathVariable("id") long id, HttpServletRequest request) {
        try {
            grnService.delete(id);
            return new ResponseWrapper(null, "success", "Deleted");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseWrapper getById(@PathVariable long id, HttpServletRequest request) {
        try {
            Grn res = grnService.getById(id);
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping
    @Override
    public ResponseWrapper getAll(HttpServletRequest request) {
        try {
            List<Grn> res = grnService.getAll();
            return new ResponseWrapper(res, "success", "Fetched");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }
}
