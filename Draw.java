public class Draw { //class to draw things on the screen
    public static void drawMario(double Mx, double My) { //draw Mario in his current position
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.filledRectangle(Mx - .02, My + .0125 / 3, .0125 / 1.5, .0125 / 2); //left boot
        StdDraw.filledRectangle(Mx - .0255, My, .0125, .0125 / 3);

        StdDraw.filledRectangle(Mx + .02, My + .0125 / 3, .0125 / 1.5, .0125 / 2); //right boot
        StdDraw.filledRectangle(Mx + .0255, My, .0125, .0125 / 3);

        //arms
        StdDraw.filledRectangle(Mx - .017, My + .04, .025 / 3, .025 / 3);
        StdDraw.filledRectangle(Mx + .017, My + .04, .025 / 3, .025 / 3);

        //hands
        StdDraw.setPenColor(251, 151, 55);
        StdDraw.filledRectangle(Mx - .025, My + .03, .025 / 4.5, .025 / 3);
        StdDraw.filledRectangle(Mx + .025, My + .03, .025 / 4.5, .025 / 3);

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledRectangle(Mx - .015, My + .016, .0125 / 1.3, .0125 / 2); //left leg
        StdDraw.filledRectangle(Mx + .015, My + .016, .0125 / 1.3, .0125 / 2); //right leg
        StdDraw.filledRectangle(Mx, My + .0255, .016, .0125 / 1.5); //lower torso
        StdDraw.filledRectangle(Mx, My + .035, .01, .0125 / 2); //upper torso

        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.filledRectangle(Mx, My + .045, .01, .0125 / 2); //upper torso
        StdDraw.filledRectangle(Mx, My + .05, .015, .0125 / 2); //neck

        StdDraw.setPenColor(StdDraw.RED); //overall straps
        StdDraw.filledRectangle(Mx - .007, My + .045, .003, .0125 / 2);
        StdDraw.filledRectangle(Mx + .007, My + .045, .003, .0125 / 2);

        StdDraw.setPenColor(StdDraw.YELLOW); //overall buttons
        StdDraw.filledSquare(Mx - .0075, My + .035, .003);
        StdDraw.filledSquare(Mx + .0075, My + .035, .003);

        //face
        StdDraw.setPenColor(251, 151, 55);
        StdDraw.filledRectangle(Mx + .003, My + .067, .017, .0125);  //head

        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.filledRectangle(Mx - .018, My + .067, .0375 / 7, .0375 / 5); //hair
        StdDraw.filledRectangle(Mx - .01, My + .078, .0375 / 4, .0375 / 12); //hair
        StdDraw.filledRectangle(Mx - .01, My + .07, .0375 / 12, .0375 / 6); //hair
        StdDraw.filledRectangle(Mx - .01, My + .0665, .0375 / 4, .0375 / 12); //hair

        StdDraw.setPenColor(251, 151, 55);
        StdDraw.filledRectangle(Mx - .0145, My + .069, .0375 / 11, .0375 / 7); //ear
        StdDraw.filledRectangle(Mx + .024, My + .069, .0125 / 2.5, .0125 / 2.5);//nose
        StdDraw.filledRectangle(Mx + .0205, My + .065, .0125, .0125 / 5); //nose tip

        StdDraw.setPenColor(StdDraw.DARK_GRAY); //mustache
        StdDraw.filledSquare(Mx + .015, My + .066, .0125 / 3.5);
        StdDraw.filledRectangle(Mx + .018, My + .061, .0125 / 1.2, .0125 / 4.5);
        StdDraw.filledRectangle(Mx + .009, My + .075, .0125 / 5, .0125 / 2); //eye

        StdDraw.setPenColor(StdDraw.RED); //hat
        StdDraw.filledRectangle(Mx + .007, My + .083, .023, .0125 / 4.5);
        StdDraw.filledRectangle(Mx, My + .087, .023 / 2, .0125 / 4);
    }

    public static void backgroundNewLevel() {
        StdDraw.setPenColor(255, 166, 66); //sky
        StdDraw.filledSquare(.5, .5, .5);

        //Hill
        StdDraw.picture(.05, .27, "Hill.png", .4, .25);
        //decorative mushroom
        StdDraw.picture(.17, .245, "PrettyMushroom.png", .13, .1);

        //Bushes
        StdDraw.picture(.8, .27, "Bush.png", .3, .15);

        //clouds
        StdDraw.picture(.25, .7, "BigCloud.png", .4, .2);
        StdDraw.picture(.7, .85, "Cloud.png", .2, .2);

        //decorative mushroom
        StdDraw.picture(.75, .74, "PrettyMushroom.png", .13, .1);

        //skyblock
        StdDraw.picture(.85, .66, "LongSkyBlock.png", .4, .07);

        //ground
        StdDraw.picture(.5, .1, "Ground.png", 1.3, .2);

        //angry mushroom
        StdDraw.picture(.4,.25,"AngryMushroom.png",.1,.1);

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.text(.5,.5,"New Level! :D");

    }

    //background for level 1
    public static void backgroundLevel1() { //draw the background of level 1
        StdDraw.setPenColor(92, 148, 252); //sky
        StdDraw.filledSquare(.5, .5, .5);

        //bushes
        StdDraw.picture(.2, .27, "Bush.png", .3, .15);

        //Bush
        StdDraw.picture(.8, .27, "Bush.png", .3, .15);

        //clouds
        StdDraw.picture(.3, .6, "BigCloud.png", .4, .2);
        StdDraw.picture(.7, .8, "Cloud.png", .2, .2);

        //flag
        StdDraw.picture(.9, .49, "Flag.png", .12, .6);

        //ground
        StdDraw.picture(.5, .1, "Ground.png", 1.3, .2);

    }

    //background for level 2
    public static void backgroundLevel2() { //draw the background of level 2
        StdDraw.setPenColor(92, 148, 252); //sky
        StdDraw.filledSquare(.5, .5, .5);

        //bush and hill
        StdDraw.picture(.9, .27, "Bush.png", .3, .15);
        StdDraw.picture(.4, .27, "Hill.png", .35, .2);

        //clouds
        StdDraw.picture(.2, .8, "Cloud.png", .2, .2);
        StdDraw.picture(.7, .6, "Cloud.png", .2, .2);

        //flag
        StdDraw.picture(.9, .49, "Flag.png", .12, .6);

        //ground
        StdDraw.picture(.5, .1, "Ground.png", 1.3, .2);

        //skyblock
        StdDraw.picture(.5, .46, "LongSkyBlock.png", .4, .07);
    }

    public static void backgroundLevel3() { //background for level 3
        StdDraw.setPenColor(92, 148, 252); //sky
        StdDraw.filledSquare(.5, .5, .5);

        //bush and hill
        StdDraw.picture(.1, .27, "Bush.png", .3, .15);
        StdDraw.picture(.6, .27, "Hill.png", .35, .2);

        //clouds
        StdDraw.picture(.75, .6, "Cloud.png", .2, .2);
        StdDraw.picture(.3, .8, "Cloud.png", .2, .2);

        //flag
        StdDraw.picture(.9, .49, "Flag.png", .12, .6);
        //ground
        StdDraw.picture(.5, .1, "Ground.png", 1.3, .2);

        //skyblock
        StdDraw.picture(.2, .46, "LongSkyBlock.png", .4, .07);
    }

    public static void backgroundLevel4(){ //background for level 4
        StdDraw.setPenColor(92, 148, 252); //sky
        StdDraw.filledSquare(.5, .5, .5);

        //bush and hill
        StdDraw.picture(.8, .27, "Bush.png", .3, .15);
        StdDraw.picture(.4, .27, "Hill.png", .36, .19);

        //clouds
        StdDraw.picture(.75, .6, "Cloud.png", .2, .2);
        StdDraw.picture(.3, .8, "BigCloud.png", .4, .2);

        //ground
        StdDraw.picture(.5, .1, "Ground.png", 1.3, .2);

        //flag
        StdDraw.picture(.9, .49, "Flag.png", .12, .6);

        //Pipe
        StdDraw.picture(.91, .24, "Pipe.png", .12, .12);
    }

    public static void backgroundLevel5(){ //background for level 5
        StdDraw.setPenColor(StdDraw.BLACK); //sky
        StdDraw.filledSquare(.5, .5, .5);

        //wall
        StdDraw.picture(-.1, .2, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .25, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .3, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .35, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .4, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .45, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .5, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .55, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .6, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .65, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .7, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .75, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .8, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .85, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .9, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(-.1, .95, "UndergroundSkyBlock.png", .4, .1);

        //Ceiling
        StdDraw.picture(.1, .95, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(.3, .95, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(.5, .95, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(.7, .95, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(.9, .95, "UndergroundSkyBlock.png", .4, .1);

        //flag
        StdDraw.picture(.9, .49, "Flag.png", .12, .6);

        //ground
        StdDraw.picture(.5, .1, "Underground.png", 1.2, .2);

        //Skyblock
        StdDraw.picture(.5, .46, "UndergroundSkyBlock.png", .4, .07);
    }
    public static void backgroundLevel6(){ //background for level 6
        StdDraw.setPenColor(StdDraw.BLACK); //sky
        StdDraw.filledSquare(.5, .5, .5);

        //pipe
        StdDraw.picture(.9, .49, "UndergroundPipe.png", .3, .6);

        //wall
        StdDraw.picture(1.1, .7, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(1.1, .75, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(1.1, .8, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(1.1, .85, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(1.1, .9, "UndergroundSkyBlock.png", .4, .1);

        //Ceiling
        StdDraw.picture(.1, .95, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(.3, .95, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(.5, .95, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(.7, .95, "UndergroundSkyBlock.png", .4, .1);
        StdDraw.picture(.9, .95, "UndergroundSkyBlock.png", .4, .1);

        //ground
        StdDraw.picture(.5, .1, "Underground.png", 1.2, .2);

        //pitfalls
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(.33,.1,.07,.1);
        StdDraw.filledRectangle(.57,.1,.07, .1);

        //fire
        StdDraw.picture(.33, .08, "Fire.png", .145, .19);
        StdDraw.picture(.57, .08, "Fire.png", .145, .19);

    }
    public static void backgroundLevel7() {
        StdDraw.setPenColor(92, 148, 252); //sky
        StdDraw.filledSquare(.5, .5, .5);

        //Hill
        StdDraw.picture(.05, .27, "Hill.png", .4, .25);

        //decorative mushroom
        StdDraw.picture(.17, .245, "PrettyMushroom.png", .13, .1);

        //Bushes
        StdDraw.picture(.6, .27, "Bush.png", .3, .15);

        //clouds
        StdDraw.picture(.25, .7, "BigCloud.png", .4, .2);
        StdDraw.picture(.7, .85, "Cloud.png", .2, .2);

        //castle
        StdDraw.picture(.8, .48, "Castle.png", .6, .6);

        //decorative mushroom
        StdDraw.picture(.9, .245, "PrettyMushroom.png", .13, .1);

        //PrincessPeach
        StdDraw.picture(.44, .35, "Heart.png", .045, .045);
        StdDraw.picture(.44, .25, "PrincessPeach.png", .065, .12);

        //ground
        StdDraw.picture(.5, .1, "Ground.png", 1.3, .2);

    }
}


