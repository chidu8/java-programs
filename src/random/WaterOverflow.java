package random;

import java.util.Arrays;



public class WaterOverflow {


	public int calculateVolume(int [] heights) {

		int[] maxLeftHeight = new int[heights.length];

		int[] maxRightHeight = new int[heights.length];

		int sum = 0;

		for (int i=0;i<heights.length;i++) {

			maxLeftHeight[i] = Math.max(heights[i],i!=0?maxLeftHeight[i-1]:0);

		}

		for (int i=heights.length-1;i>=0;i--) {

			maxRightHeight[i] = Math.max(heights[i],i!=(heights.length-1)?maxRightHeight[i+1]:0);

		}

		System.out.println(Arrays.toString(maxLeftHeight));

		System.out.println(Arrays.toString(maxRightHeight));

		for (int i=0;i<heights.length;i++) {

			sum = sum + Math.min(maxRightHeight[i],maxLeftHeight[i]) - heights[i];

		}

		return sum;

	}

	public static void main(String[] args) {

		int[] heights1 = new int[]{4,1,2,5,0,2,1,0};

		int[] heights2 = new int[]{5,4,3,2};

		WaterOverflow w = new WaterOverflow();

		System.out.println(w.calculateVolume(heights1));

	}

}
