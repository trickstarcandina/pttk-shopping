package pttk.model.clothes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Origin extends BaseEntity {
    private String nation;
    private String address;
}
