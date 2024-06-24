package com.example.springboot.maven.controller;
import com.example.springboot.maven.models.Employee;
import com.example.springboot.maven.repositories.EmployeeRepository;
import com.example.springboot.maven.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//    @RestController
//    @RequestMapping("/registration")
//    public class RegistrationController {
//        @Autowired
//        private EmployeeRepository employeeRepository;
//        @PostMapping(value = "/addEmployee", consumes = "application/json", produces = "application/json")
//        public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
//            System.out.println("@38::"+employee);
//            String msg=null;
//            Employee save=employeeRepository.save(employee);
//            if(save.getEmployeeId()!=null){
//            msg="Employee Saved ...";
//
//        }else{
//            msg="Failed to Save ..!!";
//        }
//
//
//            return ResponseEntity.ok(employee);
//            //return new ResponseEntity<>(msg, HttpStatus.CREATED);
//        }
//    }

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/addEmployee", consumes = {"application/json", "application/json"})
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        System.out.println("@38::" + employee.getEmailAddress());
        String msg = null;
        Employee savedEmployee = employeeRepository.save(employee);
        if (savedEmployee.getEmployeeId() != null) {
            msg = "Employee Saved ...";
            emailService.sendEmail(employee.getEmailAddress(), "Employee Registration Success", "Employee has been successfully registered.");
        } else {
            msg = "Failed to Save ..!!";
        }
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
}




//}
