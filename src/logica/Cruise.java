package logica;

public class Cruise {
	
	private String codigo;
	private String zona;
	private String denominacion;
	private String puertoSalida;
	private String itinerario;
	private String descripcion;
	private String aptoMenores;
	private int duracion;
	private String[] fechaSalida;
	private Ship ship;
	private boolean isDiscounted;

	
	public Cruise(String codigo, String zona, String denominacion, String puertoSalida, String itinerario, String descripcion, 
			String aptoMenores, int duracion, String fechas, Ship ship){
		setCodigo(codigo);
		setZona(zona);
		setDenominacion(denominacion);
		setPuertoSalida(puertoSalida);
		setItinerario(itinerario);
		setDescripcion(descripcion);
		setAptoMenores(aptoMenores);
		setDuracion(duracion);
		fechaSalida = fechas.split("%");
		setShip(ship);
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getZona() {
		return zona;
	}
	
	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public String getDenominacion() {
		return denominacion;
	}
	
	public void setDenominacion(String denominación) {
		this.denominacion = denominación;
	}
	
	public String getPuertoSalida() {
		return puertoSalida;
	}
	
	public void setPuertoSalida(String puertoSalida) {
		this.puertoSalida = puertoSalida;
	}
	
	public String getItinerario() {
		return itinerario;
	}
	
	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getAptoMenores() {
		return aptoMenores;
	}
	
	public void setAptoMenores(String aptoMenores) {
		this.aptoMenores = aptoMenores;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public String[] getFechaSalida() {
		return fechaSalida;
	}
	
	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public boolean getDiscounted(){
		return isDiscounted;
	}
	
	public void setDiscounted(boolean isDiscounted){
		this.isDiscounted = isDiscounted;
	}
	
}
