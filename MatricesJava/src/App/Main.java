package App;
import java.util.Arrays;

import Matrix.* ;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix mi_matrix1 = new Matrix("pepe", new double[][] {{1,0},{1,1},{1,1}} ) ;
		Matrix mi_matrix2 = new Matrix("juan", new double[][] {{1,0,1},{1,1,1},{0,0,0}} ) ;
		mi_matrix1.ShowMatrix();
		System.out.println();
		mi_matrix2.ShowMatrix();
		Matrix mi_matrix3 = MathMatrix.MakePowerOf2(mi_matrix2);
		System.out.println();
		mi_matrix3.ShowMatrix();
		
		
		
	
	}

}
