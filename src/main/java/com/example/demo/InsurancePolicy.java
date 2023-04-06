package com.example.demo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int policyid;
    @Column
    private String type;
    @Column
    private int coverageamt;
    @Column private int premium;
    @Column private String startdate;
    @Column private String enddate;

   @OneToMany
   @JoinColumn(name="policyid")
   private List<Client> clientList;
   @OneToMany
   @JoinColumn(name="policyid")
   private List<Claim> claimList;
    public int getId() {
        return policyid;
    }

    public void setId(int policyid) {
        this.policyid = policyid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCoverageamt() {
        return coverageamt;
    }

    public void setCoverageamt(int coverageamt) {
        this.coverageamt = coverageamt;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public int getPolicyid() {
        return policyid;
    }

    public void setPolicyid(int policyid) {
        this.policyid = policyid;
    }

    public List<Claim> getClaimList() {
        return claimList;
    }

    public void setClaimList(List<Claim> claimList) {
        this.claimList = claimList;
    }

}
