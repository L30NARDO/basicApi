package com.dev.basicapi.controller;

import com.dev.basicapi.model.AddressModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;


import javax.websocket.server.PathParam;

@RestController()
@RequestMapping("/address")
public class AddressController {


    @GetMapping()
    public ResponseEntity<?> findAll(){

        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/:id")
    public ResponseEntity<?> findById(@PathParam("id") Long id){

        return ResponseEntity.ok("DONE");
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody AddressModel addres){

        return ResponseEntity.ok("DONE");
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody AddressModel addressModel){

        return ResponseEntity.ok("DONE");
    }

    @DeleteMapping("/:id")
    public ResponseEntity<?> delete(@PathParam("id") Long id){

        return ResponseEntity.ok("DONE");
    }
}
