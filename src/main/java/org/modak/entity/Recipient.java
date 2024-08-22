package org.modak.entity;

import jakarta.persistence.*;

@Entity
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Recipient{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
