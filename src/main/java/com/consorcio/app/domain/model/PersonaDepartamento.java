package com.consorcio.app.domain.model;

/**
 * Entidad de dominio que representa la relación entre una persona y un departamento,
 * junto con el rol que ejerce en esa unidad.
 *
 * <p>Toda la clave es compuesta: {@code (tipoDocumento, numeroDocumento, idEdificio, piso, dpto)}.
 * El {@link Id} interno agrupa los cinco campos.</p>
 *
 * <h3>Nota sobre persistencia con Spring Data JDBC</h3>
 * Spring Data JDBC no soporta claves compuestas de forma nativa con {@code @Id}.
 * Las opciones para la capa de infraestructura son:
 * <ul>
 *   <li>Agregar un surrogate {@code Long id} auto-generado y conservar los cinco campos como columnas normales.</li>
 *   <li>Usar {@code @EmbeddedId} con Spring Data JPA (requiere migrar a la dependencia JPA).</li>
 * </ul>
 * La decisión queda diferida a la iteración de persistencia.
 */
public record PersonaDepartamento(
        TipoDocumento tipoDocumento,
        String numeroDocumento,
        Long idEdificio,
        Integer piso,
        String dpto,
        Rol rol
) {
    /**
     * Clave compuesta de la relación persona-departamento.
     */
    public record Id(
            TipoDocumento tipoDocumento,
            String numeroDocumento,
            Long idEdificio,
            Integer piso,
            String dpto
    ) {}

    public Id id() {
        return new Id(tipoDocumento, numeroDocumento, idEdificio, piso, dpto);
    }
}
