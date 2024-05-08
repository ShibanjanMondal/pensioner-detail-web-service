package dh.pensionerdetail.webservices.pensionerdetail.controller;

import dh.pensionerdetail.webservices.pensionerdetail.models.PensionerDetail;
import dh.pensionerdetail.webservices.pensionerdetail.services.PensionerDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.NoSuchElementException;

@RestController
@Slf4j
public class PensionerDetailsController {
    Logger logger = LoggerFactory.getLogger(PensionerDetailsController.class);
    @Autowired
    PensionerDetailsService detailsService;
    PensionerDetail pensionerDetail;

    @GetMapping("/PensionerDetailByAadhaar/{aadhaar}")
    public ResponseEntity<PensionerDetail> retrievePensionerByAadhaar(@PathVariable String aadhaar, HttpServletResponse response){
        logger.info("Initiated rest end point /PensionerDetailByAadhaar/ {}",aadhaar);
        try {
        pensionerDetail = detailsService.getPensionerByAadhaar(aadhaar);
        logger.info("Detail found");
            return new ResponseEntity<>(
                    pensionerDetail,
                     HttpStatus.OK);
        }catch (NoSuchElementException e){
            logger.info("Pensioner does not exist in database - details not found -----");
            logger.error(e.getMessage());
            return new ResponseEntity<>(
                    null,
                     HttpStatus.NOT_FOUND);
        }
    }
}
