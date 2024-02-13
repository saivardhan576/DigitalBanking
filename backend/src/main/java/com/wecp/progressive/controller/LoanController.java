package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Loan;
import com.wecp.progressive.service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    LoanService loanService;
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return new ResponseEntity<List<Loan>>(loanService.getAllLoans(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Loan localLoan = loanService.getLoanById(id);
        if (localLoan != null) {
            return new ResponseEntity<>(localLoan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        return new ResponseEntity<Loan>(loanService.createLoan(loan), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLoan(@PathVariable Long id, @RequestBody Loan loan) {
        Loan l = loanService.getLoanById(id);
        if (l!= null) {
            loan.setId(id);
            loanService.updateLoan(loan);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        Loan l = loanService.getLoanById(id);
        if (l!= null) {
            loanService.deleteLoan(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}