/*You are given an array of integers, where each element represents the maximum number of steps that can be jumped going
forward from that element. Write a function to return the minimum number of jumps you must take in order to get from 
the start to the end of the array.
For example, given [6, 2, 4, 0, 5, 1, 1, 4, 2, 9], you should return 2, as the optimal solution involves 
jumping from 6 to 5, and then from 5 to 9. */

import java.util.LinkedList;

public class MinJumps {

	static LinkedList<Integer> l = new LinkedList<>();
	
	public static int minJumps(int[] a) {
		if(a.length == 0 || a[0] <= 0)
			return -1;
		if(a.length == 1 || a[0] >= a.length)
			return 1;
		
		int s = a[0];
		int steps = 1;
		int loc = -1;
		int max = Integer.MIN_VALUE;
		l.add(0);
		
		for(int i = 1; i <= s; i++) {
			if(s >= a.length)
				break;
			
			if(max < s + a[i]) {
				max = s + a[i];
				loc = i;
			}
			
			if(i == s) {
				i = loc;
				s = max;
				steps++;
				l.add(loc);
			}
		}
		
		return steps;
	}
	
	public static void main(String[] args) {
		int[] arr = {6, 2, 4, 0, 5, 1, 1, 4, 2, 9};
		
		for(int i : arr)
			System.out.print(i+" ");
		
		System.out.println("\nMin jumps: "+minJumps(arr));
		
		System.out.println("Jumps taken from indexes: "+l);
	}

}
