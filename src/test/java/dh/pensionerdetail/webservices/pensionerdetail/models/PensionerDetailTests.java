package dh.pensionerdetail.webservices.pensionerdetail.models;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Slf4j
public class PensionerDetailTests {
    @Test
    public void validateAllArgsConst() {
        PensionerDetail pensionerDetail = new PensionerDetail("abc","name","dob","pan",100.0,200.0,"type",null);
        Assertions.assertNotNull(pensionerDetail);
    }
    @Test
    public void validateSetters(){
        PensionerDetail pensionerDetail = new PensionerDetail();
        pensionerDetail.setBankDetail(null);
        pensionerDetail.setPensionType("type");
        pensionerDetail.setAadhaarNo("aadhaar");
        pensionerDetail.setAllowances(100.0);
        pensionerDetail.setName("name");
        pensionerDetail.setDateOfBirth("dob");
        pensionerDetail.setSalaryEarned(200.0);
        pensionerDetail.setPAN("pan");

        Assertions.assertNull(pensionerDetail.getBankDetail());
        Assertions.assertEquals("type",pensionerDetail.getPensionType());
        Assertions.assertEquals("aadhaar",pensionerDetail.getAadhaarNo());
        Assertions.assertEquals(100.0,pensionerDetail.getAllowances());
        Assertions.assertEquals("name",pensionerDetail.getName());
        Assertions.assertEquals("dob",pensionerDetail.getDateOfBirth());
        Assertions.assertEquals(200.0,pensionerDetail.getSalaryEarned());
        Assertions.assertEquals("pan",pensionerDetail.getPAN());

    }
}
