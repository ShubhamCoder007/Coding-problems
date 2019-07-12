/*Given a 2-D matrix representing an image, a location of a pixel in the screen and a color C, replace the color of the given pixel and all adjacent same colored pixels with C.

For example, given the following matrix, and location pixel of (2, 2), and 'G' for green:

B B W
W W W
W W W
B B B
Becomes

B B G
G G G
G G G
B B B
*/


class Pixel 
{
	public static boolean valid(char[][] a, int row, int col, char val){
		if(row == -1 || col == -1 || row >= a.length || col >= a[0].length)
			return false;
		return a[row][col] == val;
	}
	
	public static void pixelUpdate(char[][] a, int row, int col, char val, char original){
		if(!valid(a, row, col, original))
			return;
		
		a[row][col] = val;

		pixelUpdate(a, row + 1, col, val, original);
		pixelUpdate(a, row, col + 1, val, original);
		pixelUpdate(a, row - 1, col, val, original);
		pixelUpdate(a, row, col - 1, val, original);
	}
	
	public static void display(char[][] a){
		System.out.println("Displaying the matrix: ");
		for(char[] b : a){
			for(char c : b)
				System.out.print(" "+c+" ");
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args)
	{
		char[][] a = {
				{'W', 'B', 'W'},
				{'B', 'W', 'W'},
				{'W', 'W', 'W'},
				{'B', 'B', 'B'}
				};
				
		display(a);
				
		pixelUpdate(a, 2, 2, 'G', a[2][2]);
		
		display(a);
		
	}
}
	