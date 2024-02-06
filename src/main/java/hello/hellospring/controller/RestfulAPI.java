package hello.hellospring.controller;

import hello.hellospring.domain.Student;
import hello.hellospring.service.Member_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;

@Controller
public class RestfulAPI {
    private final Member_Service service;

    public RestfulAPI(Member_Service service) {
        this.service = service;
    }

    @GetMapping("/getById")
    @ResponseBody
    public Student handleGetRequest1(@RequestParam("Id") Long Id) {
        return service.findName(Id).orElse(null);
    }

    @GetMapping("/getByName")
    @ResponseBody
    public Student handleGetRequest2(@RequestParam("Name") String Name) {
        return service.findId(Name).orElse(null);
    }

    @PostMapping("/save")
    @ResponseBody
    public void handlePostRequest(@RequestBody Student student) {
        service.join(student);
    }

    @PutMapping("/update")
    @ResponseBody
    public void handlePutRequest(@RequestBody Student student) {
        service.Update(student);
    }

    @DeleteMapping("/DeleteByName")
    @ResponseBody
    public void handleDeleteRequest1(@RequestParam("Name") String Name) {
        service.DeleteStudentByName(Name);
    }

    @DeleteMapping("/DeleteById")
    @ResponseBody
    public void handleDeleteRequest2(@RequestParam("Id") long Id) {
        service.DeleteStudentById(Id);
    }
}
