package hw_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

import java.util.Scanner;

/** Description of MyClass 
*
* @author Aaron Stahley
* @version 1.0 Jan 3, 2017.
* 
*/

public class MagicSquare {
	
	
	private static Scanner scan;
	
	/** Description of myMethod(int[][] array2D, int listSize, int rowSize)
	 * 
	 * @param array2D		takes in the 2D array that the holds the magic square values.
	 * @param listSize 		takes in the list size of the initial list that holds all magic square values.
	 * @param rowSize		Since the array is a perfect square you only need the row size.
	 * @return 				returns if the magic square containes all number up to n^2 
	 */
	private static boolean checkIfValid(int[][] array2D, int listSize, int rowSize)
    {
        // Makes a counter array to keep track of the number of times a number appears
        int[] countArray = new int[listSize + 1];

        for (int i = 1; i < listSize + 1; i++){
            countArray[i] = 0;
        }

        // Iterates through the values in the magic square
        for (int row = 0; row < rowSize; row++)
        {
            for (int col = 0; col < rowSize; col++)
            {
            	
                if (array2D[row][col] < 1 || array2D[row][col] > listSize){
                    return false;
                }

                // adds to the count
                countArray[array2D[row][col]]++;
            }
        }

        for (int i = 1; i < listSize; i++){
            if (countArray[i] != 1){
                return false;
            }
        }

        return true;
    }
	
	/** Description of calculateSums(int[][] array2D, int rowSize, ArrayList<Integer> list)
	 * 
	 * @param array2D		takes in the 2D array that the holds the magic square values.
	 * @param rowSize		Since the array is a perfect square you only need the row size.
	 * @param list			passes the original list that the user interned.
	 * @return				returns true or false, true for being a magic square and false for not being a magic square.
	 * 
	 */
	private static boolean calculateSums(int[][] array2D, int rowSize, ArrayList<Integer> list)
    {

		// This will be the first initial sum in which the rest of the sums will be compared to
		// in order to determine if it is a magic square or not. All sums have to equal this 
		// Initial sum to be a magic square.
		int finalSum = 0;
		
		// gets the sum of the first column to compare the values for the rest of the values.
		for(int ii = 0; ii < rowSize; ii++){
			
			finalSum = (int) finalSum + list.get(ii);
			
		}
		
    	// sums all rows
        for (int i = 0; i < rowSize; i++)
        {
        	int sum = 0;
            for (int j = 0; j < rowSize; j++){
            	
                sum += array2D[i][j];
                
                }
           
            if(sum != finalSum){
            	return false;
            }
            
        }

        
        // sums each column
        for (int j = 0; j < rowSize; j++)
        {
            int sum = 0;
            for (int i = 0; i < rowSize; i++)
                sum += array2D[i][j];
            
            if (sum != finalSum){
                return false;
            }
            
        }
        
        int sum = 0;
        
        // Sums the first Diagonal
        for (int row = 0; row < array2D.length; row++){
        	
            sum += array2D[row][row];
            
        }
       
        
        if(sum != finalSum){
        	return false;
        }
        
        sum = 0; // clears the sum variable
        
        // Sums the other diagonal
        for(int i=0; i< rowSize; i++){
             sum += array2D[i][rowSize-(i+1)];
        }
        
        if(sum != finalSum){
        	return false;
        }
        
        // If all sums are equal to the initial sum than it is a magic square.
        return true; 
    }


	public static void main(String[] args) {
		
		int n = 0; 
		int count = 0; 
		
		boolean isValid = false;

		scan = new Scanner(System.in);
		
		List<Integer> arrayList = new ArrayList<Integer>();
		
		int[][] array2D = null; 
		
		
	// While loop will run fine but the second time it runs there is issues.
		
		while(isValid == false){
			
			System.out.println("Enter the values of the magic square below separated by a space.");
			System.out.println("End the sequence with any letter and press enter");
			 
			
			while(scan.hasNextInt() == true){
				arrayList.add(scan.nextInt()); // Loads the list with user inputs until scanner recognizes a non integer.
			}
			
		
			// Determines the size of the rows and columns of the 2D array. 
			n = (int) Math.sqrt(arrayList.size());		 
			 
			// Sets the size of the 2D array.
			 array2D = new int[n][n];
			
			 // Reading in the values from the arrayList into the 2D array.
			 for(int row = 0; row < array2D.length; row++){
				 for(int col = 0; col < array2D[row].length; col++){
					 
					 array2D[row][col] = arrayList.get(count++);
					 
				 }
			 }
			
			 // Checking to see if input satisfies the conditions of a magic square.
			if(arrayList.size() >= 4 && checkIfValid(array2D,arrayList.size(),n) == true && arrayList.size() == Math.pow(n,2)){
				isValid = true; 
			}

			else{
				scan.next(); // This clears the scanner so that it can be used again in the loop. 
				arrayList.clear(); // Clears the list to be loaded again. 
				array2D = null;
				count = 0; 
				n = 0;
			
			}
		}
		

		 // Prints the magic square
		 for (int i = 0; i < array2D.length; i++) {
			    for (int j = 0; j < array2D[i].length; j++) {
			        System.out.print(array2D[i][j] + " ");
			    }
			    System.out.println();
		 }
		 
		 System.out.println();
		 System.out.println(calculateSums(array2D,n,(ArrayList<Integer>) arrayList));
			
		
	}

}
