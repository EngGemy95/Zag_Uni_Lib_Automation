package com.zu_libraries_automation.fayed.zag_uni_lib_automation;

/**
 * Created by USER on 12/23/2016.
 */

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import androidx.core.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed on 11/23/2016.
 */

public class BackgroundWorker extends AsyncTask<String, Void, String> {
    AlertDialog alertDialog;
    Context context;
    ProgressDialog prgDialog;
    String type;

    InputStream inputStream;
    HttpURLConnection httpURLConnection;
    OutputStream outputStream;
    BufferedReader bufferedReader;


    public interface GetListenerLogin {
        void onGetStatusLogin(String response);
    }

    public interface GetListenerRegister {
        void onGetStatusRegister(String response);
    }

    public interface GetDataListenerFacultyName {
        void ongetData(FacultyNameListHelp f);

        void onListenerGetAllBook(FacultyNameListHelp f);
    }

    GetDataListenerFacultyName getDataFromFacultyName;
    GetListenerLogin getListenerLogin;
    GetListenerRegister getListenerRegister;

    BackgroundWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        type = params[0];
//        String login_url = "http://192.168.1.4/phpFiles2/log_in.php";
//        String register_url = "http://192.168.1.4/phpFiles2/register.php";
//        String search = "http://192.168.1.4/phpFiles2/data.php";
//        String AllBook = "http://192.168.1.4/phpFiles2/allBook.php";
        String login_url = "http://192.168.88.120/phpFiles2/log_in.php";
        String register_url = "http://192.168.88.120/phpFiles2/register.php";
        String search = "http://192.168.88.120/phpFiles2/data.php";
        String AllBook = "http://192.168.88.120/phpFiles2/allBook.php";

        if (type.equals("login")) {
            try {
                String e_mail = params[1];
                String passward = params[2];
                URL url = new URL(login_url);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                //httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("e_mail", "UTF-8") + "=" + URLEncoder.encode(e_mail, "UTF-8") + "&"
                        + URLEncoder.encode("passward", "UTF-8") + "=" + URLEncoder.encode(passward, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                return result;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } else if (type.equals("register")) {
            try {
                String username = params[1];
                String e_mail = params[2];
                String passward = params[3];
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                //httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&"
                        + URLEncoder.encode("e_mail", "UTF-8") + "=" + URLEncoder.encode(e_mail, "UTF-8") + "&"
                        + URLEncoder.encode("passward", "UTF-8") + "=" + URLEncoder.encode(passward, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                inputStream = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                return result;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (type.equals("facultyName")) {
            try {
                String id = params[1];
                String title = params[2];
                String author = params[3];
                //String generalNo = params[4];
                String facultyName = params[4];

                URL url = new URL(search);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
//                httpURLConnection.setDoOutput(true);
//                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("BibID", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&"
                        + URLEncoder.encode("Title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8") + "&"
                        + URLEncoder.encode("Author", "UTF-8") + "=" + URLEncoder.encode(author, "UTF-8") + "&"
                        // + URLEncoder.encode("GeneralNo", "UTF-8") + "=" + URLEncoder.encode(generalNo, "UTF-8") + "&"
                        + URLEncoder.encode("facultyName", "UTF-8") + "=" + URLEncoder.encode(facultyName, "UTF-8") + "&";
                bufferedWriter.write(post_data);

                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                inputStream = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "";
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                Log.d("saaamy", facultyName);
                return result;

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (type.equals("facultyAllBook")) {
            try {
                String facultyNames = params[1];

                URL url = new URL(AllBook);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("facultyName", "UTF-8") + "=" + URLEncoder.encode(facultyNames, "UTF-8");
                bufferedWriter.write(post_data);

                Log.e("indeeex2", facultyNames);

                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                inputStream = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "";
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                return result;

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        prgDialog = new ProgressDialog(context);
        // Set Progress Dialog Text
        prgDialog.setMessage("Please wait...");
        // Set Cancelable as False
        prgDialog.setCancelable(false);
        prgDialog.show();
    }

    @Override
    protected void onPostExecute(String result) {


        if (type.equals("login")) {
            prgDialog.hide();
            getListenerLogin.onGetStatusLogin(result);
        }
        if (type.equals("register")) {
            prgDialog.hide();
            getListenerRegister.onGetStatusRegister(result);
        }

        if (type.equals("facultyName")) {
            prgDialog.hide();
            ArrayList<FacultyNameListHelp> list;

            try {
                JSONObject object = new JSONObject(result);
                JSONArray array = object.getJSONArray("result");
                list = new ArrayList<>();
                Log.d("hhhhhhh",result);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject finalObject = array.getJSONObject(i);
                    String bibid = finalObject.getString("BIbID");
                    String GeneralNo = finalObject.getString("General No");
                    String titleBook = finalObject.getString("Title");
                    String Author = finalObject.getString("Author");
                    String SubjectHeadings = finalObject.getString("Subject headings");
                    String Abstract = finalObject.getString("Abstract");
                    String ShelfLocation = finalObject.getString("Shelf Location");
                    String PublishYear = finalObject.getString("Publish year");
                    String ISBN = finalObject.getString("ISBN");
                    String ISSN = finalObject.getString("ISSN");
                    int faculty_id = Integer.parseInt(finalObject.getString("faculty_id"));

                    list.add(new FacultyNameListHelp(titleBook, GeneralNo, Author,
                            SubjectHeadings, Abstract, ShelfLocation, ISBN, ISSN, PublishYear, bibid, faculty_id));
                }

                FacultyNameListHelp help = new FacultyNameListHelp();

                help.setTitleBookList(list);
                help.setTypeOfList("facultyname");

                getDataFromFacultyName.ongetData(help);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.e("tyyyype", type);
        if (type.equals("facultyAllBook")) {
            prgDialog.hide();
            Log.e("type1", type);
            ArrayList<FacultyNameListHelp> listAllBook;
            try {
                JSONObject object = new JSONObject(result);
                JSONArray array = object.getJSONArray("result");
                listAllBook = new ArrayList<>();
                Log.e("type2", type);
                Log.e("arrayLength", array.length() + "");
                for (int j = 0; j < array.length(); j++) {
                    JSONObject finalObject = array.getJSONObject(j);
                    String bibid = finalObject.getString("BibID");
                    String GeneralNo = finalObject.getString("General No");
                    String titleBook = finalObject.getString("Title");
                    String Author = finalObject.getString("Author");
                    String SubjectHeadings = finalObject.getString("Subject headings");
                    String Abstract = finalObject.getString("Abstract");
                    String ShelfLocation = finalObject.getString("Shelf Location");
                    String PublishYear = finalObject.getString("Publish year");
                    String ISBN = finalObject.getString("ISBN");
                    String ISSN = finalObject.getString("ISSN");

                    listAllBook.add(new FacultyNameListHelp(titleBook, GeneralNo, Author,
                            SubjectHeadings, Abstract, ShelfLocation, ISBN, ISSN, PublishYear, bibid));
                }
                FacultyNameListHelp help = new FacultyNameListHelp();

                help.setAllBooksList(listAllBook);
                help.setTypeOfList("faculty_allBook");
//                for (int i=0;i<listAllBook.size();i++){
//                    Log.e("list",listAllBook.get(i).getBookTitle());
//                }
                getDataFromFacultyName.onListenerGetAllBook(help);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
