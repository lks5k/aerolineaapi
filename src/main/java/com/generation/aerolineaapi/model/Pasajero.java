package com.generation.aerolineaapi.model;

// Trae todas las anotaciones JPA de una sola vez
import jakarta.persistence.*;

@Entity // Le dice a Hibernate esta clase es una tabla en la bd
@Table(name = "pasajeros") // @Table define el nombre de la tabla como queremos que aparezca, si no se pone toma el nombre de la tabla en minúsculas por defecto
public class Pasajero {

    @Id // @ID marca este campo como llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esta linea genera el valor del id como incremental
    private Long id;

    @Column(nullable = false) // Genera el NOT NULL de PostgreSQL en la columna de PostgreSQL. La base de datos lo rechaza antes de guardar.
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String email;

    // Constructor vacío obligatorio para JPA, Hibernate lo usa para crear una nueva fila cada vez que se ingresen datos con el Constructor lleno
    public Pasajero() {}

    // Constructor completo, en la primera línea el Usuario ingresa los datos y en el cuerpo del Constructor se define X dato guárdalo en X campo de ÉSTA tabla
    public Pasajero(Long id, String nombre, String apellido, String documento, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    } // Leer el valor privado de Nombre de esta Clase y muéstramelo
    public void setNombre(String nombre) { this.nombre = nombre; } // Escribe este valor en Nombre de esta clase y "Void" no me muestres nada

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}