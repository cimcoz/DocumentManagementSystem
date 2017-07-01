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


@Entity
@Table(name ="city")

public class City implements Serializable
{

    @OneToMany(mappedBy = "zip")
    private Collection<Businesspartner> businesspartnerCollection;

//    @OneToMany(mappedBy = "zip")
//    private Collection<Businesspartner> businesspartnerCollection;

//    @OneToMany(mappedBy = "zip")
//    private Collection<Businesspartner> businesspartnerCollection;
    
    @Column (name = "Zip")
    @Id
  private int zip;
 
    @Column (name = "CityName")
  private String cityName;


  public City()
  {
    zip = 0;
    cityName = "n/a";
  }
  
  public City(int zip, String cityName) {
    this.zip = zip;
    this.cityName = cityName;
  }

//    public City(String cityName) {
//        this.cityName = cityName;
//    }
//     public City(int zip) {
//        this.zip = zip;
//    }
  
  public int getZip()
  {
    return zip;
  }
  
  public void setZip(int zip) {
    this.zip = zip;
  }
  
  public String getCityName() {
    return cityName;
  }
  
  public void setCityName(String cityName) {
    this.cityName = cityName;
  }
  

    @Override
  public String toString()
  {
    return  cityName + " "+zip;
  }
  


  @Override
  public boolean equals(Object obj)
  {
    if ((obj != null) && ((obj instanceof City)))
    {
      City c = (City)obj;
      return c.cityName.equals(cityName);
    }
    return false;
  }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.zip;
        hash = 71 * hash + Objects.hashCode(this.cityName);
        return hash;
    }

//    @XmlTransient
//    public Collection<Businesspartner> getBusinesspartnerCollection() {
//        return businesspartnerCollection;
//    }
//
//    public void setBusinesspartnerCollection(Collection<Businesspartner> businesspartnerCollection) {
//        this.businesspartnerCollection = businesspartnerCollection;
//    }

//    @XmlTransient
//    public Collection<Businesspartner> getBusinesspartnerCollection() {
//        return businesspartnerCollection;
//    }
//
//    public void setBusinesspartnerCollection(Collection<Businesspartner> businesspartnerCollection) {
//        this.businesspartnerCollection = businesspartnerCollection;
//    }

    @XmlTransient
    public Collection<Businesspartner> getBusinesspartnerCollection() {
        return businesspartnerCollection;
    }

    public void setBusinesspartnerCollection(Collection<Businesspartner> businesspartnerCollection) {
        this.businesspartnerCollection = businesspartnerCollection;
    }

   
}
