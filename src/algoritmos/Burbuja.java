/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Burbuja {
    
    private double tiempo_inicial;
    private double tiempo_final;
    private double tiempo_total;
    private double intercambios;
    private double comparaciones;


    public Burbuja() {
        this.tiempo_inicial = 0;
        this.tiempo_final = 0;
        this.tiempo_total = 0;
        this.comparaciones = 0;
        this.intercambios = 0;
    }
    
    public void ordenar(double []arreglo){
           this.tiempo_inicial = System.currentTimeMillis();
          for(int i = 0; i < arreglo.length - 1; i++)
            {
            for(int j = 0; j < arreglo.length - 1; j++)
                 {
                   this.comparaciones++;
                           
                if (arreglo[j] > arreglo[j + 1])
                {
                    double tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                    this.intercambios++;
                }
            }
        }
          // ya termino 
          this.tiempo_final = System.currentTimeMillis();
          this.tiempo_total = this.tiempo_final - this.tiempo_inicial;
    
    
    }
	
	public double getTiempo_inicial() {
		return tiempo_inicial;
	}

	public double getTiempo_final() {
		return tiempo_final;
	}

	public double getTiempo_total() {
		return tiempo_total;
	}

	public double getIntercambios() {
		return intercambios;
	}

	public double getComparaciones() {
		return comparaciones;
	}
    
    
}
