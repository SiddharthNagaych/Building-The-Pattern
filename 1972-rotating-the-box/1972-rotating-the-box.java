class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m=boxGrid.length;
        int n=boxGrid[0].length;
        char [][] res=new char[n][m];

        // applyting the gravity in the original arr

        for(int i=0;i<m;i++){
            int emptySpace=n-1;
            for(int j=n-1;j>=0;j--){
                if(boxGrid[i][j]=='#'){
                    boxGrid[i][j]='.';
                    boxGrid[i][emptySpace]='#';
                    emptySpace--;
                }else if(boxGrid[i][j]=='*'){
                    emptySpace=j-1;
                }
            }
        }

        // rotating the arr

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[j][m-1-i]=boxGrid[i][j];
            }
        }

        return res;
    }
}