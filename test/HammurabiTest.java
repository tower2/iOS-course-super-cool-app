/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jermainegoins
 */
public class HammurabiTest {
    
    public HammurabiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    @Test
    public void harvest(){
        int plantAcre = 50;
        int seedYield = 3;
        int goodHarvest = 150;
        
        assertEquals(goodHarvest,150 );
    }
    
    public void grainEatenByRats()
    {
        int ratProblem = 100;
        int grain = 1000;
        
        assertEquals(grain, 900);
                
    }
    
    public void newCostOfLand()
    {
        int rand = 2;
        int landValue = 19;
        
        assertEquals (landValue, 19);
    }
}
