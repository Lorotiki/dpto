package com.consorcio.app.infrastructure.io.output.persistence.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoEntityId implements Serializable {

    private Long idEdificio;
    private Integer piso;
    private String dpto;
}
