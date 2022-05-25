package App;
import java.util.Arrays;

import Matrix.* ;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix mi_matrix1 = new Matrix("pepe", new double[][] {
			{1, 2, 3, 4},
			{5, 6, 7 ,8 },
			{9,10,11,12}} ) ;
                
                Matrix mi_matrix2 = new Matrix("pepe", new double[][] {
			{1, 2, 3, 4},
			{5, 6, 7 ,8 },
			{9,10,11,12}} ) ;
                
                Matrix gauss_jordan_test = new Matrix ("",new double [][]{
                    {1,3,0},
                    {2,4,0}
                });
                
                gauss_jordan_test = MathMatrix.getMatrizEscalonada( gauss_jordan_test );
               

                System.out.println(Arrays.deepToString(gauss_jordan_test.getContent()));
                



		
		
		
		
		
	
	}

}
