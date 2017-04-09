package com.example.dongvan.SalesApp.ConnectInternet;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by VoNga on 25-Mar-17.
 */

public class DownloadJSON extends AsyncTask<String, Void, String> {
    //////////////////////////////////////
    String duongdan;
    List<HashMap<String,String>> attrs;
    StringBuilder dulieu;
    boolean method = true;

    public DownloadJSON(String duongdan){
        this.duongdan = duongdan;
        method = true;
    }

    public DownloadJSON(String duongdan, List<HashMap<String,String>> attrs){
        this.duongdan = duongdan;
        this.attrs = attrs;
        method = false;
    }

    @Override
    protected String doInBackground(String... strings) {
        String data = "";
        try {
            URL url = new URL(duongdan);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            if(!method){
                //httpURLConnection.setRequestMethod("POST");
                //httpURLConnection.setRequestProperty("Content-Type","application/json;charset = utf8");
                //httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset = utf8");
                data = methodPost(httpURLConnection);
            }else{
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("Content-Type","application/json;charset = utf8");
                data = methodGet(httpURLConnection);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d("dulieu",data);
        return data;
    }

    private String methodGet(HttpURLConnection httpURLConnection){
        String data = "";
        InputStream inputStream = null;
        try {
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);

            dulieu = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) !=null){
                dulieu.append(line);
            }

            data = dulieu.toString();
            bufferedReader.close();
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    private String methodPost(HttpURLConnection httpURLConnection){
        String data = "";
        String key = "";
        String value = "";

        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            Uri.Builder builder = new Uri.Builder();

            int count = attrs.size();
            for(int i=0;i<count;i++){

                for(Map.Entry<String,String> values : attrs.get(i).entrySet()){
                    key = values.getKey();
                    value = values.getValue();

//                    result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
//                    result.append("=");
//                    result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                }

                builder.appendQueryParameter(key,value);
            }
            String query = builder.build().getEncodedQuery();

            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter writer = new BufferedWriter(streamWriter);

            writer.write(query);
            writer.flush();
            writer.close();
            streamWriter.close();
            outputStream.close();

            data = methodGet(httpURLConnection);

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return data;
    }

}
