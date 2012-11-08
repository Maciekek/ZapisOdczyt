import java.util.Scanner;
import java.util.zip.*;
import java.io.*;


class Gzip
{
    public static void main(String[] args) throws IOException
    {
    	Scanner odczyt = new Scanner(System.in);
    	System.out.println("Program gzip");
    	System.out.println("Podaj nazwe istniejacego pliku txt aby zapisac go w GZIP");
    	String NazwaPliku=odczyt.next();
     	BufferedInputStream in = new BufferedInputStream (
    		new FileInputStream(NazwaPliku+".txt"));
    BufferedOutputStream out = new BufferedOutputStream(
    		new GZIPOutputStream(
    				new FileOutputStream(NazwaPliku+".gz")));
    System.out.println("Plik Zapisano jako " + NazwaPliku +".gzip");
    
    
    int c;
    while((c=in.read()) != -1)
    	out.write(c);
    in.close();
    out.close();
    System.out.println("Czy chcialbys odczytac zapisany przez Ciebie GZIP?");
    odczyt.nextLine();
    if (odczyt.nextLine().equals("tak")) Odczyt();
    System.out.println("Program zakonczyl dzialanie...");
}
    
    
    
    
    static void Odczyt () throws FileNotFoundException, IOException {
    	System.out.println("Odczyt pliku");
    
    BufferedReader in2 = new BufferedReader(
    		new InputStreamReader(new GZIPInputStream(
    				new FileInputStream("test2.gz"))));
    String s;
    while((s=in2.readLine()) != null)
    	System.out.println(s);
   
 
    }
}
    