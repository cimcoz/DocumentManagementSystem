/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentsystem.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "positions")
public class Positions implements Serializable {

//    @Basic(optional = false)
//    @Column(name = "BpID")
//    
//    private int bpID;
    @ManyToMany(mappedBy = "positionsCollection")
    private Collection<Businesspartner> businesspartnerCollection;
    @OneToMany(mappedBy = "positions_fk")
    private Collection<Users> usersCollection;

    @Id
    @Column(name = "posID")
    private int posID;

    @Column(name = "posName")
    private String posName;

    @Column(name = "posDescription")
    private String posDescription;
   
   
    @ManyToOne(fetch = FetchType.EAGER)
     //@PrimaryKeyJoinColumn(name = "BpID")
    @JoinColumn(name = "BpID")
    private Businesspartner bpID;
//    private int bpID;

    public Positions() {
    }

    public Positions(Integer posID) {
        this.posID = posID.intValue();
    }

    public Positions(Integer posID, String posName, Businesspartner bpID) {
        this.posID = posID.intValue();
        this.posName = posName;
        this.bpID = bpID;
    }

    public Positions(Integer posID, String posName, String posDescription) {
        this.posID = posID.intValue();
        this.posName = posName;
        this.posDescription = posDescription;

    }

    public Positions(int posID, String posName, String posDescription, Businesspartner bpID) {
        this.posID = posID;
        this.posName = posName;
        this.posDescription = posDescription;
        this.bpID = bpID;
    }

    public Positions(String pos) {
       this.posName = pos;
    }

//    public Positions(int posID, String posName, String posDescription, int bpID) {
//        this.bpID = bpID;
//    }
    public Businesspartner getBusinesspartner() {
        return bpID;
    }

    public void setBusinessPartner(Businesspartner bpID) {
        this.bpID = bpID;

    }

    public int getPosID() {
        return posID;
    }

    public void setPosID(int posID) {
        this.posID = posID;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getPosDescription() {
        return posDescription;
    }

    public void setPosDescription(String posDescription) {
        this.posDescription = posDescription;
    }

    @Override
    public String toString() {
        return posID + " "+posName;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Positions other = (Positions) obj;
        if (this.posID != other.posID) {
            return false;
        }
        if (!Objects.equals(this.posName, other.posName)) {
            return false;
        }
        if (!Objects.equals(this.posDescription, other.posDescription)) {
            return false;
        }
        if (!Objects.equals(this.businesspartnerCollection, other.businesspartnerCollection)) {
            return false;
        }
        if (!Objects.equals(this.usersCollection, other.usersCollection)) {
            return false;
        }
        if (!Objects.equals(this.bpID, other.bpID)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.businesspartnerCollection);
        hash = 41 * hash + Objects.hashCode(this.usersCollection);
        hash = 41 * hash + this.posID;
        hash = 41 * hash + Objects.hashCode(this.posName);
        hash = 41 * hash + Objects.hashCode(this.posDescription);
        hash = 41 * hash + Objects.hashCode(this.bpID);
        return hash;
    }

    

    @XmlTransient
    public Collection<Businesspartner> getBusinesspartnerCollection() {
        return businesspartnerCollection;
    }

    public void setBusinesspartnerCollection(Collection<Businesspartner> businesspartnerCollection) {
        this.businesspartnerCollection = businesspartnerCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

}
