package com.WHotels.HotelMIS.controller.common;


import com.WHotels.HotelMIS.dto.common.CustomerSavedResponse;
import com.WHotels.HotelMIS.model.common.Customer;
import com.WHotels.HotelMIS.service.CustomerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerManagementController {

    @Autowired
    CustomerManagementService customerManagementService;

    @GetMapping("/viewCustomer")
    ResponseEntity<Customer> findCustomerByNIC(@RequestParam String nicNo) throws Exception{
        Customer response = customerManagementService.findCustomerByNIC(nicNo);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/submit-customer")
    ResponseEntity<CustomerSavedResponse> saveCustomer(@RequestBody Customer customer) throws Exception{
        CustomerSavedResponse response = customerManagementService.saveCustomer(customer);
        return ResponseEntity.ok(response);
    }
}
