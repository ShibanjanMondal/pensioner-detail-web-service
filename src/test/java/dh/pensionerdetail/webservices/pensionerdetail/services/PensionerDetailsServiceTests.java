package dh.pensionerdetail.webservices.pensionerdetail.services;

import dh.pensionerdetail.webservices.pensionerdetail.models.PensionerDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.NoSuchElementException;


//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Slf4j
public class PensionerDetailsServiceTests {
    Logger logger = LoggerFactory.getLogger(PensionerDetailsServiceTests.class);
    @Autowired
    private MockMvc mvc;


    PensionerDetail pensionerDetail;

    @Autowired
    PensionerDetailsService pensionerDetailsService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getPensionerByAadhaarTest_HappyPath() {
        String aadhaar = "3333-3333-3333";
        pensionerDetail = pensionerDetailsService.getPensionerByAadhaar(aadhaar);
        Assertions.assertNotNull(pensionerDetail);
        Assertions.assertEquals(aadhaar, pensionerDetail.getAadhaarNo());
        Assertions.assertEquals("Kyle Roth", pensionerDetail.getName());
        Assertions.assertEquals("19-01-1952", pensionerDetail.getDateOfBirth());
        Assertions.assertEquals("VYF044X4CH", pensionerDetail.getPAN());
        Assertions.assertEquals(58833.0, pensionerDetail.getSalaryEarned(), 0.00);
        Assertions.assertEquals(11421.0, pensionerDetail.getAllowances(), 0.00);
        Assertions.assertEquals("Family", pensionerDetail.getPensionType());
        Assertions.assertEquals("Canara Bank", pensionerDetail.getBankDetail().getBankName());
        Assertions.assertEquals("580744615", pensionerDetail.getBankDetail().getAccountNo());
        Assertions.assertEquals("Public", pensionerDetail.getBankDetail().getBankType());
    }
    @Test
    public void getPensionerByAadhaarTest_NegPath() {
        String aadhaar = "3333-3333-33";
           Assertions.assertThrows(NoSuchElementException.class, ()-> pensionerDetailsService.getPensionerByAadhaar(aadhaar));
    }

    @Test
    public void getPensionerByAadhaarTest_validate_returnType(){
        String aadhaar = "3333-3333-3333";
        Assertions.assertNotNull(pensionerDetailsService.getPensionerByAadhaar(aadhaar));
        Assertions.assertEquals(PensionerDetail.class,(pensionerDetailsService.getPensionerByAadhaar(aadhaar)).getClass());
    }

}
