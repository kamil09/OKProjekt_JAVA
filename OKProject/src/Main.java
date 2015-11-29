import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main extends Thread{

	/**
	 * Tryb działania programu
	 * 1- normalny
	 * 0- wygenerowanie instancji i jej zapisanie, wymagana nazwa pliku
	 */
	public static int tryb=1;
	
	
//USTAWIENIA ALGORYTMU WCZYTYWANE Z ARGUMENTOW
	/**
	 * Startowa populacja np 50
	 */
	public static int populacjaStartowa=50;
	/**
	 * Populacja do której rozszerzamy, przynajmniej 3,4 razy większa od startowej
	 */
	public static int populacjaEwolucji=200;
	/**
	 * Procent mutacji
	 */
	public static double iloscMutacji=0.33;
	/**
	 * Procent Krzyzowania
	 */
	public static double iloscKrzyzowania=0.33;
	/**
	 * PRZYKŁAD:
	 * 40% MUTACJA , 45% KRZYZOWANIE => 15% MUTACJA i KRZYZOWANIE  
	 */
	/**
	 * Czas po którym zatrzymujemy program w sekundach
	 */
	public static double czas=60;
	
	/**
	 * Plik zapisaną instancją
	 */
	public static String serialFileName;
	/**
	 * Czy wygenerować instancja
	 * Domyślnie true, jeśli podano plik zmieniamy na false
	 */
	public static boolean wygenerowacInstancje=true; 
	
//USTAWIENIA GENERATORA INSTANCJI
	/**
	 * Ilość zadań do wygenerowania w instacji
	 */
	public static int iloscZadan=50;
	/**
	 * Ilosć przerw do wygenerowania instancji jako procent ilości zadan
	 */
	public static double procentPrzerw=0.1;
	/**
	 * Minimalna długość zadania
	 */
	public static int minZ=5;
	/**
	 * Maksymalna dłyugosć zadania
	 */
	public static int maxZ=15;
	/**
	 * Minimalna długosć przerwy
	 */
	public static int minP=5;
	/**
	 * maksymalna długość przerwy
	 */
	public static int maxP=15;
	
	/**
	 * Wygenerowana lub wczytana instancja problrmu czyli zapis wszystkich zadań, i ich danych
	 */
	public static Instancja instancja;
	
	
	/**
	 * MAIN
	 * @param args parametry programu
	 * @throws IOException Wyjątek
	 * @throws FileNotFoundException Wyjątek brak pliku
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		wczytajWartosci(args);
		if(tryb==1){
			if (wygenerowacInstancje) instancja=new Instancja();
			else{
				ObjectInputStream we = new ObjectInputStream(new FileInputStream(serialFileName));
				instancja = (Instancja)we.readObject();
				we.close();
			}
			Algorytm algorytm=new Algorytm();
			algorytm.start();
		}
		else{
			instancja=new Instancja();
			ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream(serialFileName));
			wy.writeObject(instancja);
			wy.close();
		}
		
	}
	
	/**
	 * Ustawia odpowiednie wartości z argumentów
	 * @param args ardumenty podane do programu
	 */
	public static void wczytajWartosci(String[] args){
		for(int i=0; i < args.length-1 ; i++){
			switch (args[i]){
				case "-TR0" :
					serialFileName=args[i+1];
					tryb=0;
					System.out.println(serialFileName);
					i++;
					break;
				case "-TR1" :
					break;
				case "-PS" :
					populacjaStartowa=Integer.parseInt(args[i+1]);
					i++;
					break;
				case "-PE" :
					populacjaEwolucji=Integer.parseInt(args[i+1]);
					i++;
					break;
				case "-IM" :
					iloscMutacji=Integer.parseInt(args[i+1]);
					i++;
					break;
				case "-IK" :
					iloscKrzyzowania=Integer.parseInt(args[i+1]);
					i++;
					break;
				case "-T" :
					czas=Integer.parseInt(args[i+1]);
					i++;
					break;
				case "-SF" :
					serialFileName=args[i+1];
					wygenerowacInstancje=false;
					i++;
					break;
				case "-IZ" :
					iloscZadan=Integer.parseInt(args[i+1]);
					i++;
					break;
				case "-PP" :
					procentPrzerw=Integer.parseInt(args[i+1]);
					i++;
					break;
				case "-minZ" :
					minZ=Integer.parseInt(args[i+1]);
					i++;
					break;
				case "-maxZ" :
					maxZ=Integer.parseInt(args[i+1]);
					i++;
					break;
				case "-minP" :
					minP=Integer.parseInt(args[i+1]);
					i++;
					break;
				case "-maxP" :
					maxP=Integer.parseInt(args[i+1]);
					i++;
					break;
			}
			
		}
		
	}

}
