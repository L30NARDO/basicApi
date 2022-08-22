package com.dev.basicapi.controller;


import com.dev.basicapi.model.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import javax.websocket.server.PathParam;

@Api(value = "USER")
@RestController()
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "Show all Users")
    @GetMapping()
    public ResponseEntity<?> findAll(){

        return ResponseEntity.ok("DONE");
    }
    @ApiOperation(value = "Find user by id")
    @GetMapping("/:id")
    public ResponseEntity<?> findById(@PathParam("id") Long id){

        return ResponseEntity.ok("DONE");
    }
    @ApiOperation(value = "Save a user")
    @PostMapping()
    public ResponseEntity<?> save(@RequestBody UserModel user){

        return ResponseEntity.ok("DONE");
    }

    @ApiOperation(value = "Update a user")
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody UserModel user){

        return ResponseEntity.ok("DONE");
    }

    @ApiOperation(value = "Delete a user")
    @DeleteMapping("/:id")
    public ResponseEntity<?> delete(@PathParam("id") Long id){

        return ResponseEntity.ok("DONE");
    }

}
