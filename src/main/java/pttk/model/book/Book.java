package pttk.model.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pttk.model.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity {
    private String title;
    private String type;
    private Integer quantity;
    private String size;
    private String description;
    private Publisher publisher;
    private Author author;
}
