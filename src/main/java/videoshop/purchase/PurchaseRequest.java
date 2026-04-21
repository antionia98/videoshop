package videoshop.purchase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import java.time.LocalDateTime;

@Entity
public class PurchaseRequest {
    @Id
    @GeneratedValue
    private Long id;

    private String email;

    @Lob
    private String message;

    private LocalDateTime createdAt = LocalDateTime.now();

    protected PurchaseRequest() {

    }

    public PurchaseRequest(String email, String message) {
        this.email = email;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
