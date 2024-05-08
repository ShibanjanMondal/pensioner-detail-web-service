package dh.pensionerdetail.webservices.pensionerdetail.repository;

import dh.pensionerdetail.webservices.pensionerdetail.models.PensionerDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PensionerDetailsRepository extends CrudRepository<PensionerDetail,String> {
}
