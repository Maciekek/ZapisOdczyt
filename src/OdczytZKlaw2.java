import java.io.*;
import java.util.Arrays;
public class OdczytZKlaw2 {

    
    public static void main(String[] args) throws IOException {
        
        System.out.println("Hello");
    InputStreamReader isr = new InputStreamReader(System.in);
    //Zapis in = new Zapis();
    BufferedReader br = new BufferedReader(isr);
    
    char c;
    System.out.println("Podaj znaki (q-wyjscie)");
    
    do {
            c=(char)br.read();
            System.out.print(c);
            Zapis in = new Zapis(c);
   
    } while (c!= 'q');
    
    
    }

	
}


class Zapis {
	Zapis (char c) throws IOException {
	
		DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream( 
						new FileOutputStream("Data.txt")));
		out.writeChar(c);
		
		out.close();
		
		
	}
}