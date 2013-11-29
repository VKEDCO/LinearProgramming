/*
 * Linear Programming Problems.
 * LP Problems from Ch. 10.03 in "Finite Mathematics," 4th Edition,
 * by D. Maki and M. Thompson.
 * 
 * Bugs to vladimir dot kulyukin at gmail dot com.
 */
package org.vkedco.lp.simplex;

import org.vkedco.lp.simplex_support.ratio.*;

public class LinProgTests {

    static Tableu tableu_10_03_01 = null;
    static {
        final String[] colVars_10_03_01 = {"x", "y", "u", "v", "bs"};
        final String[] rowVars_10_03_01 = {"u", "v", "p"};
        final Ratio[][] matrix_10_03_01 = {
            // row u
            {
                new Ratio(9, 1),    // x
                new Ratio(4, 1),    // y
                new Ratio(1, 1),    // u
                new Ratio(0, 1),    // v
                new Ratio(36, 1)    // bs
            },
            // row v
            {
                new Ratio(3, 1),    // x
                new Ratio(6, 1),    // y
                new Ratio(0, 1),    // u
                new Ratio(1, 1),    // v
                new Ratio(9, 1)     // bs
            },
            // row p
            {
                new Ratio(-3, 1),   // x 
                new Ratio(-2, 1),   // y
                new Ratio(0, 1),    // u
                new Ratio(0, 1),    // v
                new Ratio(0, 1)     // bs
            }
        };
        tableu_10_03_01 = new Tableu(colVars_10_03_01, 
                                    rowVars_10_03_01, 
                                    matrix_10_03_01);
    }
    
    static Tableu tableu_10_03_03 = null;
    static {
        final String[] colVars_10_03_03 = {"x", "y", "u", "v", "bs"};
        final String[] rowVars_10_03_03 = {"y", "v", "p"};
        final Ratio[][] matrix_10_03_03 = {
            // row y
            {
                new Ratio(1, 2),    // x 
                new Ratio(1, 1),    // y
                new Ratio(1, 2),    // u
                new Ratio(0, 1),    // v
                new Ratio(4, 1)     // bs
            },
            // row v
            {
                new Ratio(4, 1),    // x 
                new Ratio(0, 1),    // y
                new Ratio(-1, 1),   // u
                new Ratio(1, 1),    // v
                new Ratio(4, 1)     // bs
            },
            // row p
            {
                new Ratio(-1, 1),   // x
                new Ratio(0, 1),    // y
                new Ratio(2, 1),    // u
                new Ratio(0, 1),    // v
                new Ratio(16, 1)    // ps
            }
        };
        tableu_10_03_03 = new Tableu(colVars_10_03_03, 
                                rowVars_10_03_03, matrix_10_03_03);
    }
    
    static Tableu tableu_10_03_07 = null;
    static {
        final String[] colVars_10_03_07 = {"x", "y", "z", "u", "v", "bs"};
        final String[] rowVars_10_03_07 = {"u", "y", "p"};
        final Ratio[][] matrix_10_03_07 = {
            // row u
            {
                new Ratio(5, 1),    // x
                new Ratio(0, 1),    // y
                new Ratio(2, 1),    // z
                new Ratio(1, 1),    // u
                new Ratio(-1, 3),   // v
                new Ratio(5, 1)     // bs
            },
            // row y
            {
                new Ratio(1, 2),    // x
                new Ratio(1, 1),    // y
                new Ratio(0, 1),    // z
                new Ratio(0, 1),    // u
                new Ratio(1, 6),    // v
                new Ratio(1, 1)     // bs
            },
            // row p
            {
                new Ratio(-2, 1),   // x
                new Ratio(0, 1),    // y
                new Ratio(-1, 1),   // z
                new Ratio(0, 1),    // u
                new Ratio(1, 1),    // v
                new Ratio(6, 1)     // bs
            }
        };
        tableu_10_03_07 = new Tableu(colVars_10_03_07, 
                                rowVars_10_03_07, matrix_10_03_07);
    }
    
