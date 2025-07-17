package tn.esprit.tpfoyer.repositories.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import tn.esprit.tpfoyer.control.BlocRestController;
import tn.esprit.tpfoyer.service.BlocServiceImpl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(BlocRestController.class)
public class BlocControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlocServiceImpl blocService;

    @Test
    void testGetBlocs() throws Exception {
        mockMvc.perform(get("/bloc"))
                .andExpect(status().isOk());
    }
}
