package universe.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import universe.entity.enums.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enable;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "userEntity")
    private List<PublicationEntity> publicationEntityList = new ArrayList<>();

    @ManyToMany(mappedBy = "userEntityLikes")
    private List<CommentEntity> commentEntityList = new ArrayList<>();
}
