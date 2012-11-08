import java.io.*;

public class Test {

    
    public static void main(String[] args) throws IOException {
        
        System.out.println("Hello");
    InputStreamReader isr = new InputStreamReader(System.in);
    
    BufferedReader br = new BufferedReader(isr);
    
    char c;
    System.out.println("Podaj znaki (q-wyjscie)");
    
    do {
            c=(char)br.read();
            System.out.print(c);
            
    } while (c!= 'q');
        
    
    }
}