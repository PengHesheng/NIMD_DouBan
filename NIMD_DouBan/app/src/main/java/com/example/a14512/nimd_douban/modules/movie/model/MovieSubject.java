package com.example.a14512.nimd_douban.modules.movie.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by HP on 2017/5/11.
 */

public class MovieSubject<T> implements Serializable {
    public int count;
    public int start;
    public int total;
    public ArrayList<T> subjects;
    public String title;
}
