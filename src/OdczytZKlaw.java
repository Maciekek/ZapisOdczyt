import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.File;

public class OdczytZKlaw {

	public static void main(String[] args) throws IOException  {
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);   //odczyt z klawiatury
	    
	    
	    String s;
		String n ="nazwaPliku";
		
		
		
		System.out.println("Podaj nazwe pliku to jakiego chcesz wprowadziæ dane: ");
	    n = br.readLine();
	    System.out.println("Plik o nazwie " +n+".txt zosta³ poprawnie utworzony. Mo¿esz wpisaæ dane: //Aby wyjsc wpisz quit");
		DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream( 
						new FileOutputStream(n+ ".txt")));   //zapis danych do pliku do n(wpisane).txt
		 
		
		
		    
		   
			
		    
	while (( s=br.readLine())!=null && !s.equals("quit")) {
		
		out.writeChars(s);
		//Wyswietl(s);
	
	}
	out.close();
	
	
	 FileReader fr = null;
	 String linia = "";
	fr = new FileReader(n+ ".txt");
	
	 BufferedReader bfr = new BufferedReader(fr);
	while((linia = bfr.readLine()) != null){
        System.out.println(linia.toCharArray());
	}
	}



static void Wyswietl (String s){
	System.out.println(s);
}




}