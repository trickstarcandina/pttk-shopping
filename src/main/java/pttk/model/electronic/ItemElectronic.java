package pttk.model.electronic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemElectronic extends BaseEntity {
    private Float price;
    private String imageUrl;
    private Electronic electronic;
}
