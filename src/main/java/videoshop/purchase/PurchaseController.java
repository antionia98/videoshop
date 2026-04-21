package videoshop.purchase;

import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class PurchaseController {

    private final PurchaseRequestRepository purchaseRequests;

    PurchaseController(PurchaseRequestRepository purchaseRequests) {
        this.purchaseRequests = purchaseRequests;
    }

    @GetMapping("/ankauf")
    String showForm(Model model) {
        model.addAttribute("purchaseForm", new PurchaseForm());
        return "ankauf";
    }

    @PostMapping("/ankauf")
    String submitForm(@Valid PurchaseForm form, Errors errors) {

        if(errors.hasErrors()) {
            return "ankauf";
        }

        purchaseRequests.save(new PurchaseRequest(form.getEmail(), form.getMessage()));

        return "redirect:/ankauf?success";
    }

    @GetMapping("/ankauf/requests")
    @PreAuthorize("hasRole('BOSS')")
    String showRequests(Model model) {

        model.addAttribute("requests", purchaseRequests.findAll());
        return "ankauf_requests";
    }
}
