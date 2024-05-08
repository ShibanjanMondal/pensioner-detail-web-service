package dh.pensionerdetail.webservices.pensionerdetail.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class BankDetail {
    @Id
    @Column(name = "AADHAAR_NO")
    private String aadhaarNo;
    @Column
    private String bankName;
    @Column
    private String accountNo;
    @Column
    private String bankType;
    @JsonIgnore
    @OneToOne(mappedBy = "bankDetail", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PensionerDetail pensionerDetail;
}
