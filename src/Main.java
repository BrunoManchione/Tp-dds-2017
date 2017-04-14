import java.util.*;

public class Main {

	public static void main(String[] args) {

		ArrayList<Empresa> listaEmpresasLocal = new ArrayList<Empresa>();
		
		Periodo F2001 = new Periodo(2001, 130000);
		Periodo F2002 = new Periodo(2002, 270000);
		Periodo F2006 = new Periodo(2006, 500000);
		
		ArrayList<Periodo> lista = new ArrayList<Periodo>();
		lista.add(F2001);
		lista.add(F2002);
		lista.add(F2006);
		
		
		Cuenta nSQ = new Cuenta("NSQ",lista);
		
		ArrayList<Cuenta> listaC = new ArrayList<Cuenta>();
		listaC.add(nSQ);
		
		Empresa facebook = new Empresa("Facebook",listaC);
		
		listaEmpresasLocal.add(facebook);

		
		
		
		Scanner Scan = new Scanner(System.in);
		int opc;
		do{
			System.out.println("Menu:");
			System.out.println("1.Alta de cuenta");
			System.out.println("2.Mostrar cuentas");
			System.out.println("3.Salir");
			opc = Scan.nextInt();
			System.out.println("");
			switch(opc){
				case 1:
					listaEmpresasLocal = AltaDeCuentas(listaEmpresasLocal);
				break;
				case 2:
					System.out.println("Año inicial:");
					int anio1 = Scan.nextInt();
					System.out.println("Año final:");
					int anio2 = Scan.nextInt();
					listaEmpresasLocal.forEach((emp)->emp.mostrarValoresEntreAnios(anio1, anio2));
				break;
				case 3:
					
				break;
				default:
					System.out.println("Ingrese una opcion valida");
					System.out.println("");
				break;
			}
			

		}while(opc != 3);
		Scan.close();
	}
	
	public static ArrayList<Empresa> AltaDeCuentas(ArrayList<Empresa> listaEmpresasLocal){
		Scanner Scan = new Scanner(System.in);
		System.out.println("Ingrese el nombre de la Empresa");
		String nombreEmpresa = Scan.nextLine();
		int indiceEmpresa = existeEmpresa(listaEmpresasLocal, nombreEmpresa);
		if( indiceEmpresa != -1)
		{

				System.out.println("Ingrese el nombre de la Cuenta");
				String nombreCuenta = Scan.nextLine();
				int indiceCuenta = listaEmpresasLocal.get(indiceEmpresa).existeCuenta(nombreCuenta);
				
				System.out.println("Ingrese el año");
				int nvoAnio = Scan.nextInt();
				System.out.println("Ingrese el monto");
				float montoC = Scan.nextFloat();
				Periodo nvoPeriodo = new Periodo(nvoAnio, montoC);
				
				if(indiceCuenta !=-1){
					
					listaEmpresasLocal.get(indiceEmpresa).nuevoPeriodoEnCuentaExistente(nombreCuenta, nvoPeriodo);
				}
				else
				{
					Cuenta nvaCuenta = new Cuenta(nombreCuenta, new ArrayList<Periodo>());
					nvaCuenta.nuevoPeriodo(nvoPeriodo);
					listaEmpresasLocal.get(indiceEmpresa).nuevaCuenta(nvaCuenta);
				}
		}
		else{
			System.out.println("La empresa no existe");
		}
		
		return listaEmpresasLocal;
	}
	
	public static int existeEmpresa(ArrayList<Empresa> lista, String nombre){
		int ret = -1;
		
		for(int i = 0; i < lista.size(); i++){
			System.out.println(lista.get(i).getNombre());
			if(lista.get(i).getNombre().equals(nombre))  {
				ret = i;
			}
		}
		
		return ret;
	}


	
}
