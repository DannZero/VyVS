package mx.unam.model;

import java.util.ArrayList;

public class Pedido {

	public static double precioTotal = 0;
	public static ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	public static ArrayList<Integer> unidades = new ArrayList<Integer>();

	public static void actualizarPrecioTotal() {
		double suma = 0;
		for (int i = 0; i < listaProductos.size(); i++) {
			suma += listaProductos.get(i).precio * unidades.get(i);
		}
		precioTotal = suma;
	}

	public static void addProducto(Producto prod) {
		if (listaProductos.contains(prod)) {
			int i = listaProductos.indexOf(prod);
			unidades.set(i, unidades.get(i) + 1);
		} else {
			listaProductos.add(prod);
			unidades.add(1);
		}
		actualizarPrecioTotal();
	}

	public static void removeProducto(Producto prod) {
		int i = listaProductos.indexOf(prod);
		listaProductos.remove(i);
		unidades.remove(i);
		actualizarPrecioTotal();
	}

	public static void actualizarUnidades(Producto prod, Integer cantidad) {
		int i = listaProductos.indexOf(prod);
		unidades.set(i, cantidad);
		actualizarPrecioTotal();
	}

	public static void removeAll() {
		precioTotal = 0;
		listaProductos = new ArrayList<Producto>();
		unidades = new ArrayList<Integer>();
	}
}
