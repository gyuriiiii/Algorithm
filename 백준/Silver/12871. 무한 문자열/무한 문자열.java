import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		int num1 = s.length();
		int num2 = t.length();

		int min = (num1 * num2) / gcd(Math.max(num1, num2), Math.min(num1, num2));

		String tmp = s;
		while (true) {
			if (s.length() == min)
				break;

			s += tmp;
		}

		tmp = t;
		while (true) {
			if (t.length() == min)
				break;
			t += tmp;
		}
		
		if(s.equals(t))
		    System.out.println("1");
        else 
		    System.out.println("0");
	}
	
	static int gcd(int max, int min) {	
		while(min!=0) {
			int remainder = max%min;
			max =min;
			min = remainder;
		}
		
		return max;
	}

}