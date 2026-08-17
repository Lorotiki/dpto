package com.consorcio.app.infrastructure.io.output.persistence.repository;

import com.consorcio.app.infrastructure.io.output.persistence.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<RolEntity, Long> {
}
