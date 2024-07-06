package fa.training.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name="Member")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Firstname")
    private String firstName;

    @Column(name="Lastname")
    private String lastName;

    @Column(name="Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name="Phone")
    private String phone;

    @Column(name="Email")
    private String email;

    @Column(name="Description")
    private String description;

    @Column
    private LocalDate createDate;

    @Column
    private LocalDate updateDate;

    @OneToMany(mappedBy = "authorId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Content> contents;

}
