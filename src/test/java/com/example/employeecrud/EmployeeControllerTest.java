package com.example.employeecrud;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void sanity_createEmployee_thenGetEmployee() throws Exception {
        // 1️⃣ Create Employee
        String newEmployeeJson = """
            {
                "firstName": "Test",
                "lastName": "User",
                "email": "test.user@example.com"
            }
        """;

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newEmployeeJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());

        // 2️⃣ Get All Employees
        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
