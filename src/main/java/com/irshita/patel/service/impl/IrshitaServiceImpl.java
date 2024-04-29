package com.irshita.patel.service.impl;

import com.irshita.patel.dao.IrshitaDao;
import com.irshita.patel.model.IrshitaModel;
import com.irshita.patel.service.IrshitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IrshitaServiceImpl implements IrshitaService {

    @Autowired
    private IrshitaDao irshitaDao;

    @Override
    public IrshitaModel saveIrshita(IrshitaModel model) {
        return irshitaDao.save(model);
    }

    @Override
    public IrshitaModel getSingleIrshitaObjectById(Integer id) throws IllegalAccessException {
        Optional<IrshitaModel> optional = this.irshitaDao.findById(id);
        if (optional.isPresent()){
            return optional.get();
        } else {
            throw new IllegalAccessException("Irshita Object not found");
        }
    }

    @Override
    public List<IrshitaModel> getAllIrshitaObject() {
        return this.irshitaDao.findAll();
    }

    @Override
    public void deleteIrshitaObjectById(Integer id) {
       Optional<IrshitaModel> optional = this.irshitaDao.findById(id);
        optional.ifPresent(model -> this.irshitaDao.delete(model));
    }

    @Override
    public IrshitaModel updateIrshitaObjectById(IrshitaModel model) throws IllegalAccessException {
        Optional<IrshitaModel> optionalDb = this.irshitaDao.findById(model.getIshId());

        if(optionalDb.isPresent()){
            IrshitaModel updateIrshitaModel = optionalDb.get();
            updateIrshitaModel.setIshAge(model.getIshAge());
            updateIrshitaModel.setIshName(model.getIshName());
            updateIrshitaModel.setIshGender(model.getIshGender());
            updateIrshitaModel.setIshFee(model.getIshFee());
            updateIrshitaModel.setIshId(model.getIshId());

            return updateIrshitaModel;
        } else {
            throw new IllegalAccessException("Not found...");
        }
    }
}
