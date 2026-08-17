package com.consorcio.app.domain.model;

/**
 * Entidad de dominio que representa a una persona física.
 *
 * <p>La identidad es compuesta: {@code (tipoDocumento, numeroDocumento)}.
 * Se expone como record interno {@link Id}.</p>
 */
public record Persona(
        TipoDocumento tipoDocumento,
        String numeroDocumento,
        String nombre,
        String apellido,
        String mail,
        String telefono
) {
    /**
     * Clave compuesta de la persona.
     */
    public record Id(TipoDocumento tipoDocumento, String numeroDocumento) {}

    public Id id() {
        return new Id(tipoDocumento, numeroDocumento);
    }
}
