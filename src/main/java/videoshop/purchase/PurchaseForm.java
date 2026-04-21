package videoshop.purchase;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class PurchaseForm {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String message;

    public PurchaseForm() {

    }

    public PurchaseForm(String email, String message) {
        this.email = email;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
