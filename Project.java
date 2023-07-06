public class Project {
    public static void main(String[] args){

        if(args.length != 0){ //this game does not take any command line arguments
            System.err.println("Error: This game does not take any command line arguments");
            System.exit(1);
        }

        StdDraw.enableDoubleBuffering();

        //Mario's initial position
        double Mx = 0; double My = .2;

        //Turtle initial positions
        double Tx = .8; double Ty = .2;
        double Tx2 = .4; double Ty2 = .2;
        double Tx3 = 1; double Ty3 = .2;
        double Tx4 = .7; double Ty4 = .23;
        double Tx5 = .4; double Ty5 = .2;
        double Tx6 = .8; double Ty6 = .2;

        double Tx7 = .53; double Ty7 = .23;
        double Tx8 = .68; double Ty8 = .23;
        double Tx9 = .8; double Ty9 = .23;

        double Tx10 = .9; double Ty10 = .25; //fireballs
        double Tx11 = .5; double Ty11 = .25; //fireballs

        int [] trackArray = new int [2];
        trackArray[0] = 3; //number of lives
        trackArray[1] = 1; //level number

        //Coins and score
        int [] CoinArray = new int [100];
        CoinArray[0] = 0; //score keeper

        CoinArray[1] = 0; //coin 1 does not exist
        CoinArray[2] = 0; //coin 2 does not exist

        CoinArray[3] = 1; //coin 3 exists in level 2
        double Cx3 = .42; double Cy3 = .53;
        CoinArray[4] = 1; //coin 4 exists in level 2
        double Cx4 = .59; double Cy4 = .53;

        CoinArray[5] = 1; //coin 5 exists in level 3
        double Cx5 = .12; double Cy5 = .53;
        CoinArray[6] = 1; //coin 6 exists in level 3
        double Cx6 = .29; double Cy6 = .53;

        CoinArray[7] = 1; //coin 7 exists in level 5
        double Cx7 = .32; double Cy7 = .3;
        CoinArray[8] = 1; //coin 8 exists in level 5
        double Cx8 = .41; double Cy8 = .3;

        StdAudio.loopInBackground("MarioThemeSong.wav"); //play mario music theme in background

        TurtleShell T1 = new TurtleShell("red"); //make a new turtle enemy
        TurtleShell T2 = new TurtleShell("green"); //make a new turtle enemy

        //Start level 1
        while(trackArray[1] == 1) {
            //if Mario is in the same spot as an enemy, he loses a life
            if(getDistance(Mx,Tx,My,Ty).equals("touch") || getDistance(Mx,Tx2,My,Ty2).equals("touch")){
                trackArray[0]--;
                //reset coordinates
                Mx = 0;
                My = .2;
                Tx = 1; Ty = .2;
                Tx2 = .4; Ty2 = .2;
                //reset screen for background 1
                reset1(Mx,My, Tx, Ty, Tx2,Ty2, T1, T2, trackArray[0], CoinArray);
            }

            //turtleshells move left
            Tx = Tx - .01;
            Tx2 = Tx2 - .01;

            if (StdDraw.isKeyPressed(38)){ //make Mario jump forward with up arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx + .05; //Mario moves forward
                    if(i<=1){ //y coordinate increases
                        My = My +.15;
                    }
                    if(i>1){ //y coordinate goes back down
                        My = My -.15;
                    }
                    //turtleshells move left
                    Tx = Tx - .01;
                    Tx2 = Tx2 - .01;
                    //reset with background 1
                    reset1(Mx,My,Tx,Ty, Tx2,Ty2, T1, T2, trackArray[0], CoinArray);
                }
                StdDraw.pause(100);
            }
            else if (StdDraw.isKeyPressed(40)){ //make Mario jump backward with down arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx - .05; //Mario moves backwards
                    if(i<=1){
                        My = My +.15; //Mario moves up
                    }
                    if(i>1){
                        My = My -.15; //Mario goes back down
                    }
                    //turtleshells move left
                    Tx = Tx - .01;
                    Tx2 = Tx2 - .01;
                    //reset background
                    reset1(Mx,My,Tx,Ty, Tx2,Ty2, T1, T2, trackArray[0], CoinArray);
                }
                StdDraw.pause(100);
            }

            if (StdDraw.isKeyPressed(39)){ //mario moves right with arrow key keycode 39
                Mx = Mx + .05;
                reset1(Mx,My,Tx,Ty, Tx2,Ty2, T1, T2, trackArray[0], CoinArray);
            }
            else if (StdDraw.isKeyPressed(37)){ //mario moves left with arrow key keycode 37
                Mx = Mx - .05;
                reset1(Mx,My,Tx,Ty, Tx2,Ty2, T1, T2, trackArray[0], CoinArray);
            }
            else{ //if no buttons are pressed by the user, only the enemies move
                reset1(Mx,My,Tx,Ty, Tx2,Ty2, T1, T2, trackArray[0], CoinArray);
            }

            if(trackArray[0] == 0){ //if all of Mario's lives are gone, the game is over
                trackArray[1] = 0; //go to gameOver
            }

            //Mario reaches the next level if he reaches the end of the screen
            if(Mx>=.9){
                trackArray[1] = 2;
            }
        }

        //Mario has reached the next level transition screen
        while(trackArray[1] == 2){
            newLevel();
            Mx = 0; //reset mario's coordinates
            My = .2;
            trackArray[1] = 3; //go to level 2

        }

        TurtleShell T3 = new TurtleShell("red"); //make a new red turtle enemy

        //start level 2
        while(trackArray[1] == 3){

            if(getDistance(Mx,Tx3,My,Ty3).equals("touch")){ //if Mario touches an enemy, he loses a life
                trackArray[0]--;
                //reset initial positions
                Mx = 0;
                My = .2;
                Tx3 = 1; Ty3 = .2;
                //reset screen
                reset2(Mx,My, Tx3, Ty3, T3,  trackArray[0], CoinArray, Cx3,Cy3, Cx4,Cy4);
            }

            Tx3 = Tx3 - .018; //turtleshell moves left

            if(getAbsVal(Mx,Cx3) <=.06 && My == .5){ //if mario touches a coin, his coin score goes up and the coin is removed from the screen
                if(CoinArray[3] == 1){ //if coin currently exists on screen
                    CoinArray[0] ++; //coin score goes up
                }
                CoinArray[3] = 0; //coin removed from screen
            }

            if(getAbsVal(Mx,Cx4) <=.06 && My == .5){ //if mario touches a coin, his coin score goes up and the coin is removed from the screen
                if(CoinArray[4] == 1){ //if coin currently exists on screen
                    CoinArray[0] ++; //coin score goes up
                }
                CoinArray[4] = 0; //coin removed from screen
            }

            if (StdDraw.isKeyPressed(38) && Mx >=.15 && Mx <=.28){ //make Mario jump forward with up arrow key to get on block
                for(int i = 0; i <4;i++){ //Mario jumps up
                    Mx = Mx + .05; //x coordinate increases
                    if(i<=1){
                        My = My +.15; //y coordinate increases
                    }
                    reset2(Mx,My, Tx3, Ty3, T3,  trackArray[0], CoinArray, Cx3,Cy3, Cx4,Cy4); //reset background 2
                }
                Tx3 = Tx3 - .018; //turtle shell moves left
                StdDraw.pause(100);
            }
            else if (StdDraw.isKeyPressed(38)){ //make Mario jump forward with up arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx + .05; //Mario moves right
                    if(i<=1){
                        My = My +.15; //Mario jumps up
                    }
                    if(i>1){
                        My = My -.15; //Mario goes back down
                    }
                    Tx3 = Tx3 - .018; //turtleshell moves left
                    reset2(Mx,My, Tx3, Ty3, T3,  trackArray[0], CoinArray, Cx3,Cy3, Cx4,Cy4); //rest background 2
                }
                StdDraw.pause(100);
            }

            if (StdDraw.isKeyPressed(40) && Mx >.715 && Mx <.95){ //make Mario jump backward with down arrow key to get on block
                for(int i = 0; i <4;i++){
                    Mx = Mx - .05; //mario moves left
                    if(i<=1){
                        My = My +.15; //mario moves up
                    }
                    reset2(Mx,My, Tx3, Ty3, T3,  trackArray[0], CoinArray, Cx3,Cy3, Cx4,Cy4); //reset background 2
                }
                Tx3 = Tx3 - .018; //turtleshell moves left
                StdDraw.pause(100);
            }
            else if (StdDraw.isKeyPressed(40)){ //make Mario jump backward with down arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx - .05; //mario moves left
                    if(i<=1){
                        My = My +.15; //mario moves up
                    }
                    if(i>1){
                        My = My -.15; //mario comes back down
                    }
                    Tx3 = Tx3 - .018; //turtleshell moves left
                    reset2(Mx,My, Tx3, Ty3, T3,  trackArray[0], CoinArray, Cx3,Cy3, Cx4,Cy4); //reset background 2
                }
                StdDraw.pause(100);
            }

            if (StdDraw.isKeyPressed(39)){ //mario moves right with arrow key keycode 39
                Mx = Mx + .05;
                reset2(Mx,My, Tx3, Ty3, T3,  trackArray[0], CoinArray, Cx3,Cy3, Cx4,Cy4);
            }
            else if (StdDraw.isKeyPressed(37)){ //mario moves left with arrow key keycode 37
                Mx = Mx - .05;
                reset2(Mx,My, Tx3, Ty3, T3,  trackArray[0], CoinArray, Cx3,Cy3, Cx4,Cy4);
            }

            else{ //if no buttons are pressed by the user, only the enemies move
                reset2(Mx,My, Tx3, Ty3, T3,  trackArray[0], CoinArray, Cx3,Cy3, Cx4,Cy4);
            }

            if(Mx <=.27 || Mx>= .7){ //if mario is not on the block, he is on the ground
                My = .2;
            }

            if(trackArray[0] == 0){ //mario has lost all lives
                trackArray[1] = 0; //go to gameOver
            }

            if(Mx>=.9) { //Mario reaches the next level if he reaches the end of the screen
                trackArray[1] = 4;
            }
        }

        //level 3 transition screen
        while(trackArray[1] == 4){
            newLevel(); //level transition screen
            //reset Mario coordinates
            Mx = 0;
            My = .2;
            trackArray[1] = 5; //go to level 3

        }

        TurtleShell T4 = new TurtleShell("flying"); //make a new turtle enemy
        int multiplierT4 = 0; //allows turtle to move up and down
        while(trackArray[1] == 5){ //begin level 3

            if(getDistance(Mx,Tx4,My,Ty4).equals("touch")){ //if enemy touches Mario, he loses a life
                trackArray[0]--; //loses a life
                //reset coordinates
                Mx = 0;
                My = .2;
                Ty4 = .23;
                //reset background for level 3
                reset3(Mx,My, Tx4, Ty4, T4, trackArray[0], Cx5, Cy5, Cx6, Cy6, CoinArray);
            }

            //make flying turtle go up and down
            if(Ty4 <= .23){ //if turtle reaches .23, go back up
                multiplierT4 = 1;
            }
            if(Ty4 >= .5){ //if turtle reaches .5, go back down
                multiplierT4 = -1;
            }
            Ty4 = Ty4 + multiplierT4 * .035; //turtle moves

            if(getAbsVal(Mx,Cx5) <=.06 && My == .5){ //if Mario touches a coin, his coin score goes up
                if(CoinArray[5] == 1){ //if coin exists
                    CoinArray[0] ++; //coin score goes up
                }
                CoinArray[5] = 0; //coin no longer exists
            }

            if(getAbsVal(Mx,Cx6) <=.06 && My == .5){ //if Mario touches a coin, his coin score goes up
                if(CoinArray[6] == 1){ //if coin exists
                    CoinArray[0] ++; //coin score goes up
                }
                CoinArray[6] = 0; //coin no longer exists
            }

            if (StdDraw.isKeyPressed(38)){ //make Mario jump forward with up arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx + .05; //move right
                    if(i<=1){
                        My = My +.15; //move up
                    }
                    if(i>1){
                        My = My -.15; //go back down
                    }
                    reset3(Mx,My, Tx4, Ty4, T4, trackArray[0], Cx5, Cy5, Cx6, Cy6, CoinArray); //reset screen
                }
                StdDraw.pause(100);
            }

            if (StdDraw.isKeyPressed(40) && Mx >.4 && Mx <.55){ //make Mario jump backward with down arrow key to get on block
                for(int i = 0; i <4;i++){
                    Mx = Mx - .05; //go left
                    if(i<=1){
                        My = My +.15; //go up
                    }
                    reset3(Mx,My, Tx4, Ty4, T4, trackArray[0], Cx5, Cy5, Cx6, Cy6, CoinArray);
                }
                StdDraw.pause(100);
            }
            else if (StdDraw.isKeyPressed(40)){ //make Mario jump backward with down arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx - .05; //move left
                    if(i<=1){
                        My = My +.15; //move up
                    }
                    if(i>1){
                        My = My -.15; //go back down
                    }
                    reset3(Mx,My, Tx4, Ty4, T4, trackArray[0], Cx5, Cy5, Cx6, Cy6, CoinArray);
                }
                StdDraw.pause(100);
            }

            if (StdDraw.isKeyPressed(39)){ //mario moves right with arrow key keycode 39
                Mx = Mx + .05;
                reset3(Mx,My, Tx4, Ty4, T4, trackArray[0], Cx5, Cy5, Cx6, Cy6, CoinArray);
            }
            else if (StdDraw.isKeyPressed(37)){ //mario moves left with arrow key keycode 37
                Mx = Mx - .05;
                reset3(Mx,My, Tx4, Ty4, T4, trackArray[0], Cx5, Cy5, Cx6, Cy6, CoinArray);
            }
            else{ //if no buttons are pressed by the user, only the enemies move
                reset3(Mx,My, Tx4, Ty4, T4, trackArray[0], Cx5, Cy5, Cx6, Cy6, CoinArray);
            }

            if(Mx >=.45){ //if mario is not on a block, he is on the ground
                My = .2;
            }

            if(trackArray[0] == 0){ //if all of Mario's lives are gone
                trackArray[1] = 0; //go to gameOver
            }

            if(Mx>=.9) { //Mario reaches the next level if he reaches the end of the screen
                trackArray[1] = 6;
            }
        }

        while(trackArray[1] == 6){ //new level transition screen
            newLevel();
            Mx = 0;
            My = .2;
            trackArray[1] = 7;
        }

        TurtleShell T5 = new TurtleShell("red"); //make a new red turtle enemy
        TurtleShell T6 = new TurtleShell("green"); //make a new green turtle enemy
        int multiplierT5 = 0; //make it possible to move back and forth
        int multiplierT6 = 0;

        //level 4
        while(trackArray[1] == 7){

            if(getDistance(Mx,Tx5,My,Ty5).equals("touch") || getDistance(Mx,Tx6,My,Ty6).equals("touch")){ //if Mario touches a turtleshell, he loses a life
                trackArray[0]--; //loses a life
                //reset initial positions
                Mx = 0;
                My = .2;
                Tx5 = .4;
                Tx6 = .8;
                reset4(Mx, My, Tx5, Ty5, Tx6, Ty6, T5, T6, trackArray[0], CoinArray); //redraw everything
            }

            //make turtleshells move back and forth: move left if they reach a certain x value, move right if they reach a different x value
            if(Tx5 >= .8){
                multiplierT5 = -1;
            }
            if(Tx5 <= .4){
                multiplierT5 = 1;
            }
            Tx5 = Tx5 + multiplierT5 * .012;

            if(Tx6 >= .8){
                multiplierT6 = -1;
            }
            if(Tx6 <= .4){
                multiplierT6 = 1;
            }
            Tx6 = Tx6 + multiplierT6 * .012;

            if (StdDraw.isKeyPressed(38)){ //make Mario jump forward with up arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx + .05; //move right
                    if(i<=1){
                        My = My +.15; //move up
                    }
                    if(i>1){
                        My = My -.15; //come back down
                    }
                    reset4(Mx,My, Tx5, Ty5, Tx6, Ty6, T5, T6, trackArray[0], CoinArray);
                }
                StdDraw.pause(100);
            }
            else if (StdDraw.isKeyPressed(40)){ //make Mario jump backward with down arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx - .05; //move left
                    if(i<=1){
                        My = My +.15; //move up
                    }
                    if(i>1){
                        My = My -.15; //move back down
                    }
                    reset4(Mx,My, Tx5, Ty5, Tx6, Ty6, T5, T6, trackArray[0], CoinArray);
                }
                StdDraw.pause(100);
            }

            if (StdDraw.isKeyPressed(39)){ //mario moves right with arrow key keycode 39
                Mx = Mx + .05;
                reset4(Mx,My, Tx5, Ty5, Tx6, Ty6, T5, T6, trackArray[0], CoinArray);
            }
            else if (StdDraw.isKeyPressed(37)){ //mario moves left with arrow key keycode 37
                Mx = Mx - .05;
                reset4(Mx,My, Tx5, Ty5, Tx6, Ty6, T5, T6, trackArray[0], CoinArray);
            }
            else{ //if no buttons are pressed by the user, only the enemies move
                reset4(Mx,My, Tx5, Ty5, Tx6, Ty6, T5, T6, trackArray[0], CoinArray);
            }

            if(trackArray[0] == 0){ //Mario has lost all lives
                trackArray[1] = 0; //go to gameOver
            }

            if(Mx>=.9) { //Mario reaches the next level if he reaches the end of the screen
                trackArray[1] = 8;
            }
        }

        while(trackArray[1] == 8){ //new level transition screen
            newLevel();
            Mx = 0;
            My = .2;
            trackArray[1] = 9;
        }

        TurtleShell T7 = new TurtleShell("UndergroundMushroom"); //make a new mushroom enemy
        TurtleShell T8 = new TurtleShell("UndergroundMushroom"); //make a new mushroom enemy
        TurtleShell T9 = new TurtleShell("flying"); //make a new flying turtle enemy
        int  multiplierT7 = 0; //make it possible for enemies to move back and forth or up and down
        int  multiplierT8 = 0;
        int  multiplierT9 = 0;

        //level 5
        while(trackArray[1] == 9){

            //if Mario touches an enemy, he loses a life
            if(getDistance(Mx,Tx7,My,Ty7).equals("touch") || getDistance(Mx,Tx8,My,Ty8).equals("touch")|| getDistance(Mx,Tx9,My,Ty9).equals("touch")){
                trackArray[0]--; //loses a life
                //reset Mario coordinates
                Mx = 0;
                My = .2;
                //redraw
                reset5(Mx,My, Tx7, Ty7, T7, Tx8, Ty8, T8, Tx9, Ty9, T9, Cx7, Cy7, Cx8, Cy8, trackArray[0], CoinArray);

            }

            //make turtleshells move back and forth
            if(Tx7 >= .68){
                multiplierT7 = -1;
            }
            if(Tx7 <= .53){
                multiplierT7 = 1;
            }
            Tx7 = Tx7 + multiplierT7 * .026;

            if(Tx8 >= .68){
                multiplierT8 = -1;
            }
            if(Tx8 <= .53){
                multiplierT8 = 1;
            }
            Tx8 = Tx8 + multiplierT8 * .026;

            if(Ty9 <= .23){
                multiplierT9 = 1;
            }
            if(Ty9 >= .5){
                multiplierT9 = -1;
            }
            Ty9 = Ty9 + multiplierT9 * .035;

            if(getAbsVal(Mx,Cx7) <=.06 && My == .2){ // if mario touches a coin, his coin score goes up
                if(CoinArray[7] == 1){ //if coin currently exists
                    CoinArray[0] ++; //coin score goes up
                }
                CoinArray[7] = 0; //coin no longer exists
            }

            if(getAbsVal(Mx,Cx8) <=.06 && My == .2){ // if mario touches a coin, his coin score goes up
                if(CoinArray[8] == 1){ //if coin currently exists
                    CoinArray[0] ++; //coin score goes up
                }
                CoinArray[8] = 0; //coin no longer exists
            }

            if (StdDraw.isKeyPressed(38) && Mx >=.15 && Mx <=.28){ //make Mario jump forward with up arrow key to get on block
                for(int i = 0; i <4;i++){
                    Mx = Mx + .05;
                    if(i<=1){
                        My = My +.15;
                    }
                    reset5(Mx,My, Tx7, Ty7, T7, Tx8, Ty8, T8, Tx9, Ty9, T9, Cx7, Cy7, Cx8, Cy8, trackArray[0], CoinArray);
                }
                StdDraw.pause(100);
            }
            else if (StdDraw.isKeyPressed(38)){ //make Mario jump forward with up arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx + .05;
                    if(i<=1){
                        My = My +.15;
                    }
                    if(i>1){
                        My = My -.15;
                    }
                    reset5(Mx,My, Tx7, Ty7, T7, Tx8, Ty8, T8, Tx9, Ty9, T9, Cx7, Cy7, Cx8, Cy8, trackArray[0], CoinArray);
                }
                StdDraw.pause(100);
            }

            if (StdDraw.isKeyPressed(40) && Mx >.715 && Mx <.95){ //make Mario jump backward with down arrow key to get on block
                for(int i = 0; i <4;i++){
                    Mx = Mx - .05;
                    if(i<=1){
                        My = My +.15;
                    }
                    reset5(Mx,My, Tx7, Ty7, T7, Tx8, Ty8, T8, Tx9, Ty9, T9, Cx7, Cy7, Cx8, Cy8, trackArray[0], CoinArray);
                }
                StdDraw.pause(100);
            }
            else if (StdDraw.isKeyPressed(40)){ //make Mario jump backward with down arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx - .05;
                    if(i<=1){
                        My = My +.15;
                    }
                    if(i>1){
                        My = My -.15;
                    }
                    reset5(Mx,My, Tx7, Ty7, T7, Tx8, Ty8, T8, Tx9, Ty9, T9, Cx7, Cy7, Cx8, Cy8, trackArray[0], CoinArray);
                }
                StdDraw.pause(100);
            }

            if (StdDraw.isKeyPressed(39)){ //mario moves right with arrow key keycode 39
                Mx = Mx + .05;
                reset5(Mx,My, Tx7, Ty7, T7, Tx8, Ty8, T8, Tx9, Ty9, T9, Cx7, Cy7, Cx8, Cy8, trackArray[0], CoinArray);
            }
            else if (StdDraw.isKeyPressed(37)){ //mario moves left with arrow key keycode 37
                Mx = Mx - .05;
                reset5(Mx,My, Tx7, Ty7, T7, Tx8, Ty8, T8, Tx9, Ty9, T9, Cx7, Cy7, Cx8, Cy8, trackArray[0], CoinArray);
            }
            else{ //if no buttons are pressed by the user, only the enemies move
                reset5(Mx,My, Tx7, Ty7, T7, Tx8, Ty8, T8, Tx9, Ty9, T9, Cx7, Cy7, Cx8, Cy8, trackArray[0], CoinArray);
            }

            if(Mx <=.27 || Mx>= .74){ //if mario is not on a skyblock, he is on the ground
                My = .2;
            }

            if(trackArray[0] == 0){ //if all lives are lost
                trackArray[1] = 0; //go to gameOver
            }

            if(Mx>=.9) { //Mario reaches the next level if he reaches the end of the screen
                trackArray[1] = 10;
            }
        }

        while(trackArray[1]==10){ //new level transition screen
            newLevel();
            Mx = 0;
            My = .2;
            trackArray[1] = 11;
        }

        TurtleShell T10 = new TurtleShell("Fireball");
        TurtleShell T11 = new TurtleShell("Fireball");

        //go to level 6
        while(trackArray[1]==11) {
            Tx10 = Tx10 - .01;
            Tx11 = Tx11 - .01;

            if(Tx10 <=0){ //Fireball comes back from the right
                Tx10 = 1;
            }

            if(Tx10 <=0){ //fireball comes back from the right
                Tx10 = 1.3;
            }

            //if Mario touches a fireball, he loses a life
            if(getDistance(Mx,Tx10,My,Ty10).equals("touch") || getDistance(Mx,Tx11,My,Ty11).equals("touch")){
                trackArray[0]--; //loses a life
                //reset Mario coordinates
                Mx = 0;
                My = .2;
                Tx10 = .9;
                Tx11 = .5;
                //redraw
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);

            }

            if(Mx >=.295 && Mx <=.36 && My <= .22){ //if Mario falls into the pit, he loses a life
                trackArray[0]--; //loses a life
                My = .17; //animate mario falling
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
                My = .15;
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
                My = .12;
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
                My = .1;
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
                //reset Mario coordinates
                Mx = 0;
                My = .2;
                //reset Fireballs
                Tx10 = .9;
                Tx11 = .5;
                //redraw
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
            }

            if(Mx >=.535 && Mx <=.605 && My <= .22){ //if Mario falls into the pit, he loses a life
                trackArray[0]--; //loses a life
                My = .17; //animate mario falling
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
                My = .15;
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
                My = .12;
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
                My = .1;
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
                //reset Mario coordinates
                Mx = 0;
                My = .2;
                //reset fireballs
                Tx10 = .9;
                Tx11 = .5;
                //redraw
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
            }

            if (StdDraw.isKeyPressed(38)){ //make Mario jump forward with up arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx + .05; //Mario moves forward
                    if(i<=1){ //y coordinate increases
                        My = My +.15;
                    }
                    if(i>1){ //y coordinate goes back down
                        My = My -.15;
                    }

                    //reset with background
                    reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
                }
                StdDraw.pause(100);
            }
            else if (StdDraw.isKeyPressed(40)){ //make Mario jump backward with down arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx - .05; //Mario moves backwards
                    if(i<=1){
                        My = My +.15; //Mario moves up
                    }
                    if(i>1){
                        My = My -.15; //Mario goes back down
                    }

                    //reset background
                    reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
                }
                StdDraw.pause(100);
            }

            if (StdDraw.isKeyPressed(39)){ //mario moves right with arrow key keycode 39
                Mx = Mx + .05;
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
            }
            else if (StdDraw.isKeyPressed(37)){ //mario moves left with arrow key keycode 37
                Mx = Mx - .05;
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
            }
            else{ //if no buttons are pressed by the user, only the enemies move
                reset6(Mx,My,T10, Tx10,Ty10,T11, Tx11,Ty11, trackArray[0],CoinArray);
            }
            if(trackArray[0] == 0){ //mario has lost all lives
                trackArray[1] = 0; //go to gameOver
            }

            if(Mx>=.8) { //Mario reaches the next level if he reaches the end of the screen
                trackArray[1] = 12;
            }
        }

        while(trackArray[1] == 12){ //level transition
            newLevel();
            Mx = 0;
            My = .2;
            trackArray[1] = 13;
        }
        while(trackArray[1] ==13){ //start level 7
            if (StdDraw.isKeyPressed(38)){ //make Mario jump forward with up arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx + .05; //Mario moves forward
                    if(i<=1){ //y coordinate increases
                        My = My +.15;
                    }
                    if(i>1){ //y coordinate goes back down
                        My = My -.15;
                    }

                    //reset with background
                    reset7(Mx,My, trackArray[0], CoinArray);
                }
                StdDraw.pause(100);
            }
            else if (StdDraw.isKeyPressed(40)){ //make Mario jump backward with down arrow key
                for(int i = 0; i <4;i++){
                    Mx = Mx - .05; //Mario moves backwards
                    if(i<=1){
                        My = My +.15; //Mario moves up
                    }
                    if(i>1){
                        My = My -.15; //Mario goes back down
                    }

                    //reset background
                    reset7(Mx,My, trackArray[0], CoinArray);
                }
                StdDraw.pause(100);
            }

            if (StdDraw.isKeyPressed(39)){ //mario moves right with arrow key keycode 39
                Mx = Mx + .05;
                reset7(Mx,My, trackArray[0], CoinArray);
            }
            else if (StdDraw.isKeyPressed(37)){ //mario moves left with arrow key keycode 37
                Mx = Mx - .05;
                reset7(Mx,My, trackArray[0], CoinArray);
            }
            else{ //if no buttons are pressed by the user, only the enemies move
                reset7(Mx,My, trackArray[0], CoinArray);
            }
            if(trackArray[0] == 0){ //mario has lost all lives
                trackArray[1] = 0; //go to gameOver
            }

            if(Mx>=.26) { //Mario reaches the end of the game if he reaches Princess Peach
                StdDraw.pause(1000);
                My=.2;
                Mx = .3;
                for(int i = 0; i <6; i++) {
                    Mx = Mx + .01; //animate mario walking to peach
                    reset7(Mx, My, trackArray[0], CoinArray);
                    StdDraw.pause(300);
                }
                trackArray[1] = 100;
            }
        }

        //game ends. Mario progressed through all levels
        while(trackArray[1] == 100){
            gameEnd();
        }

        //Mario has died 3 times, so the game is over. Re-run to start again
        while (trackArray[1] == 0){
            gameOver();
        }
    }

    //Mario has progressed to the next level of the game
    public static void newLevel(){
        Draw.backgroundNewLevel();
        StdDraw.show();
        StdDraw.pause(2000);
    }

    //redraw level 1 and the objects' current positions
    public static void reset1(double Mx, double My, double Tx, double Ty, double Tx2, double Ty2,
                              TurtleShell T1, TurtleShell T2, int lives, int [] CoinArray){
        StdDraw.clear();
        Draw.backgroundLevel1(); //redraw background
        Draw.drawMario(Mx, My); //draw mario at his current position
        T1.drawTurtleShell(Tx,Ty); //draw turtle at current position
        T2.drawTurtleShell(Tx2,Ty2); //draw turtle at current position
        //draw a heart if mario has at least 1 heart
        StdDraw.picture(.8, .95, "Heart.png", .05, .05);
        if (lives == 3) { //if Mario has 3 lives, draw two additional hearts
            StdDraw.picture(.7, .95, "Heart.png", .05, .05);
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        if (lives == 2) { //if Mario has 2 lives, draw one additional heart
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.9,.95,"Lives: " + lives); //display number of lives
        StdDraw.text(.1,.95,"Coins: " + CoinArray[0]); //display coin score
        StdDraw.show();
        StdDraw.pause(50);
    }

    //redraw level 2 and the objects' current positions
    public static void reset2(double Mx, double My,  double Tx3, double Ty3, TurtleShell T3,
                              int lives, int [] CoinArray, double Cx3, double Cy3, double Cx4,
                              double Cy4){
        StdDraw.clear();
        Draw.backgroundLevel2();
        if(CoinArray[3]==1) { //if Coin exists, draw it
            StdDraw.picture(Cx3, Cy3, "Coin.png", .07, .07);
        }
        if(CoinArray[4]==1) { //if coin exists, draw it
            StdDraw.picture(Cx4, Cy4, "Coin.png", .07, .07);
        }
        Draw.drawMario(Mx, My); //draw mario at his current position
        T3.drawTurtleShell(Tx3,Ty3); //draw turtle at current position
        if (lives == 3) {
            StdDraw.picture(.7, .95, "Heart.png", .05, .05);
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        if (lives == 2) {
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        StdDraw.picture(.8, .95, "Heart.png", .05, .05);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.9,.95,"Lives: " + lives);
        StdDraw.text(.1,.95,"Coins: " + CoinArray[0]);

        StdDraw.show();
        StdDraw.pause(50);
    }
    public static void reset3(double Mx, double My, double Tx4, double Ty4, TurtleShell T4,
                              int lives, double Cx5, double Cy5, double Cx6, double Cy6,
                              int [] CoinArray){
        StdDraw.clear();
        Draw.backgroundLevel3();
        Draw.drawMario(Mx, My);
        T4.drawTurtleShell(Tx4,Ty4);
        if(CoinArray[5]==1) {
            StdDraw.picture(Cx5, Cy5, "Coin.png", .07, .07);
        }
        if(CoinArray[6]==1) {
            StdDraw.picture(Cx6, Cy6, "Coin.png", .07, .07);
        }
        if (lives == 3) {
            StdDraw.picture(.7, .95, "Heart.png", .05, .05);
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        if (lives == 2) {
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        StdDraw.picture(.8, .95, "Heart.png", .05, .05);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.9,.95,"Lives: " + lives);
        StdDraw.text(.1,.95,"Coins: " + CoinArray[0]);

        StdDraw.show();
        StdDraw.pause(50);

    }

    public static void reset4(double Mx, double My, double Tx5, double Ty5, double Tx6, double Ty6,
                              TurtleShell T5, TurtleShell T6, int lives, int [] CoinArray){

        StdDraw.clear();
        Draw.backgroundLevel4();
        Draw.drawMario(Mx, My);
        T5.drawTurtleShell(Tx5,Ty5);
        T6.drawTurtleShell(Tx6,Ty6);
        if (lives == 3) {
            StdDraw.picture(.7, .95, "Heart.png", .05, .05);
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        if (lives == 2) {
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        StdDraw.picture(.8, .95, "Heart.png", .05, .05);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.9,.95,"Lives: " + lives);
        StdDraw.text(.1,.95,"Coins: " + CoinArray[0]);
        StdDraw.show();
        StdDraw.pause(50);
    }

    public static void reset5(double Mx, double My,double Tx7, double Ty7, TurtleShell T7,
                              double Tx8, double Ty8, TurtleShell T8, double Tx9, double Ty9,
                              TurtleShell T9, double Cx7, double Cy7, double Cx8, double Cy8,
                              int lives, int [] CoinArray){

        StdDraw.clear();
        Draw.backgroundLevel5();
        Draw.drawMario(Mx, My);
        T7.drawTurtleShell(Tx7,Ty7);
        T8.drawTurtleShell(Tx8,Ty8);
        T9.drawTurtleShell(Tx9,Ty9);
        if(CoinArray[7]==1) {
            StdDraw.picture(Cx7, Cy7, "UndergroundCoin.png", .05, .05);
        }
        if(CoinArray[8]==1) {
            StdDraw.picture(Cx8, Cy8, "UndergroundCoin.png", .05, .05);
        }
        if (lives == 3) {
            StdDraw.picture(.7, .95, "Heart.png", .05, .05);
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        if (lives == 2) {
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        StdDraw.picture(.8, .95, "Heart.png", .05, .05);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(.9,.95,"Lives: " + lives);
        StdDraw.text(.1,.95,"Coins: " + CoinArray[0]);
        StdDraw.show();
        StdDraw.pause(50);
    }

    public static void reset6(double Mx, double My, TurtleShell T10, double Tx10, double Ty10,
                              TurtleShell T11, double Tx11, double Ty11, int lives, int[] CoinArray){
        StdDraw.clear();
        Draw.backgroundLevel6();
        Draw.drawMario(Mx, My);
        T10.drawTurtleShell(Tx10,Ty10);
        T11.drawTurtleShell(Tx11,Ty11);
        if (lives == 3) {
            StdDraw.picture(.7, .95, "Heart.png", .05, .05);
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        if (lives == 2) {
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        StdDraw.picture(.8, .95, "Heart.png", .05, .05);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(.9,.95,"Lives: " + lives);
        StdDraw.text(.1,.95,"Coins: " + CoinArray[0]);
        StdDraw.show();
        StdDraw.pause(50);
    }

    public static void reset7(double Mx, double My, int lives, int[] CoinArray){
        StdDraw.clear();
        Draw.backgroundLevel7();
        Draw.drawMario(Mx, My);
        if (lives == 3) {
            StdDraw.picture(.7, .95, "Heart.png", .05, .05);
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        if (lives == 2) {
            StdDraw.picture(.75, .95, "Heart.png", .05, .05);
        }
        StdDraw.picture(.8, .95, "Heart.png", .05, .05);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(.9,.95,"Lives: " + lives);
        StdDraw.text(.1,.95,"Coins: " + CoinArray[0]);
        StdDraw.show();
        StdDraw.pause(50);
    }
    public static void gameEnd(){ //Mario has reached the end of the game
        StdDraw.clear();
        StdDraw.picture(.5,.5,"GameEnd.png",1.2,1);
        StdDraw.show();
    }
    public static void gameOver(){ //Mario has lost 3 lives, so the game is over
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(.5,.5, "Game Over");
        StdDraw.show();
        StdDraw.pause(2000);
        System.exit(0);
    }

    /*the following are methods used to determine how close two objects are together on the screen
    The first has caused issues with the precedence orders of && and ||, and I am trying out the second
    to see if it is a better fix for the issue. The first does not take both the x and y values of two
    objects, but the second does.
     */
    public static double getAbsVal(double coordinate1, double coordinate2){ //find the absolute value of the difference of positions
        if((coordinate1-coordinate2) < 0){
            return -1*(coordinate1-coordinate2);
        }
        else{
            return (coordinate1-coordinate2);
        }
    }
    public static String getDistance(double xcoordinate1, double xcoordinate2, double ycoordinate1, double ycoordinate2){ //find the absolute value of the difference of positions
        double xval = 0;
        if((xcoordinate1-xcoordinate2) < 0){
            xval = -1*(xcoordinate1-xcoordinate2);
        }

        if((xcoordinate1-xcoordinate2) >= 0){
            xval = xcoordinate1-xcoordinate2;
        }

        double yval = 0;
        if((ycoordinate1-ycoordinate2) < 0){
            yval = -1*(ycoordinate1-ycoordinate2);
        }
        if((ycoordinate1-ycoordinate2) >= 0){
            yval = ycoordinate1-ycoordinate2;
        }
        if(xval <= .065 && yval <= .065){
            return "touch";
        }
        else{
            return "doesn't touch";
        }
    }
}