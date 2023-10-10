package com.example.crudapp.controller;

import com.example.crudapp.model.SecurityGuard;
import com.example.crudapp.repo.SecurityGuardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class SecurityGuardController{
    @Autowired
    private SecurityGuardRepo securityGuardRepo;

    @GetMapping("/getAllSecurityGuards")
    public ResponseEntity<List<SecurityGuard>> getAllSecurityGuards(){
        try {
            List<SecurityGuard> securityGuardList = new ArrayList<>();
            securityGuardRepo.findAll().forEach(securityGuardList::add);

            if (securityGuardList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(securityGuardList, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @GetMapping("/getSecurityGuardId/{id}")
    public ResponseEntity<SecurityGuard> getSecurityGuardById(@PathVariable Long id){

        Optional<SecurityGuard> securityGuardData = securityGuardRepo.findById(id);

        if(securityGuardData.isPresent()){
            return new ResponseEntity<>(securityGuardData.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/addSecurityGuard")
    public ResponseEntity<SecurityGuard> addSecurityGuard(@RequestBody SecurityGuard securityGuard){
        SecurityGuard securityGuardObj= securityGuardRepo.save(securityGuard);

        return new ResponseEntity<>(securityGuardObj, HttpStatus.OK);

    }
    @PostMapping("/updateSecurityGuard/{id}")
    public ResponseEntity<SecurityGuard> updateBook(@PathVariable Long id, @RequestBody SecurityGuard securityGuard) {
        try {
            Optional<SecurityGuard> securityGuardData = securityGuardRepo.findById(id);
            if (securityGuardData.isPresent()) {
                SecurityGuard updatedSecurityGuardData = securityGuardData.get();
                updatedSecurityGuardData.setFirstName(securityGuard.getFirstName());
                updatedSecurityGuardData.setLastName(securityGuard.getLastName());
                updatedSecurityGuardData.setPhoneNumber(securityGuard.getPhoneNumber());
                updatedSecurityGuardData.setEmail(securityGuard.getEmail());

                SecurityGuard securityGuardObj = securityGuardRepo.save(updatedSecurityGuardData);
                return new ResponseEntity<>(securityGuardObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteSecurityGuardById/{id}")
    public ResponseEntity<SecurityGuard> deleteSecurityGuardById(@PathVariable Long id){

        securityGuardRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

