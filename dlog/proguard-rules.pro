# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /opt/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# 删除代码中DLog相关的代码
#-assumenosideeffects class io.github.zhitaocai.dlog.DLog {
#    public static void i(...);
#    public static void e(...);
#    public static void d(...);
#    public static void w(...);
#    public static void v(...);
#
#    public static void ti(...);
#    public static void te(...);
#    public static void td(...);
#    public static void tw(...);
#    public static void tv(...);
#}

# 删除代码中BasicLog相关的代码
#-assumenosideeffects class io.github.zhitaocai.dlog.BasicLog {
#    protected static void log(...);
#    protected static void logWithInvokeInfo(...);
#    protected static void printInvokeInfo(...);
#}