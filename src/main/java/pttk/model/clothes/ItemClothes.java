package pttk.model.clothes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemClothes extends BaseEntity {
    private Float price;
    private String imageUrl;
    private Clothes clothes;
}
