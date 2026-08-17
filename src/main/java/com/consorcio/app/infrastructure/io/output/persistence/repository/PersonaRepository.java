package com.consorcio.app.infrastructure.io.output.persistence.repository;

import com.consorcio.app.infrastructure.io.output.persistence.entity.PersonaEntity;
import com.consorcio.app.infrastructure.io.output.persistence.entity.PersonaEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, PersonaEntityId> {
}
