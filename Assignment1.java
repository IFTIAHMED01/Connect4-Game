// I have used Dr. Java here
// Name - IFTI AHMED
// Student ID - 6559348
// Course-3p71 Assignment-1

import java.util.Scanner;
public class Assignment1 {
  
  //This method is used to see whether there are many moves left or not in the board
  public static boolean AnyMovesLeft( char eri[][]){
    
      for(int j=0;j<7; j++) { 
        for(int i=5;i>=0; i--) {
        if(eri[i][j]=='_') { return true; }
      }
    }
    return false;
  }
  public static void PrintConnect4GameBoard ( char eri[][]){
    for(int i=0;i<6; i++) {
      for(int j=0;j<7; j++) { 
        System.out.print(' ');
        System.out.print(eri[i][j]);
        System.out.print(' ');
      }
       System.out.println();
      }
  }
  
  //This method is used as a evaluation function to determine whether Player or AI wins
  //So, if player wins, then 100 points will be given, if AI wins, -100 points will be given, for tie it will be 0 points.
  public static int heuristicfunction (char [][] eri, char player, char AI){
    //Firstly, we are gonna check rows for Player or AI victory
    for(int i=5;i>=0; i--){
       if( (eri[i][0]==eri[i][1]&&eri[i][1]==eri[i][2]&&eri[i][2]==eri[i][3]) || (eri[i][1]==eri[i][2]&&eri[i][2]==eri[i][3]&&eri[i][3]==eri[i][4]) || 
          (eri[i][2]==eri[i][3]&&eri[i][3]==eri[i][4]&&eri[i][4]==eri[i][5])||(eri[i][3]==eri[i][4]&&eri[i][4]==eri[i][5]&&eri[i][5]==eri[i][6])){
            if ( (eri[i][0] == player) || (eri[i][1] == player) || (eri[i][2] == player) || (eri[i][3] == player) ) {return +100;}
            else if ((eri[i][0] == AI) || (eri[i][1] == AI) || (eri[i][2] == AI) || (eri[i][3] == AI) ) {return -100;}
         
      }
    }
    
    //Then, we are gonna check columns for Player or AI victory
    for(int j=0;j<7;j++){
      if( (eri[5][j]==eri[4][j]&&eri[4][j]==eri[3][j]&&eri[3][j]==eri[2][j]) ||(eri[4][j]==eri[3][j]&&eri[3][j]==eri[2][j]&&eri[2][j]==eri[1][j]) || 
        (eri[3][j]==eri[2][j]&&eri[2][j]==eri[1][j]&&eri[1][j]==eri[0][j])){
          if ( (eri[5][j] == player) || (eri[4][j] == player) || (eri[3][j] == player) ) {return +100;}
          else if ( (eri[5][j] == AI) || (eri[4][j] == AI) || (eri[3][j] == AI)) {return -100;}
      
      }
    }
    
    //Then, we are gonna check diagonals for Player or AI victory
    if((eri[5][0]==eri[4][1]&&eri[4][1]==eri[3][2]&&eri[3][2]==eri[2][1]) || (eri[4][1]==eri[3][2]&&eri[3][2]==eri[2][3]&&eri[2][3]==eri[1][4]) ||
       (eri[3][2]==eri[2][4]&&eri[2][4]==eri[1][5]&&eri[1][5]==eri[0][6])){
        if( (eri[5][0]==player) || (eri[4][1]==player) || (eri[3][2]==player)){return +100;}
        else if( (eri[5][0]==AI) ||(eri[4][1]==AI) || (eri[3][2]==AI) ){return -100;}
       
    }
    if((eri[5][6]==eri[4][5]&&eri[4][5]==eri[3][4]&&eri[3][4]==eri[2][3]) || (eri[4][5]==eri[3][4]&&eri[3][4]==eri[2][3]&&eri[2][3]==eri[1][2]) ||
       (eri[3][4]==eri[2][3]&&eri[2][3]==eri[1][2]&&eri[1][2]==eri[0][1]) ){
         if (eri[5][6]==player || (eri[4][5]==player) || (eri[3][4]==player)){return +100;}
         else if( (eri[5][6]==AI) ||(eri[4][5]==AI) || (eri[3][4]==AI) ){return -100;}
         
    }
    
     return 0;// This result is returned by tie.
  }
  // The concept of Minimax is taken from https://en.wikipedia.org/wiki/Minimax
  //Here player is a maximizer and AI is a minimizer
 public static int minimax(char [][]eri, int depth, boolean MaximizingPlayer){
   int value=0;
   if(depth==0){
     int points = heuristicfunction(eri,'O', 'X');
     return points;
   }heuristicfunction(eri,'O', 'X');
   if (MaximizingPlayer == true){
         value = -10000;
         heuristicfunction(eri,'O', 'X');
       for(int j=0;j<7;j++){
         for(int i=5;i>=0;i--){
           if(eri[i][j]=='_'){
          eri[i][j]= 'O';
          value= Math.max(value,minimax(eri,depth-1,false));
          eri[i][j]='_';
         }
       }
     }
       return value;
   }
   else if (MaximizingPlayer == false){
      value= 10000;
     for(int j=0;j<7;j++){
        for(int i=5;i>=0;i--){
         if(eri[i][j]=='_'){
          eri[i][j]= 'X';
          value= Math.min(value,minimax(eri,depth-1,true));
          eri[i][j]='_';
         }
        }
     }
     return value;
   }
   return value;
 }
 
 
 public static char [][] FindOptimalMoveforAI(char eri[][],char player, char AI){ 
   int bestvalue= 10000;

   boolean finished=false;
       for(int j=0;j<7 && !finished;j++){
        for(int i=5;i>=0;i--){
         if(eri[i][j]=='_'){
           eri[i][j]='X';
           int currentvalue= minimax(eri,4,false);
           
           if(currentvalue < bestvalue) {
             bestvalue=currentvalue;
             eri[i][j]= AI;
             finished=true;
             break;
           }
           else{eri[i][j]='_';}
         }
      }
   }
  
   return eri;
 }
 
  public static void main (String args[]){
    Scanner input = new Scanner(System.in);
    // This is creating board for Connect4 Game
    char eri [][] = new char [6][7];
    char player='O'; //This represents the human player
    char AI='X';// This represents AI player
    int count=0;//This represents the number of times Player has played
    // First, we will create empty spaces in the board using '_'
    for(int i=0;i<6; i++) {
      for(int j=0;j<7; j++) { eri[i][j]= '_';}
    }
    while(AnyMovesLeft(eri) == true){
    System.out.println(" Please choose a column : ");
    int e= input.nextInt();
    
    if( e<0 || e>6) { System.out.println("Invalid Move");}
    
    else{
    for(int i=5;i>=0;i--){ 
       if( eri[i][e]=='_'){eri[i][e] = player; count++; break;}
     } 
    
    PrintConnect4GameBoard (eri);
    FindOptimalMoveforAI(eri,player,AI); //This method finds optimal move for AI player
    
    System.out.println("Board after AI has played its move:");
    System.out.println();
    PrintConnect4GameBoard (eri);
    
    if(count==4){
      int score =  heuristicfunction(eri,'O', 'X');
      if(score==100){System.out.println("Player Wins");break;}
      else if(score==-100){System.out.println("AI Wins");break;}
      else if(AnyMovesLeft(eri)==false){System.out.println("Draw");break;}
      count=0;
    }
    
   }
  }
 }
}