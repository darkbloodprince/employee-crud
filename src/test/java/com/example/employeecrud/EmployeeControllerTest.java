package com.example.employeecrud;

import com.example.employeecrud.model.Employee;
import com.example.employeecrud.service.EmployeeService;
import com.example.employeecrud.controller.EmployeeController;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper; // For JSON serialization

    @Test
    public void testGetAllEmployees() throws Exception {
        Employee emp1 = new Employee("John", "Doe", "john@example.com", "IT");
        emp1.setDepartment("IT");
        Employee emp2 = new Employee("Jane", "Smith", "jane@example.com", "IT");
        emp2.setDepartment("HR");

        Mockito.when(employeeService.getAllEmployees())
                .thenReturn(Arrays.asList(emp1, emp2));

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[1].department").value("HR"));
    }

    @Test
    public void testGetEmployeeById() throws Exception {
        Employee emp = new Employee("John", "Doe", "john@example.com", "IT");
        emp.setDepartment("IT");
        Mockito.when(employeeService.getEmployeeById(1L))
                .thenReturn(Optional.of(emp));

        mockMvc.perform(get("/api/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }

    @Test
    public void testCreateEmployee() throws Exception {
        Employee emp = new Employee("Alice", "Wonder", "alice@example.com", "IT");
        emp.setDepartment("Finance");

        Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class)))
                .thenReturn(emp);

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emp)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Alice"))
                .andExpect(jsonPath("$.department").value("Finance"));
    }

    // Add more tests for update and delete similarly...
}
