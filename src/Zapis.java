import java.io.*;
import java.util.Arrays;


public class Zapis {

	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream( 
						new FileOutputStream("Data.txt")));
		out.writeUTF("asasasasasaasas 22323232");
		
		out.close();
		
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream("Data.txt")));
		System.out.println(in.readUTF());
	}

}
