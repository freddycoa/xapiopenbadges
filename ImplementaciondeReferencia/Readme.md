#Referencia llamada API XOB

##Listado de Verbos

* Time
* Points
* Level
* Position
* Grade


### Inicialización

Descargar el archivo: **ClassverbXOB.java** 

```Java
ClassVerbXOB xob = new ClassVerbXOB();
```

## 1. Verb time

| verb   	|      params      	|  Description 	|
|----------	|:-------------	|------	|
| hour 	|  ("hour", int) 	| Hora	|
| minutes 	|    ("minutes", int)   	|   Minutos	|
| seconds 	| ("seconds", int) 	|    Segundos 	|


**Ejemplo de ejecución:**
```java
  xob.time("hour",12);
  xob.time("minutes",20);
  xob.time("seconds",01);
```

## 2. Verb points

| verb   	|      params      	|  Description 	|
|----------	|:-------------	|------	|
| score 	|  ("score", int) 	| Puntuación 	|
| position 	|    ("position", int)   	|   Posición	|

**Ejemplo de ejecución:**
```java
  xob.points("score","Maximo record es 10000 pts");
  xob.points("position",20);
```

## 3. Verb level

| verb   	|      params      	|  Description 	|
|----------	|:-------------	|------	|
| number 	|  ("number", int) 	| Número de Nivel 	|
| description 	|    ("description", String)   	|   Descripción del nivel 	|

**Ejemplo de ejecución:**
```java
  xob.level("number",5);
  xob.level("description","Congratulations");
```

## 4. Verb position

| verb   	|      params      	|  Description 	|
|----------	|:-------------	|------	|
| number 	|  ("score", String) 	| Número de posición 	|
| description 	|    ("position", int)   	|   Descripción de la posición 	|
| total   | ("total", int)   |  (String, int)   |

**Ejemplo de ejecución:**
```java
  xob.position("score","Maximo record es 10000 pts");
  xob.position("position",20);
  xob.position("total", 16)
```

## 5. Verb grade

| verb   	|      params      	|  Description 	|
|----------	|:-------------	|------	|
| number 	|  ("number", int) 	| Número del grado obtenido 	|
| description 	|    ("description", String)   	|   Descripción del grado 	|
| imagebadge  |   ("imagebadge", String)     |    Url de imagen del Badge   |

**Ejemplo de ejecución:**
```java
  xob.grade("score",1);
  xob.grade("position","Badge obtenido con X niveles aprobados");
  xob.grade("", "Grado Maximo")
```

