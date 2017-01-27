/*
Course: CS2302
author: Javier Rivera
assignment:Lab 1
Instructor: julio urenda
T.A: Saiful Abu
Date of last modification: 6/16/16

Purpose:
Naively a set is only a collection of objects, but even in this level of generality we can make sense
of operations on sets, as arithmetical operations on integers, so we define
• (Intersection) A ∩ B = {x | x ∈ A and x ∈ B}
• (Union) A ∪ B = {x | x ∈ A or x ∈ B}
• (Difference) A \ B = {x | x ∈ A but x 6∈ B}
• (Power) P(A) = {x | x ⊂ A}
whenever A and B are sets. For example, if we assign A = {1, 2, 3} and B = {2, 3, 4} then
• A ∩ B = {2, 3}
• A ∪ B = {1, 2, 3, 4}
• A \ B = {1}
• P(A) = {∅, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, A}.
Problem: Create a class named Set that implements all the above set operations along with an appropriate
toString() method. Even though, repetition of an element within a set is irrelevant, avoid including an element in a set more than once. Write a report describing your work.

*/

package cs2302_summerLab1;
import java.util.Scanner;

public class lab1 {
	
	public static String [] sort(String [] done){
		for(int i=1;i<done.length;i++) {
	        int j = 0;
	        for(;j<i;j++) {
	            if(done[j].length() > done[j+1].length()) {
	                String temp = done[j];
	                done[j] = done[j+1];
	                done[j+1] = temp;
	            }
	        }
	    }
	    return done;
	}

	public static String[] union(int x, String[] P0) {
		String[] tmp = new String[P0.length * (2)];
		for (int i = 0; i < P0.length; i++) {
			tmp[i] = P0[i];
		}// end for filling first part array
		for (int i = P0.length; i < tmp.length; i++) {
			if (!P0[i - P0.length].isEmpty()) {
				tmp[i] = P0[i - P0.length] + "," + x;
			}// end filling 2nd part of array
			else {
				tmp[i] = "" + x;
			}// end else to just save x to empty
		}// end for flling all of powerset array
		return tmp;

	}

	public static String[] computePowerSet(String[] a) {
		if (a.length == 0) {
			String[] array = new String[1];
			array[0] = "";
			return array;
		} else {
			String[] temp = new String[a.length - 1];
			for (int i = 0; i < a.length - 1; i++) {
				temp[i] = a[i];
			}
			int x = Integer.parseInt(a[a.length-1]);
			String[] P0 = computePowerSet(temp);
			String[] complete = union(x, P0);
			return complete;

		}

	}// end of method

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int elements = 0;

		do {

			System.out.print("enter number of elements you want in a set, negatve to end");
			elements = input.nextInt();
			if (elements < 0) {

				System.exit(0);

			}// end if for if negative

			String[] a = new String[elements];
			String[] b = new String[elements];
			
            System.out.print("enter integers for set a");
            int num;
			for (int i = 0; i < a.length; i++) {
			    num = input.nextInt();
				a[i] = Integer.toString(num);
			}
			
			System.out.println("enter integers for set b");
			for (int i = 0; i < b.length; i++) {
				num = input.nextInt();
				b[i] = Integer.toString(num);
			}
			String[] union = findUnion(a,b);
			String[] diff = difference(a,b); 
			String[] inter = Intersection(a,b);

			String[] done = computePowerSet(a);
			String [] doneSort = sort(done);
			
			String[] done2 = computePowerSet(b);
			String [] doneSort2 = sort(done2);
			
			System.out.print("PoweSet A: ");
			printSet(doneSort);
			System.out.print("PowerSet B: ");
			printSet(doneSort2);
			System.out.print("Union: ");
			printSet(union);
			System.out.print("Intersection: ");
			printSet(inter);
			System.out.print("Difference: ");
			printSet(diff);

		}// end main
		while (elements >= 0);

	}// end lab5
	
	public static void printSet(String[] doneSort){
		for (int i = 0; i < doneSort.length; i++) {
			if (i == doneSort.length - 1) {
				System.out.print("{");
				System.out.print(doneSort[i]);
				System.out.print("}");

			} else {
				System.out.print("{");
				System.out.print(doneSort[i]);
				System.out.print("}");
				System.out.print(",");
			}

		}// end for printarray
		System.out.println("");
	}

	public static String[] Intersection(String[] a, String[] b){
		String[]set = new String[a.length];
        boolean pass = false;
        boolean fPass = false;
        int counter=0;
		for(int i=0;i<a.length;i++){
			if(fPass == false){
				for(int j=0; j<b.length&&pass==false;j++){
					if(a[i].contains(b[j])){
						set[i] = b[i];
						pass = true;
						
					}
				}
			}
			if(pass==true){
				set[counter++] = b[i-1];
				counter++;
			}
			pass=false;
			fPass = true;
			for(int j=0; j<b.length&&pass==false;j++){
				if(a[i].contains(b[j])){
					set[i] = b[i];
					pass = true;
					
				}
			}
		}
		return set;
	  }
	
	
		  public static String[] findUnion(String[]... arrays) {//takes multiple arrays
			int maxSize = 0;
			int counter = 0;//for amount of variable not repeated and unioned
	 
			for (String[] array : arrays)//for loop thru all arrays and get the max size
				maxSize += array.length;
			String[] temp = new String[maxSize];//creation of max size of union arrays
	 
			for (String[] array : arrays)//for loop for the arrays passed into method
				for (String i : array)//picks first arrays [ith] element and loops thru 
					if (!findDuplicated(temp, counter, i))//checks for duplicate
						temp[counter++] = (i);//if no duplicate, copies to temp array and then increments counter
	 
			String[] result = new String[counter];//creation of just elements unioned and not repeated
			for (int i = 0; i < counter; i++)
				result[i] = temp[i];
	 
			return result;
		}
	 
	public static boolean findDuplicated(String[] array, int counter, String value) {
		for (int i = 0; i < counter; i++)
			if (array[i].equals( value))
				return true;
		return false;
	}
	
	public static String[] difference(String[]a, String[]b){
		String[]set = new String[a.length];
		boolean blip = true;
		boolean first = true;
		
			for(int j=0; j<b.length||blip==true;j++){
				if(blip==true&&first == false){ //if 
					set[j-1] = a[j-1];
				}
				first = false; //1st pass
				blip=true; //resets blip to true for next loop
				if(j==b.length)//stops if last one is not in set, no need for loop again 
					blip=false;
				for(int h=0; h<b.length&&blip==true; h++){
				 if(a[j].contains(b[h])){
					blip = false;
					
				}else{
					blip=true;
				}
			}
		}

		return set;
		
	}
	  public static boolean isDuplicated(int[] array, int counter, int value){
	        for(int i = 0; i < counter; i++) if(array[i] == value) return true;
	        return false;
	    }
	
}

