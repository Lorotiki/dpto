package com.consorcio.app.infrastructure.io.output.persistence.entity;

import com.consorcio.app.domain.model.TipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "persona_departamento")
@IdClass(PersonaDepartamentoEntityId.class)
public class PersonaDepartamentoEntity {

    @Id
    @Column(name = "tipo_documento", nullable = false, length = 30)
    @EqualsAndHashCode.Include
    private TipoDocumento tipoDocumento;

    @Id
    @Column(name = "numero_documento", nullable = false, length = 30)
    @EqualsAndHashCode.Include
    private String numeroDocumento;

    @Id
    @Column(name = "id_edificio", nullable = false)
    @EqualsAndHashCode.Include
    private Long idEdificio;

    @Id
    @Column(name = "piso", nullable = false)
    @EqualsAndHashCode.Include
    private Integer piso;

    @Id
    @Column(name = "dpto", nullable = false)
    @EqualsAndHashCode.Include
    private String dpto;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "tipo_documento", referencedColumnName = "tipo_documento", insertable = false, updatable = false),
            @JoinColumn(name = "numero_documento", referencedColumnName = "numero_documento", insertable = false, updatable = false)
    })
    private PersonaEntity persona;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "id_edificio", referencedColumnName = "id_edificio", insertable = false, updatable = false),
            @JoinColumn(name = "piso", referencedColumnName = "piso", insertable = false, updatable = false),
            @JoinColumn(name = "dpto", referencedColumnName = "dpto", insertable = false, updatable = false)
    })
    private DepartamentoEntity departamento;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    private RolEntity rol;
}
