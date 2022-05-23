package Matrix;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Arrays;

public class MathMatrix {
    
	private static boolean compareDim(Matrix Matrix_B,Matrix Matrix_A){
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
	
	private static Matrix MakePowerOf2(Matrix MatrixA) {
		int ceil = (int) (Math.ceil((Math.log(MatrixA.getDimensiones()[0]/Math.log(2)))));
		int floor = (int) (Math.floor(((Math.log(MatrixA.getDimensiones()[0])/Math.log(2)))));
		if(!(MatrixA.getDimensiones()[0]==MatrixA.getDimensiones()[1])&& (ceil==floor)) {
			int nueva_dim = 0;
			if(MatrixA.getDimensiones()[0]>MatrixA.getDimensiones()[1]) {
				nueva_dim = MatrixA.getDimensiones()[0];
				ceil = (int) (Math.ceil((Math.log(nueva_dim/Math.log(2)))));
				floor = (int) (Math.floor(((Math.log(nueva_dim)/Math.log(2)))));
				while( !(ceil == floor)) {
					nueva_dim++;
				}
			}
			else if(MatrixA.getDimensiones()[1]>MatrixA.getDimensiones()[0]) {
				nueva_dim = MatrixA.getDimensiones()[1];
				ceil = (int) (Math.ceil((Math.log(nueva_dim/Math.log(2)))));
				floor = (int) (Math.floor(((Math.log(nueva_dim)/Math.log(2)))));
				while( !(ceil == floor)) {
					nueva_dim++;
				}
			}
			else {
				nueva_dim = MatrixA.getDimensiones()[0];
				ceil = (int) (Math.ceil((Math.log(nueva_dim/Math.log(2)))));
				floor = (int) (Math.floor(((Math.log(nueva_dim)/Math.log(2)))));
				while( !(ceil == floor)) {
					nueva_dim++;
				}
			}
			Matrix matrix_aux = new Matrix(nueva_dim, nueva_dim,"aux");
			matrix_aux.FillZero();
			matrix_aux = MathMatrix.MatrixSumException(MatrixA,matrix_aux);
			return matrix_aux;
		}
		else {
			return MatrixA;
		}
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
	
	
	
	public static Matrix Multiplicar(Matrix matrixA,Matrix matrixB) 
	{
        Matrix matrixC = new Matrix ("Juancho", new double[matrixA.getContent().length][matrixA.getContent().length]) ;
        for (int i = 0; i < matrixA.getContent().length; i++){
            for (int j = 0; j < matrixA.getContent().length; j++){
            matrixC.getContent()[i][j] = 0;
            for (int k = 0; k < matrixA.getContent().length; k++)
            {
                matrixC.getContent()[i][j] += matrixA.getContent()[i][k]*matrixB.getContent()[k][j];

            }            
         }
    }
                    return matrixC;
        }
		             
	public static Matrix getCuadrante(Matrix matrixA , int posX1 , int posY1, int posX2, int posY2) 
	{
		Matrix matrix_sliced;
                matrix_sliced= new Matrix("aux", new double [posY2-posY1][posX2-posX1]);
                
		for(int i = posY1; i< posY2; i++) 
                {
                    for (int j = posX1 ; j < posX2; j++)
                    {
                        matrix_sliced.content[i-posY1][j-posX1]= matrixA.content[i][j];
                    }
                }

		return  matrix_sliced;
	}
	
	public static double getDeterminante(Matrix matrixA) {
		double determinante = 0;
		if(!matrixA.IsSquared()) {
			throw new Error("Matrix Doesn't Have a Determinant");
		}
		else if(matrixA.getDimensiones()[0]>3) {
			throw new Error("Matrix Dimensions Bigger Than Limit");
		}
		else {
			if(matrixA.getDimensiones()[0]==3) {
				Matrix matrixDet = DeterminantMatrix(matrixA);
				determinante = determinante3x3(matrixA, matrixDet);
			}
			else if(matrixA.getDimensiones()[0]==2) {
				determinante = matrixA.getContent()[0][0]*matrixA.getContent()[1][1]-matrixA.getContent()[1][0]*matrixA.getContent()[0][1];
				
			}
		}
		return determinante;
	}
	
	public static double determinante3x3(Matrix matrixA,Matrix Det3x3) {
		double multipDiagonal1 = 0;
		for(int i = 0; i < 3; i++) {
			multipDiagonal1 += (Det3x3.getContent()[i][0]*Det3x3.getContent()[i+1][1]*Det3x3.getContent()[i+2][2]);
		}
		double multipDiagonal2 = 0;
		for(int i = Det3x3.getDimensiones()[0]-1;i>=2;i--) {
			multipDiagonal2 += (Det3x3.getContent()[i][0]*Det3x3.getContent()[i-1][1]*Det3x3.getContent()[i-2][2]);
		}
		double determinante = multipDiagonal1-multipDiagonal2;
		return determinante;
	}
	
	public static Matrix DeterminantMatrix(Matrix matrixA) {
		Matrix Det3x3 = new Matrix(5,3, "Roberto");
		Det3x3 = MathMatrix.MatrixSumException(matrixA, Det3x3);
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < Det3x3.getDimensiones()[1]; j++) {
				Det3x3.content[i+3][j] = matrixA.content[i][j]; 
			}
		}
		return Det3x3;
	}
	
