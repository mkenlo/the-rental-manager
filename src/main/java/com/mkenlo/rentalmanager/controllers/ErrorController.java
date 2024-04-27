
package com.mkenlo.rentalmanager.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ErrorController {

    // Mapping for /error
    @GetMapping("/error")
    public String handleError() {
        // Handle error logic here
        return "error"; 
    }
    
}
// Rest of the code
