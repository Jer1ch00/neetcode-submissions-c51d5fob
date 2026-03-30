class Solution {
    public void rotate(int[][] matrix) {
        //transpose and reverse the rows
        //1. transpose means the rows become the columns
        //2. reverse is reverse 
        for(int i =0; i<matrix.length; i++) {
            for(int j=i;j<matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //matrix reversal now
        for(int i=0;i<matrix.length; i++) {
            for(int j = 0; j<matrix.length/2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}