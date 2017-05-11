package org.vkedco.lp.simplex.tests.ignizio_cavalier;

/**
 *
 * @author vladimir kulyukin
 */

import org.vkedco.lp.simplex.Tableau;
import org.vkedco.lp.simplex_support.ratio.*;

public class Chapter_4 {
    
    static Tableau tableau_4_1_p122 = null;
    static {
        final String[] colVars_10_3_1_p487 = {"x1", "x2", "x3", "x4", "x5", "b"};
        final String[] rowVars_10_3_1_p487 = {"x3", "x4", "x5", "z"};
        final Ratio[][] matrix_10_3_1_p487 = {
            // row x3
            {
                new Ratio(-1, 1), // x1
                new Ratio(1, 1),  // x2
                new Ratio(1, 1),  // x3
                new Ratio(0, 1),  // x4
                new Ratio(0, 1),  // x5
                new Ratio(6, 1)   // b
            },
            // row x4
            {
                new Ratio(2, 1),  // x1
                new Ratio(1, 1),  // x2
                new Ratio(0, 1),  // x3
                new Ratio(1, 1),  // x4
                new Ratio(0, 1),  // x5
                new Ratio(20, 1)  // b  
            },
            // row x5
            {
                new Ratio(1, 1),  // x1
                new Ratio(1, 1),  // x2
                new Ratio(0, 1),  // x3
                new Ratio(0, 1),  // x4
                new Ratio(1, 1),  // x5
                new Ratio(12, 1)  // b  
            },
            // row z
            {
                new Ratio(-4, 1), // x1 
                new Ratio(-3, 1), // x2
                new Ratio(0, 1),  // x3
                new Ratio(0, 1),  // x4
                new Ratio(0, 1),  // x5
                new Ratio(0, 1)   // b
            }
        };
        
        tableau_4_1_p122 = 
                new Tableau(colVars_10_3_1_p487, 
                            rowVars_10_3_1_p487, 
                            matrix_10_3_1_p487);
    }
    
    public static void main(String[] args) {
        Tableau.doSimplex(tableau_4_1_p122);
    }
}

