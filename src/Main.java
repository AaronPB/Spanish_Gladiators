
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Editor editor = new Editor();
		
		Scanner S = new Scanner(System.in);
		int opcion = 0, ronda = 0; //Para la edici�n del gladiador
		double ataque, escudo; //Para la lucha
		boolean terminar = true;
		String ganador = "None"; //Valor por defecto
		
		
		System.out.println("Lucha de Gladiadores");
		System.out.println("Version BETA v0.1");
		System.out.println("=====================================");
		
		System.out.println("Por favor, introduza las caracteristicas de su gladiador");
		
		while(terminar) {
			System.out.println("========[ ENFRENTAMIENTO ]========");
			System.out.println("Datos		Gladiador 1	Gladiador 2");
			System.out.println("Nombre:		"+editor.g1.GetNombre()+"		"+editor.g2.GetNombre());
			System.out.println("Vida:		"+editor.g1.GetSalud()+"		"+editor.g2.GetSalud());
			System.out.println("Fuerza:		"+editor.g1.GetFuerza()+"		"+editor.g2.GetFuerza());
			System.out.println("EDITAR: 1 (Nombre), 2 (Vida), 3 (Fuerza), 4 (Guardar)");
			opcion = S.nextInt();
			
			switch(opcion) {
			case 1:
				editor.EditarNombre();
				break;
				
			case 2:
				editor.EditarVida();
				break;
				
			case 3:
				editor.EditarFuerza();
				break;
				
			case 4:
				System.out.println("Se ha guardado correctamente a "+editor.g2.GetNombre());
				terminar = false;
				break;
			
			default:
				System.out.println("Introduzca un apartado v�lido: 1,2 o 3");
			}
		}
		
		System.out.println("Tu gladiador ha sido definido!!");
		
		terminar = true;
		while(terminar) {
			ronda++;
			if(ronda == 10) {
				System.out.println("================================================");
				System.out.println("                 DEATHMATCH");
				System.out.println("             NO HABR� ESCUDOS!!!");
				System.out.println("================================================");
			}
			
			System.out.println("================================================");
			System.out.println(">> Ronda "+ronda+" | Turno de "+editor.g2.GetNombre());
			System.out.println("Vida de "+editor.g1.GetNombre()+": "+editor.g1.GetSalud());
			if(ronda < 10) { //Escudos en rondas bajas
				escudo = editor.g1.defensa();
				
			}else {
				escudo = 0;
			}
			ataque = editor.g2.ataque();
			editor.g1.SetSalud(editor.g1.GetSalud()-ataque+escudo);
			
			if(editor.g1.GetSalud() <= 0) {
				System.out.println("Tu gladiador ha GANADO!");
				ganador = editor.g2.GetNombre();
				terminar = false;
			}
			
			if(terminar) { //Si no ha terminado el combate... que contin�e!
				System.out.println("\n>> Ronda "+ronda+" | Turno de "+editor.g1.GetNombre());
				System.out.println("Vida de "+editor.g2.GetNombre()+": "+editor.g2.GetSalud());
				if(ronda < 10) { //Escudos en rondas bajas
					escudo = editor.g2.defensa();
					
				}else {
					escudo = 0;
				}
				ataque = editor.g1.ataque();
				editor.g2.SetSalud(editor.g2.GetSalud()-ataque+escudo);
				if(editor.g2.GetSalud() <= 0) {
					System.out.println("Tu gladiador ha PERDIDO!");
					ganador = editor.g1.GetNombre();
					terminar = false;
				}
			}
			
			System.out.println("_________________________________________________");
			if(editor.g1.GetSalud() > 0) {
				System.out.println("Vida de "+editor.g1.GetNombre()+": "+editor.g1.GetSalud());
			}else {
				System.out.println("Vida de "+editor.g1.GetNombre()+": 0");
			}
			if(editor.g1.GetSalud() > 0) {
				System.out.println("Vida de "+editor.g2.GetNombre()+": "+editor.g2.GetSalud());
			}else {
				System.out.println("Vida de "+editor.g2.GetNombre()+": 0");
			}
			System.out.println("_________________________________________________");
			
		}
		
		System.out.println("========[ RESUMEN FINAL ]========");
		System.out.println("N� Rondas:	"+ronda);
		System.out.println("Ganador:	"+ganador);
		if(ganador == editor.g1.GetNombre()) {
			System.out.println("Vida restante:	"+editor.g1.GetSalud());
		}else if(ganador == editor.g2.GetNombre()) {
			System.out.println("Vida restante:	"+editor.g2.GetSalud());
		}else {
			System.out.println("Vida restante:	No encontrado");
		}
		
	}

}
