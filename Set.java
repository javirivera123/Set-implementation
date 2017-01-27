package cs2302_summerLab1;
import java.util.Scanner; 

public class Set {
	static Scanner input = new Scanner(System.in);

	public static String[] Intersection(String[] a, String[] b){
		String[]set = new String[a.length];
		int spot = 0;
		for(int i=0;i<a.length;i++){
		     spot=i;
			for(int j=0; j<b.length;i++){
				if(a[spot]==b[i]){
					set[spot] = b[spot];
					
				}
			}
		}
		return set;
	  }
		
	}