package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.GrnDao;
import lk.teachmeit.boilerplate.dto.GrnDto;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrnServiceImpl implements ICrudService<GrnDto, GrnDto> {

    private GrnDao grnDao;

    @Autowired
    public GrnServiceImpl(GrnDao grnDao) {
        this.grnDao = grnDao;
    }

    @Override
    public GrnDto create(GrnDto grnDto) {
        return null;
    }

    @Override
    public GrnDto update(GrnDto grnDto) {
        return null;
    }

    @Override
    public boolean delete(GrnDto grnDto) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public GrnDto getById(long id) {
        return null;
    }

    @Override
    public List<GrnDto> getAll() {
        return null;
    }

    @Override
    public List<GrnDto> getPaginate(long page, long offset) {
        return null;
    }
}
