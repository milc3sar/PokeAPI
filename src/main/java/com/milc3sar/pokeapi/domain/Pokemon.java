package com.milc3sar.pokeapi.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.milc3sar.pokeapi.domain.Type;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "pokemon")
public class Pokemon implements Serializable {

    private static final long serialVersionUID = -5620858840205300545L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer height;

    private Integer weight;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "pokemon_type",
            joinColumns = @JoinColumn(name = "pokemon_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<Type> types;
}