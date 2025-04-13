package com.example.ums.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "instructorDetail")
@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor",
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE,
//                    CascadeType.REFRESH,
//                    CascadeType.DETACH}
//    ) // refers to instructor instance in Course class.
//    private Set<Course> courses = new LinkedHashSet<>();
}
