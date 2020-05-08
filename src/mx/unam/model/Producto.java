package mx.unam.model;

import javax.swing.Icon;

public class Producto {
	public String nombre;
	public String tamaño;
	public double precio;
	public Icon icono;

	public Producto(String nombre, String tamaño, double precio, Icon icono) {
		this.nombre = nombre;
		this.tamaño = tamaño;
		this.precio = precio;
		this.icono = icono;
	}

}
