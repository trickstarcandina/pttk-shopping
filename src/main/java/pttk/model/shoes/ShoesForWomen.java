package pttk.model.shoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoesForWomen extends Shoes {
    private String size;
    private Integer soleHeight;
}
