package com.consorcio.app.infrastructure.io.output.persistence.repository;

import com.consorcio.app.infrastructure.io.output.persistence.entity.DepartamentoEntity;
import com.consorcio.app.infrastructure.io.output.persistence.entity.DepartamentoEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, DepartamentoEntityId> {
}
