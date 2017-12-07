package com.sabel.rate;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonParser;
import java.io.*;
import java.net.*;

public class httpClient {


    public static void main(String[] args) throws IOException {
        URL url = new URL("https://bitaps.com/api/ticker/average");
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.100.1", 8080));
        URLConnection urlConnection = url.openConnection(proxy);

        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line = null;
        String json = null;
        while ((line = br.readLine()) != null) {
            json = line;
            System.out.println(line);
        }
        String[] splits = json.split("eur");
        json = splits[1].substring(4, 11);
        System.out.println(json);
        br.close();
        InputStream is = null;
        URL urlnew = new URL("https://bitaps.com/api/ticker/average");
        Proxy proxynew = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.100.1", 8080));
        URLConnection urlConnectionnew = url.openConnection(proxynew);

        try {
            is = urlConnectionnew.getInputStream();
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            System.out.println(jsonObject.toString());
            JsonObject fx_rates = jsonObject.getJsonObject("fx_rates");
            System.out.println(fx_rates.getString("eur"));
        } catch (Exception e){
            e.printStackTrace();
        } finally {
          is.close();
        }

        JsonParser jsonParser = Json.createParser(new StringReader(json));


    }

}
