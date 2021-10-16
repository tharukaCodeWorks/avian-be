package lk.teachmeit.boilerplate.dao;

import lk.teachmeit.boilerplate.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao extends CrudRepository<Cart, Long> {
    List<Cart> findByUserId(Long id);
}
