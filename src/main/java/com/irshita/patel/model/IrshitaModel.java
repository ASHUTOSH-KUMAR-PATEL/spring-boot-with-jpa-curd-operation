package com.irshita.patel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "irshita_patel_model")
public class IrshitaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ishId;

    private String ishName;

    private String ishAge;

    private String ishGender;

    private Double ishFee;
}
