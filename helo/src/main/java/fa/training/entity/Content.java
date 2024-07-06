package fa.training.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Content-table")
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Title")
    private String title;

    @Column(name="Brief")
    private String brief;

    @Column
    private String contentDetail;

    @Column
    private LocalDate createDate;

    @Column
    private LocalDate updateTime;

    @ManyToOne(optional = true)
    @JoinColumn(referencedColumnName = "id")
    private User authorId;


}
