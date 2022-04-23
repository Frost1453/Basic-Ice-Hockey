package fr0sty.engine.framework;

import fr0sty.engine.objects.AIPlayer;
import fr0sty.engine.objects.Ball;

public class AIController {

    Handler handler;
    AIPlayer aiPlayer;
    Ball ball;

    int aiSpeed = 3;

    public AIController(Handler handler, AIPlayer aiPlayer, Ball ball) {
        this.handler = handler;
        this.aiPlayer = aiPlayer;
        this.ball = ball;
    }

    public void update() {
    	// AI PLAYER GETS BALL'S X POSITION, BALL'S WIDTH AND HEIGHT TO RECEIVE THE BALL
        if (ball.getX() > aiPlayer.getX() + 20 && ball.getY() < 471) {
            aiPlayer.setVelX(aiSpeed);
        } else if(ball.getX() < aiPlayer.getX()+20){
            aiPlayer.setVelX(-aiSpeed);
        } else
            aiPlayer.setVelX(0);

        //aiPlayer.setX(ball.getX()-35);
    }
}
