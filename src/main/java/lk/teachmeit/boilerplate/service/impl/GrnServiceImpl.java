package lk.teachmeit.boilerplate.service.impl;

import lk.teachmeit.boilerplate.dao.GrnDao;
import lk.teachmeit.boilerplate.dto.GrnDto;
import lk.teachmeit.boilerplate.model.Grn;
import lk.teachmeit.boilerplate.service.interfaces.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrnServiceImpl implements ICrudService<GrnDto, Grn> {

    private final GrnDao grnDao;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public GrnServiceImpl(GrnDao grnDao) {
        this.grnDao = grnDao;
    }

    @Override
    public Grn create(GrnDto grnDto) {
        Grn grn = modelMapper.map(grnDto, Grn.class);
        grn = grnDao.save(grn);
        return grn;
    }

    @Override
    public Grn update(GrnDto grnDto) {
        Grn grn = modelMapper.map(grnDto, Grn.class);
        grn = grnDao.save(grn);
        return grn;
    }

    @Override
    public boolean delete(GrnDto grnDto) {
        Grn grn = modelMapper.map(grnDto, Grn.class);
        grnDao.delete(grn);
        return true;
    }

    @Override
    public boolean delete(long id) {
        grnDao.deleteById(id);
        return true;
    }

    @Override
    public Grn getById(long id) {
        return grnDao.findById(id).get();
    }

    @Override
    public List<Grn> getAll() {
        return (List<Grn>) grnDao.findAll();
    }

    @Override
    public List<Grn> getPaginate(long page, long offset) {
        return null;
    }
}
