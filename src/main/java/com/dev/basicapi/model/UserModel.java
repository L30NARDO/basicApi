package com.dev.basicapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel {

    private String name;
    private String lastName;
    private Date birthDate;
    private AddressModel addressModel;
}
