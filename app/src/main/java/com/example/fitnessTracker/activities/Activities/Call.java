package com.example.fitnessTracker.activities.Activities;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Call {

    HttpURLConnection con;

    public Call() throws IOException {
        URL url = new URL("https://exercises2.p.rapidapi.com/");
        this.con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

//        java.net.CookieManager cookieManager = new java.net.CookieManager();

        Map<String, String> parameters = new HashMap<>();
        parameters.put("param1", "val");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        con.setRequestProperty("X-RapidAPI-Host", "exercises2.p.rapidapi.com");
        con.setRequestProperty("X-RapidAPI-Key", "0c2becdfa7mshb9a3c113775cbdep163e0djsn8543d4ba6d1a");
//        String contentType = con.getHeaderField("Content-Type");

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        int status = con.getResponseCode();

        con.setInstanceFollowRedirects(false);
//        HttpUrlConnection.setFollowRedirects(false);


        //Following Redirects
//
//        if (status == HttpURLConnection.HTTP_MOVED_TEMP
//                || status == HttpURLConnection.HTTP_MOVED_PERM) {
//            String location = con.getHeaderField("Location");
//            URL newUrl = new URL(location);
//            con = (HttpURLConnection) newUrl.openConnection();
//        }
//
        // For Cookies
//
//        String cookiesHeader = con.getHeaderField("Set-Cookie");
//        List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);
//
//        cookies.forEach(cookie -> cookieManager.getCookieStore().add(null, cookie));
//
//        Optional<HttpCookie> usernameCookie = cookies.stream()
//                .findAny().filter(cookie -> cookie.getName().equals("username"));
//        if (usernameCookie == null) {
//            cookieManager.getCookieStore().add(null, new HttpCookie("username", "john"));
//        }
//
//        con.disconnect();
//        con = (HttpURLConnection) url.openConnection();
//
//        con.setRequestProperty("Cookie",
//                StringUtils.join(cookieManager.getCookieStore().getCookies(), ";"));

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
        } else {
            streamReader = new InputStreamReader(con.getInputStream());
        }
    }

    public static class ParameterStringBuilder {
        public static String getParamsString(Map<String, String> params)
                throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, String> entry : params.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }

            String resultString = result.toString();
            return resultString.length() > 0
                    ? resultString.substring(0, resultString.length() - 1)
                    : resultString;
        }
    }

    public static class FullResponseBuilder {
        public static String getFullResponse(HttpURLConnection con) throws IOException {
            StringBuilder fullResponseBuilder = new StringBuilder();

            // read status and message
            fullResponseBuilder.append(con.getResponseCode())
                    .append(" ")
                    .append(con.getResponseMessage())
                    .append("\n");

            // read headers
            con.getHeaderFields().entrySet().stream()
                    .filter(entry -> entry.getKey() != null)
                    .forEach(entry -> {
                        fullResponseBuilder.append(entry.getKey()).append(": ");
                        List headerValues = entry.getValue();
                        Iterator it = headerValues.iterator();
                        if (it.hasNext()) {
                            fullResponseBuilder.append(it.next());
                            while (it.hasNext()) {
                                fullResponseBuilder.append(", ").append(it.next());
                            }
                        }
                        fullResponseBuilder.append("\n");
                    });

            // read response content
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            return fullResponseBuilder.toString();
        }
    }

}