	public static double Determinante(Matrix matrixA) {
		if(matrixA.IsSquared()) {
			double determinante = 0;
			return determinante;
		}
		else {
			throw new Error("Matrix Isn't Squared");
		}
	}
	
	public static Matrix MatrizIdentidad(Matrix matrixA) {
		for(int i = 0; i<matrixA.filas; i++) {
			for(int j = 0; j<matrixA.columnas; j++) {
				if(i==j) {
					matrixA.getContent()[i][j] = 1;
				}
				else {
					matrixA.getContent()[i][j] = 0;
				}
			}
		}
		return matrixA;
	}
	
	public static Matrix getMatrizInversa(Matrix matriz) 
	{
		int numero_incognitas= matriz.columnas-1;
		Matrix matrixID = MatrizIdentidad(matriz);
		for(int x = 0 ; x < numero_incognitas; x++  ) 
		{
			// Cada columna
			if(matriz.content[x][x]== 0) 
			{
				int seq_search = 1;
				while( matriz.content[x+seq_search][x] == 0 && seq_search+x < numero_incognitas) 
				{
					seq_search++;
				}
				
				for(int k = 0; k <= numero_incognitas; k++) 
				{
					double temp = matriz.content[x][k] ;
					matriz.content[x][k] = matriz.content[x+seq_search][k];
					matriz.content[x+seq_search][k] = temp ;
					temp = matrixID.content[x][k];
					matrixID.content[x][k] = matrixID.content[x+seq_search][k];
					matrixID.content[x+seq_search][k] = temp;
				}
			}			
			for(int y = 0; y < numero_incognitas; y++) 
			{
				//Ignorar las diagonales pues es lo primero que checamos 
				if(x==y) {continue;}
				
				double pivote = 0;
				pivote =  matriz.content[y][x]/matriz.content[x][x];
				
				for(int k = 0; k <= numero_incognitas; k++) 
				{
					matriz.content[y][k]= matriz.content[y][k] - matriz.content[x][k]*pivote;
					matrixID.content[y][k] = matrixID.content[y][k] - matrixID.content[x][k]*pivote;
				}	
			}
		}
		return matrixID;
	}
	private static Matrix getSimplifiedResults(Matrix matrixA) {
		int numero_incognitas= matrixA.content[0].length-1;
		for( int i= 0; i<numero_incognitas; i++ ) 
		{
			matrixA.content[i][numero_incognitas]= matrixA.content[i][numero_incognitas]/matrixA.content[i][i];
			matrixA.content[i][i]= 1;
		}
		return matrixA;
	}
     
	public static Matrix Inversa(Matrix matrixA) {
		matrixA = getMatrizInversa(matrixA);
		matrixA = getSimplifiedResults(matrixA);
		return matrixA;
	}
	
}



