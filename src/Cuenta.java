import java.util.*;

public class Cuenta {
	
	//private Empresa empresa;
	private String nombreCuenta;
	private ArrayList<Periodo> periodos;
	

	public Cuenta(String nombre, ArrayList<Periodo> listaPeriodos){
		//empresa = unaEmpresa;
		nombreCuenta = nombre;
		//periodos = listaPeriodos;
		periodos = new ArrayList<Periodo>();
		periodos.addAll(listaPeriodos);


	}
	
	/*Empresa getEmpresa(){
		return empresa;
	}*/
	
	String getNombre(){
		return nombreCuenta;
	}
	
	void nuevoPeriodo(Periodo p){
		periodos.add(p);
	}
	
	float montoAnio(int anio){
		float montoARetornar = 0;
		
		for(int i = 0; i < periodos.size(); i++){
			
			Periodo temp = periodos.get(i);
			
			if(temp.getAnio() == anio){
				montoARetornar = temp.getDolares();
			}
		}
		
		return montoARetornar;
	}
	
	float montoEntreAnios(int anio1, int anio2){
		
		System.out.println("Cuenta: " + nombreCuenta);
		
		float montoARetornar = 0;
		
		if(anio1 > anio2 && anio2 != 0){
			int aux = anio1;
			anio1 = anio2;
			anio2 = aux; //Intercambio si me pasan los años desordenados
		}
		
		for(int i = 0; i < periodos.size(); i++){
			
			Periodo temp = periodos.get(i);
			
					
			if(temp.pertenezcoAPeriodoEntreAnios(anio1,anio2)){
				System.out.println("Año: " + temp.getAnio());
				System.out.println("Monto: " + temp.getDolares());
				montoARetornar += temp.getDolares();
			}
		}
		
		return montoARetornar;
	}
	
	float montoDesdeAnio(int anio){
		return montoEntreAnios(anio,0);
	}
	
	float montoHastaAnio(int anio){
		return montoEntreAnios(0,anio);
	}
	

}
