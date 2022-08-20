package javaRoid;

public class Player {
    private Game game;
    private int score;
    private int coinPos = 0;


    /*************** getter and setter score ************************/
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void getCoin(){
        if(game.blacyObject.collision()){
            game.coinObject.XYRandom();
            score+=10;
            game.blacyObject.SetLengthOfBlacy();
        }
    }
    public void getCoinPos(){
        if(coinPos==0){
            game.coinObject.XYRandom();
            coinPos++;
        }
    }

    /********************* Blacy VS Wall *******************************/
    public void BlacyVsWall (){
        if(game.wallObject.collision()){
            game.SetGameOver(false);
        }
    }
        // Wall VS Coin
    public void CoinVsWall () {
        if(game.wallObject.Collision2()){
        game.coinObject.XYRandom();
    }
    }


    public Player(Game game){
        this.game = game;
    }
}
