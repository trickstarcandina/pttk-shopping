package pttk.model.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemBook extends BaseEntity {
    private Float price;
    private String imageUrl;
    private Book book;
}
