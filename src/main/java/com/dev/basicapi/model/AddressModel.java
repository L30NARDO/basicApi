package com.dev.basicapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressModel {

    private String adress;
    private Long number;
    private String City;
    private String Country;

}
