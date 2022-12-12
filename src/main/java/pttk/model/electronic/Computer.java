package pttk.model.electronic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer extends Electronic {
    private String size;
    private String ram;
    private String power;
    private String rom;
}
