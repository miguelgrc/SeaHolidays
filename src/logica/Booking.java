package logica;

import java.util.ArrayList;

public class Booking {
	
	private Cruise cruise;
	private ArrayList<Extras> extras;
	private String date;
	private int people;
	private int[] ages;
	private float price;
	private float discountedPrice;
	private String cabinType;
	
	public Booking(Cruise cruise, ArrayList<Extras> extras, String date, int people, int ages[], float price, float discountedPrice, String cabinType){
		setCruise(cruise);
		setExtras(extras);
		setDate(date);
		setPeople(people);
		setAges(ages);
		setPrice(price);
		setDiscountedPrice(discountedPrice);
		setCabinType(cabinType);
	}

	private void setCruise(Cruise cruise) {
		this.cruise = cruise;		
	}
	
	public Cruise getCruise(){
		return cruise;
	}
	
	private void setExtras(ArrayList<Extras> extras) {
		this.extras = extras;		
	}
	
	public ArrayList<Extras> getExtras(){
		return extras;
	}
	
	private void setDate(String Date) {
		this.date = Date;		
	}
	
	public String getDate(){
		return date;
	}
	
	private void setPeople(int people) {
		this.people = people;		
	}
	
	public int getPeople(){
		return people;
	}
	
	private void setAges(int[] ages) {
		this.ages = ages;		
	}
	
	public int[] getAges(){
		return ages;
	}
	
	private void setPrice(float price) {
		this.price = price;		
	}
	
	public float getPrice(){
		return price;
	}
	
	private void setDiscountedPrice(float discountedPrice) {
		this.discountedPrice = discountedPrice;		
	}
	
	public float getDiscountedPrice(){
		return discountedPrice;
	}
	
	private void setCabinType(String cabinType){
		this.cabinType = cabinType;
	}
	
	public String getCabinType(){
		return cabinType;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getCruise().getDenominacion().toUpperCase());
		sb.append(" · " + getCabinType());
		sb.append(" · " + getDate());
		sb.append(" · " + getPeople() + "p");
		for(Extras e: extras){
			sb.append(" · " + e.getNombre());
		}
		if(getCruise().getDiscounted()){
			sb.append(" · [" + (getPrice() - getDiscountedPrice()) + " \u20ac (-15%)]");
		}
		else
		{
			sb.append(" · [" + getPrice() + " \u20ac]");
		}
		return sb.toString();
	}
	
}
