package com.gustavo.dataStructure.nonlinear;

/**
 * @author Gustavo
 *
 */
public class CrazyTest {
	public static void main(String[] args) {
		int[][] test = {
				{0,1,1,0,1},
				{0,1,0,1,0},
				{0,0,0,0,1},
				{0,1,0,0,0}
				};
		SimpleGraphSolution solution = new SimpleGraphSolution(4, 5);
		int counter = 0;
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {				
				if (test[i][j] == 1) {
					solution.assignData(counter);					
				}
				counter++;
			}
		}
		
		// [0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0] -< right
		System.out.println(solution);
		
		// [1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 2, 1, 2, 1, 0, 1, 0, 1, 2, 1] <- right
		
		// [1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1] <- current
		
		System.out.println(solution.distanceMap());
	}
}
