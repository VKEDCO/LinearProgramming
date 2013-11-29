/*
 * Tableu Class for the Simplex Method
 * Bugs to vladimir dot kulyukin at gmail dot com
 */
package org.vkedco.lp.simplex;

import org.vkedco.lp.simplex_support.ratio.*;

public class Tableu {

    public static enum SOLUTION { YES, NO };
    
    protected String[] mColVars;
    protected String[] mRowVars;
    protected Ratio[][] mMatrix;

    public Tableu() {
        mColVars = null;
        mRowVars = null;
        mMatrix = null;
    }

    public Tableu(String[] colVars, String[] rowVars, Ratio[][] matrix) {
        mColVars = colVars;
        mRowVars = rowVars;
        mMatrix = matrix;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (String cv : mColVars) {
            sb.append("\t" + cv);
        }
        sb.append("\n");
        for (int rn = 0; rn < mMatrix.length; rn++) {
            sb.append(mRowVars[rn]);
            for (Ratio r : mMatrix[rn]) {
                sb.append("\t" + r.toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private Ratio[] getPRow() {
        return mMatrix[mMatrix.length - 1];
    }

    // use RatioArithmetic.compare(r1, r2) to find the smallest
    // value in the p row and return its index
    int findEnterVar() {
        Ratio[] pvals = getPRow();
        //for (Ratio r : pvals) {
        //    System.out.println(r.toString());
        //}

        Ratio smallest = pvals[0];
        int enter_var_index = 0;
        for (int i = 1; i < pvals.length - 1; i++) {
            if (RatioArithmetic.compare(pvals[i], smallest) < 0) {
                smallest = pvals[i];
                enter_var_index = i;
            }
        }

        //System.out.println("Smallest " + smallest);
        if (RatioArithmetic.compare(smallest, new Ratio(0, 1)) < 0) {
            return enter_var_index;
        } else {
            return -1;
        }
    }

    // test a few tableus.
    int findDepartVar(int enter_var_index) {
        Ratio smallest = null;
        int row_index = -1;
        for (int r = 0; r < mMatrix.length - 1; r++) {
            Ratio bs_col_val = mMatrix[r][mMatrix[r].length - 1];
            //System.out.println("bs_col_val = " + bs_col_val);
            Ratio enter_var_col_val = mMatrix[r][enter_var_index];
            if (RatioArithmetic.compare(RatioArithmetic.ZERO, enter_var_col_val) < 0) {
                Ratio quo = RatioArithmetic.div(bs_col_val, mMatrix[r][enter_var_index]);
                //System.out.println("quo = " + quo);
                if (smallest == null) {
                    smallest = quo;
                    row_index = r;
                } else if (RatioArithmetic.compare(quo, smallest) < 0) {
                    smallest = quo;
                    row_index = r;
                }
            }
        }

        return row_index;
    }

    final String getColVar(int index) {
        return mColVars[index];
    }

    final void setRowVar(int index, String var) {
        mRowVars[index] = var;
    }

    final Ratio getEntry(int row, int col) {
        return mMatrix[row][col];
    }

    final void divRow(int row_index, Ratio r) {
        for (int c = 0; c < mMatrix[row_index].length; c++) {
            mMatrix[row_index][c] = RatioArithmetic.div(mMatrix[row_index][c], r);
        }
    }

    final void multRow(int row_index, Ratio r) {
        for (int c = 0; c < mMatrix[row_index].length; c++) {
            mMatrix[row_index][c] = RatioArithmetic.mult(mMatrix[row_index][c], r);
        }
    }

    final Ratio[] multRowNew(int row_index, Ratio r) {
        Ratio[] row = new Ratio[mMatrix[row_index].length];
        for (int c = 0; c < mMatrix[row_index].length; c++) {
            row[c] = RatioArithmetic.mult(mMatrix[row_index][c], r);
        }
        return row;
    }

    final void addRows(int row_index, Ratio[] row) {
        for (int c = 0; c < mMatrix[row_index].length; c++) {
            mMatrix[row_index][c] =
                    RatioArithmetic.add(mMatrix[row_index][c], row[c]);
        }
    }

    final void zeroOutPivotColumn(int pivot_row, int pivot_col) {
        Ratio negOne = new Ratio(-1, 1);
        for (int r = 0; r < mMatrix.length; r++) {
            if (r != pivot_row) {
                Ratio multiplier = RatioArithmetic.mult(negOne, mMatrix[r][pivot_col]);
                addRows(r, multRowNew(pivot_row, multiplier));
            }
        }
    }

    // while ( true ) {
    //  enter_var = findEnteringVariable();
    //  if enter_var == -1, return; // the problem is solved
    //  depart_var = findDepartingVariable();
    //  if depart_var == -1, return NO_SOLUTION;
    //  zeroOutPivotColumn(depart_var, enter_var);
    public SOLUTION simplex() {
        int enter_var  = -1;
        int depart_var = -1;
        while (true) {
            enter_var = findEnterVar();
            if (enter_var == -1) {
                return SOLUTION.YES;
            }
            depart_var = this.findDepartVar(enter_var);
            if (depart_var == -1) {
                return SOLUTION.NO;
            }
            doPivoting(depart_var, enter_var);
        }
    }

    final void doPivoting(int pivot_row, int pivot_col) {
        Ratio pivot = getEntry(pivot_row, pivot_col);
        setRowVar(pivot_row, getColVar(pivot_col));
        divRow(pivot_row, pivot);
        zeroOutPivotColumn(pivot_row, pivot_col);
    }
    
    final void display() {
        for (String cv : mColVars) {
            System.out.print("\t" + cv);
        }
        System.out.println();
        for (int rn = 0; rn < mMatrix.length; rn++) {
            System.out.print(mRowVars[rn]);
            for (Ratio r : mMatrix[rn]) {
                System.out.print("\t" + r.toString());
            }
            System.out.println();
        }
    }
}
