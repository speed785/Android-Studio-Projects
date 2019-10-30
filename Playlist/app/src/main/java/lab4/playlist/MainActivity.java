package lab4.playlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView playlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playlist = findViewById(R.id.listView);
        new AsynDataClass().execute();

    }

    private class AsynDataClass extends AsyncTask<String, Void, String> {
        HttpURLConnection urlConnection;

        @Override
        protected String doInBackground(String... params) {
            StringBuilder jsonResult = new StringBuilder();

            try {

                URL url = new URL("http:papademas.netL81/cd_catalog.json");
                urlConnection = (HttpURLConnection)
                        url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonResult.append(line);
                }
                System.out.println("Returned Json url object " + jsonResult.toString());

            } catch (Exception e) {
                System.out.println("Err: " + e);
            } finally {
                urlConnection.disconnect();
            }
            return jsonResult.toString();
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(String result) {
            System.out.println("Result on post execute: " + result);
            List<ItemObject> parsedObject =
                    returnParsedJsonObject(result);
            CustomAdapter jsonCustomAdapter = new
                    CustomAdapter(MainActivity.this, parsedObject);
            playlist.setAdapter(jsonCustomAdapter);
        }
    }

    private List<ItemObject> returnParsedJsonObject(String result) {

        List<ItemObject> jsonObject = new ArrayList<ItemObject>();
        JSONObject resultObject = null;
        JSONArray jsonArray = null;
        ItemObject newItemObject = null; //interior object holder

        try {
            resultObject = new JSONObject(result);
            System.out.println("Preparsed JSON object " + resultObject.toString());
            // set up json Array to be parsed
            jsonArray = resultObject.optJSONArray("Bluesy_Music");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonChildNode = null;
            try {
                jsonChildNode = jsonArray.getJSONObject(i);
                //get all data from stream
                String songSold = jsonChildNode.getString("SOLD");
                String songTitle = jsonChildNode.getString("TITLE");
                String songArtist =
                        jsonChildNode.getString("ARTIST");
                String songCountry =
                        jsonChildNode.getString("COUNTRY");
                String songCompany =
                        jsonChildNode.getString("COMPANY");
                String songPrice = jsonChildNode.getString("PRICE");
                String songYear = jsonChildNode.getString("YEAR");
                newItemObject = new ItemObject(songTitle, songYear, songArtist);
                jsonObject.add(newItemObject);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }
}