    static Tableu tableu_10_03_09 = null;
    static {
        final String[] colVars_10_03_09 = {"x", "y", "u", "v", "w", "bs"};
        final String[] rowVars_10_03_09 = {"u", "v", "w", "p"};
        final Ratio[][] matrix_10_03_09 = {
            {
                new Ratio(4, 1), 
                new Ratio(2, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(20, 1)
            },
            {
                new Ratio(3, 1), 
                new Ratio(-3, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(9, 1)
            },
            {
                new Ratio(6, 1), 
                new Ratio(6, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(24, 1)
            },
            {
                new Ratio(-1, 1), 
                new Ratio(-3, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1)
            }
        };
        tableu_10_03_09 = new Tableu(colVars_10_03_09, rowVars_10_03_09, matrix_10_03_09);
    }
    
    static Tableu tableu_10_03_11 = null;
    static {
        final String[] colVars_10_03_11 = {"x", "y", "u", "v", "bs"};
        final String[] rowVars_10_03_11 = {"u", "v", "p"};
        final Ratio[][] matrix_10_03_11 = {
            {
                new Ratio(9, 1),
                new Ratio(4, 1),
                new Ratio(1, 1),
                new Ratio(0, 1),
                new Ratio(36, 1)
            },
            {
                new Ratio(3, 1),
                new Ratio(6, 1),
                new Ratio(0, 1),
                new Ratio(1, 1),
                new Ratio(9, 1)
            },
            {
                new Ratio(-3, 1),
                new Ratio(-2, 1),
                new Ratio(0, 1),
                new Ratio(0, 1),
                new Ratio(0, 1)
            }
        };
        tableu_10_03_11 = new Tableu(colVars_10_03_11, 
                                    rowVars_10_03_11, 
                                    matrix_10_03_11);
    }
    
    static Tableu tableu_10_03_17 = null;
    static {
        final String[] colVars_10_03_17 = {"x", "y", "u", "v", "bs"};
        final String[] rowVars_10_03_17 = {"u", "v", "p"};
        final Ratio[][] matrix_10_03_17 = {
            {
                new Ratio(3, 1), 
                new Ratio(8, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(24, 1)
            },
            {
                new Ratio(6, 1), 
                new Ratio(4, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(30, 1)
            },
            {
                new Ratio(-2, 1), 
                new Ratio(-3, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1)
            }
        };
        tableu_10_03_17 = new Tableu(colVars_10_03_17, 
                rowVars_10_03_17, matrix_10_03_17);
    }
    
    static Tableu tableu_10_03_19 = null;
    static {
        final String[] colVars_10_03_19 = {"x", "y", "u", "v", "bs"};
        final String[] rowVars_10_03_19 = {"u", "v", "p"};
        final Ratio[][] matrix_10_03_19 = {
            {
                new Ratio(1, 1), 
                new Ratio(-1, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(4, 1)
            },
            {
                new Ratio(-1, 1), 
                new Ratio(3, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(4, 1)
            },
            {
                new Ratio(-1, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1)
            }
        };
        tableu_10_03_19 = new Tableu(colVars_10_03_19, 
                                rowVars_10_03_19, matrix_10_03_19);
    }
    
    static Tableu tableu_10_03_21 = null;
    static {
        final String[] colVars_10_03_21 = {"x", "y", "u", "v", "w", "bs"};
        final String[] rowVars_10_03_21 = {"u", "v", "w", "p"};
        final Ratio[][] matrix_10_03_21 = {
            {
                new Ratio(2, 1), 
                new Ratio(3, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(30, 1)
            },
            {
                new Ratio(-1, 1), 
                new Ratio(3, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(9, 1)
            },
            {
                new Ratio(-7, 1), 
                new Ratio(-6, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1)
            }
        };
        tableu_10_03_21 = new Tableu(colVars_10_03_21, 
                                        rowVars_10_03_21, matrix_10_03_21);
    }
    
    static Tableu tableu_10_03_23 = null;
    static {
        final String[] colVars_10_03_23 = {"x", "y", "u", "v", "w", "z", "bs"};
        final String[] rowVars_10_03_23 = {"u", "v", "w", "z", "p"};
        final Ratio[][] matrix_10_03_23 = {
            {
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(8, 1)
            },
            {
                new Ratio(8, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(40, 1)
            },
            {
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(4, 1)
            },
            {
                new Ratio(1, 1), 
                new Ratio(2, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(10, 1)
            },
            {
                new Ratio(-1, 1), 
                new Ratio(-10, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1)
            }
        };
        tableu_10_03_23 = new Tableu(colVars_10_03_23, 
                                    rowVars_10_03_23, matrix_10_03_23);
    }
    
    static Tableu tableu_10_03_25 = null;
    static {
        final String[] colVars_10_03_25 = {"x", "y", "z", "u", "v", "bs"};
        final String[] rowVars_10_03_25 = {"u", "v", "p"};
        final Ratio[][] matrix_10_03_25 = {
            {
                new Ratio(3, 1), 
                new Ratio(8, 1), 
                new Ratio(6, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(24, 1)
            },
            {
                new Ratio(6, 1), 
                new Ratio(2, 1), 
                new Ratio(8, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(24, 1)
            },
            {
                new Ratio(-3, 1), 
                new Ratio(-4, 1), 
                new Ratio(-5, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1)
            }
        };
        tableu_10_03_25 = new Tableu(colVars_10_03_25, 
                rowVars_10_03_25, matrix_10_03_25);
    }

    static Tableu tableu_10_03_27 = null;
    static {
        final String[] colVars_10_03_27 = {"x", "y", "z", "u", "v", "w", "bs"};
        final String[] rowVars_10_03_27 = {"u", "v", "w", "p"};
        final Ratio[][] matrix_10_03_27 = {				
            {
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(5, 1)      
            },
            {
                new Ratio(5, 1), 
                new Ratio(5, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(60, 1)
            },
            {
                new Ratio(1, 1), 
                new Ratio(2, 1), 
                new Ratio(3, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(24, 1)
            },
            {
                new Ratio(-6, 1), 
                new Ratio(-10, 1), 
                new Ratio(-2, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1)
            }
        };
        tableu_10_03_27 = new Tableu(colVars_10_03_27, 
                rowVars_10_03_27, matrix_10_03_27);
    }
    
    static Tableu tableu_10_03_29 = null;
    static {
        final String[] colVars_10_03_29 = {"x", "y", "u", "v", "w", "bs"};
        final String[] rowVars_10_03_29 = {"y", "x", "v", "p"};
        final Ratio[][] matrix_10_03_29 = {				
            {
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(-1, 1), 
                new Ratio(0, 1), 
                new Ratio(4, 1), 
                new Ratio(10, 1)
            },
            {
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(2, 1), 
                new Ratio(0, 1), 
                new Ratio(5, 1), 
                new Ratio(25, 1)
            },
            {
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(3, 1), 
                new Ratio(1, 1), 
                new Ratio(-3, 1), 
                new Ratio(4, 1)
            },
            {
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(3, 1), 
                new Ratio(0, 1), 
                new Ratio(5, 1), 
                new Ratio(70, 1)
            }
        };
        tableu_10_03_29 = new Tableu(colVars_10_03_29, 
                rowVars_10_03_29, matrix_10_03_29);
    }
    
    static Tableu tableu_10_03_31 = null;
    static {
        final String[] colVars_10_03_31 = {"x", "y", "u", "v", "bs"};
        final String[] rowVars_10_03_31 = {"u", "v", "p"};
        final Ratio[][] matrix_10_03_31 = {			
            {
                new Ratio(6, 1), 
                new Ratio(12, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(2880, 1)
            },
            {
                new Ratio(8, 1), 
                new Ratio(4, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(1248, 1)
            },
            {
                new Ratio(-50, 1), 
                new Ratio(-30, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1)
            }
        };
        tableu_10_03_31 = new Tableu(colVars_10_03_31, rowVars_10_03_31, matrix_10_03_31);
    }
    
    static Tableu tableu_10_03_33 = null;
    static {
        final String[] colVars_10_03_33 = {"x", "y", "u", "v", "bs"};
        final String[] rowVars_10_03_33 = {"u", "v", "p"};
        final Ratio[][] matrix_10_03_33 = {   			
            {
                new Ratio(1, 6), 
                new Ratio(1, 12), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(10, 1)
            },
            {
                new Ratio(1, 6), 
                new Ratio(1, 3), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(15, 1)
            },
            {
                new Ratio(-5, 1), 
                new Ratio(-7, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1)
            }
        };

        tableu_10_03_33 = new Tableu(colVars_10_03_33, 
                rowVars_10_03_33, matrix_10_03_33);
    }

    static Tableu tableu_10_03_35 = null;
    static {
        final String[] colVars_10_03_35 = {"x", "y", "z", "w", "v1", "v2", "v3", "bs"};
        final String[] rowVars_10_03_35 = {"v1", "v2", "v3", "p"};
        final Ratio[][] matrix_10_03_35 = {
            {
                new Ratio(50, 1), // x  
                new Ratio(20, 1), // y
                new Ratio(50, 1), // z
                new Ratio(30, 1), // w 
                new Ratio(1, 1), // v1
                new Ratio(0, 1), // v2 
                new Ratio(0, 1), // v3 
                new Ratio(1500, 1) // bs
            },
            {
                new Ratio(15, 1), // x  
                new Ratio(10, 1), // y
                new Ratio(20, 1), // z
                new Ratio(10, 1), // w 
                new Ratio(0, 1), // v1
                new Ratio(1, 1), // v2 
                new Ratio(0, 1), // v3 
                new Ratio(900, 1) // bs
            },
            {
                new Ratio(15, 1), // x  
                new Ratio(10, 1), // y
                new Ratio(0, 1), // z
                new Ratio(0, 1), // w 
                new Ratio(0, 1), // v1
                new Ratio(0, 1), // v2 
                new Ratio(1, 1), // v3 
                new Ratio(500, 1) // bs
            },
            {
                new Ratio(-3, 1), // x  
                new Ratio(-2, 1), // y
                new Ratio(-25, 10), // z
                new Ratio(-15, 10), // w 
                new Ratio(0, 1), // v1
                new Ratio(0, 1), // v2 
                new Ratio(0, 1), // v3 
                new Ratio(0, 1) // bs
            }
        };
        tableu_10_03_35 = new Tableu(colVars_10_03_35, rowVars_10_03_35, matrix_10_03_35);
    }
    
    static void test_01() {
        String[] colVars = {"x", "y", "z", "u", "v", "bs"};
        String[] rowVars = {"u", "v", "p"};
        Ratio[][] matrix = {
            {
                new Ratio(2, 1), 
                new Ratio(2, 1), 
                new Ratio(3, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(160, 1)
            },
            {
                new Ratio(5, 1), 
                new Ratio(1, 1), 
                new Ratio(10, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(100, 1)
            },
            {
                new Ratio(-3, 1), 
                new Ratio(-8, 1), 
                new Ratio(-6, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1)
            }
        };

        Tableu tab = new Tableu(colVars, rowVars, matrix);
        tab.display();
    }

    static void test_02() {
        String[] colVars = {"x", "y", "z", "u", "v", "bs"};
        String[] rowVars = {"u", "v", "p"};
        Ratio[][] matrix = {
            {
                new Ratio(2, 1), 
                new Ratio(2, 1), 
                new Ratio(3, 1), 
                new Ratio(1, 1), 
                new Ratio(0, 1), 
                new Ratio(160, 1)
            },
            {
                new Ratio(5, 1), 
                new Ratio(1, 1), 
                new Ratio(10, 1), 
                new Ratio(0, 1), 
                new Ratio(1, 1), 
                new Ratio(100, 1)
            },
            {
                new Ratio(-10, 1), 
                new Ratio(-6, 1), 
                new Ratio(-2, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1), 
                new Ratio(0, 1)
            }
        };

        Tableu tab = new Tableu(colVars, rowVars, matrix);
        int ent_index = tab.findEnterVar();
        int dep_index = tab.findDepartVar(ent_index);
        System.out.println(colVars[ent_index] + ", " + rowVars[dep_index]);
    }

    public static void do_simplex(Tableu tableu) {
        Tableu.SOLUTION sol = tableu.simplex();
        System.out.println(sol);
        if (sol == Tableu.SOLUTION.YES) {
            tableu.display();
        }
    }

    public static void main(String[] args) {
        do_simplex(tableu_10_03_11);
    }
}
