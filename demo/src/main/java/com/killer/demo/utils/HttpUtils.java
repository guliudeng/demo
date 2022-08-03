package com.killer.demo.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * http 工具类
 */
public class HttpUtils {

    public static String post01(String url,String param) {
        System.out.println("进入post请求入参，url="+url+",param="+param);
        PrintWriter out = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = "";
                  HttpURLConnection conn = null;
                   StringBuilder stringBuilder = new StringBuilder();
                    try {
                          URL realUrl = new URL(url);
                            conn = (HttpURLConnection) realUrl.openConnection();
                         // 设置通用的请求属性
                           conn.setRequestMethod( "POST");
                           conn.setConnectTimeout(20000);
                           conn.setReadTimeout(300000);
                           conn.setRequestProperty("Charset", "utf-8");
                        // 传输数据为json，如果为其他格式可以进行修改
                           conn.setRequestProperty( "Content-Type", "application/json");
                            conn.setRequestProperty( "Content-Encoding", "utf-8");
                         // 发送POST请求必须设置如下两行
                            conn.setDoOutput( true);
                           conn.setDoInput( true);
                            conn.setUseCaches( false);
                           // 获取URLConnection对象对应的输出流
                             out = new PrintWriter(conn.getOutputStream());
                           // 发送请求参数
                          out.print(param);
                           // flush输出流的缓冲
                           out.flush();
                           is = conn.getInputStream();
                          BufferedReader bufferedReader = null;
                          if (is != null) {
                                   // 此处需要将编码格式设置为UTF_8，解决 InputStream 流读取时的中文乱码问题
                                    bufferedReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                                    char[] charBuffer = new char[128];
                                   int bytesRead = -1;
                                 while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                                            stringBuilder.append(charBuffer, 0, bytesRead);
                                        }
                                } else {
                                    stringBuilder.append("");
                               }

                            result = stringBuilder.toString();
                       } catch (Exception e) {
                            System. out.println( "发送 POST 请求出现异常！" + e);
                            e.printStackTrace();
                        }
                  // 使用finally块来关闭输出流、输入流
                  finally {
                           try {
                                    if (out != null) {
                                          out.close();
                                      }
                                  if (br != null) {
                                           br.close();
                                      }
                                  if (conn!= null) {
                                          conn.disconnect();
                                       }
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                              }
                       }
                     return result;
               }



}
