package com.consorcio.app.infrastructure.io.output.persistence.repository;

import com.consorcio.app.infrastructure.io.output.persistence.entity.PersonaDepartamentoEntity;
import com.consorcio.app.infrastructure.io.output.persistence.entity.PersonaDepartamentoEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDepartamentoRepository extends JpaRepository<PersonaDepartamentoEntity, PersonaDepartamentoEntityId> {
}
