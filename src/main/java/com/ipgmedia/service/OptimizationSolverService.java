package com.ipgmedia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.RateLimiter;
import com.ipgmedia.lib.OptimizationSolver;

/*
 * Service which wraps the Optimization Solver Framework
 */
public class OptimizationSolverService {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    
    private OptimizationSolver optimizationSolver;
    
    // Google Guava RateLimiter
    private RateLimiter rateLimiter;
    
    public OptimizationSolverService(OptimizationSolver optimizationSolver, RateLimiter rateLimiter) {
        this.optimizationSolver = optimizationSolver;
        this.rateLimiter = rateLimiter;
    }
    
    public String solveService(String data) {
        
        long threadId = Thread.currentThread().getId();
        
        // acquire 1 permit
        rateLimiter.acquire(1);
        
        try {
            
            // Call solve API of Optimization Solver Framework
            logger.info("[{}] === Start Solve ===", threadId);
            String returnData = optimizationSolver.solve(data);
            logger.info("[{}] Solution: {}", threadId, returnData);
            logger.info("[{}] === End solve ===", threadId);
            
            return returnData;
            
        } catch (Exception ex) {
            // handle exception
            logger.error("[{}] ERROR: {}", threadId, ex.getMessage());
            ex.printStackTrace();
        }
        
        return null;
    }

}
