package com.felipe.controllstock.controllers.documentation;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerDocumentationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                                      .apply(documentationConfiguration(restDocumentation))
                                      .build();
    }


    @Test
    public void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/product"))
               .andExpect(status().isOk())
               .andDo(document("product-get-all"));
    }

    @Test
    public void testGetProductById() throws Exception {
        mockMvc.perform(get("/product/{id}", 1))
               .andExpect(status().isOk())
               .andDo(document("product-get-by-id"));
    }

    @Test
    public void testCreateProduct() throws Exception {
        mockMvc.perform(post("/product")
                .contentType("application/json")
                .content("{\"id\": 1, \"nome\": \"Produto Teste\", \"preco\": 10.0, \"quantidade\": 5}")
        )
               .andExpect(status().isOk())
               .andDo(document("product-create"));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        mockMvc.perform(delete("/product/{id}", 1))
               .andExpect(status().isNoContent())
               .andDo(document("product-delete"));
    }
}
