package com.boot.billing_software.controller;
import com.boot.billing_software.dto.InvoiceRequestDTO;
import com.boot.billing_software.dto.InvoiceResponseDTO;
import com.boot.billing_software.entity.Invoice;
import com.boot.billing_software.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // POST /invoices
    @PostMapping
    public InvoiceResponseDTO createInvoice(@RequestBody InvoiceRequestDTO request) {
        return invoiceService.generateInvoice(request);
    }

    // GET /invoices
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // GET /invoices/{id}
    @GetMapping("/{id}")
    public Invoice getInvoice(@PathVariable String id) {
        return invoiceService.getInvoiceById(id);
    }

    // GET /invoices/customer/{customerId}
    @GetMapping("/customer/{customerId}")
    public List<Invoice> getByCustomer(@PathVariable int customerId) {
        return invoiceService.getInvoicesByCustomerId(customerId);
    }
}
