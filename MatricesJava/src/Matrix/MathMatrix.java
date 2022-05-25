package Matrix;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MathMatrix {
	
	public static void UserInterface(ArrayList<Matrix> list){
		Boolean reiniciar = true,reiniciar2 = true;
		int value = 0;
		Matrix matrixA,matrixB;
		while(reiniciar) {
			System.out.println("Calculadora de matrices" + "\n" + "Ingrese lo que desea hacer"+"\n");
			System.out.print("\t"+"1.- Seleccionar una matriz"+"\n\t"+"2.- Crear una nueva matriz"+"\n\t"+
			"3.- Suma de matrices" + "\n\t" + "4.-Resta de matrices" + "\n\t" + "5.- Multiplicacion de matrices" + "\n\t" +
			"6.- Determinante de matriz" + "\n\t" + "7.- Inversa de matriz" + "\n\t" + "8.- Multiplicacion por escalar");
			Scanner in = new Scanner(System.in);
			int opcion = Validator(in.nextLine());
			while(reiniciar2) {
				if(opcion<=0 || opcion>8) {
					System.out.println("El numero ingresado esta fuera del rango, ingrese otro");
					opcion = Validator(in.nextLine());
				}
				else {
					reiniciar2=false;  //Point of interest;
				}
			}
			reiniciar2 = true;
			switch(opcion) {
				case 1:
					for(int i=0; i<list.size();i++) {
						System.out.println(i+1 + ":");
						for(double[] row:list.get(i).content) {
							System.out.println(Arrays.toString(row));
						}
					System.out.println();
					System.out.println("Ingrese el numero de la matriz que desea usar:");
					opcion = Validator(in.nextLine());
					
				}
					break;
				case 2:
					System.out.println("Ingrese la cantidad de filas de la matriz");
					int n = in.nextInt();
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
			}
			System.out.println("¿Desea realizar otra acción?" + "\n\t" + "1.-Si" + "\n\t" + "2.-No");
			String num = in.nextLine();
			while(reiniciar2) {
				try {
					value = Integer.parseInt(num);
					if (value>0 && value<3) {    //Cambiar por switch?
						if(value==1)
							reiniciar2 = false;
						if(value==2) {
							reiniciar=false;
							reiniciar2 = false;
						}	
					}
					else {
						System.out.println("Ha ingresado un numero no valido, ingrese 1 o 2");
						num = in.nextLine();
					}
				} catch (Exception e) {
					System.out.println("Ha ingresado un dato no valido, ingrese 1 o 2");
					num = in.nextLine();
				}
				
			}
			
			
			
		}
	}
	private static int Validator(String value) {
		Boolean reiniciar = true;
		int parsedValue = 0;
		Scanner in = new Scanner(System.in);
		while(reiniciar) {
			try {
				parsedValue = Integer.parseInt(value);
				reiniciar = false;
			}catch (Exception e) {
				System.out.println("El valor ingresado no es valido, ingrese otro");
				in = new Scanner(System.in);
				value = in.nextLine();
			}
		}
		return parsedValue;
	}
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
	
	
	
	public static Matrix MultiplicarMatrix(Matrix matrixA,Matrix matrixB) 
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
			if(matrixA.getDimensiones()[0]==1||matrixA.getDimensiones()[0]==2) {
				if(matrixA.getDimensiones()[0]==1) {
					determinante = matrixA.getContent()[0][0];
					return determinante;
				}
				else {
					determinante = matrixA.getContent()[0][0]*matrixA.getContent()[1][1]-matrixA.getContent()[1][0]*matrixA.getContent()[0][1];
					return determinante;
				}
			}
			else {
				Matrix matrixN = new Matrix(matrixA.getDimensiones()[0]-1, matrixA.getDimensiones()[1]-1,"Matriz recursiva");
				int sign = 1;
				double cof = 0;
				for(int i = 0; i<matrixA.filas; i++) {
					cof = matrixA.content[0][i];
					for(int j = 1; j<matrixA.getDimensiones()[0];j++) {
						int saltarFil = 0; 
						for(int k = 0; k<matrixA.getDimensiones()[0];k++) {
							if(j==0||i==k) {
								continue;
							}
							matrixN.getContent()[j-1][saltarFil] = matrixA.getContent()[j][k];
							saltarFil++;
						}
					}
					double solInterna = sign*cof*Determinante(matrixN);	
					determinante = determinante+solInterna;
					sign*=-1;
				}
			}
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
			
}



