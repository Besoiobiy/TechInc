package com.TechInc.blog.models;
import javax.persistence.*;
@Entity
@Table(name = "equipments")
public class Equipment {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "characteristic")
    private String characteristic;
    @Column(name = "accounting")
    private boolean accounting;
    @Column(name = "status")
    private String status;
    @Column(name = "fact")
    private boolean fact;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Place place;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCharacteristic() {
        return characteristic;
    }
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
    public boolean isAccounting() {
        return accounting;
    }
    public void setAccounting(boolean accounting) {
        this.accounting = accounting;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public boolean isFact() {
        return fact;
    }
    public void setFact(boolean fact) {
        this.fact = fact;
    }
    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }
}