
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Gladiador {
	//Datos del Gladiador
	private String Nombre;
	private double Salud,Fuerza;
	
	private Random Rand = new Random(System.nanoTime());
	
	public Gladiador(String Nombre, double Salud, double Fuerza) {
		this.Nombre = Nombre;
		this.Salud = Salud;
		this.Fuerza = Fuerza;
	}

	//Setters and getters
	public void SetNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public void SetSalud(double Salud) {
		this.Salud = Salud;
	}
	public void SetFuerza(double Fuerza) {
		this.Fuerza = Fuerza;
	}
	
	public String GetNombre() {
		return Nombre;
	}
	public double GetSalud() {
		return Salud;
	}
	public double GetFuerza() {
		return Fuerza;
	}

	
	//Ataques y defensas de personajes
	public double ataque() {
		double golpe, randomizador = Rand.nextDouble();
		golpe = GetFuerza()*randomizador;
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (Exception e) {
			System.out.println("Algo ha salido mal en la lucha [ATAQUE]...");
		}
		
		if(randomizador == 1) {
			System.out.println("[GRANDIOSO!] El ataque de "+GetNombre()+" ha sido perfecto: "+golpe);
		}else if(randomizador > 0.8 && randomizador < 1) {
			System.out.println("[EFECTIVO!] El ataque de "+GetNombre()+" ha sido certero: "+golpe);
		}else if(randomizador > 0 && randomizador < 0.3) {
			System.out.println("[PENOSO!] El ataque de "+GetNombre()+" ha sido muy malo: "+golpe);
		}else if(randomizador == 0) {
			System.out.println("[PESIMO!] "+GetNombre()+" no ha podido atacar: "+golpe);
		}else {
			System.out.println(GetNombre()+ " ha atacado con una fuerza de "+golpe);
		}
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (Exception e) {
			System.out.println("Algo ha salido mal en la lucha [DEFENSA]...");
		}
		
		return golpe;
	}

	public double defensa() {
	double escudo, randomizador = Rand.nextDouble();
	escudo = GetSalud()*randomizador*0.1;
	
	try {
		TimeUnit.SECONDS.sleep(4);
	} catch (Exception e) {
		System.out.println("Algo ha salido mal en la lucha [DEFENSA]...");
	}
	
	if(randomizador == 1) {
		System.out.println("[INHUMANO!] El escudo de "+GetNombre()+" ha sido máximo: "+escudo);
	}else if(randomizador > 0.8 && randomizador < 1) {
		System.out.println("[INCREIBLE!] El escudo de "+GetNombre()+" ha sido potente: "+escudo);
	}else if(randomizador > 0 && randomizador < 0.3) {
		System.out.println("[DEBIL!] El escudo de "+GetNombre()+" ha sido muy débil: "+escudo);
	}else if(randomizador == 0) {
		System.out.println("[AGOTADO!] "+GetNombre()+" no ha podido generar un escudo: "+escudo);
	}else {
		System.out.println(GetNombre()+ " se ha defendido con un escudo de "+escudo);
	}
	
	try {
		TimeUnit.SECONDS.sleep(4);
	} catch (Exception e) {
		System.out.println("Algo ha salido mal en la lucha [DEFENSA]...");
	}
	return escudo;
}

}
