package lk.teachmeit.boilerplate.service.interfaces;

import java.util.List;

public interface ICrudService<Input,Return> {
    Return create(Input input) throws Exception;
    Return update(Input input) throws Exception;
    boolean delete(Input input);
    boolean delete(long id);
    Return getById(long id);
    List<Return> getAll();
    List<Return> getPaginate(long page, long offset);
}
