package com.example.bookreviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SqlHelper db = new SqlHelper(this);
        /** CRUD Operations **/
        // add Books
        db.addBook(new Book("Android Studio Development Essentials", "Neil Smyth"));
        db.addBook(new Book("Beginning Android Application Development", "Wei-Meng Lee"));
        db.addBook(new Book("Programming Android", "Wallace Jackson"));
        db.addBook(new Book("Hello, Android", "Wallace Jackson"));

        // get all books
        List<Book> list = db.getAllBooks();

        // update one book
        int j = db.updateBook(list.get(0));
        // delete one book
        db.deleteBook(list.get(0));
        // get all books
        db.getAllBooks();

        // get book count
        Log.d("Book Count", db.getId() + "");

        //get list count size
        Log.d("count", "Count test:" + list.size());

        //
        Log.d("name", "James Dumitru");

    }
}


