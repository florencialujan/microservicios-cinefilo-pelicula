<h1>Descripción del proyecto</h1>
<h3>Herramientas utilizadas</h3>
<h4>Se utilizaron las siguientes herramientas</h4>
<ul>
 <li>Java 17 y Springboot</li>
 <li>Maven como gestor de dependencias</li>
 <li>Spring web</li>
 <li>Spring DevTools</li>
 <li>Lombok</li>
 <li>JPA</li>
  <li>H2 database</li>
</ul>
<h2>Microservicio cinefilo</h2>
<p>El microservicio cinefilo se encarga de almacenar la database "Cinefilos" in-memory. En el modelo se almacenan dos clases, Persona y Pelicula, estableciendo una relación OneToMany entre Persona y Pelicula.</p>

<h3>Endpoints</h3>
<ul style="list-style-type:square">

<li>http://localhost:8092/api/personas</li>
<p>Formato del request</p>
<pre><code>{
    "id": 1,
    "firstName": "pablo",
    "lastName": "lamberti",
    "birthDay": "1987-04-03",
    "hasInsurance": false
}</code></pre>
<h4>Response</h4>
<p>De ser creado se devuelve un 201 CREATED.</p>


<li>http://localhost:8092/api/personas/all</li>
<h5>Tipo de request: GET</h5>
<p>Devuelve los registros de todas las personas cargadas ordenadas por id.</p>
<li>http://localhost:8092/api/personas/nombre</li>
<h5>Tipo de request: GET</h5>
<p>Devuelve la lista de personas ordenadas por nombre</p>
<li>http://localhost:8092/api/personas/apellido</li>
<h5>Tipo de request: GET</h5>
<p>Devuelve la lista de personas ordenadas por apellido./p>


<li>http://localhost:8092/api/personas/1</li>
<h5>Tipo de request: PATCH</h5>
<p>Actualiza los datos de una persona con un id determinado, solo pasandóle el atributo que se desea modificar</p>
<p>Formato del request</p>
<pre><code>{
    "firstName": "John",
    "lastName":"Doe"
}</code></pre>
<li>http://localhost:8092/api/personas/1</li>
<h5>Tipo de request: DELETE</h5>
<p>Borra los datos de la persona con el id especificado.</p>

<li>http://localhost:8092/api/personas/1</li>
<h5>Tipo de request: PATCH</h5>
<p>Actualiza los datos de una persona con un id determinado, solo pasandóle el atributo que se desea modificar</p>
<p>Formato del request</p>
<pre><code>{
    "firstName": "John",
    "lastName":"Doe"
}</code></pre>
<li>http://localhost:8092/api/personas/1</li>
<h5>Tipo de request: DELETE</h5>
<p>Borra los datos de la persona con el id especificado.</p>

<li>http://localhost:8092/api/personas/{idPersona}/agregarPelicula/{idPelicula}</li>
<h5>Tipo de request: POST</h5>
<p>Le agrega a los atributos de la persona de id especificado, la pelicula del id requerido.</p>

<li>http://localhost:8092/api/personas/{idPersona}/quitarPelicula/{idPelicula}</li>
<h5>Tipo de request: DELETE</h5>
<p>Le quita a los atributos de la persona de id especificado, la pelicula del id requerido.</p>

<h2>Microservicio Peliculas</h2>
<p>El microservicio Pelicula se encarga de almacenar la database "Peliculas" in-memory. En el modelo se almacena la clase Pelicula </p>

<h3>Endpoints</h3>

<li>http://localhost:8092/api/peliculas</li>
<h5>Tipo de request: POST</h5>
<p>Agrega una pelicula a la base de datos de Pelicula.</p>
<p>Formato del request</p>
<pre><code>{
    "title": "Harry Potter",
    "genre": "fantasy"
}</code></pre>

<li>http://localhost:8092/api/peliculas/1</li>
<h5>Tipo de request: PATCH</h5>
<p>Modifica una pelicula de la base de datos de Pelicula (solo de los campos especificados en el request)</p>
<p>Formato del request</p>
<pre><code>{
    "title": "El señor de los anillos",
}</code></pre>

<li>http://localhost:8092/api/peliculas/all</li>
<h5>Tipo de request: GET</h5>
<p>Muestra una lista de todas las peliculas almacenadas en la base de datos.</p>


<li>http://localhost:8092/api/peliculas/1</li>
<h5>Tipo de request: GET</h5>
<p>Muestra la pelicula del id especificado.</p>


<li>http://localhost:8092/api/peliculas/1</li>
<h5>Tipo de request: DELETE</h5>
<p>Elimina la pelicula del id especificado.</p>


