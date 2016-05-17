package io.github.zhitaocai.dlog;

import android.util.Log;

/**
 * @author zhitao
 * @since 2016-05-16 19:26
 */
public class DLog extends BasicLog {
	
	// INFO
	public static void i(String tag, String format, Object... args) {
		log(Log.INFO, tag, null, format, args);
	}
	
	public static void i(String tag, Throwable throwable) {
		log(Log.INFO, tag, throwable, null);
	}
	
	public static void i(String tag, Throwable throwable, String format, Object... args) {
		log(Log.INFO, tag, throwable, format, args);
	}
	
	public static void ti(String preTag, Object targetTagClass, String fmt, Object... args) {
		logWithInvokeInfo(Log.INFO, preTag, targetTagClass, null, fmt, args);
	}

	public static void ti(String preTag, Object targetTagClass, Throwable throwable) {
		logWithInvokeInfo(Log.INFO, preTag, targetTagClass, throwable, null);
	}

	public static void ti(String preTag, Object targetTagClass, Throwable throwable, String fmt, Object... args) {
		logWithInvokeInfo(Log.INFO, preTag, targetTagClass, throwable, fmt, args);
	}

	// ERROR
	public static void e(String tag, String format, Object... args) {
		log(Log.ERROR, tag, null, format, args);
	}

	public static void e(String tag, Throwable throwable) {
		log(Log.ERROR, tag, throwable, null);
	}

	public static void e(String tag, Throwable throwable, String format, Object... args) {
		log(Log.ERROR, tag, throwable, format, args);
	}

	public static void te(String preTag, Object targetTagClass, String fmt, Object... args) {
		logWithInvokeInfo(Log.ERROR, preTag, targetTagClass, null, fmt, args);
	}

	public static void te(String preTag, Object targetTagClass, Throwable throwable) {
		logWithInvokeInfo(Log.ERROR, preTag, targetTagClass, throwable, null);
	}

	public static void te(String preTag, Object targetTagClass, Throwable throwable, String fmt, Object... args) {
		logWithInvokeInfo(Log.ERROR, preTag, targetTagClass, throwable, fmt, args);
	}

	// DEBUG
	public static void d(String tag, String format, Object... args) {
		log(Log.DEBUG, tag, null, format, args);
	}

	public static void d(String tag, Throwable throwable) {
		log(Log.DEBUG, tag, throwable, null);
	}

	public static void d(String tag, Throwable throwable, String format, Object... args) {
		log(Log.DEBUG, tag, throwable, format, args);
	}

	public static void td(String preTag, Object targetTagClass, String fmt, Object... args) {
		logWithInvokeInfo(Log.DEBUG, preTag, targetTagClass, null, fmt, args);
	}

	public static void td(String preTag, Object targetTagClass, Throwable throwable) {
		logWithInvokeInfo(Log.DEBUG, preTag, targetTagClass, throwable, null);
	}

	public static void td(String preTag, Object targetTagClass, Throwable throwable, String fmt, Object... args) {
		logWithInvokeInfo(Log.DEBUG, preTag, targetTagClass, throwable, fmt, args);
	}

	// WARN
	public static void w(String tag, String format, Object... args) {
		log(Log.WARN, tag, null, format, args);
	}

	public static void w(String tag, Throwable throwable) {
		log(Log.WARN, tag, throwable, null);
	}

	public static void w(String tag, Throwable throwable, String format, Object... args) {
		log(Log.WARN, tag, throwable, format, args);
	}

	public static void tw(String preTag, Object targetTagClass, String fmt, Object... args) {
		logWithInvokeInfo(Log.WARN, preTag, targetTagClass, null, fmt, args);
	}

	public static void tw(String preTag, Object targetTagClass, Throwable throwable) {
		logWithInvokeInfo(Log.WARN, preTag, targetTagClass, throwable, null);
	}

	public static void tw(String preTag, Object targetTagClass, Throwable throwable, String fmt, Object... args) {
		logWithInvokeInfo(Log.WARN, preTag, targetTagClass, throwable, fmt, args);
	}

	// VERBOSE
	public static void v(String tag, String format, Object... args) {
		log(Log.VERBOSE, tag, null, format, args);
	}

	public static void v(String tag, Throwable throwable) {
		log(Log.VERBOSE, tag, throwable, null);
	}

	public static void v(String tag, Throwable throwable, String format, Object... args) {
		log(Log.VERBOSE, tag, throwable, format, args);
	}

	public static void tv(String preTag, Object targetTagClass, String fmt, Object... args) {
		logWithInvokeInfo(Log.VERBOSE, preTag, targetTagClass, null, fmt, args);
	}

	public static void tv(String preTag, Object targetTagClass, Throwable throwable) {
		logWithInvokeInfo(Log.VERBOSE, preTag, targetTagClass, throwable, null);
	}

	public static void tv(String preTag, Object targetTagClass, Throwable throwable, String fmt, Object... args) {
		logWithInvokeInfo(Log.VERBOSE, preTag, targetTagClass, throwable, fmt, args);
	}
}
