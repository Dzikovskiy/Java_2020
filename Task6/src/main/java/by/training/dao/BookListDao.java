package by.training.dao;

import by.training.entity.Book;
import by.training.specification.ISpecification;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookListDao {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {

    }

    public void removeBook(Book book) {

    }

    public ArrayList<Book> getBySpecification(ISpecification<Book> specification){
        Stream<Book> result = books.stream();

        if(specification.getFilter()!=null){
            result= books.stream().filter(specification.getFilter());
        }
        if(specification.getSorted()!=null){
            result = books.stream().sorted(specification.getSorted());
        }
        return (ArrayList<Book>) result.collect(Collectors.toList());
    }



}
