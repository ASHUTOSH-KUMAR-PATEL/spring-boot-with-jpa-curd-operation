package com.irshita.patel.service;


import com.irshita.patel.model.IrshitaModel;
import java.util.List;

public interface IrshitaService {

    IrshitaModel saveIrshita(IrshitaModel model);

    IrshitaModel getSingleIrshitaObjectById(Integer id) throws IllegalAccessException;

    List<IrshitaModel> getAllIrshitaObject();

    void deleteIrshitaObjectById(Integer id);

    IrshitaModel updateIrshitaObjectById(IrshitaModel model) throws IllegalAccessException;

}
