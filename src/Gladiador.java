
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Gladiador {
	DecimalFormat df = new DecimalFormat("#.##");
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
			System.out.println("[GRANDIOSO!] El ataque de "+GetNombre()+" ha sido perfecto: "+df.format(golpe));
		}else if(randomizador > 0.8 && randomizador < 1) {
			System.out.println("[EFECTIVO!] El ataque de "+GetNombre()+" ha sido certero: "+df.format(golpe));
		}else if(randomizador > 0 && randomizador < 0.3) {
			System.out.println("[PENOSO!] El ataque de "+GetNombre()+" ha sido muy malo: "+df.format(golpe));
		}else if(randomizador == 0) {
			System.out.println("[PESIMO!] "+GetNombre()+" no ha podido atacar: "+df.format(golpe));
		}else {
			System.out.println(GetNombre()+ " ha atacado con una fuerza de "+df.format(golpe));
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
		System.out.println("[INHUMANO!] El escudo de "+GetNombre()+" ha sido máximo: "+df.format(escudo));
	}else if(randomizador > 0.8 && randomizador < 1) {
		System.out.println("[INCREIBLE!] El escudo de "+GetNombre()+" ha sido potente: "+df.format(escudo));
	}else if(randomizador > 0 && randomizador < 0.3) {
		System.out.println("[DEBIL!] El escudo de "+GetNombre()+" ha sido muy débil: "+df.format(escudo));
	}else if(randomizador == 0) {
		System.out.println("[AGOTADO!] "+GetNombre()+" no ha podido generar un escudo: "+df.format(escudo));
	}else {
		System.out.println(GetNombre()+ " se ha defendido con un escudo de "+df.format(escudo));
	}
	
	try {
		TimeUnit.SECONDS.sleep(4);
	} catch (Exception e) {
		System.out.println("Algo ha salido mal en la lucha [DEFENSA]...");
	}
	return escudo;
}

}
