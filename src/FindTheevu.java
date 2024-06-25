import java.util.Arrays;
import java.util.stream.IntStream;

public class FindTheevu {

    static int totalIslands = 0;

    public static void main(String[] args) {
        Arrays.stream(getGrid()).forEach(System.out::println);
        char[][] grid = getGrid();
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j]=='1') {
                    totalIslands = totalIslands +1;
                    //grid[i][j] = '2';
                    deepSearchFourSides(grid,i,j,rows,columns);
                }
            }
        }
        System.out.println("Total Islands ='"+totalIslands+"'");
        IntStream.range(0, 8)
            .forEach(
                i -> IntStream.range(0, 8).forEach(j -> {
                    if(grid[i][j] =='2') grid[i][j] = '1';}
                ));
        Arrays.stream(grid).forEach(System.out::println);
    }

    private static void deepSearchFourSides(char[][] grid, int currentX, int currentY, int rows, int columns) {
        if (currentX < 0 || currentY < 0 || currentX >= rows || currentY >= columns) return;
        if (grid[currentX][currentY] == '0') return;
        if (grid[currentX][currentY] == '1') {
            grid[currentX][currentY] = '2';
            deepSearchFourSides(grid, currentX + 1, currentY, rows, columns);
            deepSearchFourSides(grid, currentX - 1, currentY, rows, columns);
            deepSearchFourSides(grid, currentX, currentY + 1, rows, columns);
            deepSearchFourSides(grid, currentX , currentY - 1, rows, columns);
        }
    }

    private static char[][] getGrid() {
        char[][] grid = {
            {'1', '1', '1', '1', '0', '0', '1', '0'},
            {'1', '1', '1', '1', '0', '0', '1', '0'},
            {'1', '1', '1', '1', '0', '0', '1', '0'},
            {'1', '1', '1', '1', '0', '0', '1', '1'},
            {'1', '1', '1', '1', '0', '0', '1', '0'},
            {'1', '1', '1', '1', '0', '0', '1', '0'},
            {'1', '1', '1', '1', '0', '0', '1', '0'},
            {'1', '1', '1', '1', '0', '0', '1', '0'}};
        return grid;
    }

/*    int n = alphabet.length();
    char[][] cs = new char[n][n];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cs[i][j] = alphabet.charAt((i + j) % n);
        }
    }

    IntStream.range(0, n)
    .forEach(
        i -> IntStream.range(0, n).forEach(j -> cs[i][j] = alphabet.charAt((i + j) % n)));
    */
}
