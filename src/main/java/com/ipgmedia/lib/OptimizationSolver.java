package com.ipgmedia.lib;

import org.springframework.stereotype.Component;

/*
 * Optimization Solver Framework Library
 */
@Component
public class OptimizationSolver {
    
    public String solve(String data) throws Exception {
    
        // Perform some task (i.e. reverse the input string)
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i=data.length()-1; i>=0; i--) {
            stringBuilder.append(data.charAt(i));
        }
        
        // simulate some task delay
        Thread.sleep(10000);
        
        return stringBuilder.toString();
    }

}
