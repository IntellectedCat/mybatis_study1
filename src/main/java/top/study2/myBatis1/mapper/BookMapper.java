package top.study2.myBatis1.mapper;

import top.study2.myBatis1.entity.Book;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public interface BookMapper {
    //insert
    void insert(Book book);

    void deleteById(int id);

    void deleteByIDs(int[] ids);

    void deleteByListIDs(List<Integer> ids);

    List<Book> getAll();

    List<Book> selectByauthorandTitle(Map<String,Object> map);

    void update(Book book);

    List<Book> getBook(Properties pro);
}
