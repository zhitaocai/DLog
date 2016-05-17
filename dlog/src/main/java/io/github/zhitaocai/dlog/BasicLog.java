package io.github.zhitaocai.dlog;

import android.text.TextUtils;
import android.util.Log;

import java.util.Locale;

/**
 * 基本Log工具
 *
 * @author zhitao
 * @since 2016-05-16 19:26
 */
class BasicLog {

	/**
	 * 是否输出详细的调用信息
	 */
	private static boolean isLogInvokeInfo = false;

	/**
	 * 输出log
	 *
	 * @param level     Log级别 {@link Log#DEBUG}之类
	 * @param tag       具体tag
	 * @param throwable 异常信息
	 * @param format    格式化的输出
	 * @param args      输出参数
	 */
	protected static void log(int level, String tag, Throwable throwable, String format, Object... args) {
		try {
			if (TextUtils.isEmpty(tag)) {
				tag = "debug";
			}
			String msg = "";
			if (!TextUtils.isEmpty(format)) {
				msg = String.format(Locale.getDefault(), format, args);
			}

			if (throwable == null) {
				switch (level) {
				case Log.DEBUG:
					Log.d(tag, msg);
					break;
				case Log.INFO:
					Log.i(tag, msg);
					break;
				case Log.WARN:
					Log.w(tag, msg);
					break;
				case Log.ERROR:
					Log.e(tag, msg);
					break;
				default:
					Log.v(tag, msg);
					break;
				}
			} else {
				switch (level) {
				case Log.DEBUG:
					Log.d(tag, msg, throwable);
					break;
				case Log.INFO:
					Log.i(tag, msg, throwable);
					break;
				case Log.WARN:
					Log.w(tag, msg, throwable);
					break;
				case Log.ERROR:
					Log.e(tag, msg, throwable);
					break;
				default:
					Log.v(tag, msg, throwable);
					break;
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输出log，并且输出被调用方法的信息
	 *
	 * @param level          Log级别 {@link Log#DEBUG}之类
	 * @param preTag         前置tag(最终tag为前置tag + 后面传入来的 targetTagClass)，可以为空
	 * @param targetTagClass 具体tag的类(最终tag为前置tag + 这里的object),可以是该类的实例，若是静态类，请传递静态类class
	 * @param throwable      异常信息
	 * @param format         格式化的输出
	 * @param args           输出参数
	 */
	protected static void logWithInvokeInfo(int level, String preTag, Object targetTagClass, Throwable throwable, String format,
			Object... args) {
		String tag;
		if (targetTagClass instanceof Class) {
			tag = preTag + ((Class) targetTagClass).getSimpleName();
		} else {
			tag = preTag + targetTagClass.getClass().getSimpleName();
		}
		if (isLogInvokeInfo) {
			printInvokeInfo(level, tag);
		}
		log(level, tag, throwable, format, args);
	}

	/**
	 * 打印log 调用时的详细信息
	 *
	 * @param invokeInfoColor 显示log详细信息的文字的颜色
	 *                        <ul>
	 *                        <li>{@code Log.DEBUG} : 蓝色</li>
	 *                        <li>{@code Log.ERROR} : 红色</li>
	 *                        <li>{@code Log.INFO} : 绿色</li>
	 *                        <li>{@code Log.VERBOSE} : 黑色</li>
	 *                        <li>{@code Log.WARN} : 黄色</li>
	 *                        </ul>
	 * @param tag             标签
	 */
	protected static void printInvokeInfo(int invokeInfoColor, String tag) {
		try {
			StackTraceElement[] elements = Thread.currentThread().getStackTrace();
			if (elements.length > 5) {
				StackTraceElement element = elements[5];
				String txt =
						String.format("FileName[ %s ] Method[ %s ] Line[ %d ]", element.getFileName(), element.getMethodName(),
								element.getLineNumber());
				// String txt = String.format("Time:[ %d ] Thread:[ %d ] Method:( %s ) FileName:[ %s ] Line:( %d )",
				// System.currentTimeMillis(), Thread.currentThread().getId(), element.getMethodName(),
				// element.getFileName(), element.getLineNumber());
				log(invokeInfoColor, tag, null, txt);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打印每句log之前，是否打开该log的所在位置（java文件-所在方法名-所在行）
	 *
	 * @return boolean
	 */
	public static boolean isLogInvokeInfo() {
		return isLogInvokeInfo;
	}

	/**
	 * 打印每句log之前，是否打开该log的所在位置（java文件-所在方法名-所在行）
	 *
	 * @param isLogInvokeInfo boolean值
	 */
	public static void setIsLogInvokeInfo(boolean isLogInvokeInfo) {
		BasicLog.isLogInvokeInfo = isLogInvokeInfo;
	}

	//	/**
	//	 * 获取调用时的方法名
	//	 *
	//	 * @return 方法名
	//	 */
	//	protected synchronized static String getMethodName() {
	//		final Thread current = Thread.currentThread();
	//		final StackTraceElement trace = current.getStackTrace()[4];
	//		return trace.getMethodName();
	//	}
	//
	//	protected synchronized static String getLogText(String methodName, Object... params) {
	//		try {
	//			final StringBuilder sb = new StringBuilder();
	//			sb.append(methodName).append(":\t");
	//			for (int i = 0, size = params.length; i < size; i++) {
	//				final Object obj = params[i];
	//				sb.append('[').append(obj).append("]");
	//				if (i != size - 1) {
	//					sb.append(", ");
	//				}
	//			}
	//			return sb.toString();
	//		} catch (Throwable e) {
	//			e.printStackTrace();
	//
	//		}
	//		return null;
	//	}
}
