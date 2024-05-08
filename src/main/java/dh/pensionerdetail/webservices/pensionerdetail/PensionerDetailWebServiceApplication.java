package dh.pensionerdetail.webservices.pensionerdetail;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Generated
@OpenAPIDefinition(info = @Info(title = "Pensioner Details Microservice",
		description = "</b>Description:</b> Returns pensioner details of the given Aadhaar number <br><br>" +
				"<b>Naming Server:</b> Eureka <br><br>" +
				"<b>Naming Server Link:</b> <a>http://localhost:8761</a> <br><br>" +
				"<b>Directly Linked To:</b> Process Pension Microservice<br><br>" +
				"<b>Output:</b> Returns processed Pensioner Details<br><br>" +
				"<b>Responses:</b><br>" +
				"<i>200:</i> When details have been correctly processed <br>" +
				"<i>404:</i> When Aadhaar received as request is not present in the database <br>"))

public class PensionerDetailWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailWebServiceApplication.class, args);
	}

}
