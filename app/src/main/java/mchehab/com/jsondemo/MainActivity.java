package mchehab.com.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        List<Person> listPersons = createListFromFile();
        ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<>(this, android.R.layout
                .simple_list_item_1, listPersons);
        listView.setAdapter(arrayAdapter);
    }

    private List<Person> createListFromFile(){
        StringBuilder jsonData = new StringBuilder();
        List<Person> listPersons = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets()
                    .open("persons.txt")));
            String line;
            while((line = bufferedReader.readLine()) != null){
                jsonData.append(line);
            }
            JSONArray jsonArray = new JSONArray(jsonData.toString());
            for(int i=0;i<jsonArray.length();i++){
                listPersons.add(new Person(jsonArray.getJSONObject(i)));
            }
        }catch (IOException ioException){
            ioException.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listPersons;
    }
}