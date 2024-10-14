package agrospot.models;

import agrospot.enums.RolesEnum;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class UserModel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID external_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"))
//    @Column(name = "role")
//    private List<String> roles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RolesModel> roles;

    public UserModel(String name, String email, String password, Set<RolesModel> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.external_id = UUID.randomUUID();
        this.roles = roles;
    }

    public UserModel() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        if(this.roles.contains(RolesEnum.ADMIN))
//            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
//        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String toString() {
        return "User: " + this.id +
                ", " + this.name +
                ", " + this.email +
                ", " + this.password +
                ", " + this.roles;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternal_id() {
        return this.external_id;
    }

    public void setExternal_id(UUID external_id) {
        this.external_id = external_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RolesModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesModel> roles) {
        this.roles = roles;
    }
}

