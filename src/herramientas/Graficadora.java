/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientas;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graficadora {
	JFreeChart grafica;
	XYSeriesCollection datos=new XYSeriesCollection();
	String titulo;
	String etiquetax;
	String etiquetay;
	
	public Graficadora(Graficadora g){
		this.datos=g.datos;
		this.etiquetax=g.etiquetax;
		this.etiquetay=g.etiquetay;
		this.grafica=g.grafica;
		this.titulo=g.titulo;
	}
	
	public Graficadora(String t,String x,String y){
		titulo = t;
		etiquetax=x;
		etiquetay=y;
		grafica=ChartFactory.createXYLineChart(titulo, x, y, datos, PlotOrientation.VERTICAL, true, true, true);
	}
	public Graficadora(){
		this("Sin Titulo","x","y");
	}
	
	public void agregarGrafica(String id,ArrayList<Double> x,ArrayList<Double> y){
		XYSeries s= new XYSeries(id);
		int n=x.size();
		for(int i=0;i<n;i++){
			s.add(x.get(i),y.get(i));
		}
		datos.addSeries(s);
	}
	
	public void crearGrafica(String id,ArrayList<Double> x,ArrayList<Double>y){
		datos.removeAllSeries();
		agregarGrafica(id,x,y);
	}
	
	public JPanel obtieneGrafica(){
		return new ChartPanel(grafica);
	}
	
	public void setTitulo(String t){
		titulo = "Grafica de la Funcion: " + t;	
		grafica.setTitle(titulo);
	}
}