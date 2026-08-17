package com.consorcio.app.domain.model;

/**
 * Entidad de dominio que representa una unidad funcional (departamento) dentro de un edificio.
 *
 * <p>La identidad es compuesta: {@code (idEdificio, piso, dpto)}.
 * Se expone como record interno {@link Id} para simplificar el manejo de la clave.</p>
 *
 * <p>{@code dpto} es String porque puede ser un número ("1") o una letra ("A").</p>
 */
public record Departamento(
        Long idEdificio,
        Integer piso,
        String dpto
) {
    /**
     * Clave compuesta del departamento, útil como identificador explícito en la capa de persistencia.
     */
    public record Id(Long idEdificio, Integer piso, String dpto) {}

    public Id id() {
        return new Id(idEdificio, piso, dpto);
    }
}
