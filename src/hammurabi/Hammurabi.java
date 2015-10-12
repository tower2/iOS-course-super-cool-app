/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hammurabi;

import java.util.*;

/**
 *
 * @author jermainegoins
 */
public class Hammurabi { // Save in a file named Hammurabi.java
     
     
    // Initial town values
    private int population = 1000;
    private int grain = 2800;
    private int acre = 1000;
    private int landValue = 19;
    private int acrePurchased = 0;
    private int acreSell = 0;
    private int cost = 0;
    private int year = 0;
    
    // Influences town values
    private int plagueDeath = 0;
    private int starve = 0;
    private int aliens = 0;
    private int goodHarvest = 0;
    private int ratProblem = 0;
    private int newLandPrice = 0;
    private double starvePercent = 0;
    
    private int feedPeople = 0;
    private int plantAcre = 0;
    private int storage = 0;
    private boolean tryAgain = true;
    
    
    Random rand = new Random();
    Scanner scanner = new Scanner (System.in);        
    String omg = ("\n\t\tO' Great Hammurabi. \n \t\t TRY AGAIN!!!");
    
    
    public static void main(String[] args)
    {
        new Hammurabi().startUp();
        
    }
    
    private void startUp() {
            
        
        while (tryAgain == true) 
        {
            playGame();
            System.out.println ("\t\t Mayor, would you like to play again? /n/"
                    + "t/t Yes or No \n");
            Scanner input = new Scanner (System.in);
            String yesOrNo = input.next();
            
            if (yesOrNo.equalsIgnoreCase("yes"))
            {
                tryAgain = true;
            }
            
            else
            {
                tryAgain = false;
            }
        }
        
        System.out.println("Goodbye!");
        
    }
    
    // Methods that gather Hammurabi information and display as need to the 
    // Mayor summary as needed.
    private void playGame()
    {
        boolean inOffice = true;
        mayorSummary();
        
        while (year <= 10)
        {
            askHowManyAcresToBuy();
            askHowManyAcresToSell();
            askHowMuchGrainToFeedPeople();
            askHowManyAcresToPlant();
            verifyPlague();
            
            uprising();
            
            starvationDeaths();
            immigrants();
            harvest();
            grainEatenByRats();
            newCostOfLand();
            mayorSummary();
            year+= 1;
        }
        
        finalMayorSummary();
    }

    
// Major's progress summary
    private void mayorSummary()
    {    
        System.out.println("\n\tO' great Hammurabi!\n");
        System.out.println("\tYou are in year " + year + " of your ten year rule.\n");
        System.out.println("\tIn the previous year " + starvePercent + " people starved to death.\n");
        System.out.println("\tIn the previous year " + aliens + " people entered kingdom.\n");
        System.out.println("\tThe population is now " + population + ".\n");
        System.out.println("\tWe harvested " + goodHarvest + " bushels at " + plantAcre + " bushels per acre.\n");
        System.out.println("\tRats destroyed " + ratProblem + " bushels, leaving " + storage + " bushels in storage.\n");
        System.out.println("\tThe city owns " + acre + " acres of land.\n");
        System.out.println("\tLand is currently worth " + landValue + " bushels per acre.\n\n");
        System.out.println("\t Currently have "+ grain+" amount of grain! \n");    
    }

            
        // Ask user how many acres to buy    
            public int askHowManyAcresToBuy( )
            {
                System.out.println ("\t\t How many acres of land do you want to buy? \n");
            
            // Calculating cost
                acrePurchased = getInput();
                cost = landValue * acrePurchased;
            
            //Compare cost and grain
                while (cost > grain)
                {
                   System.out.println(omg);
                   acrePurchased = getInput();
                   cost = landValue * acrePurchased;
                }
                
                acre += acrePurchased;
                grain -= cost;
            
            return grain & acre;
            }

        
        
            // User enters how many acres to sell
            public int askHowManyAcresToSell( ){
                
                System.out.println ("\t\t How many acres would you like to sell ??");
                acreSell = getInput();
                
                while (acreSell > acre)
                {
                    System.out.println(omg);
                    
                    // Calculates acres
                    System.out.println("\t\t Current acres: " + acre);
                    acreSell = getInput();
                }
                
                acre -= acreSell;
                grain += acreSell * landValue;
                
                return acre & grain;
            }


// User enter how much grain to feed to people
            public int askHowMuchGrainToFeedPeople( ){
            
            String question = ("\t\tHow much grain would you like to feed the people? ");
            feedPeople = getInput();
            
            while (feedPeople > grain)
            {
                System.out.println(omg);
                
                // Calculates feed people
                System.out.println("\t\t Current grain count: " + grain);
                feedPeople = getInput();
            }
            
            grain = grain - feedPeople;
            
            return grain;
            }
          
            
            // User enters how many acres to plant
            public int askHowManyAcresToPlant( ){
            System.out.println ("\t\t How many acres to plant with grain?");
            plantAcre = getInput();
            
            if (plantAcre > acre && plantAcre > population && plantAcre > grain)
            {
                System.out.println(omg);
                
                //Calculates planting
                System.out.println(" Current acre: " + acre + "\n Current population: "
                        + population + "\n Current grain : " + grain );
                plantAcre = getInput();
                acre = acre - plantAcre;
            }
            
            System.out.println("Acres left after planting grain: " + acre);
            return acre;
            
            }
            
