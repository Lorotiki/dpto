package com.consorcio.app.infrastructure.io.output.persistence.entity;

import com.consorcio.app.domain.model.Rol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "roles")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idRol;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false, unique = true, length = 30)
    private Rol rol;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    private List<PersonaDepartamentoEntity> personasDepartamentos = new ArrayList<>();
}
