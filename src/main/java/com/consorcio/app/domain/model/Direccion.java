package com.consorcio.app.domain.model;

/**
 * Value object que representa la dirección física de un edificio.
 * Se modela como record para garantizar inmutabilidad.
 */
public record Direccion(
        String calle,
        String numero,
        String localidad,
        String provincia
) {}
