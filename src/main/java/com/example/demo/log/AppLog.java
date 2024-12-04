package com.example.demo.log;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppLog {
    private AppLog() {
    }

    public static void debug(String logString) {
        StackTraceElement ste = (new Throwable()).getStackTrace()[1];
        String clsName = ste.getClassName();
        Logger subLog = LogManager.getLogger(clsName);
        if (subLog != null) {
            subLog.log(Level.DEBUG, logString);
        }
    }

    public static void info(String logString) {
        StackTraceElement ste = (new Throwable()).getStackTrace()[1];
        String clsName = ste.getClassName();
        Logger subLog = LogManager.getLogger(clsName);
        if (subLog != null) {
            subLog.log(Level.INFO, logString);
        }
    }

    public static void errorLogFile(Exception e) {
        StackTraceElement ste = (new Throwable()).getStackTrace()[1];
        String clsName = ste.getClassName();
        Logger subLog = LogManager.getLogger(clsName);
        if (subLog != null) {
            Level var10001 = Level.ERROR;
            String var10002 = ste.getClassName();
            subLog.log(var10001, var10002 + " " + ste.getMethodName() + " " + ste.getLineNumber() + " - " + e);
            subLog.error("", e);
        }
    }

    public static void fatal(String logString) {
        StackTraceElement ste = (new Throwable()).getStackTrace()[1];
        String clsName = ste.getClassName();
        Logger subLog = LogManager.getLogger(clsName);
        if (subLog != null) {
            Level var10001 = Level.FATAL;
            String var10002 = ste.getClassName();
            subLog.log(var10001, var10002 + " " + ste.getMethodName() + " " + ste.getLineNumber() + " - " + logString);
        }
    }

    public static void warning(String logString) {
        StackTraceElement ste = (new Throwable()).getStackTrace()[1];
        String clsName = ste.getClassName();
        Logger subLog = LogManager.getLogger(clsName);
        if (subLog != null) {
            Level var10001 = Level.WARN;
            String var10002 = ste.getClassName();
            subLog.log(var10001, var10002 + " " + ste.getMethodName() + " " + ste.getLineNumber() + " - " + logString);
        }
    }

    public static String getStackTrace(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;

        try {
            if (e != null) {
                sw = new StringWriter();
                pw = new PrintWriter(sw, true);
                e.printStackTrace(pw);
                String var3 = sw.getBuffer().toString();
                return var3;
            }
        } catch (Exception var14) {
            var14.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (sw != null) {
                    sw.close();
                }
            } catch (IOException var13) {
                var13.printStackTrace();
            }

        }

        return "";
    }
}