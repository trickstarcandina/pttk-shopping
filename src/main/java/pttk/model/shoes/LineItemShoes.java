package pttk.model.shoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItemShoes {
    private int id;
    private int quantity;
    private ItemShoes itemShoes;
}
