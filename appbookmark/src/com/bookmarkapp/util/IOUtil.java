package com.bookmarkapp.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.IOException;

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
}
