package top.study2.myBatis1;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import top.study2.myBatis1.entity.Book;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class BookTest {
    private SqlSessionFactory sessionFactory;

    @Before
    public void init(){
        InputStream is = null;

        try {
            is =  Resources.getResourceAsStream("mybatis_config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void GetSession(){
        SqlSession session = sessionFactory.openSession();
        System.out.println(session);
    }

    @Test
    public void insert (){
        SqlSession session = sessionFactory.openSession();
        Book book = new Book("hcie-bigDate","huawei","199","华为出版社");
        int result = session.insert("insert",book);
        System.out.println("操作成功，数据增加：" + result);
        System.out.println(book.getId());
        session.commit();
        session.close();
    }

    @Test
    public void deleteByID(){
        SqlSession session = sessionFactory.openSession();
        session.delete("deleteById",13);
        session.commit();
        session.close();
    }

    @Test
    public void deleteByIDs(){
        SqlSession session = sessionFactory.openSession();
        session.delete("deleteByIDs",new int[] {15,16,17});
        session.commit();
        session.close();
    }

    @Test
    public void deleteByListIDs(){
        SqlSession session = sessionFactory.openSession();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(20);
        ids.add(21);
        ids.add(22);
        session.delete("deleteByListIDs",ids);
        session.commit();
        session.close();
    }

    @Test
    public void selectByID(){
        SqlSession session = sessionFactory.openSession();
        Book book = session.selectOne("selectByID",1);
        System.out.println(book);
        session.close();
    }

    @Test
    public void selectAll(){
        SqlSession session = sessionFactory.openSession();
        List<Book> books = session.selectList("selectAll");
        books.stream().forEach(System.out::println);
        session.close();
    }

    @Test
    public void getBook(){
        SqlSession session = sessionFactory.openSession();
        Properties pro = new Properties();
        pro.put("author","huawei");
        pro.put("press","华为出版社");
        List<Book> books = session.selectList("getBook",pro);
        books.stream().forEach(System.out::println);
        session.close();
    }

    @Test
    public void selectByauthorandTitle(){
        SqlSession session = sessionFactory.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("author","oracle");
        map.put("title","mysql");
        List<Book> books = session.selectList("net.togogo.mapper.BookMapper.selectByauthorandTitle",map);
        books.stream().forEach(System.out::println);
        session.close();
    }

    @Test
    public void selectAllEmp() {
        SqlSession session = sessionFactory.openSession();
        List<Map<String, Object>> emps = session.selectList("net.togogo.mybatis.domain.Emp.findEmpByCols");
        for (Map<String, Object> emp : emps) {
            System.out.println(emp);
        }
    }

}
