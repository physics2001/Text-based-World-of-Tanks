package wottextbased;

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Wottextbased {

    public static void main(String[] args) {
        
        Random r = new Random();       
        Scanner k = new Scanner(System.in);
        
        //ingame variables
        int playerhp = 0, enemyhp;
        int playerAPpen = 0, enemyAPpen=0;
        int playerAPdmg=0, enemyAPdmg=0;
        int playerHEpen=0, enemyHEpen=0;
        int playerHEdmg=0, enemyHEdmg=0;
        int playerUnipen = 0, playerUnidmg = 0, playerUniLMT = 0;
        int playerACC=0, enemyACC=0;
        int playerAMR=0,enemyAMR=0, actualPlayerAMR = 0, actualEnemyAMR = 0;
        int playerActualdmg=0, enemyActualdmg=0; 
        int playerAutoB=0, enemyAutoB=0;
        String tankName = "tank name";
        int numberofenemy = 1;
        int ammoexp = 0;
        boolean playing = true;
        //quotes
        String[] playerpens = {"Critical Hit!", "That one went in!", "Nice Shot!", "Penetration!", "Enemy vehicle on fire!", "Enemy vehicle immobilized!", "We tracked them!", "We've hit them hard!"};
        String[] playerbounces = {"That one didn't go through!", "That one bounced!", "Did not penetrate!", "We didn't even scratch them!", "Their armour is too thick!"};
        String[] playernonhits = {"That one flied into the dirt", "That one missed!", "Your Aiming System isn't working!", "Enemy dodged that one!", "That one was close!"};
        String [] enemypens = {"We are hit!", "Our loader is hit!", "Our driver is knocked out!", "Our commander is stunned", "Our Engine is smoking!", "We are tracked!"};
        String [] enemybounces = {"We bounced that one!", "Nice Angling!", "We were lucky it didn't penetrate!", "We weren't even scratched!"}; 
        String [] enemynonhits = {"They missed that one!", "We were lucky it didn't hit!", "We dodged that one!", "They have a bad gunner!"}; 
        String [] enemyDestroyed = {"Enemy armour destroyed!", "We knocked out all of their crew!", "Enemy is dead!","Let's move on to our next target!"};
        String [] playerDestroyed = {"Our vehicle is dead!", "We have been destroyed!", "Our ammo storage exploded!", "Our armor is destroyed, let's get out!"};
        
        while (playing = true) {
            
            //introduction
            System.out.println("Hola, tanker! what's your name");
            String name = k.next();

            System.out.println("Hello " + name);
            System.out.println("In this game, you will choose a tank to fight in and keep fighting enemy tanks until your tank is knocked out by the enemies.");
            System.out.println("Now what tank would you like to use?"); 
            System.out.println("Notice: AP shells will only deal damage if penetrates.\n\tHE or HESH shells will always deal damage but depends on penetration value and armor of your opponent. \n\t each tank have a special kind of shell which can only be used 10 times."); 

            //stats of M48A1 Patton
            System.out.println("1. US: M48A1 Patton");
            System.out.println("\tHP: 2000");
            System.out.println("\tAP shell damage: 350(300-400)"); 
            System.out.println("\tAP shell penetration: 268mm(218-318)"); 
            System.out.println("\tHE shell damage: 450(350-550)"); 
            System.out.println("\tHE shell penetration: 55mm(45-65)");
            System.out.println("\tArmour Value: 32-288");
            System.out.println("\tChance of automatically bouncing enemy shells: 30%");
            System.out.println("\tChance of hitting the enemy 92%");
            System.out.println("\tSpecial Shell: APCR (work as AP except with higher pen and lower dmg,limit 10 times per game)");
            System.out.println("\tAPCR shell damage: 330(280-380)");
            System.out.println("\tAPCR shell penetration: 380mm(330-430)");
            
            //stats of T62
            System.out.println("2. USSR: T62");
            System.out.println("\tHP: 1950");
            System.out.println("\tAP shell damage: 320(270-370)"); 
            System.out.println("\tAP shell penetration: 280mm(230-330)"); 
            System.out.println("\tHE shell damage: 420(320-520)"); 
            System.out.println("\tHE shell penetration: 33mm(23-43)");
            System.out.println("\tArmour Value: 40-360mm");
            System.out.println("\tChance of automatically bouncing enemy shells: 40%");
            System.out.println("\tChance of hitting the enemy 88%"); 
            System.out.println("\tSpecial Shell: APCR (work as AP except with higher pen and lower dmg\n\tlimit 10 times per game)");
            System.out.println("\tAPCR shell damage: 300(250-350)");
            System.out.println("\tAPCR shell penetration: 400mm(350-450)");

            //stats of Type 69
            System.out.println("3. China: Type 69");
            System.out.println("\tHP: 1950");
            System.out.println("\tAP shell damage: 400(350-450)"); 
            System.out.println("\tAP shell penetration: 250mm(200-300)"); 
            System.out.println("\tHE shell damage: 500(400-600)"); 
            System.out.println("\tHE shell penetration: 68mm(58-78)");
            System.out.println("\tArmour Value: 37-333mm");
            System.out.println("\tChance of automatically bouncing enemy shells: 35%");
            System.out.println("\tChance of hitting the enemy 90%");
            System.out.println("\tSpecial Shell: HEAT (work as HE if doesn't pen and AP if does, except with higher pen and lower dmg\n\tlimit 8 times per game)");
            System.out.println("\tAPCR shell damage: 375(325-425)");
            System.out.println("\tAPCR shell penetration: 375mm(325-425)");

            //stats of Centurion
            System.out.println("4. UK: Centurion");
            System.out.println("\tHP: 2050");
            System.out.println("\tAP shell damage: 330(270-370)"); 
            System.out.println("\tAP shell penetration: 250mm(200-300)"); 
            System.out.println("\tHESH shell damage: 500(400-600)"); 
            System.out.println("\tHESH shell penetration: 80mm(70-90)");
            System.out.println("\tArmour Value: 30-270mm");
            System.out.println("\tChance of automatically bouncing enemy shells: 25%");
            System.out.println("\tChance of hitting the enemy 94%"); 
            System.out.println("\tSpecial Shell: HEAT (work as HE if doesn't pen and AP if does, except with higher pen and lower dmg\n\tlimit 8 times per game)");
            System.out.println("\tAPCR shell damage: 375(325-425)");
            System.out.println("\tAPCR shell penetration: 350mm(350-450)");

            //stats of Leopard-1
            System.out.println("5. Germany: Leopard-1");
            System.out.println("\tHP: 1900");
            System.out.println("\tAP shell damage: 310(260-360)"); 
            System.out.println("\tAP shell penetration: 275mm(225-325)"); 
            System.out.println("\tHE shell damage: 480(380-580)"); 
            System.out.println("\tHE shell penetration: 45mm(35-55)");
            System.out.println("\tArmour Value: 20-180mm");
            System.out.println("\tChance of automatically bouncing enemy shells: 11%");
            System.out.println("\tChance of hitting the enemy 99%"); 
            System.out.println("\tSpecial Shell: HEAT (work as HE if doesn't pen and AP if does, except with higher pen and lower dmg\n\tlimit 8 times per game)");
            System.out.println("\tAPCR shell damage: 290(240-340)");
            System.out.println("\tAPCR shell penetration: 385mm(385-435)");

             //stats of STB-1
            System.out.println("6. Japan: STB-1");
            System.out.println("\tHP: 1850");
            System.out.println("\tAP shell damage: 310(260-360)"); 
            System.out.println("\tAP shell penetration: 275mm(225-325)"); 
            System.out.println("\tHE shell damage: 470(370-570)"); 
            System.out.println("\tHE shell penetration: 50mm(40-60)");
            System.out.println("\tArmour Value: 22-198mm");
            System.out.println("\tChance of automatically bouncing enemy shells: 15%");
            System.out.println("\tChance of hitting the enemy 96%");
            System.out.println("\tSpecial Shell: APCR (work as AP except with higher pen and lower dmg,limit 10 times per game)");
            System.out.println("\tAPCR shell damage: 290(280-380)");
            System.out.println("\tAPCR shell penetration: 390mm(340-440)");

            System.out.print("Please enter your choice here: \n>"); 
            int tankChoice = k.nextInt();

            //Defining ingame variables depending on the choice
            if (tankChoice == 1) {
                playerhp = 2000;
                playerAPpen = 218;
                playerAPdmg = 300;
                playerHEpen = 45;
                playerHEdmg = 350;
                playerUnipen = 330;
                playerUnidmg = 280;
                playerUniLMT = 10;
                playerACC = 92; 
                playerAMR = 160;
                playerAutoB = 25;
                tankName = "M48A1 Patton"; 
            } else if (tankChoice == 2) {
                playerhp = 1950;
                playerAPpen = 230;
                playerAPdmg = 270;
                playerHEpen = 23;
                playerHEdmg = 320;
                playerUnipen = 350;
                playerUnidmg = 250;
                playerUniLMT = 10;
                playerACC = 88; 
                playerAMR = 200;
                playerAutoB = 35;
                tankName = "T62"; 
            } else if (tankChoice == 3) {
                playerhp = 1950;
                playerAPpen = 200;
                playerAPdmg = 350;
                playerHEpen = 23;
                playerHEdmg = 400;
                playerUnipen = 325;
                playerUnidmg = 325;
                playerUniLMT = 8;
                playerACC = 90; 
                playerAMR = 195;
                playerAutoB = 30;
                tankName = "Type 69"; 
            } else if (tankChoice == 4) {
                playerhp = 2050;
                playerAPpen = 200;
                playerAPdmg = 270;
                playerHEpen = 70;
                playerHEdmg = 400;
                playerUnipen = 300;
                playerUnidmg = 325;
                playerUniLMT = 8;
                playerACC = 94; 
                playerAMR = 150;
                playerAutoB = 20;
                tankName = "Centurion"; 
            } else if (tankChoice == 5) {
                playerhp = 1900;
                playerAPpen = 225;
                playerAPdmg = 250;
                playerHEpen = 35;
                playerHEdmg = 380;
                playerUnipen = 335;
                playerUnidmg = 240;
                playerUniLMT = 8;
                playerACC = 99; 
                playerAMR = 100;
                playerAutoB = 10;
                tankName = "Leopard-1"; 
            } else if (tankChoice == 6) {
                playerhp = 1850;
                playerAPpen = 225;
                playerAPdmg = 260;
                playerHEpen = 40;
                playerHEdmg = 370;
                playerUnipen = 330;
                playerUnidmg = 240;
                playerUniLMT = 10;
                playerACC = 96; 
                playerAMR = 110;
                playerAutoB = 15;
                tankName = "STB-1"; 
            } 

            System.out.println("Let's roll out!");

            while(playerhp>0) {
                System.out.println("Here is your " + numberofenemy + " Enemy");

                //random enemy
                enemyhp = 500 + r.nextInt(1001);
                enemyAPdmg = 50 + r.nextInt(401);
                enemyAPpen = 50 + r.nextInt(201);
                enemyHEpen = 10 + r.nextInt(81);
                enemyHEdmg = 50 + r.nextInt(851);
                enemyAMR = (1 + r.nextInt(250));
                enemyAutoB = r.nextInt(31);
                enemyACC = 35 + r.nextInt(51);
                ammoexp = r.nextInt(10);

                System.out.println("Your " + numberofenemy + " enemy");
                System.out.println("\tHP: " + enemyhp);
                System.out.println("\tAP shell damage: " + (enemyAPdmg+50) + "(" + (enemyAPdmg) + "-" + (enemyAPdmg + 100) + ")"); 
                System.out.println("\tAP shell penetration: " + (enemyAPpen+50) + "mm(" + (enemyAPpen) + "-" + (enemyAPpen + 100) + ")"); 
                System.out.println("\tHE shell damage: " + (enemyHEdmg+100) + "(" + (enemyHEdmg) + "-" + (enemyHEdmg + 200) + ")"); 
                System.out.println("\tHE shell penetration: " + (enemyHEpen+10) + "mm(" + (enemyHEpen) + "-" + (enemyHEpen + 20) + ")"); 
                System.out.println("\tArmour Value: " + (int)(0.2*enemyAMR) + "-" + (int)(1.8*enemyAMR));
                System.out.println("\tChance of automatically bouncing Your shells: " + enemyAutoB + "%");
                System.out.println("\tChance of hitting you: " + enemyACC + "%"); 
                System.out.println("\tChance of getting ammo racked when penetrated by you: " + ammoexp + " out of a thousand");

                while(enemyhp>0) {

                    //Selecting Shells
                    System.out.println("Player's Turn: ");
                    System.out.println("Select the shell you want to use!");
                    System.out.println("1. AP 2. HE/HESH 3. Special(" + playerUniLMT + " shells left)");
                    int playerShellType = k.nextInt();
                    
                    //player combat mechanics
                    
                    if (playerShellType == 1) {
                        //AP shell damage mechanics
                        System.out.println("Loading..."); 
                        try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                        try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                        if (Math.random()*100 <= playerACC) {
                            //If the shell hits
                            System.out.println("You shot the shell and it was a hit");
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                            if (((Math.random()*100) >= enemyAutoB) && ((playerAPpen + r.nextInt(101)) > (enemyAMR * (0.125+Math.random())*1.6))) {

                                playerActualdmg = playerAPdmg + r.nextInt(101);
                                enemyhp = enemyhp - (playerActualdmg);
                                String playerpen = playerpens [(r.nextInt(playerpens.length))];
                                System.out.println(playerpen);
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                
                                if (Math.random() * 1000 < ammoexp) {
                                    System.out.println("You have hit their ammo storage!");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    break;
                                }
                                
                                System.out.println("You have reduced your enemy's health pool by " + playerActualdmg + " HP!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                
                                if (enemyhp <= 0) {
                                    String enemydead = enemyDestroyed [(r.nextInt(enemyDestroyed.length))];
                                    System.out.println(enemydead);
                                    break;
                                }
                                
                                System.out.println("You have reduced your enemy's health pool to " + enemyhp + " HP!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                            } else {

                                String playerbounce = playerbounces [(r.nextInt(playerbounces.length))];
                                System.out.println(playerbounce);
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                System.out.println("You shot the shell and it didn't damage enemy armor. ");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                            }
                            
                        } else {
                            //If the shell miss
                            String playernonhit = playernonhits[(r.nextInt(playernonhits.length))];
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                            System.out.println("You shot the shell but it didn't hit the opponent");
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                            System.out.println("Your enemy is still at " + enemyhp + " HP!");

                        }

                    } else if (playerShellType == 2) {
                        //HE shell damage mechanics
                        System.out.println("Loading..."); 
                        try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                        try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                        if (Math.random()*100 <= playerACC) {
                            //If the shell hits
                            System.out.println("You shot the shell and it was a hit");
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                            if (((playerHEpen + r.nextInt(21)) > (actualEnemyAMR = (int) (enemyAMR * (0.125+Math.random())*1.6)))) {

                                playerActualdmg = playerHEdmg + r.nextInt(201);
                                enemyhp = enemyhp - (playerActualdmg);
                                String playerpen = playerpens [(r.nextInt(playerpens.length))];
                                System.out.println(playerpen);
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                
                                if (Math.random() * 1000 < ammoexp) {
                                    System.out.println("You have hit their ammo storage!");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    break;
                                }
                                
                                System.out.println("You have reduced your enemy's health pool by " + playerActualdmg + " HP!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                
                                if (enemyhp <= 0) {
                                    String enemydead = enemyDestroyed [(r.nextInt(enemyDestroyed.length))];
                                    System.out.println(enemydead);
                                    break;
                                }
                                
                                System.out.println("You have reduced your enemy's health pool to " + enemyhp + " HP!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                            } else {

                                playerActualdmg = (int) (0.5 * (playerHEdmg + r.nextInt(201)) - 1.1 * actualEnemyAMR); 

                                if (playerActualdmg > 0) {

                                    enemyhp = enemyhp - playerActualdmg; 
                                    System.out.println("Although it didn''t penetrate enemy vehicle, you were able to splash damage it!");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    System.out.println("You have reduced your enemy's health pool by " + playerActualdmg + " HP!");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    
                                    if (enemyhp <= 0) {
                                        
                                        String enemydead = enemyDestroyed [(r.nextInt(enemyDestroyed.length))];
                                        System.out.println(enemydead);
                                        break;
                                    }
                                    
                                    System.out.println("You have reduced your enemy's health pool to " + enemyhp + " HP!");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                
                                } else if (playerActualdmg <= 0){

                                    playerActualdmg = 0;
                                    String playerbounce = playerbounces [(r.nextInt(playerbounces.length))];
                                    System.out.println(playerbounce);
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    System.out.println("You shot the shell and it didn't damage enemy armor. ");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    System.out.println("Your enemy is still at " + enemyhp + " HP!");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                                }
                            }

                        } else {
                            //If the shell miss
                            String playernonhit = playernonhits[(r.nextInt(playernonhits.length))];
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                            System.out.println("You shot the shell but it didn't hit the opponent");
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                            System.out.println("Your enemy is still at " + enemyhp + " HP!");

                        }
                    } else if (playerShellType == 3) {
                        
                        if (playerUniLMT > 0) {
                            
                            //Unique shell damage mechanics
                            playerUniLMT--;
                            System.out.println("Loading..."); 
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                            
                            if (Math.random()*100 <= playerACC) {
                                System.out.println("You shot the shell and it was a hit");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                                if (((Math.random()*100) >= enemyAutoB) && ((playerUnipen + r.nextInt(101)) > (enemyAMR * (0.125+Math.random())*1.6))) {

                                    playerActualdmg = playerUnidmg + r.nextInt(101);
                                    enemyhp = enemyhp - (playerActualdmg);
                                    String playerpen = playerpens [(r.nextInt(playerpens.length))];
                                    System.out.println(playerpen);
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                
                                if (Math.random() * 1000 < ammoexp) {
                                    System.out.println("You have hit their ammo storage!");
                                    String enemydead = enemyDestroyed [(r.nextInt(enemyDestroyed.length))];
                                    System.out.println(enemydead);
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    break;
                                }
                                
                                System.out.println("You have reduced your enemy's health pool by " + playerActualdmg + " HP!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                
                                if (enemyhp <= 0) {
                                    
                                    String enemydead = enemyDestroyed [(r.nextInt(enemyDestroyed.length))];
                                    System.out.println(enemydead);
                                    break;
                                    
                                }
                                
                                System.out.println("You have reduced your enemy's health pool to " + enemyhp + " HP!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                                } else {

                                    String playerbounce = playerbounces [(r.nextInt(playerbounces.length))];
                                    System.out.println(playerbounce);
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    System.out.println("You shot the shell and it didn't damage enemy armor. ");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    
                                }
                            } else {
                            //If the shell miss
                            String playernonhit = playernonhits[(r.nextInt(playernonhits.length))];
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                            System.out.println("You shot the shell but it didn't hit the opponent");
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                            System.out.println("Your enemy is still at " + enemyhp + " HP!");

                            }
                        } else {
                            System.out.println("You missed your turn because you have no more special ammo left!");
                            break; 
                        }
                    }

                    //enemy combat mechanics
                    System.out.println("Enemy's Turn: ");
                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                    if (Math.random()*100 <= enemyACC) {   

                        //how enemy chooses shell 
                        if ((playerhp <= 200) || (enemyHEdmg > (enemyAPdmg + 300)) || (enemyHEpen > enemyAPpen) || (enemyHEpen > (playerAMR * 0.7))) {

                            //enemy HE shell mechanics
                            System.out.println("Your enemy have chosen to use HE shells!");
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                            if (((enemyHEpen + r.nextInt(21)) > (actualPlayerAMR = (int) (playerAMR * (0.125+Math.random())*1.6)))) {

                                enemyActualdmg = enemyHEdmg + r.nextInt(201);
                                playerhp = playerhp - (enemyActualdmg);
                                String enemypen = enemypens [(r.nextInt(enemypens.length))];
                                System.out.println(enemypen);
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                System.out.println("The enemy have reduced your health pool by " + enemyActualdmg + " HP!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                
                                if (playerhp <= 0) {
                                    break;
                                }
                                
                                System.out.println("The enemy have reduced your health pool to " + playerhp + " HP!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                
                            } else {

                                enemyActualdmg = (int) (0.5 * (enemyHEdmg + r.nextInt(201)) - 1.1 * actualPlayerAMR); 

                                if (enemyActualdmg > 0) {

                                    playerhp = playerhp - enemyActualdmg; 
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    System.out.println("Although your enemy didn''t penetrate yout vehicle, your enemy was able to splash damage your vehicle!");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    System.out.println("The enemy have reduced your health pool by " + enemyActualdmg + " HP!"); 
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    
                                    if (playerhp <= 0) {
                                        break;
                                    }
                                    
                                    System.out.println("The enemy have reduced your health pool to " + playerhp + " HP!");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    
                                } else if (enemyActualdmg <= 0){

                                    enemyActualdmg = 0;
                                    String enemybounce = enemybounces [(r.nextInt(enemybounces.length))];
                                    System.out.println(enemybounce);
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    System.out.println("The enemy hit you but did not do any damage!");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                    System.out.println("Your tank is still at " + playerhp + " HP!");
                                    try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                                }
                            }

                        } else {

                            //enemy AP shell damage mechanics
                            System.out.println("Your enemy have chosen AP shells!");
                            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                            if (((Math.random()*100) >= playerAutoB) && ((enemyAPpen + r.nextInt(101)) > (playerAMR * (0.125+Math.random())*1.6))) {

                                enemyActualdmg = enemyAPdmg + r.nextInt(101);
                                playerhp = playerhp - (enemyActualdmg);
                                String enemypen = enemypens [(r.nextInt(enemypens.length))];
                                System.out.println(enemypen);
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                System.out.println("The enemy have reduced your health pool by " + enemyActualdmg + " HP!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                
                                if (playerhp <= 0) {
                                    break;
                                }
                                
                                System.out.println("The enemy have reduced your health pool to " + playerhp + " HP!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                
                            } else {

                                String enemybounce = enemybounces [(r.nextInt(enemybounces.length))];
                                System.out.println(enemybounce);
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                System.out.println("You were able to bounce the enemy shell!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                                System.out.println("Your tank is still at " + playerhp + " HP!");
                                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                            }

                        }

                    } else {

                        String enemynonhit = enemynonhits [(r.nextInt(enemynonhits.length))]; 
                        System.out.println(enemynonhit);
                        try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                        System.out.println("Enemy missed you!");
                        try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                        System.out.println("Your tank is still at " + playerhp + " HP!"); 
                        try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}

                    }

                }

                if (playerhp <= 0) {
                    break;
                }

                String enemyDestroy = enemyDestroyed [(r.nextInt(enemyDestroyed.length))]; 
                System.out.println(enemyDestroy);
                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                System.out.println("You have destroyed your " + numberofenemy + " enemy!");
                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                System.out.println("New enemy approaching!");
                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                numberofenemy++;

            }

            String playerDestroy = playerDestroyed [(r.nextInt(playerDestroyed.length))]; 
            System.out.println(playerDestroy);
            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
            System.out.println(name + " you have done a great job fighting. You have destroyed " + (numberofenemy - 1) + " enemies!");
            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
            System.out.println("Now your " + tankName + " is destroyed!"); 
            try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
            System.out.println("Would you like to try again?");
            System.out.println("1. Yes 2. No");
            int again = k.nextInt(); 
            
            if (again == 1 ) {
                System.out.println("Let's do this again then!");
                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
            } else if (again == 2) {
                System.out.println("See you next time!");
                try {Thread.sleep(1000);} catch(InterruptedException ex) {Thread.currentThread().interrupt();}
                break;
            }
        }
    }
}
