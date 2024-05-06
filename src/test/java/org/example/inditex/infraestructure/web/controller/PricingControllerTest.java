package org.example.inditex.infraestructure.web.controller;

import org.example.inditex.InditexApplication;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ContextConfiguration(classes = InditexApplication.class)
class PricingControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    void setUp() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    @Order(1)
    @DisplayName("Test 1 - Request at 10:00 a.m. on the 14th for product 35455 for brand 1. Returns correct price details and HTTP 200 status")
    void getPriceDetailsTest1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPriceDetails")
                        .param("date", "2020-06-14 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.*", hasSize(6)))
                .andExpect(jsonPath("$.brandId").exists())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.startDate").exists())
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.endDate").exists())
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.price").value(35.5))
                .andReturn();
    }

    @Test
    @Order(2)
    @DisplayName("Test 2 - Request at 4:00 p.m. on the 14th for product 35455 for brand 1. Returns correct price details and HTTP 200 status")
    void getPriceDetailsTest2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPriceDetails")
                        .param("date", "2020-06-14 16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.brandId").exists())
                .andExpect(jsonPath("$.*", hasSize(6)))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.startDate").exists())
                .andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"))
                .andExpect(jsonPath("$.endDate").exists())
                .andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00"))
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.price").value(25.45))
                .andReturn();
    }

    @Test
    @Order(3)
    @DisplayName("Test 3 - Request at 9:00 p.m. on day 14th for product 35455 for brand 1. Returns correct price details and HTTP 200 status")
    void getPriceDetailsTest3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPriceDetails")
                        .param("date", "2020-06-14 21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.*", hasSize(6)))
                .andExpect(jsonPath("$.brandId").exists())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.startDate").exists())
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.endDate").exists())
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.price").value(35.5))
                .andReturn();
    }

    @Test
    @Order(4)
    @DisplayName("Test 4 - Request at 10:00 a.m. on the 15th for product 35455 for brand 1. Returns correct price details and HTTP 200 status")
    void getPriceDetailsTest4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPriceDetails")
                        .param("date", "2020-06-15 10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.brandId").exists())
                .andExpect(jsonPath("$.*", hasSize(6)))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.startDate").exists())
                .andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$.endDate").exists())
                .andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00"))
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.price").value(30.5))
                .andReturn();
    }

    @Test
    @Order(5)
    @DisplayName("Test 5 - Request at 9:00 p.m. on day 16th for product 35455 for brand 1. Returns correct price details and HTTP 200 status")
    void getPriceDetailsTest5() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPriceDetails")
                        .param("date", "2020-06-16 21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.*", hasSize(6)))
                .andExpect(jsonPath("$.brandId").exists())
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.startDate").exists())
                .andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
                .andExpect(jsonPath("$.endDate").exists())
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:00"))
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.price").value(38.95))
                .andReturn();
    }

    @Test
    @Order(6)
    @DisplayName("Test 6 - Request at 9:00 p.m. on day 16th for product 35455 for brand 2. Returns an appropriate error message and HTTP 404 status")
    void getPriceDetailsTest6NotFound() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPriceDetails")
                        .param("date", "2020-06-16 21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "2")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.message").value(
                        "## There is no price for the parameters Date: 2020-06-16T21:00, ProductId: 35455, BrandId: 2. ##"))
                .andReturn();
    }

    @Test
    @Order(7)
    @DisplayName("Test 7 - Request at 9:00 p.m. on day 16th for product 35455. Returns an appropriate error message and HTTP 400 status")
    void getPriceDetailsTest7BadRequest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPriceDetails")
                        .param("date", "2020-06-16 21:00:00")
                        .param("productId", "35455")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.message").value(
                        "## Your request has issued an incorrect or illegal request. ## " +
                                "\nRequired request parameter 'brandId' for method parameter type int is not present"))
                .andReturn();
    }

    @Test
    @Order(8)
    @DisplayName("Test 8 - Wrong Api Rest End A. Returns an appropriate error message and HTTP 400 status")
    void getPriceDetailsTestBad() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/prices/getPrice")
                        .param("date", "2020-06-16 21:00:00")
                        .param("productId", "35455")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.message").value(
                        "## Your request has issued an incorrect or illegal request. ## " +
                                "\nNo static resource api/prices/getPrice."))
                .andReturn();
    }

}