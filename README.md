# XapiOpenBadges
Emision de Badges
Repositorio de Estandar de de emision de badges a traves de una sola plataforma mediante la combinancion de estandares, los principales para comunicación xAPI (ADL), Openbadges (Mozilla). A continuacion se mostraran tres carpetas en la que cada una tendra un ejemplo de comunicación y emision de badges a traves del estandar propuesto. 

# Propuesta de un modelo de intercambio y almacenamiento de badges con xAPI y Mozilla Open Badges

##Formato de Comunicación entre Juego y LRS con xAPI
Juego: El juego debe estar determinado con Metas como objetivos y estrategias para alcanzar un nivel, Puntos se lograran de acuerdo al tiempo y métodos utilizados para lograr los objetivos, y Niveles cantidad de etapas, se puede denir como grado alcanzado en el juego.

####Normas del Juego:
* Establecer condiciones de puntaje: Indicar el nivel o tiempo de obtener puntos.
* Grado de Dificultad: Establecer un mínimo de 3 niveles de dificultad. También se puede realizar un test para asignar el nivel para el jugador.
* Base de Datos: Preferiblemente la data debe guardar en el dispositivo a utilizar, por lo tanto se debe emplear el uso de SQLITE, en el caso de no estar conectado a internet, el jugador podrá reenviar luego la
información de su Badge.
* Registro: Para que el Usuario o Jugador puedan ingresar al juego primero deberán registrar sus datos, Nombres, Edad, Correo Electrónico (importante: indicar al Usuario que el correo a utilizar debe ser el utilizado en juegos que estén desarrollados bajo este Estándar de xAPI).

##LRS: Learning Record Store:
LRS: Learning Record Store, Puede registrar casi cualquier actividad que estemos realizando en un dispositivo, ver videos, pequeñas lecturas, clics que hagamos en enlaces o botones, juegos, no depende de una plataforma de E-learning para extraer las experiencias, además los registros no requieren envío inmediato, la información se guarda en el dispositivos donde realizamos la actividad, en caso de no estar conectados a internet, este hará el envío de los datos de experiencia cuando nos conectemos a una Red.

En el Servidor LRS, se puede visualizar las experiencias de los usuarios en tiempo real, nos permite ver el flujo de actividades realizadas, así como realizar comparaciones entre los usuarios de una misma actividad, en el caso de Gamificación se pueden observar tiempo de éxito de cada nivel, el número de intentos fallidos, numero de niveles avanzados, puntos logrados. Los datos recogidos por este Servidor LRS, se pueden enviar a otro Servidor LRS o LMS.

Learning Records Store, se encarga de recoger toda la información emitida desde el juego en formato JSON, la cual contara, con un conjunto de declaraciones (Verbos) para la emisión de datos. Su comunicación y envío de información se establece a través de JSON. Para realizar el registro de Actividades, XAPI permite enviarlas en forma de oraciones o declaraciones (Sujeto, Verbo, Actor), también puede incluir la Fecha.


#SERVIDORES
###SERVIDOR WEB
Para implementación del servidor web, se utilizó la plataforma de software
libre XAMPP, que incluye el sistema de gestión de datos MySQL, y
Servidor HTTP Apache.

En este servidor se encuentra alojado:
* Los archivos y base de datos de la Plataforma de Badges.
* Base de Datos de los Juegos Calc Match y Lyrics Puzzle.

###SERVIDOR NODEJS
Es un Servidor de peticiones desarrollado con la libreria nodejs express, el cual tiene habilitado un puerto 8888, este servidor recibe parametros GET y se encarga de enviarlo al Servidor LRS.

Contenido del Servidor:
* Entorno de ejecución multiplataforma **nodejs**
* Libreria nodejs xapiwrapper.
* Archivo de ejecución app.js.


###SERVIDOR LRS
Para la implementación de este servidor se utilizó el servidor ADL-LRS, el cual se encuentra bajo licencia Software Libre, este servidor ha sido desarrollado por Advanced Distributed Learning, Organización encargada de la estandarización de xAPI, para su ejecución es necesario ejecutarlo bajo Ubuntu 12.10, es posible también con Ubuntu 13.10 pero no garantiza su completa funcionabilidad. Esta desarrollado en Python.

Este servidor fue instalado en una máquina virtual Amazon AWS, y cuenta con un sistema operativo Ubuntu 12.10.

**URL del Servidor: http://52.88.101.103:8000/xAPI/**

En este servidor se encuentra alojado:
* Los archivos y base de datos (PosgreSQL) de la ADL-LRS.

###VENTAJAS
Una de las ventajas que ofrece Modelo de emisión de Badges a traves de xAPI es su implementación a traves de diversas plataformas tecnologias Dispositivos Moviles, Computadoras Personales y plataformas Web. Este modelo es adaptable a los lenguajes de programación mas conocidos y utilizados (Java, Javascript, cSharp) que en el caso de estudio se ha utilizado estos tres lenguajes.

###Lenguajes Utilizados
 Java es uno de los lenguajes mas completos, se pueden implementar dos librerias para establecer la comunicación xAPI, una es por medio libreria propia en Java proporcionada por ADL-LRS llamada JxAPI, vienen los parametros definidos para la envio de data al LRS, otra forma es con la libreria xapiwrapper, la cual es una liberia desarrollada en Javascript que permite la recepción y envio de data con el Servidor LRS, esta liberia es conveniente debido al grado de adaptabilidad que tiene Javascript, sin embargo hay una libreria de Nodejs que permite crear un Servidor de peticiones, en el solo tendremos una url recibiendo tareas y este se encarga del envio de la información que deseamos guardar en el Badge.
