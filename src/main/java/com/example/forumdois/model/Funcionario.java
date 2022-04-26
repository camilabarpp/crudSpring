package com.example.forumdois.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.math.BigDecimal;
@Data
@Document //é o entity so que para mongodb
//identifica um objeto para persistir no banco de dados mongodb
public class Funcionario {

    @Id
    private String codigo;

    private String nome;

    private Integer idade;

    private BigDecimal salario;

}
