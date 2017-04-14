import java.util.*;



public class Empresa {

	private String nombreEmpresa;
	private ArrayList<Cuenta> cuentas;
	
	
	public Empresa(String nombre, ArrayList<Cuenta> listaCuentas){
		nombreEmpresa = nombre;
		cuentas = listaCuentas;
	}
	
	void nuevoPeriodoEnCuentaExistente(String nombre, Periodo nvoPer){
		int indiceC = this.existeCuenta(nombre);
		if(indiceC != -1){
			cuentas.get(indiceC).nuevoPeriodo(nvoPer);
		}
	}
	
	String getNombre(){
		return nombreEmpresa;
	}
	
	void nuevaCuenta(Cuenta unaCuenta){
		cuentas.add(unaCuenta);
	}
	
	void mostrarValoresEntreAnios(int anio1, int anio2){
		System.out.println("Empresa: " + nombreEmpresa);
		System.out.println("");
		float montoTotal = 0;
		for(int i = 0; i< cuentas.size(); i++){
			float montoCuenta = cuentas.get(i).montoEntreAnios(anio1, anio2);
			montoTotal += montoCuenta;
		}
		System.out.println("Monto total: " + montoTotal);
		System.out.println("");
	}
	
	public int existeCuenta(String nombre){			//REPITO MUCHO CODIGO, SE PODRIA EVITAR
		int ret = -1;
		
		for(int i = 0; i < cuentas.size(); i++){
			if(cuentas.get(i).getNombre().equals(nombre)) ret = i;
		}
		
		return ret;
	}
	
	
	
}
