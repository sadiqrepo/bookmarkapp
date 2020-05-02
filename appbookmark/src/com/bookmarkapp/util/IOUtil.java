package com.bookmarkapp.util;

import java.io.*;

/**
 * Created by sadiq on 27/04/20.
 */
public class IOUtil {

    public static void read(String[] data, String filename){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))){
            String line;
            int count = 0;

            while( (line = br.readLine()) != null){
                data[count] = line;
                count++;
            }

        }catch (UnsupportedEncodingException | FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String read(InputStream in){

        StringBuilder text = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"))){
            String line;

            while( (line = br.readLine()) != null){
                text.append(line).append("\n");
            }

        }catch (UnsupportedEncodingException | FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return text.toString();
    }

    public static void write(String webpage, long id) {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
                ("./appbookmark/pages" + String.valueOf(id) +
                ".html"),
                "UTF-8"))){
         writer.write(webpage);

        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
