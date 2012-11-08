import java.io.*;

public class WczytywanieZKlawiatury{

    public static void main(String[] args) throws IOException {

	// zamiana potoku bajtowego na znakowy
	InputStreamReader isr = new InputStreamReader(System.in);
	
	// otoczenie potoku znakowego buforowanym
	BufferedReader br = new BufferedReader(isr);

	char c;
	System.out.println("Wprowadzaj znaki, znak 'q' - wyjscie");
	
	do {
	    c=(char)br.read();
	    System.out.println(c);
	} while ( c != 'q');


	System.out.println("Wprowadzaj lancuchy - 'quit' - wyjscie");

	String str;
        do {
            str=br.readLine();
            System.out.println(str);
        } while ( !str.equals("quit") );

	System.out.println("Wprowadzaj lancuchy do zapamietania 'stop' - wyjscie\n");

	String[] tabStr = new String[10];

	for (int i = 0; i < tabStr.length; i++) {
	    tabStr[i] = br.readLine();
	    if (tabStr[i].equals("stop")) break;
        }

	System.out.println("Oto twoje dane\n");

 	for (int i = 0; i < tabStr.length; i++) {
	    if (tabStr[i].equals("stop")) break;
	    System.out.println(tabStr[i]);

        } 

	
    }

}
