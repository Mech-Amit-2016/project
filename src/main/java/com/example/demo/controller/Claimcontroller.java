package com.example.demo.controller;

import com.example.demo.Claim;
import com.example.demo.ClaimRepository;
import com.example.demo.InsurancePolicy;
import com.example.demo.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
//*****************   this class is used to controll all the activity of claim from creating to delete ***********
@Controller
public class Claimcontroller {
    @Autowired
    ClaimRepository claimRepository;
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
//    **************** this api is used to create new claim ********************************
  @PostMapping("/addclaim")
  public @ResponseBody Claim addClaim(@RequestParam(name="claimid")int claimid, @RequestParam(name="description")String description, @RequestParam(name="claimstatus")String claimstatus, @RequestParam(name="claimdate")String claimdate,@RequestParam(name="policyid")int  policyid){
      try {
          Claim claim = new Claim();
          claim.setDescription(description);
          claim.setClaimdate(claimdate);
          claim.setClaimstatus(claimstatus);
          InsurancePolicy policy = insurancePolicyRepository.findById(policyid).get();
          claim.setPolicy(policy);
          claimRepository.save(claim);
          return claim;
      }
      catch(Exception ex){
          return new Claim();
      }
  }
//  ***************** this api is used to retrieve all claims **************************
    @GetMapping("/allclaim")
    public @ResponseBody ArrayList<Claim> claims(){

      return (ArrayList<Claim>) claimRepository.findAll();
    }
// ************************** this api is used to access a perticular claim
    @GetMapping("/findclaim")
    public @ResponseBody Claim getClaim(@RequestParam(name="claimid") int claimid){
        try {
            return claimRepository.findById(claimid).get();
        }
        catch(Exception ex){
            return new Claim();
        }
    }
//  ****************************** this api is used to update a claim  *********************************
    @PutMapping("/updateclaim")
    public @ResponseBody Claim changeClaim(@RequestParam(name="claimid") int claimid,@RequestParam(name="claimstatus") String claimstatus){
        try {
            Claim claim = claimRepository.findById(claimid).get();
            claim.setClaimstatus(claimstatus);
            return claim;
        }
        catch(Exception ex){
            return new Claim();
        }
    }
//    ******************* By calling this api you can delete all claim
    @DeleteMapping("/deleteclaim")
    public @ResponseBody String deleteClaim(@RequestParam int claimid){
        try {
            Claim claim = claimRepository.findById(claimid).get();
            claimRepository.delete(claim);
            return "deleted claim";
        }
        catch(Exception ex){
            return "notdeleted";
        }
    }
}
