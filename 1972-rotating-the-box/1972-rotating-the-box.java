class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m=boxGrid.length;
        int n=boxGrid[0].length;

        char [][] rotatedBox=new char[n][m];

        // lets apply the gravity

        for(int i=0;i<m;i++){
            int emptyspaceIdx=n-1;
            for(int j=n-1;j>=0;j--){
               if(boxGrid[i][j]=='#'){
                boxGrid[i][j]='.';
                boxGrid[i][emptyspaceIdx]='#';
                emptyspaceIdx--;

               }else if(boxGrid[i][j]=='*'){
                emptyspaceIdx=j-1;
               }
            }
        }

        // Now lets rotate the matrix by 90 degree

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               rotatedBox[j][m-1-i]=boxGrid[i][j];
            }
        }

        return rotatedBox;


    }
}