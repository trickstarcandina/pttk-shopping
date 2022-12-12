package pttk.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cash extends Payment {
    private String cashId;
    private String cashTendered;
}
