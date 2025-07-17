package tn.esprit.tpfoyer.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tn.esprit.tpfoyer.control.FoyerRestController;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FoyerRestController.class)
public class FoyerRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IFoyerService foyerService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testGetAllFoyers() throws Exception {
        Foyer f1 = new Foyer(1L, "F1", 100, null, null);
        Mockito.when(foyerService.retrieveAllFoyers()).thenReturn(List.of(f1));

        mockMvc.perform(get("/foyer/retrieve-all-foyers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nomFoyer").value("F1"));
    }

    @Test
    void testAddFoyer() throws Exception {
        Foyer f = new Foyer(null, "F2", 200, null, null);
        Mockito.when(foyerService.addFoyer(Mockito.any())).thenReturn(f);

        mockMvc.perform(post("/foyer/add-foyer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(f)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomFoyer").value("F2"));
    }
}