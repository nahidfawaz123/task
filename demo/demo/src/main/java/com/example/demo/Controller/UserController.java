package com.example.demo.Controller;

import com.example.demo.Model.Bank;
import com.example.demo.Model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {

    ArrayList<Users> user = new ArrayList<>();

    @GetMapping("users")
    public ArrayList allUsers() {

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody Users users) {
        for (Users value : user) {
            if (value.getUserName().equals(users.getUserName())
                    && value.getId().equals(users.getId())
                    && value.getEmail().equals(users.getEmail())) {
                return ResponseEntity.status(400).body("the user is exist ");
            }
        }
        if (users.getName() == null
                || users.getUserName() == null
                || users.getPassword() == null
                || users.getEmail() == null) {
            return ResponseEntity.status(400).body("pleases full all filed ");
        }
        user.add(users);
        return ResponseEntity.status(200).body("user Added");
    }

    @PutMapping("/users/dePost/")
    public ResponseEntity<String> dePost(@RequestBody Users users) {
        for (Users value : user) {
            if (value.getUserName().equals(users.getUserName())
                    && value.getPassword().equals(users.getPassword())) {
                value.setBalance(value.getBalance() + users.getBalance());
                System.out.println(value.getBalance());
                return ResponseEntity.status(200).body("dePost success ");

            }
        }
        return ResponseEntity.status(400).body("userName or password not correct");
    }

    @PutMapping("/users/withdraw/")
    public ResponseEntity<String> withdraw(@RequestBody Users users) {
        for (Users value : user) {
            if (value.getUserName().equals(users.getUserName())
                    && value.getPassword().equals(users.getPassword())) {
                value.setBalance(value.getBalance() - users.getBalance());
                System.out.println(value.getBalance());
                return ResponseEntity.status(200).body("withdraw success ");
            }
        }
        return ResponseEntity.status(400).body("userName or password not correct");
    }

    @PutMapping("/users/loanAmountUser/")
    public ResponseEntity<String> loanAmountUser(@RequestBody Users users) {

        for (Users value : user) {
            if (value.getUserName().equals(users.getUserName()) && value.getPassword().equals(users.getPassword())) {
                Bank bank = new Bank();

                if (value.getLoanAmount() > bank.getBankBalance()) {
                    return ResponseEntity.status(400).body(" error ");
                } else {
                    value.setLoanAmount(value.getLoanAmount() + users.getLoanAmount());
                    bank.setBankBalance(bank.getBankBalance() - value.getLoanAmount());
                    System.out.println(bank.getBankBalance());
                    return ResponseEntity.status(200).body(" loanAmount success ");
                }
            }
        }
        return ResponseEntity.status(400).body("userName or password not correct");
    }

    @PutMapping("/users/loanAmountDePost/")
    public ResponseEntity<String> loanAmountDePost(@RequestBody Users users) {

        for (Users value : user) {
            if (value.getUserName().equals(users.getUserName())
                    && value.getPassword().equals(users.getPassword())) {
                value.setLoanAmount(value.getLoanAmount() - users.getBalance());
                Bank bank = new Bank();
                bank.setBankBalance(bank.getBankBalance() + users.getBalance());//سداد
                value.setBalance(value.getBalance() - users.getBalance());
                System.out.println(bank.getBankBalance());

                return ResponseEntity.status(200).body(" loanAmount success ");
            }
        }
        return ResponseEntity.status(400).body("userName or password not correct");
    }

    @DeleteMapping("/users/deleteUser/")
    public ResponseEntity<String> deleteUser(@RequestBody Users users) {
        for (Users value : user) {
            if (value.getUserName().equals(users.getUserName()) && value.getPassword().equals(users.getPassword())) {
                if (value.getLoanAmount() == 0) {
                    Bank bank = new Bank();
                    bank.setBankBalance(bank.getBankBalance() + value.getBalance());
                    user.remove(value);
                    return ResponseEntity.status(200).body(" deleted user success ");
                }
                return ResponseEntity.status(400).body(" can not cancel  your account because you hav Loan Amount ");
            }
        }
        return ResponseEntity.status(400).body(" username or password is not correct");

    }
}
