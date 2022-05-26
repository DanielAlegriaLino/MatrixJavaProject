package Matrix;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MathMatrix {
	
	public static void saveMatrix(ArrayList <Matrix> list) {
		System.out.println("¿Quiere guardar esta matriz?");
		
	}
	
	public static Matrix getMatrixA(ArrayList<Matrix> list) {
		Scanner in = new Scanner(System.in);
		Boolean reiniciar = true;
		Matrix matrixA = new Matrix("0",new double[][] {
			{0}});
		System.out.println("Ingrese el numero de matriz que desea utilizar");
		ShowMatrixes(list);
		int n = Validator(in.nextLine());
		while(reiniciar) {
			if(n>list.size() || n<0) {
				System.out.println("Ha ingresado un numero de matriz fuera de rango, ingrese otro");
				n = Validator(in.nextLine());
			}
			else {
				matrixA = list.get(n-1);
				reiniciar = false;
			}
		}
		return matrixA;
	}
	
	public static void UserInterface(ArrayList<Matrix> list){
		Boolean reiniciar = true,reiniciar2 = true;
		int value = 0;
		Matrix matrixA = new Matrix("0",new double[][] {
			{0}
		}),matrixB = new Matrix("0",new double[][] {
			{0}
		});
		while(reiniciar) {
			System.out.println("Calculadora de matrices" + "\n" + "Ingrese lo que desea hacer"+"\n");
			System.out.print("\t"+"1.- Ver matrices"+"\n\t"+"2.- Crear una nueva matriz"+"\n\t"+
			"3.- Suma de matrices" + "\n\t" + "4.- Resta de matrices" + "\n\t" + "5.- Multiplicacion de matrices" + "\n\t" +
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
					ShowMatrixes(list);
					break;
					///////////////////////////////////////////////////////////////////////////////////	
					///////////////////////////////////////////////////////////////////////////////////
				case 2:
					System.out.println("Ingrese la cantidad de filas de la matriz");
					int n = Validator(in.nextLine());
					System.out.println("Ingrese la cantidad de columnas de la matriz");
					int m = Validator(in.nextLine());
					System.out.println("Ingrese el nombre de la matriz");
					String name = in.nextLine();
					list.add(new Matrix(n,m,name));
					list.get(list.size()-1).FillMatrix();
					break;
					///////////////////////////////////////////////////////////////////////////////////	
					///////////////////////////////////////////////////////////////////////////////////
				case 3:
					matrixA = getMatrixA(list);
					System.out.println("Ingrese la matriz B que se le sumara a A");
					matrixB = getMatrixA(list);
					if(compareDim(matrixA,matrixB)) {
						try {
							Matrix sumaMatrix = MatrixSum(matrixA,matrixB);
							System.out.println("La suma resulta en la siguiente matriz:");
							sumaMatrix.ShowMatrix();
						}
						catch(Exception e){
							System.out.println("Esta suma no esta definida, las matrices son de dimensiones diferentes");
						}
					}
					else
						System.out.println("La suma de estas matrices no esta definida, pues son de tamaños distintos");
					break;
				///////////////////////////////////////////////////////////////////////////////////	
				///////////////////////////////////////////////////////////////////////////////////	
				case 4:
					matrixA = getMatrixA(list);
					matrixB = getMatrixA(list);
					if(compareDim(matrixA,matrixB)) {
						try {
							Matrix restaMatrix = MatrixDifferences(matrixA,matrixB);
							System.out.println("La resta resulta en la siguiente matriz:");
							restaMatrix.ShowMatrix();
						}
						catch(Exception e) {
							System.out.println("La resta de estas matrices no esta definida, pues son de tamaños distintos");
						}
					}
					else
						System.out.println("La resta de estas matrices no esta definida, pues son de tamaños distintos");
					break;
					///////////////////////////////////////////////////////////////////////////////////	
					///////////////////////////////////////////////////////////////////////////////////
				case 5:
					matrixA = getMatrixA(list);
					matrixB = getMatrixA(list);
					if(CompareCompatibility(matrixA,matrixB)) {
						try {
							Matrix matrixProduct = MultiplicarMatrix(matrixA,matrixB);
							System.out.println("La multiplicacion resulta en la siguiente matriz:");
							matrixProduct.ShowMatrix();
						}
						catch(Exception e){
							System.out.println("Las matrices no pueden multiplicarse por la diferencia entre columnas A y filas B");
						}
					}
					else
						System.out.println("Las matrices no pueden multiplicarse por la diferencia entre columnas A y filas B");
					break;
					///////////////////////////////////////////////////////////////////////////////////	
					///////////////////////////////////////////////////////////////////////////////////
				case 6:
					matrixA = getMatrixA(list);
					try {
						double determinante = Determinante(matrixA);
						System.out.println("El determinante es: " + determinante);
					}
					catch(Exception e){
						System.out.println("La matriz no es cuadrada, por ende no tiene determinante");
					}
					break;
					///////////////////////////////////////////////////////////////////////////////////	
					///////////////////////////////////////////////////////////////////////////////////
				case 7:
					matrixA = getMatrixA(list);
					if(matrixA.IsSquared() && Determinante(matrixA)!=0) {
						try {
							matrixA = zeroCol(matrixA);
							Matrix matrixInversa = getMatrizEscalonada(matrixA);
							if(matrixInversa.columnas == 2)
								matrixInversa = swapCol(matrixInversa);
							System.out.println("La matriz inversa es la siguiente matriz:");
							matrixInversa.ShowMatrix();
						}
						catch(Exception e) {
							System.out.println("Esta matriz no tiene inversa, pues su determinante es cero o no es cuadrada");
						}
					}
					else 
						System.out.println("Esta matriz no tiene inversa, pues su determinante es cero o no es cuadrada");
					break;
				case 8:
					matrixA = getMatrixA(list);
					System.out.println("Ingrese el numero por el que desea multiplicar la matriz");
					double escalar = ValidatorDouble(in.nextLine());
					Matrix escalarMatrix = MultiplicacionEscalar(matrixA,escalar);
					System.out.println("La multiplicacion resulta en la siguiente matriz:");
					escalarMatrix.ShowMatrix();
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
	private static void ShowMatrixes(ArrayList<Matrix> list) {
		for(int i=0; i<list.size();i++) {
			System.out.println(i+1 + ":");
			for(double[] row:list.get(i).content) {
				System.out.println(Arrays.toString(row));
			}
		System.out.println();
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
	
	private static double ValidatorDouble(String value) {
		Boolean reiniciar = true;
		double parsedValue = 0;
		Scanner in = new Scanner(System.in);
		while(reiniciar) {
			try {
				parsedValue = Double.parseDouble(value);
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

	public static Matrix MultiplicacionEscalar(Matrix MatrixA,double escalar) {
		Matrix matrix_aux = new Matrix(MatrixA.filas,MatrixA.columnas,"aux");
		for(int i = 0; i<MatrixA.filas; i++) {
			for(int j = 0; j<MatrixA.columnas; j++) {
				matrix_aux.content[i][j] = MatrixA.content[i][j]*escalar;
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
		
		
        
        public static Matrix getMatrizEscalonada(Matrix matriz) 
	{
            Matrix matrix_identidad = MathMatrix.MatrizIdentidadCuadrada(matriz);
		int numero_incognitas= matriz.getContent()[0].length-1;
		
		for(int x = 0 ; x < numero_incognitas; x++  ) 
		{
			// Cada columna
			if(matriz.getContent()[x][x]== 0) 
			{
				int seq_search = 1;
				while( matriz.getContent()[x+seq_search][x] == 0 && seq_search+x < numero_incognitas) 
				{
					seq_search++;
				}
				
				for(int k = 0; k < numero_incognitas; k++) 
				{
					double temp = matriz.getContent()[x][k] ;
					matriz.getContent()[x][k] = matriz.getContent()[x+seq_search][k];
					matriz.getContent()[x+seq_search][k] = temp ;
				}
				
			}
			
			
			for(int y = 0; y < numero_incognitas; y++) 
			{
				//Ignorar las diagonales pues es lo primero que checamos 
				if(x==y) {continue;}
				
				double pivote = 0;
				pivote =  matriz.getContent()[y][x]/matriz.getContent()[x][x];
				
				for(int k = 0; k < numero_incognitas; k++) 
				{
					matrix_identidad.getContent()[y][k] = matrix_identidad.getContent()[y][k]  - matrix_identidad.getContent()[x][k]*pivote;
                    matriz.getContent()[y][k]= matriz.getContent()[y][k] - matriz.getContent()[x][k]*pivote;
                                        
                                }
				
			}
			
		}
        
                        
		for( int i= 0; i<numero_incognitas; i++ ) 
		{
                    for (int j = 0; j< numero_incognitas; j++)
                    {
			matrix_identidad.getContent()[i][j]= matrix_identidad.getContent()[i][j]/matriz.getContent()[i][i];                    
                    }
		}
                return matrix_identidad;
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
			for(int j = 0; j<matrixA.filas; j++) {
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
        
	public static Matrix zeroCol(Matrix matrixA) {
		Matrix matrix_aux = new Matrix(matrixA.filas,matrixA.columnas+1,"Extra cero");
		matrix_aux = MatrixSumException(matrixA,matrix_aux);
		return matrix_aux;
	}
	
	public static Matrix swapCol(Matrix matrixA) {
		Matrix matrix_aux = new Matrix(matrixA.filas,matrixA.columnas,"Cambiar col");
		matrix_aux.getContent()[0][0] = matrixA.getContent()[0][1];
		matrix_aux.getContent()[0][1] = matrixA.getContent()[0][0];
		matrix_aux.getContent()[1][0] = matrixA.getContent()[1][1];
		matrix_aux.getContent()[1][1] = matrixA.getContent()[1][0];
		return matrix_aux;
		
	}
	
        	public static Matrix MatrizIdentidadCuadrada(Matrix matrixA) {
                Matrix matrix_identidad = new Matrix("pepe", new double [matrixA.getContent().length][matrixA.getContent().length] );
                for (int i = 0 ; i < matrix_identidad.getContent().length; i++)
                {
                      for (int j = 0 ; j < matrix_identidad.getContent().length; j++)
                      {
                          if(i == j ){ matrix_identidad.getContent()[i][i]=1;}
                      }
                }
                
                  return matrix_identidad;
	}
        
			
}



