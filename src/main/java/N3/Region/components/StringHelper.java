package N3.Region.components;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component // Bu anatatsiya shunchaki biron bir oddiy class ni bean ni bizga kerak bo'lib qolsa shu class dan bean hosil qilib beradi.
public class StringHelper {

    public String toString(Object o){
        try {
            return String.valueOf(o);
        }catch (Exception e){
            return null;
        }
    }

    public String capitalize(String s){
        return StringUtils.capitalize(s);
    }

    public String dateToString(Date date){
        //dd-MM-yyyy
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            dateFormat.parse("04.10.2022");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return dateFormat.format(date);
    }

    public Date parseToDate(String s){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
