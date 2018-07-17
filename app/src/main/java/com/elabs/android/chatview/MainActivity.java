package com.elabs.android.chatview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String messageText;
    EditText editText;
    Button okButton, koButton;
    ArrayList<IndividualMessage> arrayList;
    CustomAdapter customAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editText = (EditText)findViewById(R.id.Edit_text);
        okButton = (Button)findViewById(R.id.ok_button);
        koButton  = (Button)findViewById(R.id.ko_button);
        listView = (ListView)findViewById(R.id.list_view);


        arrayList = new ArrayList<IndividualMessage>();

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageText = editText.getText().toString();
                arrayList.add(new IndividualMessage(messageText, Gravity.RIGHT, R.drawable.bubble));
                customAdapter = new CustomAdapter(getApplicationContext(), arrayList);
                listView.setAdapter(customAdapter);
                editText.setText("");
            }
        });

        koButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageText = editText.getText().toString();
                arrayList.add(new IndividualMessage(messageText, Gravity.LEFT, R.drawable.bubble2));
                customAdapter = new CustomAdapter(getApplicationContext(), arrayList);
                listView.setAdapter(customAdapter);
                editText.setText("");
            }
        });











    }
}
