/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * Mario Saiz & Marc Valdoria
 * Artificial Intelligence: Checkers
 */
/**
 *
 * @author phil
 */
public class AIblackMove {

    CheckersGame currentGame;
    CheckersMove legalMoves[];
	
	int iter;

    public AIblackMove(CheckersGame game, CheckersMove moves[]) {
        currentGame = game;
        legalMoves = moves;
		iter = 5;
    }

    public CheckersMove nextMove() {
        return minmax(currentGame.boardData, iter);
    }
	
    public class Shift{
	
        public int value;
	public CheckersMove move;
	
	public Shift(int x, CheckersMove y){
            value = x;
            move = y;
		
	}
    }
	CheckersMove minmax(CheckersData x, int iter){
		CheckersData b = new CheckersData(x);
		CheckersMove z = new CheckersMove(0,0,0,0);
		CheckersMove blackMoves[] = b.getLegalMoves(CheckersData.BLACK);
		
		if(blackMoves != null && blackMoves.length > 0){
			z = blackMoves[0];
			int m = Integer.MIN_VALUE;
			
                        for(int i = 0; i<blackMoves.length; i++){
				b = new CheckersData(x);
				b.makeMove(blackMoves[i]);

				if(!makeBestRedMove(b))
					return blackMoves[i];
                                        int n = evaluate(b);

				if(iter > 0 && n > 0){
					b.makeMove(minmax(b, iter - 1));
					int d = evaluate(b);

					if(d > m){
						m = d;
						z = blackMoves[i];
					}
				}
				else{
					if(n > m){
						m = n;
						z = blackMoves[i];
					}
				}
				
			}
		}
		return z;
	}

	boolean makeBestRedMove(CheckersData board){
		CheckersMove redMoves[] = board.getLegalMoves(CheckersData.RED);

		if(redMoves != null && redMoves.length > 0) {
			CheckersMove a = redMoves[0];
			int q = Integer.MAX_VALUE;

			for(int i = 0; i<redMoves.length; i++){
				CheckersData redTest = new CheckersData(board);
				redTest.makeMove(redMoves[i]);
				
				int t = evaluate(redTest);
				if(t < q){
					q = t;
					a = redMoves[i];
				}
			}
			board.makeMove(a);
			return true;
		}
		return false;
	}

    int evaluate(CheckersData board) {
		int e = 0;

		for(int y = 0; y < 8; y++){
			for(int x = Math.floorMod(y,2); x < 8; x+=2){ 

				int p = board.pieceAt(x,y);
				int v = 0;
				switch(p){
					case CheckersData.BLACK:
						v = 2;
						break;
					case CheckersData.BLACK_KING:
						v = 4;
						break;
					case CheckersData.RED:
						//v = -1;
						v=-2;
                                                break;
					case CheckersData.RED_KING:
						//v = -2;
                                                v=-4;
						break;
				}

				e += (CheckersData.boardValues[0][0] * v); 
			}
		}

        return e;
    }
}

