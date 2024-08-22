package org.modak.entity;

import jakarta.persistence.*;
import org.modak.entity.enums.Type;

import java.time.Instant;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_recipient", referencedColumnName = "id")
    private Recipient recipient;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String message;

    private Instant date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", recipient=" + recipient +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
