
public class Periodo {

	private int anio;
	private float dolares;
	
	public Periodo(int unAnio, float cantDolares){
		anio= unAnio;
		dolares = cantDolares;
	}
	
	int getAnio(){
		return anio;
	}
	
	float getDolares(){
		return dolares;
	}
	
	boolean pertenezcoAPeriodoEntreAnios(int anio1, int anio2){
		if(anio1 == 0) return AnioMenorA(anio2);
		else if(anio2 == 0) return AnioMayorA(anio1);
		else return (anio >= anio1 && anio <= anio2);			//Tengo que averiguar una forma de hacer esto sin tantos ifs
	}
	
	private boolean AnioMayorA(int unAnio){
		return anio > unAnio;
	}
	
	private boolean AnioMenorA(int unAnio){
		return anio < unAnio;
	}
}
