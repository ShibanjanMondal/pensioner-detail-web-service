package dh.pensionerdetail.webservices.pensionerdetail.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class PensionerDetail {
    @Id
    private String aadhaarNo;
    @Column
    private String name;
    @Column
    private String dateOfBirth;
    @Column
    private String PAN;
    @Column
    private Double salaryEarned;
    @Column
    private Double allowances;
    @Column
    private String pensionType;

    @OneToOne(optional = false)
    @JoinColumn(name = "AADHAAR_NO", unique = true,nullable = false)
    private BankDetail bankDetail;


}
