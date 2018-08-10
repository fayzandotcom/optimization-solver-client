package com.ipgmedia;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.util.concurrent.RateLimiter;
import com.ipgmedia.lib.OptimizationSolver;
import com.ipgmedia.service.OptimizationSolverService;

@SpringBootApplication
public class Application {
    
    @Value("${optimization.solver.license.count}")
    private int licenseCount;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/*
	 * Initialize Guava Rate Limiter bean
	 */
	@Bean
	public RateLimiter rateLimiter() {
	    return RateLimiter.create(licenseCount);
	}
	
	@Bean
	public OptimizationSolver optimizationSolver() {
	    return new OptimizationSolver();
	}
	
	@Bean
	public OptimizationSolverService optimizationSolverService(OptimizationSolver optimizationSolver, 
	        RateLimiter rateLimiter) {
	    return new OptimizationSolverService(optimizationSolver, rateLimiter);
	}
}
