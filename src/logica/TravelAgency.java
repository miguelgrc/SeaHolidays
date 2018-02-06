package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TravelAgency {
	
	private ArrayList<Ship> ships;
	private ArrayList<Cruise> cruises;
	private ArrayList<Extras> extras;
	
	public TravelAgency(){
		ships = new ArrayList<Ship>();
		cruises = new ArrayList<Cruise>();
		extras = new ArrayList<Extras>();
		
		readBarcos();
		readCruceros();
		readExtras();
	}

	public ArrayList<Ship> getShips() {
		return ships;
	}

	public ArrayList<Cruise> getCruises() {
		return cruises;
	}

	public ArrayList<Extras> getExtras() {
		return extras;
	}
	
	private void readBarcos(){
		String line = "";
		try {
			//BufferedReader file = new BufferedReader(new FileReader("src/files/barcos.dat"));	//Necessary to replace this line for the one below in order for it to work after exporting as jar
			BufferedReader file = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/files/barcos.dat")));	//For exporting as jar (there's no "src" in jars)
			while (file.ready()) {
				line = file.readLine();
				String[] fields = line.split(";");
				ships.add(new Ship(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), Integer.parseInt(fields[5]), 
						Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), Integer.parseInt(fields[9]), Integer.parseInt(fields[10])));
			}
			file.close();
		} catch (FileNotFoundException e) {
//			JOptionPane.showMessageDialog(null, "File not found");
		} catch (IOException ex) {
			new RuntimeException("I/0 error");
		}
	}
	
	private void readCruceros() {
		String line = "";
		Ship ship = null;
		try {
			//BufferedReader file = new BufferedReader(new FileReader("src/files/cruceros.dat"));	//Necessary to replace this line for the one below in order for it to work after exporting as jar
			BufferedReader file = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/files/cruceros.dat")));		//For exporting as jar (there's no "src" in jars)
			while (file.ready()) {
				line = file.readLine();
				String[] fields = line.split(";");
				for (Ship s : ships) {
					if (s.getCodigo().equals(fields[9])) {
						ship = s;
					}
				}
				cruises.add(new Cruise(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6],
						Integer.parseInt(fields[7]), fields[8], ship));
			}
			file.close();
		} catch (FileNotFoundException e) {
//			JOptionPane.showMessageDialog(null, "File not found");
		} catch (IOException ex) {
			new RuntimeException("I/0 error");
		}
	}
	
	private void readExtras() {
		String line = "";
		try {
			//BufferedReader file = new BufferedReader(new FileReader("src/files/barcos.dat"));	//Necessary to replace this line for the one below in order for it to work after exporting as jar
			BufferedReader file = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/files/extras.dat")));	//For exporting as jar (there's no "src" in jars)
			while (file.ready()) {
				line = file.readLine();
				String[] fields = line.split(";");
				extras.add(new Extras(fields[0], fields[1], Integer.parseInt(fields[2])));
			}
			file.close();
		} catch (FileNotFoundException e) {
//			JOptionPane.showMessageDialog(null, "File not found");
		} catch (IOException ex) {
			new RuntimeException("I/0 error");
		}
	}
	
	public int printBill(String content, String dni, String date) {
		String fileName = "src/files/" + dni + "_" + date + ".txt";
		System.out.println(fileName);
		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			BufferedWriter writeFile = new BufferedWriter(new FileWriter(file));
			writeFile.write(content);
			writeFile.close();
			return (0);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to save file");
			return (-1);
		} catch (IOException ex) {
			new RuntimeException("I/O error");
			return (-2);
		}
	}

}
