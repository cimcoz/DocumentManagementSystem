/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentsystem.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {

    @OneToMany(mappedBy = "role_fk")
    private Collection<Users> usersCollection;

    @Id
    @Column(name = "roleID")
    private int roleID;

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "roleDescription")
    private String roleDescription;

    public Role() {
        roleID = 0;
        roleName = "n/a";
    }

    public Role(int roleID, String roleName, String roleDescription) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public Role(int roleID) {
        this.roleID = roleID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {

        this.roleID = roleID;

    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {

        this.roleName = roleName;

    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {

        this.roleDescription = roleDescription;

    }

    @Override
    public String toString() {
        return roleID + " " + roleName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.roleID;
        hash = 53 * hash + Objects.hashCode(this.roleName);
        hash = 53 * hash + Objects.hashCode(this.roleDescription);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj != null) && ((obj instanceof Role))) {
            Role r = (Role) obj;
            return r.getRoleName() == roleName;
        }
        return false;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

}
