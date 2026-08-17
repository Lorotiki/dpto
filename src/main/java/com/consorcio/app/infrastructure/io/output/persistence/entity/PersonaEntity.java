package com.consorcio.app.infrastructure.io.output.persistence.entity;

import com.consorcio.app.domain.model.TipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@Table(name = "persona")
@IdClass(PersonaEntityId.class)
public class PersonaEntity {

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", nullable = false, length = 30)
    @EqualsAndHashCode.Include
    private TipoDocumento tipoDocumento;

    @Id
    @Column(name = "numero_documento", nullable = false, length = 30)
    @EqualsAndHashCode.Include
    private String numeroDocumento;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String telefono;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<PersonaDepartamentoEntity> personasDepartamentos = new ArrayList<>();
}
