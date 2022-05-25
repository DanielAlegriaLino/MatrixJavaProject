package App;
import java.util.ArrayList;

import Matrix.* ;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Matrix> matrixsDisponibles = new ArrayList<Matrix>();
		
		Matrix mi_matrix1 = new Matrix("A",new double[][] {
			{0,8},
	    	{6,3}
		});
		matrixsDisponibles.add(mi_matrix1);
		Matrix mi_matrix2 = new Matrix("B",new double[][] {
	    	{5,2,-3},
	    	{0,8,-1},
	    	{-4,5,2}
	    });
		matrixsDisponibles.add(mi_matrix2);
		Matrix mi_matrix3 = new Matrix("C", new double [][] {
			{1,5,4,6},
			{6,7,3,5},
			{8,9,2,8},
			{3,9,1,5}
		});
		matrixsDisponibles.add(mi_matrix3);
		Matrix mi_matrix4 = new Matrix("D", new double[][] {
			{-6,4,-2,-1,7},
	    	{2,-1,3,-4,6},
	    	{-5,4,3,2,1},
	    	{6,-3,0,-4,5},
	    	{3,-2,1,3,-2}
		});
		matrixsDisponibles.add(mi_matrix4);
        
                



		
		
		
		
		
	
	}

}
