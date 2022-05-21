package Matrix;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MathMatrix {
	public static boolean compareDim(Matrix Matrix_B,Matrix Matrix_A){
		return  Matrix_A.getDimensiones()[0] == Matrix_B.getDimensiones()[0] &&
				Matrix_A.getDimensiones()[1] == Matrix_B.getDimensiones()[1] ;
	}
	
	public static boolean CompareCompatibility(Matrix matrixA,Matrix matrixB) {
		return	matrixA.getDimensiones()[1] == matrixB.getDimensiones()[0];
	}
	
	public static Matrix MatrixSum(Matrix MatrixA, Matrix MatrixB) 
	{
		if(!compareDim(MatrixA,MatrixB)) {
			throw new Error("Matrixes Don't Have Equal Dimensions");
		}else 
		{
			Matrix matrix_aux = new Matrix(MatrixA.filas, MatrixB.columnas, "aux");
			for(int i=0; i<MatrixA.filas; i++) {
				for(int j=0; j<MatrixA.columnas;j++) {
					matrix_aux.content[i][j]= MatrixA.content[i][j]+MatrixB.content[i][j];
				}
			}
			return matrix_aux;
		}
	}

	public static Matrix MultiplicacionEscalar(Matrix MatrixA,int escalar) {
		Matrix matrix_aux = new Matrix(MatrixA.filas,MatrixA.columnas,"aux");
		for(int i = 0; i<MatrixA.filas; i++) {
			for(int j = 0; j<MatrixA.columnas; j++) {
				matrix_aux.content[i][j] = matrix_aux.content[i][j]*escalar;
			}
		}
		return matrix_aux;
	}
	
	public static Matrix MultiplicacionMatrix(Matrix MatrixA, Matrix MatrixB) {
		Matrix matrix_aux_A = new Matrix(MatrixA.filas, MatrixB.columnas,"aux");
		
		return matrix_aux_A;
	}
	
	public static Matrix MatrixDifferences(Matrix MatrixA, Matrix MatrixB) 
	{
		if(!compareDim(MatrixA,MatrixB)) {
			throw new Error("Matrix Not Equal Dimensions");
		}else 
		{
			Matrix matrix_aux = new Matrix(MatrixA.filas, MatrixB.columnas, "aux");
			for(int i=0; i<MatrixA.filas; i++) {
				for(int j=0; j<MatrixA.columnas;j++) {
					matrix_aux.content[i][j]= MatrixA.content[i][j]-MatrixB.content[i][j];
				}
			}
			return matrix_aux;
		}
	}
	
	public static Matrix MakePowerOf2(Matrix MatrixA) {
		int nueva_dim = 0;
		if(MatrixA.getDimensiones()[0]>MatrixA.getDimensiones()[1]) {
			nueva_dim = MatrixA.getDimensiones()[0];
			int ceil = (int) (Math.ceil((Math.log(nueva_dim/Math.log(2)))));
			int floor = (int) (Math.floor(((Math.log(nueva_dim)/Math.log(2)))));
			while( !(ceil == floor)) {
				nueva_dim++;
			}
		}
		else if(MatrixA.getDimensiones()[1]>MatrixA.getDimensiones()[0]) {
			nueva_dim = MatrixA.getDimensiones()[1];
			int ceil = (int) (Math.ceil((Math.log(nueva_dim/Math.log(2)))));
			int floor = (int) (Math.floor(((Math.log(nueva_dim)/Math.log(2)))));
			while( !(ceil == floor)) {
				nueva_dim++;
			}
		}
		else {
			nueva_dim = MatrixA.getDimensiones()[0];
			int ceil = (int) (Math.ceil((Math.log(nueva_dim/Math.log(2)))));
			int floor = (int) (Math.floor(((Math.log(nueva_dim)/Math.log(2)))));
			while( !(ceil == floor)) {
				nueva_dim++;
			}
		}
		Matrix matrix_aux = new Matrix(nueva_dim, nueva_dim,"aux");
		matrix_aux.FillZero();
		matrix_aux = MathMatrix.MatrixSumException(MatrixA,matrix_aux);
		return matrix_aux;
	}
	
	public static Matrix MatrixSumException(Matrix MatrixA, Matrix MatrixB) 
	{
		Matrix matrix_aux = new Matrix(MatrixB.filas, MatrixB.columnas, "aux");
		for(int i=0; i<MatrixA.filas; i++) {
			for(int j=0; j<MatrixA.columnas;j++) {
				matrix_aux.content[i][j]= MatrixA.content[i][j]+MatrixB.content[i][j];
			}
		}
		return matrix_aux;
		}	
}



