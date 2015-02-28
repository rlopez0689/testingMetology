package test;
import intervalo.Intervalo;

import java.util.ArrayList;

import utils.ReadExcel;


public class IntervalTestData {
	public ArrayList<Intervalo> intervaloData = new ArrayList<Intervalo>();
	public ArrayList<Double> longitudData = new ArrayList<Double>();
	public ArrayList<Double> puntoMedioData;
	public ArrayList<Double> incluyeParamData;
	public ArrayList<Boolean> incluyeData;
	public ArrayList<Intervalo> incluyeIntervaloData;
	public ArrayList<Boolean> incluyeIntervalo;
	public ArrayList<Intervalo> interseccionParamData;
	public ArrayList<Intervalo> interseccion;
	

	@SuppressWarnings("unchecked")
	public IntervalTestData(){
		ReadExcel rd = new ReadExcel();
		ArrayList<Object> arrMaster = new ArrayList<Object>();
		arrMaster=rd.readColumn("interval_data.xlsx");
		this.intervaloData = (ArrayList<Intervalo>) arrMaster.get(0);
		this.longitudData = (ArrayList<Double>) arrMaster.get(1);
		this.puntoMedioData = (ArrayList<Double>) arrMaster.get(2);
		this.incluyeParamData = (ArrayList<Double>) arrMaster.get(3);
		this.incluyeData = (ArrayList<Boolean>) arrMaster.get(4);
		this.incluyeIntervaloData = (ArrayList<Intervalo>) arrMaster.get(5);
		this.incluyeIntervalo = (ArrayList<Boolean>) arrMaster.get(6);
		this.interseccionParamData = (ArrayList<Intervalo>) arrMaster.get(7);
		this.interseccion = (ArrayList<Intervalo>) arrMaster.get(8);	
	}
	
}
