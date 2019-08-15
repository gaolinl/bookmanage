package com.example.demo.util;/**
 * Created by Administrator on 2018/10/22.
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换类
 *
 * @author HESHUZHUANG
 * @create 2018-10-22 19:01
 **/
public class GetDateFormat {
    private static String str = "NULL";
    public static Date getDateFormat(String time) throws ParseException {
        String format  = "";
        Date date = new Date();
        if (time != null && time != str && time != "") {
                //转换日期格式(将Mon Jun 18 2018 00:00:00 GMT+0800 (中国标准时间) 转换成yyyy-MM-dd)
                time = time.replace("Z", " UTC");
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
                Date d = sdf1.parse(time);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                format = sdf.format(d);
                //2017-03-06
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = sdf2.parse(format);

        }
        System.out.println("ppppppppppppppppppppp");
        System.out.println(date);
        return date;
    }

}