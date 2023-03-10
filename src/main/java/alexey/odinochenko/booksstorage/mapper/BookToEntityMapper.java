package alexey.odinochenko.booksstorage.mapper;

import alexey.odinochenko.booksstorage.data.entity.BookEntity;
import alexey.odinochenko.booksstorage.data.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
    BookEntity bookToBookEntity(Book book);
    Book bookEntityToBook(BookEntity bookEntity);
}
