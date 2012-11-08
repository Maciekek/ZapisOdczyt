import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class Szyfrowanie {


	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		FileReader plikWczytaj;
        BufferedReader plikBufor_odczyt;
        FileWriter plikZapis;
        String dane;
       
        
        String odczytTekst;
        char[] szyfr;
        String klucz = "java";
        System.out.println("Podaj nazwe pliku, na ktorym chcesz wykonac operacje: ");
        String nazwaPliku = in.nextLine();
        File plik = new File(nazwaPliku);
		PrintWriter zapis = new PrintWriter(n+".txt");
	   
		
		System.out.println("Plik o nazwie " +n+".txt zosta³ poprawnie utworzony. Mo¿esz wpisaæ dane: //Aby wyjsc wpisz quit");
	    String tekst;
	    plikWczytaj = new FileReader(nazwaPliku);
        plikBufor_odczyt = new BufferedReader(plikWczytaj);
        odczytTekst = plikBufor_odczyt.readLine();
        szyfr = new char[odczytTekst.length()];
        for (int i=0; i<odczytTekst.length(); i++)
        {
            szyfr[i] = (char) (odczytTekst.charAt(i)^klucz.charAt(i % klucz.length()));
        }
        System.out.println("Zaszyfrowany/odszyfrowany " + plik + ":");
        System.out.println(szyfr);
        System.in.read();
        // zapis do pliku
        plikZapis = new FileWriter(nazwaPliku);
        plikZapis.write(szyfr);
        plikZapis.close();
	}
	}

}
