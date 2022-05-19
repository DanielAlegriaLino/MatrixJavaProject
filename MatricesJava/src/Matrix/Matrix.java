package Matrix;

public class Matrix {
	protected int filas;
	protected int columnas;
	protected String nombre;
	protected int[] dimensiones;
	protected double[][] content;
	
	public double[][] getContent() {
		return content;
	}
	
	public Matrix(int filas, int columnas, String nombre) 
	{
		this.filas = filas;
		this.columnas = columnas;
		this.nombre = nombre;
		this.content = new double[filas][columnas];
		
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
	
	
	public void Suma(Matrix B) {
		
	}
	
	
}




