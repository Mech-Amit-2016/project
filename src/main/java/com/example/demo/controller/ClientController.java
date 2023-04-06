package com.example.demo.controller;

import com.example.demo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
//      ******************** by using this controller you are able to perform client related activity form creating client to deletin *************
@org.springframework.stereotype.Controller
public class ClientController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
    @Autowired
    ClaimRepository claimRepository;
//    @GetMapping("/addStudent")
//
//    public @ResponseBody Student doadd(@RequestParam String name){
//        try{
//       Student student=new Student();
//       student.setName(name);
//       studentRepository.save(student);
//       return student;
//        }
//     catch(Exception ex){
//            Student notstudent=new Student();
//         notstudent.setId(-1);
//         notstudent.setName("not found");
//         return notstudent;
//     }
//    }

//    ************** **************************
    @GetMapping("/")
   public @ResponseBody String hello(){
        return "hello";
    }

//    *************************** ClientSpecificMethod **************************************

//    ************ code to fetch all client *********************
    @GetMapping("/getclients")
    public @ResponseBody ArrayList<Client> getAll(){
        ArrayList<Client> list= (ArrayList<Client>) clientRepository.findAll();
        return list;
    }

//    **************** by calling this api you are able to create new client ********************
    @PostMapping(path="/addclient")
    public @ResponseBody Client add(@RequestParam(name="name")String name,@RequestParam(name="dob") String dob,@RequestParam(name="address") String address,@RequestParam(name="contactno") String contactno,@RequestParam(name="policyid") int policyid ){
        try {
            Client client = new Client();
            client.setName(name);
            client.setDob(dob);
            client.setAddress(address);
            client.setContactno(contactno);
            InsurancePolicy policy=insurancePolicyRepository.findById(policyid).get();
            client.setPolicy(policy);
            clientRepository.save(client);
            return client;
        }
        catch(Exception ex){
            return new Client();
        }
    }

//    ************************* by calling this api you are able to acces a client details *******************
  @GetMapping("/findclient")
    public @ResponseBody Client findclient(@RequestParam int clientid){
        try {
            return clientRepository.findById(clientid).get();
        }
        catch(Exception ex){
            return new Client();
        }
  }

//  **************** you can update client details by calling this api ********************
  @PutMapping("/updateclient")
    public  @ResponseBody Client updateclient(@RequestParam(name="clientid") int clientid,@RequestParam(name="name") String name){
        try {
            Client client = clientRepository.findById(clientid).get();
            client.setName(name);
            return client;
        }
        catch(Exception ex){
            return new Client();
        }
  }

//  ****************** you can delete a client *****************************
  @DeleteMapping("/deletecient")
    public @ResponseBody String  deleteclient(@RequestParam(name="clientid") int clientid){
        try {
            Client client = clientRepository.findById(clientid).get();
            clientRepository.delete(client);
            return "client deleted";
        }
        catch(Exception ex){
            return "not deleted";
        }
  }
}
