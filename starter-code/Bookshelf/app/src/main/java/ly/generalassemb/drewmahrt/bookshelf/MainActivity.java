package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mBookAdapter;

    //TODO: Define your ListView
    ListView mListView;

    //TODO: Define your Book List
    List<Book> mBookList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Use helper method to add books to the list
        mBookList = generateBooks();

        mListView = (ListView) findViewById(R.id.listView);

        //TODO: Instantiate BaseAdapter
        //Below is a partially complete example for one Adapter
        mBookAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {
                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //TODO: Update the view
                View view = convertView;
                if (view == null){
                    LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.listtemplate, null);
                }
                TextView txt1 = (TextView) view.findViewById(R.id.txt_view1);
                TextView txt2 = (TextView) view.findViewById(R.id.txt_view2);
                ImageView img_view = (ImageView) view.findViewById(R.id.img_view);
                txt1.setText("Title: " + mBookList.get(position).getTitle());
                txt2.setText("Author: " + mBookList.get(position).getAuthor());
                img_view.setImageResource(mBookList.get(position).getResourceId());

                return view;
            }
        };

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txt1 = (TextView) view.findViewById(R.id.txt_view1);
                TextView txt2 = (TextView) view.findViewById(R.id.txt_view2);
                txt1.setTextColor(Color.parseColor("#FF0000"));
                txt2.setTextColor(Color.parseColor("#FF0000"));
            }
        });

        //TODO: Set the ListView's adapter
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(mBookAdapter);

    }

    //android:src="@android:drawable/sym_def_app_icon"

    //Method to generate a list of Books
    private List<Book> generateBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book("Apples Book","Brad", android.R.drawable.sym_def_app_icon));
        books.add(new Book("Cats Book","Ryan", android.R.drawable.sym_action_call));
        books.add(new Book("Eagles Book","Kate", android.R.drawable.sym_action_chat));
        books.add(new Book("Strawberries Cathy","Brad", android.R.drawable.sym_action_email));
        books.add(new Book("Dogs Book","Tom", android.R.drawable.sym_call_incoming));
        books.add(new Book("Ants Book","Zane", android.R.drawable.sym_contact_card));

        return books;
    }
}
