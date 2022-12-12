package pttk.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {
    private String username;
    private String password;
    public boolean isValid() {
    return username != null && password != null ;
  }
}
