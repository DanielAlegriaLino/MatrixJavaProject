package App;
import java.util.Arrays;

import Matrix.* ;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix mi_matrix1 = new Matrix("pepe", new double[][] {{1,2,3},{4,5,6},{7,8,9}} ) ;
		Matrix mi_matrix2 = new Matrix("juan", new double[][] {{1,0,1},{1,1,1},{0,0,0}} ) ;
		
		
		
		
		
		System.out.println(
				Arrays.deepToString(( MathMatrix.MatrixSum(mi_matrix1, mi_matrix2)).getContent()
				));
	
	}

}
