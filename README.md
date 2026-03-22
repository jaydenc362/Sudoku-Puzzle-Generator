Sudoku Puzzle Generator
Jayden Chan Period 5

My program, like the name says, is a Sudoku puzzle generator.
Sudoku is a nine by nine puzzle, each tile either empty or filled with a number.
The numbers on the Sudoku board must follow these rules: It cannot repeat on the same row, column, or inside its 3 by 3 box.
The goal of the puzzle is to fill out the empty tiles.
However, my program only generates a valid Sudoku puzzle solution, not exactly a puzzle for users to solve.

To run the program, copy the entire SudokuPuzzleGenerator.java file into any online live editor. Select Java, then hit run. The program will automatically generate a puzzle.

For optimization purposes, my program fills the top left, middle, and bottom right 3 by 3 boxes of the Sudoku board.
In each of those boxes, it shuffles numbers from 1 to 9, and fills each tile in each box in order with the shuffled numbers.
This is guaranteed to fill numbers while maintaining a valid Sudoku board since by only going through the diagonals, it’s impossible for a number to be in the same row or column with another copy, as long as each 3 by 3 box is also filled with completely unique numbers.
This fills out 27 numbers with O(1) efficiency.
After optimizing the most amount of tiles, I then use a recursion process to fill the rest of the tiles.
Going through each tile, my program shuffles numbers from 1 to 9, and tries a number.
If the number is invalid by breaking any rules of Sudoku or being filled already, it tries another or goes on.
If the number is valid, it’s important to check whether the future of the Sudoku board will also be valid, since it’s possible that the numbers the program puts before makes it impossible to complete the board.
If it can successfully fill the whole board, then it’s done.
If it cannot, then it erases its progress up to the number that caused the problem, then tries a new number.
This recursive process continues until the board is complete.

Files:
- SudokuPuzzleGenerator.java
- Sudoku Design.pdf
- README.md
