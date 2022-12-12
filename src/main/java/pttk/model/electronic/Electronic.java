package pttk.model.electronic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Electronic extends BaseEntity {
    private String name;
    private String brand;
    private Float price;
    private Float discount;
    private String origin;
    private String description;
}
