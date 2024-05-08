
package dh.pensionerdetail.webservices.pensionerdetail.services;

import dh.pensionerdetail.webservices.pensionerdetail.models.PensionerDetail;
import dh.pensionerdetail.webservices.pensionerdetail.repository.PensionerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PensionerDetailsService {
    @Autowired
    PensionerDetailsRepository repository;

    PensionerDetail pensionerDetail;

    public PensionerDetail getPensionerByAadhaar(String aadhaar) {
        try{
            pensionerDetail = repository.findById(aadhaar).get();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
        return pensionerDetail;
    }
}
