package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.CartDao;
import lk.teachmeit.boilerplate.dto.CartDto;
import lk.teachmeit.boilerplate.model.Cart;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICrudService<CartDto, Cart> {

    private final CartDao cartDao;
    private final ModelMapper modelMapper = new ModelMapper();

    public CartServiceImpl(CartDao cartDao){
        this.cartDao = cartDao;
    }

    @Override
    public Cart create(CartDto cartDto) throws Exception {
        Cart cart = modelMapper.map(cartDto, Cart.class);
        return cartDao.save(cart);
    }


    @Override
    public Cart update(CartDto cartDto) throws Exception {
        Cart cart = modelMapper.map(cartDto, Cart.class);
        return cartDao.save(cart);
    }

    @Override
    public boolean delete(CartDto cartDto) {
        Cart cart = modelMapper.map(cartDto, Cart.class);
        cartDao.delete(cart);
        return true;
    }

    @Override
    public boolean delete(long id) {
        cartDao.deleteById(id);
        return true;
    }

    @Override
    public Cart getById(long id) {
        return cartDao.findById(id).get();
    }

    @Override
    public List<Cart> getAll() {
        return (List<Cart>) cartDao.findAll();
    }

    public List<Cart> getMy(Long id) {
        return cartDao.findByUserId(id);
    }

    @Override
    public List<Cart> getPaginate(long page, long offset) {
        return null;
    }
}
