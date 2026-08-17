# Contexto del Proyecto: Sistema de Gestión de Consorcios (Java)

## 1. Visión General del Proyecto
El objetivo principal es desarrollar una aplicación para la gestión integral de consorcios y edificios. 
En esta fase inicial, la herramienta funcionará como un MVP (Producto Mínimo Viable) enfocado exclusivamente en la administración interna de edificios, unidades funcionales (departamentos) y el cálculo automatizado de expensas/gastos.

## 2. Alcance del MVP (Fase 1)
El sistema en su primera versión se centrará en:

* **Gestión de Edificios y Unidades:**
  * Crear, listar, editar y desactivar edificios.
  * Cargar y administrar departamentos (unidades funcionales) asociados a un edificio, incluyendo su porcentaje de participación (porcentual de expensas).
* **Gestión de Gastos y Cálculo de Expensas:**
  * Cargar gastos/expensas asociados a un edificio (categoría, monto, fecha, comprobante/descripción).
  * Calcular automáticamente el costo liquidado por departamento según el porcentaje asignado o reglas de liquidación.
* **Escalabilidad Futura (A considerar en el diseño):**
  * Asignación de propietarios e inquilinos.
  * Portal de pagos y registro de comprobantes.
  * Módulo de reclamos e incidencias.

## 3. Roles de Usuario
Por el momento, el sistema contempla un único tipo de usuario:
* **Administrador de Consorcio:** Usuario operativo con permisos totales para gestionar edificios, unidades, registrar gastos y ejecutar la liquidación de expensas.

## 4. Stack Tecnológico

* **Lenguaje:** Java 21.
* **Framework Principal:** Spring Boot 4.1 (Spring Web, Spring Data JPA).
* **Base de Datos:** PostgreSQL.
* **Herramienta de Construcción:** Maven (o Gradle).
* **Migraciones de BD:** Flyway o Liquibase.
* **Mapeo de DTOs:** MapStruct (para mantener limpias las capas).
* **Utilidades:** Lombok.

## 5. Arquitectura Propuesta: Arquitectura Hexagonal (Ports & Adapters)

Se elige **Arquitectura Hexagonal** para desvincular el dominio del negocio (reglas de cálculo, entidades de edificio y gastos) del framework (Spring Boot) y de la persistencia (JPA / PostgreSQL).

### Estructura de Paquetes Recomendada (`com.consorcio.app`):

```text
src/main/java/com/consorcio/app/
├── domain/                      # Lógica y Reglas de Negocio Puras (Sin anotaciones de Spring/JPA)
│   ├── model/                   # Entidades de dominio (Edificio, Departamento, Gasto)
│   └── exception/               # Excepciones de dominio
│
├── application/                 # Casos de Uso y Puertos
│   ├── ports/
│   │   ├── input/               # Interfaces que definen los Casos de Uso
│   │   └── output/              # Interfaces de repositorios o servicios externos
│   └── service/                 # Implementación de la lógica de negocio
│
└── infrastructure/              # Adaptadores de Entrada/Salida y Configuración
    ├── io/
    │   ├── input/
    │   │   └── rest/            # Controllers, DTOs de request/response y Mappers
    │   └── output/
    │       └── persistence/     # Entities JPA, Repositorios Spring Data y Adapters de persistencia
    └── config/                  # Configuración de Spring Beans y Beans de Dominio

## 6. Implementación actual

La base inicial quedó modelada con Lombok + JPA bajo `com.consorcio.app`:

- `EdificioEntity` + `DireccionEmbeddable`
- `DepartamentoEntity` + `DepartamentoEntityId`
- `PersonaEntity` + `PersonaEntityId`
- `PersonaDepartamentoEntity` + `PersonaDepartamentoEntityId`
- `RolEntity`

Repositorios disponibles:

- `EdificioRepository`
- `DepartamentoRepository`
- `PersonaRepository`
- `PersonaDepartamentoRepository`
- `RolRepository`

La clase principal quedó en `com.consorcio.app.DptoApplication` para que Spring escanee entidades y repositorios sin configuración extra.
