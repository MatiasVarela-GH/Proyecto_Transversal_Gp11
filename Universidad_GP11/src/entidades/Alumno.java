/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;
public class Alumno {
    private int id = -1;
    private int dni;
    private String nombre;
    private LocalDate fechaNac;
    private boolean activo;

    public Alumno(int id,int dni, String nombre, LocalDate fechaNac, boolean activo) {
        this.id= id;
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }
     public Alumno(int dni, String nombre, LocalDate fechaNac, boolean activo) {
        this.id = -1;
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = activo;
    }
     public Alumno (){
         this.id = -1;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
     public String toString(){
         return id+""+nombre;
     }
}
