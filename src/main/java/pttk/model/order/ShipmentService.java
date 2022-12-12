package pttk.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentService extends BaseEntity {
    private String shipUnit;
    private Float shipPrice;
}
