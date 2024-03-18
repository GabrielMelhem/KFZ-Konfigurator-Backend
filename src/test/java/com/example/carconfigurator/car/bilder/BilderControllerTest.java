package com.example.carconfigurator.car.bilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.util.Arrays;
import java.util.List;

@WebMvcTest(BilderController.class)
public class BilderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BilderService bilderService;

    private List<Bilder> sampleBilderList;

    @BeforeEach
    void setUp() {
        this.sampleBilderList = Arrays.asList(
                new Bilder("Der Polo", "image/png", "/Users/gabimelhem/Desktop/MyFiles/1Der Polo.png"),
                new Bilder("Der Polo2", "image/png", "/Users/gabimelhem/Desktop/MyFiles/2Der Polo.png"),
                new Bilder("GKlass", "image/png", "/Users/gabimelhem/Desktop/MyFiles/1GKlass.png"),
                new Bilder("GKlass5", "image/png", "/Users/gabimelhem/Desktop/MyFiles/5GKlass.png")
        );
    }

    @Test
    void shouldFetchAllBilder() throws Exception {
        when(bilderService.getBilder()).thenReturn(sampleBilderList);

        mockMvc.perform(get("/api/v1/bilder")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(sampleBilderList.size()))
                .andExpect(jsonPath("$[0].name").value(sampleBilderList.get(0).getName()))
                .andExpect(jsonPath("$[1].name").value(sampleBilderList.get(1).getName()));

        verify(bilderService, times(1)).getBilder();
    }
}
