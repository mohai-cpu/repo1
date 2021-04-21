package cn.itcast.study.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author ALEX
 * @Date 2012-6-12
 * <p>
 * 日期时间工具类
 *
 */
public class TimeUtils {

    private static final Logger logger = LoggerFactory.getLogger(TimeUtils.class);

    private TimeUtils() {
    }

    /**
     * 将java.sql.Date转换成 String yyyy-MM-dd表示
     *
     * @param date java.sql.Date
     * @return String
     */
    public static String converDateToString(java.sql.Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }
        return null;
    }
    /**
     *@Description 获取星期
     *@param
     *@return java.lang.String
     *@Author zhangjian
     *@Date 2021/3/1 17:54
     */
    public static String dateToWeek() {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = new Date();
        try {
            cal.setTime(datet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    /**
     * 按照提供的格式化样式输出当前时间的字符串表示形式
     *
     * @param date   java.util.Date
     * @param format yyyy-MM-dd HH:mm:ss
     * @return String 字符串时间
     */
    public static String convertDateToStringBySample(Date date, String format) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
        return null;
    }
    /**
     *@Description 字符串转日期
     *@param
     *@return java.util.Date
     *@Author zhangjian
     *@Date 2021/2/4 18:17
     */
    public static Date convertStringToDate(String date,String format) throws ParseException {
        if(StringUtils.isNotBlank(date)){
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(date);
        }
        return null;
    }
    /**
     *@Description  将yyyyMMdd字符串的日期减去相应的天数然后返回yyyyMMdd日期字符串
     *@param
     *@return java.lang.String
     *@Author zhangjian
     *@Date 2021/2/3 17:29
     */
    public static String dateToMinusDay(String date,int day) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Date dt=sdf.parse(date);
        Calendar rightNow=Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.DAY_OF_YEAR,day);//日期加10天
        return sdf.format(rightNow.getTime());
    }
    /**
     * 将yyy-MM-dd样式的日期转换成java.sql.Date
     *
     * @param date String 日期
     * @return java.sql.Date
     */
    public static java.sql.Date convertStringToDate(String date) {
        if (date != null && !"".equals(date.trim())) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return new java.sql.Date(sdf.parse(date).getTime());
            } catch (ParseException e) {
                logger.info("日期转换异常");
            }
        }
        return null;
    }

    /**
     * 将java.sql.Timestamp转换成 String yyyy-MM-dd hh:mm:ss表示
     *
     * @param time java.sql.Timestamp
     * @return String(yyyy-MM-dd HH:mm:ss)
     */
    public static String converTimestampToString(Timestamp time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(time);
        }
        return null;
    }

    /**
     * 将java.sql.Timestamp转换成 String  yyyyMMddhhmmss表示
     *
     * @param timestamp
     * @return String(yyyy-MM-dd HH:mm:ss)
     */
    public static String converTimestampToString2(Timestamp timestamp) {
        if (timestamp != null
                ) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            return sdf.format(timestamp);
        }
        return null;
    }

    /**
     * 将 yyyy-MM-dd hh:mm:ss样式的String转化成java.sql.Timestamp
     *
     * @param time String
     * @return java.sql.Timestamp
     */
    public static Timestamp convertStringToTimestamp(String time) {
        if (time != null && !"".equals(time.trim())) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return new Timestamp(sdf.parse(time).getTime());
            } catch (ParseException e) {
                logger.info("日期转换异常");
            }
        }
        return null;
    }

    /**
     * 获得String类型的当前系统时间
     *
     * @return 当前系统时间样式为“yyyy-MM-dd hh:mm:ss”
     */
    public static String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /**
     * 通过出生日期计算当前年龄
     *
     * @param birthDay String 出生日期
     * @return int 年龄
     * @date 2012-9-19
     */
    public static int getAge(String birthDay) {
        // 出生日期
        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setTime(TimeUtils.convertStringToDate(birthDay));
        int sYears = sCalendar.get(Calendar.YEAR);
        int sMonths = sCalendar.get(Calendar.MONTH);
        int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);
        // 当前日期
        Calendar eCalendar = Calendar.getInstance();
        int eYears = eCalendar.get(Calendar.YEAR);
        int eMonths = eCalendar.get(Calendar.MONTH);
        int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);
        // 年龄
        int age = eYears - sYears;

        if (eMonths < sMonths) {
            age--;
        } else {
            if (eMonths == sMonths && eDays < sDays) {
                age--;
                if (eMonths == 1) { // 如果同是2月，校验润年问题
                    if ((sYears % 4) == 0 && (eYears % 4) != 0) { // 如果起始年是润年，终止年不是润年
                        if (eDays == 28) { // 如果终止年不是润年，且2月的最后一天28日，那么补一
                            age++;
                        }
                    }
                }
            }
        }
        return age;
    }

    /**
     * 计算到指定日期的年龄
     *
     * @param startDate 指定日期
     * @param birthDay  出生日期
     * @return
     */
    public static int getSpecifyAge(String startDate, String birthDay) {
        // 出生日期
        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setTime(TimeUtils.convertStringToDate(birthDay));
        int sYears = sCalendar.get(Calendar.YEAR);
        int sMonths = sCalendar.get(Calendar.MONTH);
        int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);
        // 当前日期
        Calendar eCalendar = Calendar.getInstance();
        eCalendar.setTime(TimeUtils.convertStringToDate(startDate));
        int eYears = eCalendar.get(Calendar.YEAR);
        int eMonths = eCalendar.get(Calendar.MONTH);
        int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);
        // 年龄
        int age = eYears - sYears;

        if (eMonths < sMonths) {
            age--;
        } else {
            if (eMonths == sMonths && eDays < sDays) {
                age--;
                if (eMonths == 1) { // 如果同是2月，校验润年问题
                    if ((sYears % 4 == 0 && ((sYears % 100 != 0) || (sYears % 400 == 0))) && !(eYears % 4 == 0 && ((eYears % 100 != 0) || (eYears % 400 == 0)))) { // 如果起始年是润年，终止年不是润年
                        if (eDays == 28) { // 如果终止年不是润年，且2月的最后一天28日，那么补一
                            age++;
                        }
                    }
                }
            }
        }
        return age;
    }

    /**
     * 获取距离指定日期 N年之后的日期{yyyyMMdd}
     *
     * @param cal    Calendar 指定日期
     * @param years  int 间隔年份
     * @param format String 样式{yyyy-MM-dd}
     * @return String N年之后的日期
     */
    public static String afterYears(Calendar cal, int years, String format) {
        cal.add(Calendar.YEAR, years);
        return TimeUtils.convertDateToStringBySample(cal.getTime(), format);
    }

    //取时间差
    public static long diffBetweenTime(String bigTimeStamp, String smallTimestamp, String unit) {
//		String bigDate = converTimestampToString(new Timestamp(Long.valueOf(bigTimeStamp)));
//		String smallDate = converTimestampToString(new Timestamp(Long.valueOf(smallTimestamp)));
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date d1 = df.parse(bigDate);
//		Date d2 = df.parse(smallDate);
        long diff = Long.valueOf(bigTimeStamp) - Long.valueOf(smallTimestamp);
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = diff / (60 * 60 * 1000);
        long mins = diff / (60 * 1000);
        long secs = diff / 1000;
        long result = 0;
        if ("days".equals(unit)) {
            result = days;
        } else if ("hours".equals(unit)) {
            result = hours;

        } else if ("mins".equals(unit)) {
            result = mins;
        } else if ("secs".equals(unit)) {
            result = secs;
        }
        return result;
    }

    /**
     * 指定日期的毫秒数转换为“yyyy-MM-dd”样式
     *
     * @param millisecond 1970年1月1日到指定日期的毫秒数
     * @return 日期样式为“yyyy-MM-dd”的String
     */
    public static String convertMillisecondToDate(String millisecond) {
        long birthday = Long.parseLong(millisecond);
        Date date = new Date(birthday);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dataFormat.format(gc.getTime());
        return dateStr;
    }

    /**
     * 获取指定样式的系统时间
     *
     * @return
     */
    public static String getCurrentTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = new Date(System.currentTimeMillis());
        String date = sdf.format(d);
        return date;
    }

    /**
     * 获取系统时间N天之后的指定样式的时间
     *
     * @param i
     * @param format
     * @return
     */
    public static String getAddNDay(int i, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DAY_OF_YEAR, i);
        Date begin = calendar.getTime();
        return sdf.format(begin);
    }

    /**
     * 获取活动区间编码
     *
     * @return
     */
    public static String checkAgentSection(RedisTemplate<String, String> redisTemplate) {
        String section = null;
        Long start = Long.parseLong(redisTemplate.opsForValue().get("YYB_AGENTRED_START"));
        Long end_1 = Long.parseLong(redisTemplate.opsForValue().get("YYB_AGENTRED_1_END"));
        Long start_2 = Long.parseLong(redisTemplate.opsForValue().get("YYB_AGENTRED_2_START"));
        Long end_2 = Long.parseLong(redisTemplate.opsForValue().get("YYB_AGENTRED_2_END"));
        Long start_3 = Long.parseLong(redisTemplate.opsForValue().get("YYB_AGENTRED_3_START"));
        Long end_3 = Long.parseLong(redisTemplate.opsForValue().get("YYB_AGENTRED_3_END"));
        Long start_4 = Long.parseLong(redisTemplate.opsForValue().get("YYB_AGENTRED_4_START"));
        Long end = Long.parseLong(redisTemplate.opsForValue().get("YYB_AGENTRED_END"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date d = new Date(System.currentTimeMillis());
        String nowDate = sdf.format(d);
        Long date = Long.parseLong(nowDate);
        if (date >= start && date < end_1) {
            section = "1";
        } else if (date >= start_2 && date < end_2) {
            section = "2";
        } else if (date >= start_3 && date < end_3) {
            section = "3";
        } else if (date >= start_4 && date < end) {
            section = "4";
        }
        return section;
    }

    /**
     * 利用date的原生方法判断当前时间处于哪个活动阶段
     *
     * @param redisTemplate
     * @return 代理人活动阶段值section:
     * {
     * -1:活动已结束,
     * 0:活动未开始,
     * 1:活动第一阶段,
     * 2:活动第二阶段,
     * 3:活动第三阶段,
     * }
     */
    public static String getAgentSectionByDate(RedisTemplate redisTemplate, Date now) {
        String section = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date startDate001 = sdf.parse(redisTemplate.opsForValue().get("YYB_AGENTRED_START").toString());
            Date startDate002 = sdf.parse(redisTemplate.opsForValue().get("YYB_AGENTRED_2_START").toString());
            Date startDate003 = sdf.parse(redisTemplate.opsForValue().get("YYB_AGENTRED_3_START").toString());
            Date endDate001 = sdf.parse(redisTemplate.opsForValue().get("YYB_AGENTRED_1_END").toString());
            Date endDate002 = sdf.parse(redisTemplate.opsForValue().get("YYB_AGENTRED_2_END").toString());
            Date endDate003 = sdf.parse(redisTemplate.opsForValue().get("YYB_AGENTRED_END").toString());
            if (now.before(startDate001)) {
                section = "0";
            } else if (now.after(startDate001) && now.before(endDate001)) {
                section = "1";
            } else if (now.after(startDate002) && now.before(endDate002)) {
                section = "2";
            } else if (now.after(startDate003) && now.before(endDate003)) {
                section = "3";
            } else {
                section = "-1";
            }
        } catch (ParseException e) {
            logger.info("时间转换异常", e);
        }
        return section;
    }
}
