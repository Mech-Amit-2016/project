package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


import java.util.List;

@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    int claimid;
    @Column
    String description;
    @Column
    String claimdate;
    @Column
    String claimstatus;
    @ManyToOne
    @JoinColumn(name="policyid")
    @JsonBackReference
    InsurancePolicy policy;

    public int getClaimid() {
        return claimid;
    }

    public void setClaimid(int claimid) {
        this.claimid = claimid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClaimdate() {
        return claimdate;
    }

    public void setClaimdate(String claimdate) {
        this.claimdate = claimdate;
    }

    public String getClaimstatus() {
        return claimstatus;
    }

    public void setClaimstatus(String claimstatus) {
        this.claimstatus = claimstatus;
    }

    public InsurancePolicy getPolicy() {
        return policy;
    }

    public void setPolicy(InsurancePolicy policy) {
        this.policy = policy;
    }

}

