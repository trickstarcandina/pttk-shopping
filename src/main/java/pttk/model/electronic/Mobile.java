package pttk.model.electronic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mobile extends Electronic {
    private String chip;
    private String camera;
    private String accessory;
    private String power;
    private String ram;
    private String rom;
    private String resolution;
}
