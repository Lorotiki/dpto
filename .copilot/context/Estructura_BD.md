# Estructura Base de Datos

Documento base y registro de la implementación actual del MVP.

## 1. Edificio

- `ID_EDIFICIO` (PK)
- `NOMBRE`
- `DIRECCION`
  - `CALLE`
  - `NUMERO`
  - `LOCALIDAD`
  - `PROVINCIA`

### Implementación actual

- Entidad JPA: `EdificioEntity`
- Dirección embebida: `DireccionEmbeddable`
- Repositorio: `EdificioRepository`

## 2. Departamento

- `ID_EDIFICIO` (PK, FK a `EDIFICIO`)
- `PISO` (PK)
- `DPTO` (PK, string; puede ser número o letra)

### Implementación actual

- Entidad JPA: `DepartamentoEntity`
- Clave compuesta: `DepartamentoEntityId`
- Relación `ManyToOne` con `EdificioEntity`
- Repositorio: `DepartamentoRepository`

## 3. Personas

- `TIPODOCUMENTO` (PK)
- `NUMERODOCUMENTO` (PK)
- `NOMBRE`
- `APELLIDO`
- `MAIL`
- `TELEFONO`

### Implementación actual

- Entidad JPA: `PersonaEntity`
- Clave compuesta: `PersonaEntityId`
- Repositorio: `PersonaRepository`

## 4. Personas_Departamento

- `TIPODOCUMENTO` (PK, FK a `PERSONAS`)
- `NUMERODOCUMENTO` (PK, FK a `PERSONAS`)
- `ID_EDIFICIO` (PK, FK a `DEPARTAMENTO`)
- `PISO` (PK, FK a `DEPARTAMENTO`)
- `DPTO` (PK, FK a `DEPARTAMENTO`)
- `ROL` (FK a `ROLES`)

### Implementación actual

- Entidad JPA: `PersonaDepartamentoEntity`
- Clave compuesta: `PersonaDepartamentoEntityId`
- Relación `ManyToOne` con `PersonaEntity`
- Relación `ManyToOne` con `DepartamentoEntity`
- Relación `ManyToOne` con `RolEntity`
- Repositorio: `PersonaDepartamentoRepository`

## 5. Roles

- `ID_ROL` (PK)
- `ROL`
  - `PROPIETARIO`
  - `INQUILINO`

### Implementación actual

- Entidad JPA: `RolEntity`
- Campo `rol` modelado como enum
- Repositorio: `RolRepository`

## Observaciones

- La tabla `Personas_Departamento` representa la relación entre una persona y un departamento.
- La capa actual usa Spring Data JPA con Lombok.
- `DptoApplication` fue movida a `com.consorcio.app` para escanear entidades y repositorios.
- La estructura queda abierta para ajustes posteriores de normalización o nombres definitivos.
