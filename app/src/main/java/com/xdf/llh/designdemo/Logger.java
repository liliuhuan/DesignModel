package com.xdf.llh.designdemo;

import android.util.Log;

/**
 * 日志出管理类
 * @author dell
 */
public class Logger{
  public static void loge(String string){
      System.out.println(string);
      Log.e("Logger===",string);
  }
}
