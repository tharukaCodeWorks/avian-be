package lk.teachmeit.boilerplate.controller;

import lk.teachmeit.boilerplate.dto.CartDto;
import lk.teachmeit.boilerplate.dto.ResponseWrapper;
import lk.teachmeit.boilerplate.model.Cart;
import lk.teachmeit.boilerplate.model.User;
import lk.teachmeit.boilerplate.service.impl.CartServiceImpl;
import lk.teachmeit.boilerplate.util.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/cart")
public class CartController implements IController<CartDto>{

    private CartServiceImpl cartService;
    TokenProvider tokenProvider;

    @Autowired
    public CartController(CartServiceImpl cartService, TokenProvider tokenProvider) {
        this.cartService = cartService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping
    @Override
    public ResponseWrapper create(@RequestBody CartDto item, HttpServletRequest request) {
        try{
            User user = tokenProvider.getAuthUser(request);
            item.setUserId(user.getId());
            Cart res = cartService.create(item);
            return new ResponseWrapper(res, "success", "success");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @PutMapping
    @Override
    public ResponseWrapper update(@RequestBody CartDto item, HttpServletRequest request) {
        try{
            User user = tokenProvider.getAuthUser(request);
            item.setUserId(user.getId());
            Cart res = cartService.create(item);
            return new ResponseWrapper(res, "success", "updated");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseWrapper deleteById(@PathVariable long id, HttpServletRequest request) {
        try{
            cartService.delete(id);
            return new ResponseWrapper(null, "success", "deleted");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseWrapper getById(@PathVariable long id, HttpServletRequest request) {
        try{
            Cart res = cartService.getById(id);
            return new ResponseWrapper(res, "success", "success");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping("/my")
    public ResponseWrapper getMy( HttpServletRequest request) {
        try{
            User user = tokenProvider.getAuthUser(request);
            List<Cart> res = cartService.getMy(user.getId());
            return new ResponseWrapper(res, "success", "success");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }

    @GetMapping
    @Override
    public ResponseWrapper getAll(HttpServletRequest request) {
        try{
            List<Cart> res = cartService.getAll();
            return new ResponseWrapper(res, "success", "success");
        }catch (Exception e) {
            return new ResponseWrapper(null, "failed", "Internal server error");
        }
    }
}
