package Matrix;
import java.util.Scanner;
import java.util.Arrays;
public class Matrix {
	protected int filas;
	protected int columnas;
	protected String nombre;
	protected int[] dimensiones;
	protected double[][] content;
	Scanner in = new Scanner(System.in);
	
	public double[][] getContent() {
		return content;
	}
	
	public Matrix(int filas, int columnas, String nombre) 
	{
		this.filas = filas;
		this.columnas = columnas;
		this.nombre = nombre;
		this.content = new double[filas][columnas];
		this.FillZero();
	}
	
	public Matrix(String nombre, double[][] content) 
	{
		this.filas = content.length;
		this.columnas = content[0].length;
		this.nombre = nombre;
		this.content= content;
		
	}
	
	public int[] getDimensiones()
	{
		return new int [] {this.filas,this.columnas};
	}
	
	public boolean IsSquared()
	{
		if(this.filas == this.columnas) {
			return true;
		}
		return false;
	}
	

	public void FillZero() {
		for(int i = 0; i<this.getDimensiones()[0];i++) {
			for(int j = 0; j<this.getDimensiones()[1]; j++) {
				this.content[i][j] = 0;
			}
		}
	}
	
	public void ShowMatrix() {
		for(double[] row:this.content) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	public void FillMatrix() {
		for(int i = 0; i<this.filas;i++) {
			for(int j = 0; j<this.columnas; j++) {
				System.out.println("Ingrese el valor que se ubica en " + (i+1) + ","+ (j+1) + "\n" );
				this.getContent()[i][j] = Valid(in.nextLine());
				System.out.println("La matriz se ve así:");
				this.ShowMatrix();
			}
		}
	}
	
	private double Valid(String value) {
		Boolean repetir = false;
		double parsedValue = 0;
		while(!repetir) {
			try {
				parsedValue = Double.parseDouble(value);
				repetir = true;
			} catch (Exception e) {
				System.out.println("El dato ingresado no es un valor adecuado, ingrese otro");
				value = in.nextLine();
			}
		}
		return parsedValue;
		
	}
	
}




