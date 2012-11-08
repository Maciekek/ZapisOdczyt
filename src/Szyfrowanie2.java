import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.File;

public class Szyfrowanie2{

	public static void main(String[] args) throws IOException  {
		Scanner odczyt = new Scanner (System.in);
		
        String klucz = "java";
        char[] szyfr;
   	
	    System.out.println("Podaj nazwe pliku do jakiego chcesz wprowadziæ dane: ");
		String n = odczyt.next();
		PrintWriter zapis = new PrintWriter(n+".txt");
	    System.out.println("Plik o nazwie " +n+".txt zosta³ poprawnie utworzony. Mo¿esz wpisaæ dane: //Aby wyjsc wpisz quit");
	    String tekst;
	    do {
           tekst=odczyt.next();
            
           if (!tekst.equals("quit")){
            	//zapis.println(tekst);
           
          	
          	szyfr = new char[tekst.length()];
              for (int i=0; i<tekst.length(); i++)
              {
                  szyfr[i] = (char) (tekst.charAt(i)^klucz.charAt(i % klucz.length()));
              }
              //System.out.println(szyfr);
              zapis.println(szyfr);
           }
	    
	    } while ( !tekst.equals("quit") ); 
	    
	    	//zapis.println(odczyt.nextLine());
	    	zapis.close();

	    	
		    
	
	 FileReader fr = new FileReader(n+ ".txt");
	 String linia;
	
	//Scanner odczytplik = new Scanner(fr);
	BufferedReader bfr = new BufferedReader(fr);
	
	while((linia = bfr.readLine()) != null){
        
		szyfr = new char[linia.length()];
        for (int i=0; i<linia.length(); i++)
        {
            szyfr[i] = (char) (linia.charAt(i)^klucz.charAt(i % klucz.length()));
        }
        
        System.out.println(szyfr);
        
   	
   	
     
	}
	bfr.close();
	}
}