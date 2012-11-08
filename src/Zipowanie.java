import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Zipowanie {

	
	public static void main(String[] args) throws IOException {
		
		String Tresc = null;
		ZipOutputStream outZIP = new ZipOutputStream(new BufferedOutputStream(
				new FileOutputStream("test.zip")));
		
		Scanner odczyt = new Scanner(System.in);
		PrintWriter zapis = new PrintWriter("test.txt");
		System.out.println("Wprowadz tekst ktory chcesz zapisac do ZIP:");
		do {
		
			Tresc = odczyt.next();
			zapis.println(Tresc);
			outZIP.setComment(Tresc);
			
		} while(!Tresc.equals("quit"));
		
		zapis.close();
		outZIP.close();
		
		
	}

}
