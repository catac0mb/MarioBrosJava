public class TurtleShell { //class to make and draw enemies
    private String name;
    public TurtleShell(String name) {
        //constructor to initialize variables
        this.name = name;
    }
    public void drawTurtleShell(double x, double y){
        if(this.name == "red"){ //if name is red, draw a red turtleshell
            StdDraw.picture(x,y,"RedTurtle.png",.07,.07);
        }
        if(this.name == "green"){ //if name is green, draw a green turtleshell
            StdDraw.picture(x,y,"GreenTurtle.png",.07,.07);
        }
        if(this.name == "flying"){ //if name is flying, draw a flying turtle
            StdDraw.picture(x,y,"FlyingTurtle.png",.15,.15);
        }
        if(this.name == "mushroom"){ //if name is mushroom, draw an angry mushroom
            StdDraw.picture(x,y,"AngryMushroom.png",.08,.08);
        }
        if(this.name == "UndergroundMushroom"){ //if name is mushroom, draw an angry mushroom
            StdDraw.picture(x,y,"UndergroundMushroom.png",.08,.077);
        }
        if(this.name == "Fireball"){
            StdDraw.picture(x,y,"Fireball.png",.08,.05);
        }
    }
}
