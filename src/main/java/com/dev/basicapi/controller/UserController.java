package com.dev.basicapi.controller;


import com.dev.basicapi.model.UserModel;
import com.dev.basicapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;

@Api(value = "USER")
@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Show all Users")
    @GetMapping()
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    @ApiOperation(value = "Find user by id")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){

        return ResponseEntity.ok(userService.findById(id));
    }
    @ApiOperation(value = "Save a user")
    @PostMapping()
    public ResponseEntity<?> save(@RequestBody UserModel user){

        return ResponseEntity.created(URI.create("created")).body(userService.save(user));
    }

    @ApiOperation(value = "Update a user")
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody UserModel user){

        return ResponseEntity.ok(userService.update(user));
    }

    @ApiOperation(value = "Delete a user")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathParam("id") Long id){
        userService.delete(id);
        return ResponseEntity.ok("");
    }

    @ApiOperation(value = "Delete a user")
    @DeleteMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password){
        UserModel userModel = userService.login(email, password);
        return userModel.getId()  != null ?
                ResponseEntity.status(HttpStatus.OK).body(userModel) :
                ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
