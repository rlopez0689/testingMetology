package intervalo;

public class Intervalo {

	private double min;
	private double max;
	
	public Intervalo(double min, double max){
		this.min = min;
		this.max = max;
	}
	
	public double longitud(){
		return this.max - this.min;
	}
	
	public double puntoMedio(){
		return ((this.max + this.min)/2);
	}
	
	public boolean incluyePunto(double punto){
		if(punto>=this.min&&punto<=this.max)
			return true;
		return false;
	}
	
	public boolean incluyeIntervalo(Intervalo intervalo){
		if(this.incluyePunto(intervalo.max)&&this.incluyePunto(intervalo.min))
			return true;
		return false;
	}
	
	public Intervalo interseccion(Intervalo intervalo){
		double minimo=intervalo.min, maximo=intervalo.max;
		
		if(this.min > intervalo.min)
			minimo = this.min;
		if(this.max < intervalo.max)
			maximo = this.max;

		return new Intervalo(minimo,maximo);	
	}

	@Override
	public boolean equals(Object obj) {
		if(this.min == ((Intervalo)obj).min && this.max == ((Intervalo)obj).max )
			return true;
		return false;			
	} 
}
