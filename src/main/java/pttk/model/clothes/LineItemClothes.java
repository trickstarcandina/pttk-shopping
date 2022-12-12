package pttk.model.clothes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItemClothes {
    private int id;
    private int quantity;
    private ItemClothes itemClothes;
}
