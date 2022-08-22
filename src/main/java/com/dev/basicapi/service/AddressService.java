package com.dev.basicapi.service;

import com.dev.basicapi.model.AddressModel;
import com.dev.basicapi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;


    public List<AddressModel> findAll(){
        List<AddressModel> addressModelList = new ArrayList<>();
        try {
            addressModelList = addressRepository.findAll();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return addressModelList.isEmpty() ? new ArrayList<>() : addressModelList;
    }

    public AddressModel findById(Long id){
       Optional<AddressModel> addressModel = null;
        try {
            addressModel = addressRepository.findById(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return addressModel.get() != null ? addressModel.get() : new AddressModel();
    }

    public AddressModel save(AddressModel addressModel){

        try {
            addressModel = addressRepository.save(addressModel);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return addressModel != null ? addressModel : new AddressModel();
    }

    public AddressModel update(AddressModel addressModel){

        try {
            addressModel = addressRepository.save(addressModel);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return addressModel != null ? addressModel : new AddressModel();
    }

    public void delete(Long id){
        Optional<AddressModel> addressModel = null;
        try {
            addressModel = addressRepository.findById(id);
            if(addressModel.isPresent()){
                addressRepository.delete(addressModel.get());
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
