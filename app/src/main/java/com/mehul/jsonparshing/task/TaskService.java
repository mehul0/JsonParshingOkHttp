package com.mehul.jsonparshing.task;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehul.jsonparshing.ApiRequest;
import org.json.JSONException;
import java.io.IOException;
import java.net.SocketTimeoutException;

public class TaskService extends AsyncTask<String, String, String> {

    Context context;

    public TaskService(Context contexts) {
        this.context = contexts;
    }

    @Override
    protected String doInBackground(String... strings) {


        int count = 0;

        boolean retry = false;

        StringBuilder responseStrBuilder = new StringBuilder();

        do {
            retry = false;

            try {

                ApiRequest.doNetworkProcessGet(strings[0], responseStrBuilder);
                String response = responseStrBuilder.toString();
                ObjectMapper objectMapper = new ObjectMapper();
                return response;

            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (SocketTimeoutException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            retry = true;

            count += 1;

        } while (count < 3 && retry);

        /*HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {

            URL url = new URL(strings[0]);

            connection = (HttpURLConnection) url.openConnection();

            connection.connect();

            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();

            String line = " ";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            String finalJson = buffer.toString();

            //JSONObject parentOjject = new JSONObject(finalJson);  //Json Main Object for Array
            //JSONArray jsonArray = parentOjject.getJSONArray("");  //JsonArray with Object
            //JSONArray jsonArrays = new JSONArray(finalJson);      //use when only Array without Object

            JSONObject finalObject = new JSONObject(finalJson);   //use for direct JSON object

            int userId = finalObject.getInt("userId");
            int id = finalObject.getInt("id");
            String title = finalObject.getString("title");
            String body = finalObject.getString("body");

            return "User ID = " + userId + "\n" + " ID = " + id + "\n" + " Title = " + title + "\n" + " Body = " + body;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, "response : " + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
