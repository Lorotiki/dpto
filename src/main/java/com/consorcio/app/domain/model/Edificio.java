package com.consorcio.app.domain.model;

/**
 * Entidad de dominio que representa un edificio del consorcio.
 *
 * <p>{@code idEdificio} es {@code null} cuando la instancia aún no fue persistida.</p>
 */
public record Edificio(
        Long idEdificio,
        String nombre,
        Direccion direccion
) {}
