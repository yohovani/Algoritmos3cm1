/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaordenamiento3cm1;

import algoritmos.Burbuja;
import algoritmos.BurbujaOptimizado;
import herramientas.Grafica;
import herramientas.Graficadora;
import java.util.ArrayList;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AAOrdenamiento3CM1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //double [] datos = new double[]{6,5,3,1,8,7,2,4};
		
		ArrayList<Double> xB1 = new ArrayList();
		ArrayList<Double> yB1 = new ArrayList();
		ArrayList<Double> xB2 = new ArrayList();
		ArrayList<Double> yB2 = new ArrayList();
		
		for(int i=5000;i<50000;i+=5000){
			double [] datos =herramientas.Datos.generarDatosAleatorios(i, 1000);
        	double [] datos3 = datos.clone();
			Burbuja b1 = new Burbuja();
			b1.ordenar(datos);
			xB1.add(b1.getTiempo_total());
			yB1.add(b1.getIntercambios());
			BurbujaOptimizado b2 = new BurbujaOptimizado();
			b2.ordenar(datos3);
			xB2.add(b2.getTiempo_total());
			yB2.add(b2.getIntercambios());
			
		}
		Grafica grafica = new Grafica();
		grafica.graficar(xB1, yB1, xB2, yB2);
		grafica.setVisible(true);
    }
   
}
