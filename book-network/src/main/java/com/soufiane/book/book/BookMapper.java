package com.soufiane.book.book;

import com.soufiane.book.file.FileUtils;
import com.soufiane.book.history.BookTransactionHistory;
import org.springframework.stereotype.Service;


@Service
public class BookMapper {
    public Book toBook(BookRequest request) {
        return Book.builder()
                .id(request.id())
                .title(request.title())
                .authorName(request.authorName())
                .synopsis(request.synopsis())
                .archived(false)
                .shareable(request.shareable())
                .build();
    }

    public BookResponse toBookResponse(Book book) {

        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .isbn(book.getIsbn())
                .synopsis(book.getSynopsis())
                .rate(book.getRate())
                .archived(book.isArchived())
                .shareable(book.isShareable())
                //.owner(book.getOwner().fullName())
                .cover(FileUtils.readFileFromLocation(book.getBookCover()))
                .build();
    }

    public BorrowedBookResponse toBorrowedBookResponse(BookTransactionHistory transactionHistory) {
        return BorrowedBookResponse.builder()
                .id(transactionHistory.getBook().getId())
                .title(transactionHistory.getBook().getTitle())
                .authorName(transactionHistory.getBook().getAuthorName())
                .isbn(transactionHistory.getBook().getIsbn())
                .rate(transactionHistory.getBook().getRate())
                .returned(transactionHistory.isReturned())
                .returnApproved(transactionHistory.isReturnApproved())
                .build();
    }
}
