package uniandes.conceptosAvanzados.programm1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Model {

	/**
	 * Lista de N números reales
	 */
	private LinkedList<Double> numbers;

	/**
	 * Media de los N números reales
	 */
	private double mean;

	/**
	 * Desviación Estandar de los N números reales
	 */
	private double stdDev;

	/**
	 * Cantidad de números reales
	 */
	private int n;

	public Model() {
		super();
		numbers = new LinkedList<Double>();
		mean = 0.0;
		stdDev = 0.0;
		n = 0;
	}

	public double getMean() {
		return mean;
	}

	public double getStdDev() {
		return stdDev;
	}

	public void readFile() {

		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader("C:/Users/Juan Paz/Documents/Personales/Pro JAVA/Program_1_PSP_0/data/numbers.txt");
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				double number = Double.parseDouble(sCurrentLine);
				numbers.add(number);
				n++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void calculateMean() {

		Iterator it = numbers.iterator();
		double sumatory = 0;

		while (it.hasNext()) {
			double number = (double) it.next();

			sumatory += number;

		}

		mean = sumatory / n;
	}

	public void calculateStdDev() {
		Iterator it = numbers.iterator();
		double sumatory = 0;

		while (it.hasNext()) {
			double number = (double) it.next();
			double value = number - mean;
			value = Math.pow(value, 2);
			sumatory += value;

		}
		
		stdDev = sumatory / (n - 1);
		
		stdDev = Math.sqrt(stdDev);
		
	}
}
