package de.htwberlin.f4.calculationmicroservice.controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.htwberlin.f4.calculationmicroservice.services.CalculateMehrwertsteuerService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculateMehrwertsteuerController.class)
public class CalculateMehrwertsteuerControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculateMehrwertsteuerService service;

    @Test
    public void calculateMehrwertSteuerTest() throws Exception {
        when(service.calculateMehrwertSteuer(10.0)).thenReturn(1.9);
        this.mockMvc.perform(get("/api/v1/calculator/calculatemehrwertsteuer").param("preis", "10.0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(content().string("1.9"));
    }

    @Test
    public void calculateMehrwertSteuerInvalidValidationTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/calculatemehrwertsteuer").param("preis", "-1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN)).andExpect(content().string(containsString("Validation Error: ")));
    }

    @Test
    public void calculateMehrwertSteuerInvalidFormatTest() throws Exception {
        String s = "test";
        this.mockMvc.perform(get("/api/v1/calculator/calculatemehrwertsteuer").param("preis", s).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN)).andExpect(content().string(containsString("NumberFormatException: ")));
    }

    @Test
    public void calculateMehrwertSteuerNullParameter() throws Exception {
        String s = null;
        this.mockMvc.perform(get("/api/v1/calculator/calculatemehrwertsteuer").param("preis", s).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN)).andExpect(content().string(containsString("MissingServletRequestParameterException: ")));
    }

    @Test
    public void calculateMehrwertSteuerWrongParameter() throws Exception {
        String s = "10.0";
        this.mockMvc.perform(get("/api/v1/calculator/calculatemehrwertsteuer").param("test", s).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN)).andExpect(content().string(containsString("MissingServletRequestParameterException: ")));
    }

    @Test
    public void calculateMehrwertSteuerMissingParameter() throws Exception {
        this.mockMvc.perform(get("/api/v1/calculator/calculatemehrwertsteuer").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN)).andExpect(content().string(containsString("MissingServletRequestParameterException: ")));
    }
}
