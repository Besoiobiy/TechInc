package com.TechInc.blog.models;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "places")
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "organization")
    private String organization;
    @Column(name = "checked")
    private boolean checked;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "place")
    private List<Equipment> equipments = new ArrayList<>();
    public void addEquipmentToPlace(Equipment equipment) {
        equipment.setPlace(this);
        equipments.add(equipment);
    }
}