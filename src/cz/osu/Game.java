package cz.osu;

public class Game {
    private int[][] grid;

    public Game(){
        grid = new int[][]{
                {0,0,0,0,0,0,0,6,0},
                {0,0,3,0,0,0,0,0,0},
                {1,0,8,7,0,0,0,0,0},
                {0,9,0,0,6,5,0,0,0},
                {0,0,0,0,0,0,8,0,3},
                {0,0,0,0,9,0,0,0,0},
                {0,0,4,0,2,0,0,0,0},
                {0,6,0,0,0,0,0,5,0},
                {0,0,0,8,0,0,1,0,0}
        };
    }

    private boolean possible(int x, int y, int n){
        for(int i=0; i < 9; i++){
            if(grid[y][i] == n){
                return false;
            }
        }
        for(int i=0; i < 9; i++){
            if(grid[i][x] == n){
                return false;
            }
        }

        int xSquare = Math.floorDiv(x,3)*3;
        int ySquare = Math.floorDiv(y,3)*3;
        for(int i = ySquare; i<ySquare+3; i++){ // y
            for(int u = xSquare; u<xSquare+3; u++){ //x
                if(grid[i][u] == n){
                    return false;
                }
            }
        }
        return true;
    }

    public void solve(){
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 9; x++){
                if(grid[y][x] == 0){
                    for(int n = 1; n < 10; n++){
                        if(possible(x,y,n)){
                            grid[y][x] = n;
                            solve();
                            grid[y][x] = 0;
                        }
                    }
                    return;
                }
            }
        }
        printGrid();
    }

    public void printGrid(){
        for(int i = 0; i < 9; i++){
            System.out.println(String.format("%d %d %d %d %d %d %d %d %d", grid[i][0],grid[i][1],grid[i][2],grid[i][3],grid[i][4],grid[i][5],grid[i][6],grid[i][7],grid[i][8]));
        }
    }
}
