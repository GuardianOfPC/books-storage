package alexey.odinochenko.booksstorage.mapper;

import alexey.odinochenko.booksstorage.data.model.Book;
import alexey.odinochenko.booksstorage.data.request.BookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToDtoMapper {
    Book BookRequestToBook(BookRequest bookRequest);
}
