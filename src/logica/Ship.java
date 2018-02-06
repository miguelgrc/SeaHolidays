package logica;

public class Ship {
	
	private String codigo;
	private String nombre;
	private String descripcion;
	private int cabinsDI;
	private int cabinsDE;
	private int cabinsFI;
	private int cabinsFE;
	private int precioDI;
	private int precioDE;
	private int precioFI;
	private int precioFE;
	
	
	public Ship(String codigo, String nombre, String descripcion, int cabinsDI, int cabinsDE, int cabinsFI, int cabinsFE, int precioDI, int precioDE, int precioFI, int precioFE){
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setCabinsDI(cabinsDI);
		setCabinsDE(cabinsDE);
		setCabinsFI(cabinsFI);
		setCabinsFE(cabinsFE);
		setPrecioDI(precioDI);
		setPrecioDE(precioDE);
		setPrecioFI(precioFI);
		setPrecioFE(precioFE);
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
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public int getCabinsDI(){
		return cabinsDI;
	}
	
	public void setCabinsDI(int cabinsDI){
		this.cabinsDI = cabinsDI;
	}
	
	public int getCabinsDE(){
		return cabinsDE;
	}
	
	public void setCabinsDE(int cabinsDE){
		this.cabinsDE = cabinsDE;
	}
	
	public int getCabinsFI(){
		return cabinsFI;
	}
	
	public void setCabinsFI(int cabinsFI){
		this.cabinsFI = cabinsFI;
	}
	
	public int getCabinsFE(){
		return cabinsFE;
	}
	
	public void setCabinsFE(int cabinsFE){
		this.cabinsFE = cabinsFE;
	}
	
	public int getPrecioDI(){
		return precioDI;
	}
	
	public void setPrecioDI(int precioDI){
		this.precioDI = precioDI;
	}
	
	public int getPrecioDE(){
		return precioDE;
	}
	
	public void setPrecioDE(int precioDE){
		this.precioDE = precioDE;
	}
	
	public int getPrecioFI(){
		return precioFI;
	}
	
	public void setPrecioFI(int precioFI){
		this.precioFI = precioFI;
	}
	
	public int getPrecioFE(){
		return precioFE;
	}
	
	public void setPrecioFE(int precioFE){
		this.precioFE = precioFE;
	}
		
}
