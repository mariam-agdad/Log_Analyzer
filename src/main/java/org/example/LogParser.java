package com.example.dashboard1;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import net.sf.uadetector.UserAgentStringParser;
import  java.net.*;

public class LogParser {

    private static String regex = "^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\d+) \"([^\"]+)\" \"(.+?)\"";

    private static Pattern logPattern = Pattern.compile(regex);


    public static LogRecord parseLog(String logLine) {
        Matcher logMatcher = logPattern.matcher(logLine);
        if(!logMatcher.matches()) {
            return null;
        }
        String ipAddress = logMatcher.group(1);
        String clientId = logMatcher.group(2);
        String userId = logMatcher.group(3);
        String creationTime = logMatcher.group(4);

        // C'est pour analyser le 5eme champs et en tirer les elements :method,uri,protocol
        String[] requestURLElements= logMatcher.group(5).split(" ");
        String method=requestURLElements[0];
        String uri=requestURLElements[1];
        String protocol=requestURLElements[2];

        String statusCode = logMatcher.group(6);
        String size = logMatcher.group(7);
        String userAgent = logMatcher.group(9);
        for(int i=1;i<10;i++){
            System.out.println(logMatcher.group(i));
        }
        // System.out.println(timestampParser(creationTime).getHour());
        return new LogRecord(ipAddress, clientId, userId, creationTime, method, uri,protocol, statusCode, sizeParser(size), userAgentParser(userAgent));
    }
    public static UserAgent userAgentParser(String userAgent){
        String regex="^[a-z]|[A-Z]{3} ";
        Pattern userAgentPattern = Pattern.compile(regex);
        Matcher userAgentMatcher = userAgentPattern.matcher(userAgent);
        String operatingSystem="";
        String browser="";
        String operatingSystemVersion="";
        return new UserAgent(operatingSystem,browser,operatingSystemVersion);


    }
    public static double  sizeParser(String size){ return Double.parseDouble(size);}
    public static TimeStamp timestampParser(String timestamp){

        String[] timestamps=timestamp.split(" ");
        String[] dateTime=timestamps[0].split(":",2);
        String[] date=dateTime[0].split("/");
        String day=date[0];
        String month=date[1];
        String year=date[2];
        String[] time=dateTime[1].split(":");
        String hour=time[0];
        String minute=time[1];
        String second=time[2];

        // System.out.println(day+" "+month+" "+year+" "+hour+" "+minute);

        return new TimeStamp(day, month, year, hour, minute, second);
    }

    public static void main(String[] args) {
        // UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();

        parseLog("127.0.0.1 - - [07/Mar/2022:23:34:35 +0100] \"GET /dashboard/ HTTP/1.1\" 200 7576 \"-\" \"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:97.0) Gecko/20100101 Firefox/97.0\"");
    }

}

