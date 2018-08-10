package com.ipgmedia.lib;

/*
 * Optimization Solver Framework Library
 */
public class OptimizationSolver {
    
    public String solve(String data) throws Exception {
    
        // Perform some task (i.e. reverse the input string)
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i=data.length()-1; i>=0; i--) {
            stringBuilder.append(data.charAt(i));
        }
        
        return stringBuilder.toString();
    }

}
