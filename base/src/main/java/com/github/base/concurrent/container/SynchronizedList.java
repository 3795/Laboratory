package com.github.base.concurrent.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: Collections.synchronizedXXX()的使用方法
 * Created At 2018/11/19
 */
public class SynchronizedList {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        List<String> strsSync = Collections.synchronizedList(strs);
    }

}
