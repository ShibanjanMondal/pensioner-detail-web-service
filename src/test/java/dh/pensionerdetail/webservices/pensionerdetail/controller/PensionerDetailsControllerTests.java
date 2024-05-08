package dh.pensionerdetail.webservices.pensionerdetail.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class PensionerDetailsControllerTests {

    Logger logger = LoggerFactory.getLogger(PensionerDetailsControllerTests.class);

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    //for end point "/PensionerDetailByAadhaar/{aadhaar} " happy path
    @Test
    public void retrievePensionerByAadhaarTestHappyPath() throws Exception {
        mvc.perform(get("/PensionerDetailByAadhaar/3333-3333-3333")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.aadhaarNo").value("3333-3333-3333"))
                .andExpect(jsonPath("$.name").value("Kyle Roth"))
                .andExpect(jsonPath("$.dateOfBirth").value("19-01-1952"))
                .andExpect(jsonPath("$.pan").value("VYF044X4CH"))
                .andExpect(jsonPath("$.salaryEarned").value("58833.0"))
                .andExpect(jsonPath("$.allowances").value("11421.0"))
                .andExpect(jsonPath("$.pensionType").value("Family"))
                .andExpect(jsonPath("$.bankDetail.bankName").value("Canara Bank"))
                .andExpect(jsonPath("$.bankDetail.accountNo").value("580744615"))
                .andExpect(jsonPath("$.bankDetail.bankType").value("Public"));
    }
    @Test
    public void retrievePensionerByAadhaarTestNegScenario() throws Exception {
        logger.info(String.valueOf(mvc.perform(get("/PensionerDetailByAadhaar/3333-3333-3333"))));
        mvc.perform(get("/PensionerDetailByAadhaar/3333-3333-")).andExpect(status().isNotFound());
    }


}
