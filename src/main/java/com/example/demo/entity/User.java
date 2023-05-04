package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;

import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "race")
    String race;
    @Column(name = "sex")
    String sex;
    @Column(name = "level")
    Integer level;
    @Column(name = "shield")
    Integer shield;
    @Column(name = "heat_point")
    Integer heatPoint;
    @OneToOne
    Stats stats;
    @ManyToMany
    List<Weapon> weapons;
    @ManyToMany
    List<Abilitiy> abilities;
    @ManyToMany
    List<Item> items;
}

