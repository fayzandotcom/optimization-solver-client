package com.ipgmedia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ipgmedia.service.OptimizationSolverService;

@RestController
public class MainController {
    
    private OptimizationSolverService service;
    
    public MainController(OptimizationSolverService service) {
        this.service = service;
    }
    
    /*
     * API endpoint to solve some data
     */
    @GetMapping("solve/{data}")
    public String solve(@PathVariable("data") String data) {
        return "Solve Result: " + service.solveService(data);
    }

}
