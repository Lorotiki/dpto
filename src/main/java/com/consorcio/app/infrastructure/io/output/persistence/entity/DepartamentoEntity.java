package com.consorcio.app.infrastructure.io.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "departamento")
@IdClass(DepartamentoEntityId.class)
public class DepartamentoEntity {

    @Id
    @EqualsAndHashCode.Include
    private Long idEdificio;

    @Id
    @EqualsAndHashCode.Include
    private Integer piso;

    @Id
    @EqualsAndHashCode.Include
    private String dpto;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_edificio", referencedColumnName = "id_edificio", insertable = false, updatable = false)
    private EdificioEntity edificio;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private List<PersonaDepartamentoEntity> personasDepartamentos = new ArrayList<>();
}
