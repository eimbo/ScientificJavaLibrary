/**
 * Matrix.java
 * 
 * Provides a Matrix object
 * 
 */

package scientific;


public class Matrix {

	private final int width, height;
	private int[][] matrix;

	public Matrix(int width, int height){
		this.width = width;
		this.height = height;
		matrix = new int[height][width];
	}

	public Matrix(int[][] matrix){
		this.matrix = matrix;
		this.height = matrix.length;
		this.width = matrix[0].length;
	}

	public Matrix setMatrix(int[][] matrix){
		if(matrix.length != height || matrix[0].length != width)
			return null;

		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				this.matrix[y][x] = matrix[y][x];
			}
		}
		return this;
	}

	public int getIndex(int x, int y){
		return matrix[y][x];
	}

	public void setIndex(int x, int y, int value){
		matrix[y][x] = value;
	}

	public int det(){
		if(width != height)
			return -1;

		if(width == 1)
			return matrix[0][0];
		else if(width == 2)
			return matrix[0][0]*matrix[1][1]+matrix[0][1]*matrix[1][0];
		else
			return -1;
		//TODO add determinant for more difficult sizes
	}

}
