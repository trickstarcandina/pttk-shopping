package pttk.model.shoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemShoes extends BaseEntity {
    private Float price;
    private String imageUrl;
    private Shoes shoes;
}
