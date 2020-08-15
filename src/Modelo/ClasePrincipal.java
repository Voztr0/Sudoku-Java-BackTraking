package Modelo;

public class ClasePrincipal {
    
    public static boolean esSeguro(int[][] tablero,int fila, int columna,int num) 
    { 
        // fila has the unique (fila-clash) 
        for (int d = 0; d < tablero.length; d++) { 
            // si el número que estamos intentando
             // el lugar ya está presente en
             // que fila, devuelve falso;
            if (tablero[fila][d] == num) { 
                return false; 
            } 
        } 
  
        // columnaumn has the unique numbers (columnaumn-clash) 
        for (int r = 0; r < tablero.length; r++) { 
            // if the number we are trying to 
            // place is already present in 
            // that columnaumn, return false; 
  
            if (tablero[r][columna] == num) { 
                return false; 
            } 
        } 
  
        // corresponding square has 
        // unique number (box-clash) 
        int sqrt = (int)Math.sqrt(tablero.length); 
        int inicioFila = fila - fila % sqrt; 
        int inicioColumna = columna - columna % sqrt; 
  
        for (int r = inicioFila; 
             r < inicioFila + sqrt; r++) { 
            for (int d = inicioColumna; 
                 d < inicioColumna + sqrt; d++) { 
                if (tablero[r][d] == num) { 
                    return false; 
                } 
            } 
        } 
  
        return true; 
    } 
  
    public static boolean resuelveSudoku( 
        int[][] tablero, int n) 
    { 
        int fila = -1; 
        int columna = -1; 
        boolean esVacia = true; 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) { 
                if (tablero[i][j] == 0) { 
                    fila = i; 
                    columna = j; 
  
                    // todavía nos queda algo
                    // valores perdidos en sudoku 
                    esVacia = false; 
                    break; 
                } 
            } 
            if (!esVacia) { 
                break; 
            } 
        } 
  
        // no queda espacio vacío
        if (esVacia) { 
            return true; 
        } 
  
        // else for each-fila backtrack 
        for (int num = 1; num <= n; num++) { 
            if (esSeguro(tablero, fila, columna, num)) { 
                tablero[fila][columna] = num; 
                if (resuelveSudoku(tablero, n)) { 
                    // print(tablero, n); 
                    return true; 
                } 
                else { 
                    // se reemplaza
                    tablero[fila][columna] = 0; 
                } 
            } 
        } 
        return false; 
    } 
  
    public static void print( 
        int[][] tablero, int N) 
    { 
        // tenemos la respuesta, solo la imprimimos
        for (int r = 0; r < N; r++) { 
            for (int d = 0; d < N; d++) { 
                System.out.print(tablero[r][d]); 
                System.out.print(" "); 
            } 
            System.out.print("\n"); 
  
            if ((r + 1) % (int)Math.sqrt(N) == 0) { 
                System.out.print(""); 
            } 
        } 
    } 
  }