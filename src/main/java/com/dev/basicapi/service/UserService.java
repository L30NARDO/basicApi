package com.dev.basicapi.service;

import com.dev.basicapi.model.UserModel;
import com.dev.basicapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<UserModel> findAll(){
        List<UserModel> userModelList = new ArrayList<>();
        try {
            userModelList = userRepository.findAll();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return userModelList.isEmpty() ? new ArrayList<>() : userModelList;
    }

    public UserModel findById(Long id){
        Optional<UserModel> userModel = null;
        try {
            userModel = userRepository.findById(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return userModel.get() != null ? userModel.get() : new UserModel();
    }

    public UserModel save(UserModel userModel){

        try {
            if ( userModel.getPassword() != null){
            userModel.setPassword( passwordEncoder.encode(userModel.getPassword()));
            }
            userModel = userRepository.save(userModel);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return userModel != null ? userModel : new UserModel();
    }

    public UserModel update(UserModel userModel){

        try {
            userModel = userRepository.save(userModel);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return userModel != null ? userModel : new UserModel();
    }

    public void delete(Long id){
        Optional<UserModel> userModel = null;
        try {
            userModel = userRepository.findById(id);
            if(userModel.isPresent()){
                userRepository.delete(userModel.get());
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    public UserModel login(String email, String password){
        boolean valid = false;
        if (email.isEmpty() || password.isEmpty()) {
          return new UserModel();
        }
            Optional<UserModel> userModelOpt = userRepository.findByEmail(email);
            valid = passwordEncoder.matches(password, userModelOpt.get().getPassword());

        if(valid){
            return userModelOpt.get();
        }
        return new UserModel();
    }

}
