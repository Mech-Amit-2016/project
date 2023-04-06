package com.example.demo.controller;

import com.example.demo.InsurancePolicy;
import com.example.demo.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//  ************************ this controller lest you do activities related to Insurance policy ********************
@Controller
public class InsurancePolicyController {
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

//    **************** this api lets you to crate or add new policy ***************************
    @PostMapping("/addpolicy")
    public @ResponseBody InsurancePolicy addOne(@RequestParam(name="type") String type, @RequestParam(name="coverageamt") int coverageamt, @RequestParam(name="premium") int premium, @RequestParam(name="startdate") String startdate, @RequestParam(name="enddate") String enddate) {
        try {
            InsurancePolicy insurancePolicy = new InsurancePolicy();
            insurancePolicy.setType(type);
            insurancePolicy.setCoverageamt(coverageamt);
            insurancePolicy.setPremium(premium);
            insurancePolicy.setStartdate(startdate);
            insurancePolicy.setEnddate(enddate);
            insurancePolicyRepository.save(insurancePolicy);
            return insurancePolicy;
        } catch (Exception ex) {
            return new InsurancePolicy();
        }
    }

//    *********** can get any policy ***********************
    @GetMapping("/policybyid")
    public @ResponseBody InsurancePolicy find(@RequestParam(name="policyid") int policyid) {
        try {
            return insurancePolicyRepository.findById(policyid).get();
        } catch (Exception ex) {
            return new InsurancePolicy();
        }
    }
//      ***************************** can access all policy at once *********************
    @GetMapping("/allpolicy")
    public @ResponseBody List<InsurancePolicy> getall(){
            return insurancePolicyRepository.findAll();
        }

//        ******************** can make changes to a policy ****************************
        @PutMapping("/updatepolicy")
    public @ResponseBody InsurancePolicy update(@RequestParam int id,@RequestParam String enddate){
        try {
            InsurancePolicy policy = insurancePolicyRepository.findById(id).get();
            policy.setEnddate(enddate);
            return policy;
        }
        catch(Exception ex){
            return new InsurancePolicy();
        }
        }
//  ******************************** can delete a policy *************************************
        @PutMapping("/deletepolicy")
    public @ResponseBody String delete(@RequestParam(name="policyid") int id){
        try {
            insurancePolicyRepository.deleteById(id);
            return "policy deleted";
        }
        catch(Exception ex){
            return "not deleted";
        }
        }
    }

