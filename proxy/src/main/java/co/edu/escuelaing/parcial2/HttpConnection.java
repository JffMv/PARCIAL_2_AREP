package co.edu.escuelaing.parcial2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String FIRTS_PART_URL = "http://ec2-3-84-13-222.compute-1.amazonaws.com:8000";
    private static final String SECOND_PART_URL = "http://ec2-54-89-214-152.compute-1.amazonaws.com:8000";

    private static String GET_URL ="/collatzsequence?value=";

    public static String conection(Integer[] args, boolean flag) throws IOException {
        GET_URL ="/collatzsequence?value=";
        GET_URL = flag ? FIRTS_PART_URL+GET_URL : SECOND_PART_URL+GET_URL;

        System.out.println("esta es la url "+GET_URL);
        System.out.println(flag);
        String URL_complete = GET_URL+args[0];

        URL obj = new URL(URL_complete);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
            return "{GET request not worked}";
        }

    }

}
