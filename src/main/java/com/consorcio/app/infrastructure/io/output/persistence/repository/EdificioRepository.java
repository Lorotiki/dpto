package com.consorcio.app.infrastructure.io.output.persistence.repository;

import com.consorcio.app.infrastructure.io.output.persistence.entity.EdificioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<EdificioEntity, Long> {
}
