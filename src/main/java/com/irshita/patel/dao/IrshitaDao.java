package com.irshita.patel.dao;

import com.irshita.patel.model.IrshitaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public interface IrshitaDao extends JpaRepository<IrshitaModel, Serializable> {

}
