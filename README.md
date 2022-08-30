# Project - Connect4 Game
# • Creating a Connect4 game for 2 players (human and AI) using minimax algorithm.
<b>So, I did my program in Dr. Java using Java as a programming language.</b></br>
First, I created an empty board using 2D Array and fill it with ‘_’.  ‘_’ represents the empty space in my array and my game board is of dimension 6x7. I declared 2 variables (player and AI). Player represents ‘O’ and AI represents ‘X’. I also declared the count variable which determines how many turns the Player got.
Then, AnyMovesLeft method will determine whether there are any spaces left in the 2D Array. If there is, which means AnyMoveLeft(eri)=true, then we will enter the while loop.
So, my program asks the user for input (variable e) which determines what column the user(player) wants to put the value in. If the value is less than 0 or greater than 6, then the program will print Invalid Move.
So, assuming, it is a valid input, it will print the board using PrintConnect4GameBoard method with the player’s move on it. Then, FindOptimalMoveforAI method will be used to used to determine an optimal move for AI using minimax method and heuristicfunction method. Then, Player will play its turn again. This will continue until we get a result (Player Wins, AI Wins, Draw).
Here player is a maximizer and AI is a minimizer in the minimax method.</br>
heuristicfunction method is used as an evaluation function to determine whether Player or AI wins. So, if player wins, then 100 points will be given, if AI wins, -100 points will be given, for tie it will be 0 points. So, in this method, we are going to check rows for Player or AI victory. Then, we are gonna check columns for Player or AI victory. Lastly, we are going to check diagonals for Player or AI victory.
So, to get the result, if the count variable gets to 4, then we are going to use heuristicfunction method to check for result. And, we are going to store the result from heuristicfunction method in the form of variable score. So, if score = 100, then print Player Wins, and break out of the while loop in the main method using exit option in java. Else if score = -100, then print AI Wins, and break out of  the while loop in the main method using exit option in java. And, lastly, if AnyMovesLeft(eri)= false, then print Draw, and break out of the while loop in the main method using exit option in java, as it means there are no moves left remaining in Connect4 Game Board. If none of this if else statements matches for the result, then reset the count to 0, then continue with the game to get a result.