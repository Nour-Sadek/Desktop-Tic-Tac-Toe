# Desktop-Tic-Tac-Toe

### About

This project creates a desktop version of the game Tic-Tac-Toe using the Swing graphics library. 

It includes four game modes:
- Human vs Human
- Human vs Robot
- Robot vs Human
- Robot vs Robot

# General Info

To learn more about this project, please visit [HyperSkill Website - Desktop Tic-Tac-Toe](https://hyperskill.org/projects/174).

This project's difficulty has been labelled as __Challenging__ where this is how
HyperSkill describes each of its four available difficulty levels:

- __Easy Projects__ - if you're just starting
- __Medium Projects__ - to build upon the basics
- __Hard Projects__ - to practice all the basic concepts and learn new ones
- __Challenging Projects__ - to perfect your knowledge with challenging tasks

This repository contains

    tictactoe package
        - Contains the ApplicationRunner java class that contains the main method to run the project
        - Contains the TicTacToe java class that builds the main frame of the program and contains all other components
        - Contains the PlayingField java class that builds the center playing field component (field containing the 9 cells of the game)
        - Contains the Cell java class which represents one of the nine cells on the field as JButtons
        - Contains the PlayerType enum that describes a player as either HUMAN or ROBOT
        - Contains the GameMode enum that describes the current game mode and displays it on the screen as a JLabel
        - Contains the StatusStartReset enum that describes the status of the start/reset button located on the middle upper portion of the screen

Project was built using java 21

# How to Run

Download the tictactoe repository to your machine. Create a new project in IntelliJ IDEA, then move the downloaded
repository to the src folder and run the ApplicationRunner java class.