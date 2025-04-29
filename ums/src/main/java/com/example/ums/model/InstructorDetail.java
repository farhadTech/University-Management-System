package com.example.ums.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_detail_seq")
    @SequenceGenerator(name = "instructor_detail_seq", sequenceName = "instructor_detail_seq", initialValue = 1001, allocationSize = 1)
    private Long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", fetch = FetchType.EAGER
            ,cascade = {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH}
    )
    private Instructor instructor;
}
