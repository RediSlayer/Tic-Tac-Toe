# ❌⭕ Tic-Tac-Toe (Tres en Raya) in Java

Classic Tic-Tac-Toe game developed from scratch in Java (Swing), using matrices, custom event handling and no external libraries. Play 1 vs 1 locally or against an **unbeatable AI** powered by the **Minimax** algorithm.

## 🚀 Features

- **Main menu** to choose the game mode
- **1 vs 1 Local** mode
- **Player vs AI** mode: Minimax explores the whole game tree, so the AI never loses (best case for you is a draw)
- **3x3 grid state management**: direct matrix representation (`char[][] tablero`) to track cell states (`'X'`, `'O'`, `' '`)
- **Win and draw detection** across rows, columns and both diagonals
- **State protection**: prevents overwriting occupied cells and locks the board once the game ends
- **Back to menu** button shown when a game finishes
- Clean UI with different colors for X and O
- Online multiplayer mode (coming soon)

## 🛠️ Tech Stack

- **Language:** Java (JDK 11+)
- **UI Framework:** Java Swing (`JFrame`, `JPanel`, `JButton`, `JLabel`, `CardLayout`)
- **Concepts:** Object-Oriented Programming (OOP), MVC architecture, 2D arrays, event-driven programming, recursion and backtracking (Minimax)

## 📁 Project Structure

```
src/
├── controlador/
│   └── VentanaPrincipal.java   # Game flow and screen switching (Controller)
├── modelo/
│   ├── Tablero.java            # Board state and game rules (Model)
│   └── MinimaxIA.java          # Minimax AI (Model)
└── vista/
    ├── PanelMenu.java          # Main menu screen (View)
    └── PanelJuego.java         # Game board screen (View)
```

| Layer | Classes | Responsibility |
|-------|---------|----------------|
| Model | `Tablero`, `MinimaxIA` | Game rules and AI decisions |
| View | `PanelMenu`, `PanelJuego` | Graphical interface |
| Controller | `VentanaPrincipal` | Connects the view with the model |

## 🎮 How to Run

1. Clone the repository:

```bash
git clone https://github.com/RediSlayer/tic-tac-toe.git
cd tic-tac-toe
```

2. Compile and run from the project root (the folder containing `src/`):

**Linux / macOS**

```bash
javac -d out $(find src -name "*.java")
java -cp out src.controlador.VentanaPrincipal
```

**Windows (PowerShell)**

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java src).FullName
java -cp out src.controlador.VentanaPrincipal
```

## 🕹️ How to Play

1. Choose a game mode in the main menu.
2. Player **X** always goes first.
3. Click an empty cell to place your mark.
4. The first player to get three marks in a row (horizontally, vertically or diagonally) wins.
5. When the game ends, press **Menú Principal** to go back to the menu.

## 🤖 How the AI Works

The AI uses the **Minimax** algorithm: it simulates every possible game from the current board, assuming the opponent plays perfectly, and picks the move with the best outcome.

| Outcome | Score |
|---------|-------|
| AI wins | +10 |
| Draw | 0 |
| Player wins | -10 |

## 🔮 Roadmap

- [ ] Online multiplayer
- [ ] Difficulty levels (AI with random mistakes)
- [ ] Alpha-beta pruning
- [ ] Score counter
- [ ] Highlight the winning line

## 👤 Author

Created by **RediSlayer**.