            // Number of death associated with plague 
            public int verifyPlague ()
            {
                if ( rand.nextInt() < 15 ){
                    System.out.println("\n\n\t\t **** TERRIBLE PLAGUE  **** \n\t\t"
                            + " KILLS HALF POPULATION\n\n");
                    plagueDeath = population / 2;
                    population -= plagueDeath;
                }
                
                else 
                {
                    plagueDeath = 0;
                }
                return plagueDeath;
            }
            
            // Number of starvation deaths method
            public int starvationDeaths()
            {
                int grainFed = feedPeople / 20;
                
                if (grainFed<= population)
                {
                    starve = 0;
                    System.out.println("\t\t Number of people that starved: "
                            + starve + "\n \t\tGreat Job Mayor!!!");
                }
                
                else
                {
                    starve = population - grainFed;
                    System.out.println("\n\t\t Sorry to report " + starve + 
                            " people starved to death\n\t\t "
                            + "You need to do better Mayor.");
                    population -= starve;
                    
                    double percent = starve / population;
                    starvePercent = 100 * percent;
                }
                return population;
            }
            
            // Uprisng method to kick mayor out of office
            public String uprising ()
            {
                if( starvePercent > 45)
                {
                    System.out.println("\n\n\t\t THROWN OUT OF OFFICE!!!!");
                    return "yes";
                }
                
                return "no";
            }
            
            // Number of aliens or immigrants in town
            public int immigrants ()
            {
                if ( starve > 0)
                {
                    return 0;
                }
                
                else 
                {
                    aliens = (20 * acre + storage) / (100 * population) + 1;
                    System.out.println("\t\tNumber of immigrants: " + aliens);
                }
                return population + aliens;
            }
            
            // Harvest acres method    
            public int harvest ()
            {
                    int max = 6;
                    int min = 1; 
                    int range = max - min + 1;
                    int seedYield =  rand.nextInt(range) + min;
                    
                    goodHarvest = plantAcre * seedYield;
                    System.out.println("\t\t Harvested " + goodHarvest + " bushels.");
                    return goodHarvest;
            }
            
            // Grain eaten by rats method
            public int grainEatenByRats ()
            {
                if (rand.nextInt(100) < 40)
                {
                    int percentRatsAte = 10 + rand.nextInt(30);
                    System.out.println("\n\t **** RATS ATE " + percentRatsAte 
                            + " % OF GRAIN!!! ****");
                    ratProblem = ((percentRatsAte/100) * grain) ;
                    grain -= ratProblem;
                }
                return grain;
            }
            
            // Cost of land method
            public int newCostOfLand()
            {
                newLandPrice = 17 + rand.nextInt(23);
                return landValue = newLandPrice;
            }
            
            // Final mayor summary
            private void finalMayorSummary()
            {
                if ( starve >= (45 * population)/ 100)
                {
                    System.out.println("  Formerly Great Hammurabi, \nyou have "
                            + "starved more than 45% of your citizens and the \n"
                            + "remains citizens have picked up the closest \n"
                            + "farming tool and broke down your door. I would \n"
                            + "strongly recommend you run for your life before \n"
                            + "they feed you to wolves. It has been nice knowing\n"
                            + " you.  BANG...... BANG......... CRASH.....\n"
                            + "RUN !!!!!\n\n");
                }
                
                else 
                {
                    System.out.println ("  O' Great Hammurabi, \n"
                            + "you have ruled wisely and your follower have \n"
                            + "survived your 10 year tour. Things have been \n"
                            + "rough but everyone is happy an alive. Keep up \n"
                            + "the good work. ");
                }
            }

        // Yes or no response to playing again            
        private boolean yesorNO ()
        {
            String reply;
            while (true)
            {
                System.out.println(  "  ");
                reply = scanner.nextLine();
                
                if (reply.equalsIgnoreCase("yes"))
                {
                    return true;
                }
                
                else if (reply.equalsIgnoreCase("no"))
                {
                    return false;
                }
            }
        }       
            
            
            

            
            
            

            

            
            

            
            
            
        
            
            
        
            
        // Input general input method    
        int getInput()
        {
            while (true)
            {
                try
                {
                    Scanner input = new Scanner(System.in);
                    int amount = input.nextInt();
                    
                    return amount;
                }
                
                catch (Exception e)
                {
                    System.out.println("\t\tO' Great Hammurabi. "
                            + "\n\t\t TRY AGAIN!!!");
                }
            }
            
        }
   
/* Matuszek, D. (2009). The Hammurabi game, as an Example for CIT590 in Spring 
*       2009. Retrieved from 
*       http://www.cis.upenn.edu/~matuszek/cit590-2009/Examples/Hammurabi.java.            
*/     

    private boolean yesOrNo(String string) 
    {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
            

       
                    
            
                    
      
            
            
            
        
        
        // Other methods go here
        
        

            
            
      
                    
              
        
    
    
        

    

    /**
     * The Hammurabi game.
     * @author Jermaine Goins
     */
    
    
    
    
    
   
