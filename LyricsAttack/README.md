# Lyrics Puzzle
Emision de Badges

##Introducción
Es un juego desarrollado en la plataforma Unity, bajo el lenguaje cSharp, Unity como herramienta de desarrollo cuenta con numero de recursos, ofrece gran soporte referente a código y métodos de programación, he utilizado Unity debido a que es una de las herramientas más utilizadas para la creación de videojuegos, es capaz de soportar diversas plataformas como IOS, Android,Windows Phone, Windows para PC, incluso se puede exportar como página web.



#Sinopsis del Juego
La trama del juego se basa en completar palabras en inglés, cuenta con tres niveles y posee tres vidas para pasar cada nivel, dependiendo de la puntuación la cual se basa en tiempo de respuesta y vida mantenida, arrojara una serie de puntos, la cual está condicionada para él envió de Badges, cada palabra en ingles a su vez tiene como referencia la palabra en español. Para obtener puntaje se debe disparar a las letras que no correspondan y si alguna de estas cae al suelo o te toca perderás una vida, la única letra que se debe dejar tocar es la letra correspondiente.


Repositorio de Estandar de de emision de badges a traves de una sola plataforma mediante la combinancion de estandares, los principales para comunicación xAPI (ADL), Openbadges (Mozilla). A continuacion se mostraran tres carpetas en la que cada una tendra un ejemplo de comunicación y emision de badges a traves del estandar propuesto.


#Comunicación Unity Servidor LRS
Para la comunicación desde c# en Unity, se establece a traves de la clase **WWW** desde donde se invoca la url de un Servicio Web, normalmente estos servicios no tienen una funcion autoejecutable de JS, por lo que se debe establecer un servidor de escucha, razon por la cual se ha utilizado la libreria nodejs express **xapiwrapper de ADL**, esta libreria permite realizar un servidor de escucha y podemos configurar el puerto de comunicación, ademas de esto, fue necesario añadirle otras funcionalidades como recepcion de get, y configuración de puerto. EL get es necesario para recibir los parametros o data de los usuarios los cuales se deben enviar desde el juego, el codigo se puede apreciar en app.js, aunque para la ejecucion completa del servidor es necesario la carpeta servernodejs, es necesario tener instalado el servicio nodejs.

###Instalación y Ejecución del Servidor servernodejs:
* Instalar nodejs en el Servidor del Juego
* Descargar la carpeta del servidor servernodejs
* Abrir la terminal Windows, Mac o Linux (Recomiendo), ubicamos en la carpeta **cd path/servernodejs/**, una vez ubicado en la carpeta ejecutamos el 2do comando ** node app.js ** podrán apreciar en la terminal un mensaje "Servidor en Ejecucion".

