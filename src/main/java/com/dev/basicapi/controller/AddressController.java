package com.dev.basicapi.controller;

import com.dev.basicapi.model.AddressModel;
import com.dev.basicapi.service.AddressService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ExampleProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;

@RestController()
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping()
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){

        return ResponseEntity.ok(addressService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody() AddressModel address){
        return ResponseEntity.created(URI.create("str")).body(addressService.save(address));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody() AddressModel addressModel){

        return ResponseEntity.ok(addressService.update(addressModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        addressService.delete(id);
        return ResponseEntity.ok("");
    }
}
