package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int clientid;
    @Column
    private String name;
    @Column
    private String dob;
    @Column
    private String address;
    @Column
    private String contactno;
    public int getId() {
        return clientid;
    }
@ManyToOne
@JoinColumn(name="policyid")
@JsonBackReference

private InsurancePolicy policy;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int clientid) {
        this.clientid = clientid;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }


    public InsurancePolicy getPolicy() {
        return policy;
    }

    public void setPolicy(InsurancePolicy policy) {
        this.policy = policy;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}
