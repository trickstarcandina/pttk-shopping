package pttk.model.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;
import pttk.model.electronic.Electronic;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher extends BaseEntity {
    private String name;
    private String address;
}
