package com.bookStore.service;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookStore.entity.MyBookList;
import com.bookStore.repository.MyBookRepository;

import java.util.*;

@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository mybook;

    public void saveMyBook(MyBookList book) {
        mybook.save(book);
    }
    
    public List<MyBookList> getAllMyBooks(){
    	return mybook.findAll();
    }
    
    public void deleteById(int id) {
    	mybook.deleteById(id	);;
    }
}
