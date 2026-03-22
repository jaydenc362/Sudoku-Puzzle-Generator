public class SudokuPuzzleGenerator {
    public static void main(String[] s) {
        int[][] board = new int[9][9];
        System.out.println("Jayden Chan P5 Sudoku Puzzle Generator:\n");
        generateSudoku(board);
        printSudoku(board);
        System.out.println();
    }
    
    public static void printSudoku(int[][] b) {
        System.out.println("+ - - - - - - - - - +");
        for (int y = 0; y < 9; y++) {
            System.out.print("| ");
            for (int x = 0; x < 8; x++) {
                System.out.print(b[y][x] + " ");
            }
            System.out.println(b[y][8] + " |");
        }
        System.out.println("+ - - - - - - - - - +");
    }
    
    public static void generateSudoku(int[][] b) {
        // Fill diagonal 3x3 boxes first for optimization
        int[] randomNine1 = generateRandomNine();
        int[] randomNine2 = generateRandomNine();
        int[] randomNine3 = generateRandomNine();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                b[y][x] = randomNine1[y * 3 + x];
            }
        }
        for (int y = 3; y < 6; y++) {
            for (int x = 3; x < 6; x++) {
                b[y][x] = randomNine2[(y - 3) * 3 + (x - 3)];
            }
        }
        for (int y = 6; y < 9; y++) {
            for (int x = 6; x < 9; x++) {
                b[y][x] = randomNine3[(y - 6) * 3 + (x - 6)];
            }
        }
        
        // Fill rest
        fillSudoku(b);
    }
    
    public static boolean fillSudoku(int[][] b) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (b[y][x] == 0) {
                    int[] randomNine = generateRandomNine();
                    for (int n : randomNine) {
                        if (validateNumber(b, y, x, n)) {
                            b[y][x] = n;
                            // If number works
                            if (fillSudoku(b)) return true;
                            b[y][x] = 0;
                        }
                    }
                    // If no number works
                    return false;
                }
            }
        }
        // Must return something when done
        return true;
    }
    
    public static boolean validateNumber(int[][] b, int y, int x, int n) {
        // Check boxes
        int boxY = y / 3 * 3;
        int boxX = x / 3 * 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (b[boxY + r][boxX + c] == n) return false;
            }
        }
        // Check rows and columns
        for (int i = 0; i < b.length; i++) {
            if (b[y][i] == n || b[i][x] == n) return false;
        }
        return true;
    }
    
    public static int[] generateRandomNine() {
        // Fisher yates shuffle
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = a.length - 1; i > 0; i--) {
            int random = (int) (Math.random() * (i + 1));
            int temp = a[i];
            a[i] = a[random];
            a[random] = temp;
        }
        return a;
    }
}