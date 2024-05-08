package dh.pensionerdetail.webservices.pensionerdetail.models;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Slf4j
public class BankDetailTests {
    @Test
    public void validateAllArgsConst() {
        BankDetail bankDetail = new BankDetail("aadhaar","type", "bnk name", "acct no",null);
        Assertions.assertNotNull(bankDetail);
    }

    @Test
    public void validateSetters(){
        BankDetail bankDetail=new BankDetail();
        bankDetail.setBankType("type");
        bankDetail.setBankName("bnk name");
        bankDetail.setAccountNo("acct no");
        bankDetail.setAadhaarNo("aadhaar");
        bankDetail.setPensionerDetail(null);

        Assertions.assertEquals("type",bankDetail.getBankType());
        Assertions.assertEquals("bnk name",bankDetail.getBankName());
        Assertions.assertEquals("acct no",bankDetail.getAccountNo());
        Assertions.assertEquals("aadhaar",bankDetail.getAadhaarNo());
        Assertions.assertNull(bankDetail.getPensionerDetail());
    }
}
