# ❌⭕ Tic-Tac-Toe (Tres en Raya) en Java

Classic Tic-Tac-Toe game developed from scratch in **Java (Swing)** using first principles, matrices, and custom event handling without external component libraries.

## 🚀 Features
- **3x3 Grid State Management:** Direct matrix representation (`char[][] tablero`) to track cell states (`'x'`, `'o'`, `' '`).
- **Algorithm & Validation Logic:** Automated win-checking across rows, columns, and both diagonals, plus strict turn validation and draw detection (`turno == 9`).
- **Interactive GUI:** Built using `JFrame`, `JButton`, and `ActionListener` event handling in Java Swing.
- **State Protection:** Prevents overwriting occupied cells and locks the board once a win condition or a tie is reached.

## 🛠️ Tech Stack
- **Language:** Java
- **UI Framework:** Java Swing (`JFrame`, `JButton`, `JLabel`)
- **Concepts:** Object-Oriented Programming (OOP), 2D Arrays, Event-Driven Programming.

## 🎮 How to Run
1. Clone the repository:
   ```bash
   git clone [https://github.com/RediSlayer/tic-tac-toe.git](https://github.com/RediSlayer/tic-tac-toe.git)
2. Compile and run the main class:
     javac TicTacToe.java
     java TicTacToe

