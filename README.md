# Programa de Petagram para el curso de *"Desarrollo de aplicaciones con Android"*


Esta app para android se encuentra desarrollada usando como base la api 21 de android, es decir Android Lollipop. Se realizado tambien pensando en la retrocompatibilidad con versiones anteriores del *Lollipop* sin embargo no se asegura su correcto funcionamiento.

Este programa ha sido desarrollado por Rots87 siguiendo las clases vertidas en Coursera y respetando el Codigo de Honor proclamado por la misma. Este programa se encuentra protegido bajo la licencia MIT la cual puedes consultar en el siguiente [enlace](https://opensource.org/licenses/MIT "Licencia MIT").

##Tareas en Semana 5
- [x] Diseño de BD para la aplicacion
- [x] Cambio de la estructura a MVP
- [x] Crear la base de datos
- [x] Implementar la base de datos
- [x] Pruebas del Like
- [x] Mostrar Cambios en el raiting

#*Para dar Like por favor dar clic en el hueso amarillo*

##Puntos a Evaluar
###Semana 3 (Completado)
* Que corra el proyecto
* DataSet
* Adapter
* ViewHolder
* Clase para dar forma a los items del RecyclerView
* Resultado final del RecyclerView
* Action View de estella
* Acciones del Action View
* RecyclerView con 5 Items
* Botón para subir

###Semana 4 (Completado)
* Que tu aplicación muestre los dos menús solicitados
* Que ambos menús funcionen correctamente
* Libreria JavaMail
* Que corra la aplicación
* View Pager
* Modularizacion en Fragments
* Librería implementada

###Semana 5 (En Desarrollo)
Tomando como punto de partida la funcionalidad que generaste para mostrar las ultimas 5 mascotas, es momento de dar persistencia a esta información.

Estas 5 mascotas estarán cambiando conforme el usuario da rating a una o varias, mascotas. En el POJO que estas manejando para la entidad mascota genera un identificador el cuál deberá ser único y te permita diferenciar una mascota de otra.

Crea un modelo de base de datos que contenga una tabla llamada mascota esta debe ser idéntica al POJO de mascota, de tal forma que cuando una persona de rating a una foto puedas guardar los datos completos de la entidad en la base de datos. Para fines de este ejercicio tu tabla solo estará guardando las últimas 5 mascotas con rating.

##Capturas de pantalla

![Base de Datos](/Images/db.png "Base de datos a implementar")

![Pagina Principal](/Images/index.png "Pagina principal del proyecto")
![fragments](/Images/fragments.png "Fragments y TabLayout")
![Preferencia](/Images/raiting.png "Raiting de las mascotas por su numero de like")
![Bio](/Images/Bio.png "Bio del programador")
![Contactame](/Images/contactame.png "Formulario de contacto")
