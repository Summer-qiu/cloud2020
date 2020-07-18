import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author Dark
 * @date 2020-07-18 14:45
 */
public class T2 {
    public static void main(String[] args) {

        ZonedDateTime zbj = ZonedDateTime.now(); //默认时区
        System. out . println(zbj);
        //2020-07-18T14:50:06.798+08:00[Asia/Shanghai]
        //curl http://localhost:9527/payment/lb --cookie "username=zzyy"
        //Header=X-Request-Id,\d+ #请求头要有X-Request- Id属性并且值为整数的正则表达式


        //用指定时区获取当前时间
        //ZonedDateTime zny = ZonedDateTime. now(ZoneId. of( "America/New_ York"));
        //System. out. println(zny);

    }
}
