import java.util.Scanner;
import java.util.zip.*;
import java.io.*;


public class ZapisOdczytZip {
	public static void main(String[] args) throws IOException {
		
	Scanner odczyt = new Scanner (System.in);
	System.out.println(" Witaj w programie zapisujacym/zipujacym/odzpipowujacym pliki tekstowe.\n" +
			"Aby wykonac jakies dzialanie wpisz w okienko co bys chcial zrobic\n" +
			"zapis -- Powoduje zapisanie tekstu wpisanego przez uzytkownika \n" +
			"odczyt -- Powoduje odczytanie tekstu wczesniej zapisanego do Zip\n");
	
		if (odczyt.next().equals("zapis")) {
			Zapis();
		}
		else Drukowanie();
		
	
	
	odczyt.close();
	System.out.println("---------------------------");
	System.out.println("Program zakonczyl dzialanie");
}
	
	
static String Zapis() throws IOException {
	String NazwaPliku = WczytajNazwe();
	
	ZipOutputStream zout = new ZipOutputStream( 			//!
			new FileOutputStream(NazwaPliku+".zip")
			);
	DataOutputStream dout = new DataOutputStream(zout);     //zapisz w zip
	
	ZipEntry ze = new ZipEntry(NazwaPliku+".txt");			//Wstawienie pliku txt do archiwum
	zout.putNextEntry(ze);									
//		Scanner odczyt = new Scanner (System.in);
	InputStreamReader isr = new InputStreamReader(System.in);   //!
	BufferedReader br = new BufferedReader(isr);				//wrzucenie tekstu wpisanego do bufora
	
	System.out.println("Wpisz tekst który chcesz zapisaæ do pliku ZIP: //aby skonczy wpisz 'quit'");
	//while (( Tekst=br.readLine())!=null && !Tekst.equals("quit")){
	
	
	String Tekst;
	
	do {
      Tekst=br.readLine();
      if (!Tekst.equals("quit"))
    	  dout.writeBytes(Tekst);
      } while ( !Tekst.equals("quit") ); 				//petla majaca na celu zapisywanie tekstu do pliku
	
	
	zout.setComment(WczytajComment());					//wywolanie metody, pytajacej o komentarz do archiwum
	//dout.writeUTF(WczytajTekst());
	
	
	//zout.closeEntry(); // zamknij zipowany plik
	dout.close();      // zamknij zip
	
	
	return null;
}
	
static String WczytajNazwe() throws IOException   {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	System.out.println("Witaj w programie zapisujacym tekst do zip! ");
	System.out.println("Wpisz nazwe dla swojego archiwum zip: ");
	
	
	
	return br.readLine();
	
}


static String WczytajComment () {
	System.out.println("Czy chcia³byœ wpisaæ komentarz w pliku ZIP? //wpisz 'tak' lub 'nie'");
	Scanner odczyt = new Scanner (System.in);
	
	if (odczyt.next().equals("tak")){
		System.out.println ("Wpisz tekst ktory ma byc kom");
		String comment = odczyt.next();
		odczyt.close();
		return comment;
	}
	odczyt.close();
	return null;
	
	
}

static String Drukowanie() throws IOException {
	String NazwaPliku = null;
	Scanner odczyt = new Scanner (System.in);
	
		System.out.println("Podaj nazwe pliku //bez rozszerzenia");
		NazwaPliku = odczyt.nextLine();
	
	ZipInputStream zin = new ZipInputStream(						//otwieranie zip
			new FileInputStream(NazwaPliku+".zip")
			);
	DataInputStream din = new DataInputStream(zin);					//wprowadzenie potoku z zip do 

	zin.getNextEntry();	             //Reads the next ZIP file entry and positions stream at the beginning of the entry data.
	String a = (String)din.readLine(); 				//zapisanie do zmiennej tekstu
	
	System.out.println(a);
	din.close();  //zamknij plik
	odczyt.close();
	return null;
}
}


