
import java.util.Scanner;

public class Editor {

	Scanner S = new Scanner(System.in);
	Gladiador g1 = new Gladiador("AaronPB", 100, 30); //Gladiador a vencer
	Gladiador g2 = new Gladiador("Default", 50, 10); //Gladiador 2 default
	
	//Editar Nombre
	public void EditarNombre() {
		System.out.println("Nombre del gladiador que se va a enfrentar a "+g1.GetNombre());
		System.out.println("Nombre definido: "+g2.GetNombre());
		g2.SetNombre(S.nextLine());
	}
	
	//Editar Vida
	public void EditarVida() {
		boolean verificador = true;
		while(verificador) {
			System.out.println("Vida de "+g2.GetNombre()+". De 10 a 100");
			System.out.println("Vida Previa: "+g2.GetSalud());
			g2.SetSalud(S.nextDouble());
			
			if (g2.GetSalud() < 10 || g2.GetSalud() > 100) {
				System.out.println(g2.GetSalud()+" no es un número válido, ingrese una salud de 10 a 100");
			}
			else {
				verificador = false;
				
			}
			
		}
	}
	
	//Editar Fuerza
	public void EditarFuerza() {
		boolean verificador = true;
		while(verificador) {
			System.out.println("Fuerza de "+g2.GetNombre()+". De 2 a 50");
			System.out.println("Fuera Previa: "+g2.GetFuerza());
			g2.SetFuerza(S.nextDouble());
			
			if (g2.GetFuerza() < 2 || g2.GetFuerza() > 50) {
				System.out.println(g2.GetFuerza()+" no es un número válido, ingrese una salud de 10 a 100");
			}
			else {
				verificador = false;
				
			}
			
		}
	}
}
