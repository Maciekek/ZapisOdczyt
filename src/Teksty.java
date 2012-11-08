import java.io.*;


public class Teksty {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader("maciek.txt")
				);
		PrintWriter pw = new PrintWriter(
				new FileWriter("tekst2000.txt",true)
				);
		
		String linia;
		while((linia = br.readLine()) != null)
			pw.println(linia.toUpperCase());
		
		pw.close();
		br.close();
	}
}
