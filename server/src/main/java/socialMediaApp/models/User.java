package socialMediaApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name")
    private String firstName;

    @NotNull
    @Column(name = "email")
    @Email
    private String email;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "title")
    private String title;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "bio")
    private String userBio;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Follow> following;
    @OneToMany(mappedBy = "following",cascade = CascadeType.ALL)
    Set<Follow> followers;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Post> posts;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Like> likes;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<UserImage> images;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    Set<Comment>comments;

}
