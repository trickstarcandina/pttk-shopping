package pttk.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {
    private String numberHouse;
    private String street;
    private String district;
    private String city;
    private String nation;
    public boolean isValid() {
        return numberHouse != null && street != null && district != null&& city != null&& nation != null;
  }
}
