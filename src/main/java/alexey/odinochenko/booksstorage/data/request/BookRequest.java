package alexey.odinochenko.booksstorage.data.request;

import lombok.Data;

@Data
public class BookRequest {
    private String author;
    private String title;
    private Double price;
}
