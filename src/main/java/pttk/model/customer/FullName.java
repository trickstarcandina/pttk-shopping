package pttk.model.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullName extends BaseEntity {
    private String firstName;
    private String middleName;
    private String lastName;
    public boolean isValid() {
        return firstName != null && middleName != null && lastName != null;
  }
}
