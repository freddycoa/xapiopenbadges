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

| verb   	|      params      	|  Tipos 	|
|----------	|:-------------:	|------:	|
| hour 	|  ("hour", value) 	| (String, int) 	|
| minutes 	|    ("minutes", value)   	|   (String, int) 	|
| seconds 	| ("seconds", value) 	|    (String, int) 	|


**Ejemplo de ejecución:**
```java
  xob.time("hour",12);
  xob.time("minutes",20);
  xob.time("seconds",01);
```

## 2. Verb points

| verb   	|      params      	|  Tipos 	|
|----------	|:-------------:	|------:	|
| score 	|  ("score", value) 	| (String, String) 	|
| position 	|    ("position", value)   	|   (String, int) 	|

**Ejemplo de ejecución:**
```java
  xob.points("score","Maximo record es 10000 pts");
  xob.points("position",20);
```

## 3. Verb level

| verb   	|      params      	|  Tipos 	|
|----------	|:-------------:	|------:	|
| number 	|  ("number", value) 	| (String, int) 	|
| description 	|    ("description", value)   	|   (String, String) 	|

**Ejemplo de ejecución:**
```java
  xob.level("number",5);
  xob.level("description","Congratulations");
```

## 4. Verb position

| verb   	|      params      	|  Tipos 	|
|----------	|:-------------:	|------:	|
| number 	|  ("score", value) 	| (String, String) 	|
| description 	|    ("position", value)   	|   (String, int) 	|
| total   | ("total", value)   |  (String, int)   |

**Ejemplo de ejecución:**
```java
  xob.position("score","Maximo record es 10000 pts");
  xob.position("position",20);
  xob.position("total", 16)
```

## 5. Verb grade

| verb   	|      params      	|  Tipos 	|
|----------	|:-------------:	|------:	|
| number 	|  ("number", value) 	| (String, int) 	|
| description 	|    ("description", value)   	|   (String, String) 	|
| imagebadge  |   ("imagebadge", value)     |    (String, String) 

**Ejemplo de ejecución:**
```java
  xob.grade("score",1);
  xob.grade("position","Badge obtenido con X niveles aprobados");
  xob.grade("", "Grado Maximo")
```

