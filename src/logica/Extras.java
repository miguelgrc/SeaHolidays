package logica;

public class Extras {
	
	private String codigo;
	private String nombre;
	private int precio;
	
	public Extras(String codigo, String nombre, int precio){
		setCodigo(codigo);
		setNombre(nombre);
		setPrecio(precio);
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public int getPrecio(){
		return precio;
	}
	
	public void setPrecio(int precio){
		this.precio = precio;
	}
	

}
