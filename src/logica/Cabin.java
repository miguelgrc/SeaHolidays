package logica;

public class Cabin {
	
	private String nombre;
	private int precio;
	private int capacidad;
	
	public Cabin(String nombre, int precio, int capacidad){
		setNombre(nombre);
		setPrecio(precio);
		setCapacidad(capacidad);
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	@Override
	public String toString() {
		return nombre + " [" + precio + " \u20ac]";
	}

}
