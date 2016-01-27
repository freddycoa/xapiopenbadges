#Servidor ADL-LRS

Para la implementacion de xAPI se ha utilizado el servidor ADL-LRS, servidor creado por ADL con el estandar de transmisión de información xAPI.

https://github.com/adlnet/ADL_LRS

##Caracteristicas principales para su implementación

1. Contar con una maquina con Ubuntu 12.04 o 12.10.
2. Tener configurada la red y habilitado el puerto 8000.
3. Si se desea instalar en una Maquina Virtual recomiendo VMWARE Workstation, permite configurar la red interna.
4. Si se desea subir a la nube pueden utilizar AWS Amazon.

##Servidor utilizado como prueba

El servidor utilizado para este proyecto se instalo en una instancia AWS EC2 con un Sistema Operativo Ubuntu 12.10, esta protegido por una key.pem, tiene instalado python 2.7, Base de Datos PostgreSQL, Apache.

En el grupo de red AWS se tiene habilitado el puerto 80 y 8000, el primero para la comunicación con Apache y el segundo para la comunicación con LRS.

##Ejecución del Servidor LRS
Este servidor se puede habilitar tanto en Mac, Windows o Linux. 
* Mac o Linux : Se debe abrir la terminal y ejecutar el comando "sudo chmod 400 key.pem" y luego el otro comando "ssh -i key-pem ubuntu@dominio.com"
* Windows: Debemos instalar Putty y Puttygen, abrimos el puttygen y modificamos la key.pem a key.ppk, luego abrimos el putty colocamos en direccion ubuntu@dominio.com, vamos a la pestaña auth seleccionamos la llave .ppk se abrira un terminal preguntando si desea conectar, presionamos "yes" y tendremos acceso a nuestro servidor.

