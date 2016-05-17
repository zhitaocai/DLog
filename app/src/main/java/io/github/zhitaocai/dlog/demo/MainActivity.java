package io.github.zhitaocai.dlog.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;

import io.github.zhitaocai.dlog.DLog;

public class MainActivity extends AppCompatActivity {

	private final static String DOWNLOAD_TAG = "download_";

	private int i = 10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 正常的Android Log 封装使用
		Log.i("aaaaa", "=======华丽分割线1=======");
		DLog.i("test", "下载测试: 1");
		DLog.d("test", "下载测试: " + 2);
		DLog.w("test", "下载测试: %d", 3);
		DLog.e("test", new Exception("测试的Exception"), "下载测试: 4");
		DLog.v("test", new Exception("测试的Exception"), "下载测试: %d", 5);

		Log.i("aaaaa", "=======华丽分割线2=======");
		// 支持指定前缀tag（方便给tag分类）以及可以指定具体调用类的Log方式
		DLog.ti(DOWNLOAD_TAG, this, "下载测试 1");
		DLog.td(DOWNLOAD_TAG, this, "下载测试 " + 2);
		DLog.tw(DOWNLOAD_TAG, this, "下载测试 %d", 3);
		DLog.te(DOWNLOAD_TAG, this, new Exception("测试的Exception"), "下载测试 4");
		DLog.tv(DOWNLOAD_TAG, this, new Exception("测试的Exception"), "下载测试 %d", 5);

		// 输出详细的调用信息
		DLog.setIsLogInvokeInfo(true);
		DLog.ti(DOWNLOAD_TAG, this, "下载测试 1:会输出详细的调用信息");
		DLog.setIsLogInvokeInfo(false);


		Log.i("aaaaa", "=======采用Proguard控制Log输出=======");
		proguardLogTest();

		Log.i("aaaaa", "=======采用BuildConfig控制Log输出=======");
		BuildConfigLogTest();

	}

	private void proguardLogTest() {
		// 测试1: log输出中使用方法
		Log.i("aaaaa", "=======proguard 1=======");
		byte[] input = new byte[] { 1, 2 };
		DLog.i("network", "加密byte数组: %s", formatByte2String(input));

		// 测试2: log输出中使用方法，并且该方法中和其他存在关联
		Log.i("aaaaa", "=======proguard 2=======");
		DLog.ti(DOWNLOAD_TAG, this, "下载测试 %d", incrementI());
		DLog.ti(DOWNLOAD_TAG, this, "下载测试 %d", incrementI());
		DLog.ti(DOWNLOAD_TAG, this, "下载测试 %d", incrementI());

		// 测试3: 外部先构建好一个对象，然后输出该对象的toString
		Log.i("aaaaa", "=======proguard 3=======");
		TestModel testModel = new TestModel("下载测试 1000");
		DLog.ti(DOWNLOAD_TAG, this, testModel.toString());
	}

	private void BuildConfigLogTest() {
		// 测试1: log输出中使用方法
		Log.i("aaaaa", "=======proguard 1=======");
		byte[] input = new byte[] { 1, 2 };
		if (BuildConfig.ISDEBUG) {
			DLog.i("network", "加密byte数组: %s", formatByte2String(input));
		}

		// 测试2: log输出中使用方法，并且该方法中和其他存在关联
		Log.i("aaaaa", "=======proguard 2=======");
		if (BuildConfig.ISDEBUG) {
			DLog.ti(DOWNLOAD_TAG, this, "下载测试 %d", incrementI());
			DLog.ti(DOWNLOAD_TAG, this, "下载测试 %d", incrementI());
			DLog.ti(DOWNLOAD_TAG, this, "下载测试 %d", incrementI());
		}

		// 测试3: 外部先构建好一个对象，然后输出该对象的toString
		Log.i("aaaaa", "=======proguard 3=======");
		TestModel testModel = new TestModel("下载测试 1000");
		if (BuildConfig.ISDEBUG) {
			DLog.ti(DOWNLOAD_TAG, this, testModel.toString());
		}
	}

	/**
	 * 假设这个方法为将byte数组加密成Base64(对应于实际场合中的，和服务器联调测试时，解密网络请求中返回的数据时用)
	 *
	 * @return encodeString
	 */
	private String formatByte2String(byte[] input) {
		return Base64.encodeToString(input, Base64.NO_WRAP);
	}

	private int incrementI() {
		return ++i;
	}

	static class TestModel {

		protected String mTest;

		public TestModel(String test) {
			mTest = test;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("TestModel {\n");
			sb.append("  mTest=\"").append(mTest).append('\"').append("\n");
			sb.append('}');
			return sb.toString();
		}
	}
}
