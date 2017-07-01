/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentsystem.model;

import static com.oracle.util.Checksums.update;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "users")
public class Users implements Serializable{

    @Id
    @Column(name = "userID")
    private int userID;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    // @MapsId
    @ManyToOne
    @JoinColumn(name = "role_fk")
    public Role role_fk;
    //@MapsId
    @ManyToOne
    @JoinColumn(name = "positions_fk")
    private Positions positions_fk;
    //@MapsId()
    @JoinColumn(name = "busPartner_fk")
   
    @ManyToOne
    private Businesspartner busPartner_fk;

    public Users() {
    }

    public Users(Integer userID) {

        this.userID = userID.intValue();
    }

    public Users(Integer userID, String name, String lastName, String username, String password, Role role, Positions positions_fk, Businesspartner bp) {
        this.userID = userID.intValue();
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role_fk = role;
        this.positions_fk = positions_fk;
        this.busPartner_fk = bp;
    }

    public Users(String name, String lastName, String username, String password) {

        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;

    }

    public Users(String name) {
        this.name = name;
    }

    public Users(String user, Businesspartner bpp) {
        this.name = user;
        this.busPartner_fk = bpp;
    }

    public Businesspartner getBp() {
        return busPartner_fk;
    }

    public void setBp(Businesspartner bp) {
        this.busPartner_fk = bp;
    }

    public Positions getPos() {
        return positions_fk;
    }

    public void setPos(Positions positions_fk) {
        this.positions_fk = positions_fk;
    }

    public Role getRoleFk() {
        return role_fk;
    }

    public void setRoleFk(Role role) {

        this.role_fk = role;

    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {

        this.userID = userID.intValue();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        this.username = username;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;

    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 83 * hash + this.userID;
//        hash = 83 * hash + Objects.hashCode(this.positions_fk);
//        hash = 83 * hash + Objects.hashCode(this.busPartner_fk);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Users other = (Users) obj;
//        if (this.userID != other.userID) {
//            return false;
//        }
//        if (!Objects.equals(this.positions_fk, other.positions_fk)) {
//            return false;
//        }
//        if (!Objects.equals(this.busPartner_fk, other.busPartner_fk)) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Users other = (Users) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.role_fk, other.role_fk)) {
            return false;
        }
        if (!Objects.equals(this.positions_fk, other.positions_fk)) {
            return false;
        }
        if (!Objects.equals(this.busPartner_fk, other.busPartner_fk)) {
            return false;
        }
        return true;
    }
}
