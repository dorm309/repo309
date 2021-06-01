package util;

import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {

    public static java.sql.Timestamp d2t(java.util.Date d) {
        if (null == d)
            return null;
        return new java.sql.Timestamp(d.getTime());
    }

    public static Date t2d(Timestamp t) {
        if (null == t)
            return null;
        return new java.util.Date(t.getTime());
    }
}