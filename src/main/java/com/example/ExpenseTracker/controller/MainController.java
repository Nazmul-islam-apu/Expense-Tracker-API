package com.example.ExpenseTracker.controller;

import com.example.ExpenseTracker.model.Expense;
import com.example.ExpenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class MainController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @PostMapping("/add")
    public ResponseEntity<Expense> addNew(@RequestBody Expense expense){
        expenseRepository.save(expense);
        return new ResponseEntity<>(expense,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Expense>>getAllExpense(){
        List<Expense> allExpense = new ArrayList<>();
        allExpense = expenseRepository.findAll();
        return new ResponseEntity<>(allExpense,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense){
        expenseRepository.save(expense);
        return new ResponseEntity<>(expense,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Expense>deleteExpense(@PathVariable("id") Long id){
        expenseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
