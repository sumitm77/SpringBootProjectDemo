package com.springbootproject.sumit.services;

import org.springframework.beans.factory.annotation.Autowired;

//Replacement of Setter,Getter and Constructor
public class TestLombokEmployee {
    @Autowired
    private Employee employee;


    public Employee getEmployee(){
        return employee;
    }

    public static void main(String[] args) {

        Employee lombokEmp = new Employee();
        lombokEmp.setAge(21);
        lombokEmp.setName("Sumit");
        lombokEmp.setAddress("Bhugaon");
        lombokEmp.setCity("Pune");
        System.out.println(lombokEmp.getAge());
        System.out.println(lombokEmp);



    }


}
