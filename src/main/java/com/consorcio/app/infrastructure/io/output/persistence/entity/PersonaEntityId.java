package com.consorcio.app.infrastructure.io.output.persistence.entity;

import com.consorcio.app.domain.model.TipoDocumento;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntityId implements Serializable {

    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
}
