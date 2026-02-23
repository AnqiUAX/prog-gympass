# prog-gympass
Gestión de Gimnasio en Java

# Proyecto Individual – Sistema GymPass

## Fecha de entrega

**25-febrero-2026 - 10:30h**

## Objetivo

Diseñar e implementar el modelo inicial de un sistema de gestión de socios para un gimnasio.

En esta primera fase se trabajará:

- Diseño de clases
- Encapsulación
- Constructores
- Métodos de acceso (getters)
- Sobreescritura de `toString()`
- Buenas prácticas de código
- Uso adecuado de Git y commits progresivos

## Escenario

El gimnasio **GymPass** necesita un sistema básico para representar a sus socios registrados.

Cada socio tiene:
- Un número identificador único dentro del gimnasio
- Un nombre
Cada sala tiene: 
- Un número identificador único dentro del gimnasio
- Descripción de la sala
El gimnasio: 
El sistema debe permitir representar correctamente a cada socio y mostrar su información en formato legible.

## Requisitos Técnicos

Debes seguir los siguientes pasos:

### Clase `Socio`
#### Atributos (privados)
- `numeroSocio` (int)
- `nombre` (String)
#### Constructor

Debe inicializar ambos atributos.
#### Métodos obligatorios
- `getNumeroSocio()`
- `getNombre()`
- `toString()`  
	  Formato requerido:
	```
		[numeroSocio] nombre
	```

>[!important] Haz un commit en este punto

### Clase `Sala`
#### Atributos:  
- `codigoSala` (int)  
- `descripcion` (String)  
#### Debe incluir:  
- Constructor  
- Getters  
- `toString()`

>[!important] Haz un commit en este punto

### Prueba en `Main`  
  
- Crear 2 socios.  
- Crear 2 salas.  
- Mostrar su información por consola.  
  
Sin arrays todavía.

>[!important] Haz un commit en este punto

### Clase `Gimnasio`
#### Atributos:  
- `codigo` (String)  
- `nombre` (String)  
- `Socio[] listaSocios` (tamaño fijo, por ejemplo 12)  
- `Sala[] listaSalas` (tamaño fijo, por ejemplo 6)  
- `responsableId` (int, inicializado a -1)  
#### Métodos obligatorios  
(No deben imprimir nada)  
#####  Gestión de socios  
```java
boolean registrarSocio(Socio s)
```
- Inserta en la primera posición libre.
- No permite números de socio repetidos.
- Devuelve `true` o `false`.

>[!important] Haz un commit en este punto


```java
Socio expulsarSocio(int numero)
```
- Elimina al socio si existe.
- Devuelve el objeto eliminado.
- Si no existe → `null`.

>[!important] Haz un commit en este punto


```java
boolean existeSocio(int numero)
```
- Indica si pertenece al gimnasio.

>[!important] Haz un commit en este punto


```java
boolean designarResponsable(int numeroSocio)
```
- Solo válido si el socio pertenece al gimnasio.

>[!important] Haz un commit en este punto

### Gestión de salas

```java
boolean incorporarSala(Sala sala)
```
- Inserta en primera posición libre.
- No permite códigos repetidos.

>[!important] Haz un commit en este punto

### Resumen

```java
String obtenerInforme()
```
Debe devolver un texto con:
- Código y nombre
- Número de socios ocupados / capacidad
- Responsable actual
- Listado de socios
- Número de salas ocupadas / capacidad
- Listado de salas

>[!important] Haz un commit en este punto

## Prueba en `Main`
- Crear un gimnasio.
- Registrar 3 socios.
- Añadir 2 salas.
- Designar responsable.
- Mostrar el informe.Atributos:  
- `codigo` (String)  
- `nombre` (String)  
- `Socio[] listaSocios` (tamaño fijo, por ejemplo 12)  
- `Sala[] listaSalas` (tamaño fijo, por ejemplo 6)  
- `responsableId` (int, inicializado a -1)  
#### Métodos obligatorios  
(No deben imprimir nada)  
  
### Gestión de socios  

```java  
boolean registrarSocio(Socio s)
```
- Inserta en la primera posición libre.
- No permite números de socio repetidos.
- Devuelve `true` o `false`.

>[!important] Haz un commit en este punto

```java
Socio expulsarSocio(int numero)
```
- Elimina al socio si existe.
- Devuelve el objeto eliminado.
- Si no existe → `null`.

>[!important] Haz un commit en este punto

```java
boolean existeSocio(int numero)
```
- Indica si pertenece al gimnasio.

>[!important] Haz un commit en este punto

```java
boolean designarResponsable(int numeroSocio)
```
- Solo válido si el socio pertenece al gimnasio.

>[!important] Haz un commit en este punto

### Gestión de salas
```java
boolean incorporarSala(Sala sala)
```
- Inserta en primera posición libre.
- No permite códigos repetidos.

>[!important] Haz un commit en este punto

### Resumen
```java
String obtenerInforme()
```
Debe devolver un texto con:
- Código y nombre
- Número de socios ocupados / capacidad
- Responsable actual
- Listado de socios
- Número de salas ocupadas / capacidad
- Listado de salas

>[!important] Haz un commit en este punto

## Prueba en `Main`
- Crear un gimnasio.
- Registrar 3 socios.
- Añadir 2 salas.
- Designar responsable.
- Mostrar el informe.

>[!important] Haz un commit en este punto

---
## Reglas Importantes

1. No se permite usar generación automática de código (Generate → Getter/Constructor).
2. No se permite copiar código de otros compañeros.
3. No se permite utilizar IA generativa para escribir el código.
4. El código debe seguir las buenas prácticas indicadas en clase.
5. El proyecto debe compilar sin errores.

## Requisitos de Control de Versiones

Este proyecto se tendrá en cuenta también por el **proceso de desarrollo**.
### Obligatorio:
- Mínimo **4 commits** diferenciados.
- Cada commit debe representar un avance lógico del proyecto.
- Los mensajes deben ser descriptivos.

---
## Criterios de Evaluación

- Correcta encapsulación
- Funcionamiento del constructor
- Correcta implementación de getters
- Formato exacto de `toString`
- Calidad del código (nombres, formato, claridad)
- Proceso de commits

---
## Defensa Oral

El profesor podrá solicitar una breve explicación del código entregado.

Deberás ser capaz de explicar:
- Qué hace el constructor
- Por qué los atributos son privados
- Qué hace `toString`
- Qué ocurriría si se pasan valores incorrectos

---
## Extensión voluntaria 

Añadir validaciones:
- `numeroSocio` debe ser mayor que 0.
- `nombre` no puede estar vacío.

En caso contrario, lanzar `IllegalArgumentException` (Pregunta al profesor para aclarar dudas)
