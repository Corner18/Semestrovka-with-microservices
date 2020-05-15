package ru.itis.semestrovka.models;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "itis_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String password;
    private LocalDateTime createdAt;
    @Enumerated(value = EnumType.STRING)
    private State state;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private String confirmCode;
    private String phoneNumber;
    private String avatar;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @Where(clause = "type = 'image/jpeg'")
    private List<FileInfo> fileInfoList;

}

