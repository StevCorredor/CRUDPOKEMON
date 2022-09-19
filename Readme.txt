Leeme

Video 2.00

Controlador - Llama al -  Servicio  - llama al - Repositorio

1. Importar las dependencias indicadas en la toma de pantalla adjunta en la carpeta.

1.1 Con la dependencia H2 podemos usar una base de datos virtual para hacer las pruebas sin necesidad de realizar instalaciones. IMPORTANTE. Incluir en application.properties el siguiente código:

spring.datasource.url=jdbc:h2:mem:pokemondb
spring.datasource.diverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true

2. Incluir la dependencia lombok desde Maven Repository. Con ella podemos crear nuestras clases y con solo las anotaciones "@" le indicamos al sistema lo que lleva nuestro código, ej. constructor, un constructor vacío, getter y setter.

2.1 @Data reemplaza los Getter y Setter

3. Es importante incluir el ID de la entidad, para ello lo incluimos con la anotación @ID

4. Creamos el repositorio como una interfaz, en ésta interfaz se define la conexión con la Base de Datos.
	Se debe realizar de la siguiente manera 
	
	public interface PokemonRepository extends JpaRepository <Pokemon, Long> {
	}
	
	extends JpaRepository = Hereda los métodos desde la dependencia JPA, guardar, actualziar, crear...
	<Pokemon, Long> Indicamos la clase a la que va a pertenecer y el tipo de dato que tiene el ID que tiene ésta clase.
	
	NOTA: con la notación anterior no se va a tener que incluir nada más con respecto a la clase-entidad que va a tener relación en la Base de Datos.

5. Para conectar un repositorio con un servicio se debe manejar el concepto de inyección de dependencias, para ello se debe incluir el siguiente código de ejemplo: 
	
	@Autowired
	PokemonRepository pokemonRepository;
	
	Hacemos el llamado al nombre del repositorio y definimos a continuación el nombre de un objeto con el mismo nombre.
	@Autowired = lo usamos para indicarle a SprintBoot que estamos haciendo una inyección de dependencias.

6. En el servicio incluimos los métodos y dentro de los argumentos del método indicamos la entidad con su respectiva importación. Ej: 

	public void crearPokemon(Pokemon Pokemon){
     	pokemonRepository.save(Pokemon);
	}

6.1 Para visualizar un grupo de elementos registrados en una base de datos debemos implementar un método con la sigueinte sintaxis: 

	public List<Pokemon> verPokemon(){
       	List<Pokemon> pokemons = new ArrayList<Pokemon>();
        	pokemons.addAll(pokemonRepository.findAll());
        	return pokemons;
    	}

	public List<Pokemon> verPokemon() = Creamos un método tipo lista
       	List<Pokemon> pokemons = new ArrayList<Pokemon>(); = Instanciamos un nuevo objeto de tipo lista
        	pokemons.addAll(pokemonRepository.findAll()); = nos conectamos a la base de datos
        	return pokemons; = retornamos el elemento objeto de la consulta.


7. Para el controlador, debemos crear de igual manera los métodos. ej.

	@PostMapping("/Pokemon")
    	public void crearPokemon(@RequestBody Pokemon Pokemon){
        	pokemonService.crearPokemon(Pokemon);
	}

	@PostMapping("/Pokemon") = lo usamos para indicar la ruta en la URL a la que se puede invocar ésta petición
	(@RequestBody Pokemon Pokemon) = lo usamos para indicarle al sistema que envié en el cuerpo de la petición un objeto u información
        	pokemonService.crearPokemon(Pokemon); = lo usamos para indicarle a la Base de Datos que le vamos a enviar un objeto u información.

7.1 Para eliminar un elemento de nuestro repositorio tomando con referencia el identificador único o ID, creamos un método con la siguiente estructura:

	@DeleteMapping("/Pokemon/{id}")
	private void eliminarPokemon(@PathVariable("id")long id){
	pokemonService.eliminarPokemon(id);
    	}

	@DeleteMapping("/Pokemon/{id}") = lo usamos para indicarle a SprintBoot que en esa ruta vamos a realizar la eliminación por id
	private void eliminarPokemon(@PathVariable("id")long id){  = definimos el método e indicamos la anotación "@PathVariable("id")long id" para realizar la captura por id
	pokemonService.eliminarPokemon(id); = invocamos el método creado desde el servicio
    	}

8. Para definir los enum ó los tipos de elementos que pueden clasificarse los elementos dentro de la base de datos, lo hacemos definiendo un nuevo paquete y dentro de él una clase de tipo "ENUM" con el sigueinte detalle:

	@Table(name = "tipo")
	public enum Enum_Tipo {
	FUEGO,
	AGUA,
	PLANTA,
	ELECTRICO
	}

	@Table(name = "tipo") = usamos esta anotación para indicarle a SprintBoot que definimos éste como una tabla con el nombre "tipo"
	public enum Enum_Tipo {  = definimos un método de tipo enum y dentro de él y separado por coma (,) enlistamos los diferentes tipos en los que se puede clasificar los objetos.
	FUEGO,
	AGUA,
	PLANTA,
	ELECTRICO
	}

	NOTA. En las propiedades del objeto debemos definir uno para los enum de la siguiente manera: 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private Enum_Tipo tipo;

	@Enumerated(EnumType.STRING) = usamos esta anotación para indicarle a SprintBoot que definimos una propiedad de tipo enum
	@Column(name = "tipo") = usamos esta anotación para indicarle a SprintBoot que definimos éste como una tabla con el nombre "tipo"
	private Enum_Tipo tipo; = concluimos de definir el método.


RELACIONES 

1. En las relaciones de tipo  uno a uno podemos definir en la entidad una propiedad del tipo con la que se va a relacionar de la sigueinte manera:

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "entrenador_id")
	private Entrenador entrenador;

	Y

	@OneToOne (mappedBy = "entrenador")
	private Pokemon pokemon;
	
	@OneToOne(cascade = CascadeType.ALL) = usamos esta anotación para indicarle a SprintBoot que elimine una relación de estremo a extremo al ser eliminada una de las dos
	@JoinColumn(name = "entrenador_id") = usamos esta anotación para indicarle a SprintBoot cuál va a ser la llave por la cual se van a realcionar dos entidades
	private Entrenador entrenador; = definimos la entidad con la propiedad del tipo con el que se va a relacionar. 