Proyecto Final - Study Jam II 2016
===
<div align="center">
    <center>
        <img src="http://developerstudyjams.com/images/masthead.png" width="400px"/>
    </center>
</div>

Repositorio Proyecto Final del Study Jam Android Development for Beginners II 2017, llevado a cabo en la ciudad de La Paz, Bolivia a cargo del <a target="_blank" href="http://www.gdg.androidbolivia.com">GDG Android Bolivia</a> .

Nombre Aplicación.
---
El nombre de la aplicación es: **Flash Cards**

Objetivo
---
Facilitar el aprendizaje del idioma Ingles a estudiantes y publico general de una manera atractiva.

Caracteristicas
---
La aplicacion pretende ayudar a los estudiantes de Ingles y publico general aprender Ingles de una manera atractiva y divertida, mediante FlashCards.
La aplicacion tiene 4 secciones bien separadas:
1. GRAMMAR. Esta seccion es una ayuda con los topicos gramaticales mas usados. Esta dividido en las siguientes partes:
	* Lista de verbos irregulares.
	* Lista de adjetivos con sus respectivos comparativos y superlativos.
	* Estructuras gramaticales en todos los tiempos. Se toma en cuenta los usos, frases de tiempo que podemos utilizar y ejemplos.
2. LISTENING. Esta seccion pretende motivar al estudiante practicar el ESCUCHA  y el HABLA inglesa, mediante canciones sencillas.
3. SPEAKING. Esta ayuda al estudiante a pronunciar frases y palabras del habla inglesa.
4. VOCABULARY. Esta seccion motiva y ayuda a los estudiantes a aprender palabras de una manera animada mediante flashcards. Esta dividido en las siguientes partes:
	* Adjetivos
	* Animales
	* Bebidas
	* Clima
	* Comida
	* Frutas
	* Ropa
	* Sentimientos
	* Vegetales
	* Verbos
* Lista de 19 canciones para elegir.
* Control de produccion.
* Boton para elegir el destino de la cancion.
* El destino de la cancion puede ser, tono de llamada, tono de mensaje, y tono de alarma.

Compatibilidad
---
Esta aplicación es compatible con versiones de Android 5.1. (Lollipop) o superior.

Uso
---------
Para probar este ejemplo clona este repositorio de la siguiente forma:
>
>     $ git clone https://github.com/Cristian740/StudyJam_Tarea_4

Luego de ello dentro de Android Studio:

* File --> New --> Import Project
* Seleccionas la ruta donde hiciste el `clone` del proyecto.
* Build --> Rebuild Project
* Run

Corrida previa
---
Aca te muestro cual es el funcionamiento de mi aplicación a grandes rasgos.
<div align="center">
    <center>
        <table border="0">
            <tr>
                <td>*Menu de Navegacion*<img src="/img/captura1.png" width="300"></td>
				<td>*Lista de Verbos*<img src="/img/captura2.png" width="300"></td>
				<td>*Estructuras gramaticales*<img src="/img/captura3.png" width="300"></td>
            </tr>
            <tr>
                <td>*Detalles Item Present Simple*<img src="/img/captura4.png" width="300"></td>
				<td>*Songs*<img src="/img/captura5.png" width="300"></td>
				<td>*Lyryc Song*<img src="/img/captura6.png" width="300"></td>
            </tr>
            <tr>
                <td>*Reproductor Song*<img src="/img/captura7.png" width="300"></td>
				<td>*Seccion Speaking*<img src="/img/captura8.png" width="300"></td>
				<td>*Flash Card Verbs*<img src="/img/captura9.png" width="300"></td>
            </tr>
			<tr>
                <td>*Flash Card Fruits*<img src="/img/captura10.png" width="300"></td>
				<td>*Consulta para soporte*<img src="/img/captura11.png" width="300"></td>
				<td>*Acerca de*<img src="/img/captura12.png" width="300"></td>
            </tr>
        </table>
    </center>
</div>
<br>

Descripción técnica
---
En este proyecto de utilizáron los siguientes componentes tanto en el `diseño` como en la `funcionalidad`:

**`Vista:`**
* Navegation Drawer, para la visualizacion y organizacion de los fragments.
* Fragments, para visualizacion de los cada uno de las secciones de la aplicacion.
* Recycler View, como contenedor para mostrar grandes conjuntos de datos que se pueden desplazar de manera muy eficiente manteniendo un número limitado de vistas
* ListVIew, para el contener de los itemes.
* ImageView, para las imagenes de las canciones, las figuras de la seccion vocabulario y otras secciones.
* EditTexts, para insertar texto en la seccion de speaking, para que sean traducido.
* ImageButton, para los botones de reproduccion de los sonidos y las canciones.
* Rotare y Alpha, para las animaciones de la SplashScreen.
* TablaLayout, para mostrar las listas de verbos y adjetivos.
* CordinatorLayout, para coordinar el contenido de las vistas(esto es un elemento de Material Design).


**`Funcionalidad:`**
* MediaPlayer, para reproducir y detener las canciones.
* Animation, para insertar las animaciones.
* TexttoSpeech, para reproducir los textos en ingles.
* Intents Implicitos, para mandar mensajes a un canal de Telegram, Facebook y Gmail
* Sharet Preference para guardar la ultima palabra escrita dentro de la seccion Speaking

Autor
---
Cristian Josue Rojas Lopez

Contactos
---
cristianrojas.ing@gmail.com<br>
Telf. +591 73590644<br>
La Paz - Bolivia<br>
[Facebook](https://www.facebook.com/cristianjosue.rojaslopez)
