# 如何正确优雅地使用Log

## Usage

1: 引入依赖库，目前项目已经上传到JCenter，因此只需要在你的项目Module中直接引入即可:

```gradle
    dependencies {
        compile 'io.github.zhitaocai:dlog:0.1.0'
    }
```

2: 调用方法

```java
public class MainActivity extends AppCompatActivity {

    private final static String DOWNLOAD_TAG = "download_";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // 正常的Android Log 封装使用
        DLog.i("test", "下载测试: 1");
        DLog.d("test", "下载测试: " + 2);
        DLog.w("test", "下载测试: %d", 3);
        DLog.e("test", new Exception("测试的Exception"), "下载测试: 4");
        DLog.v("test", new Exception("测试的Exception"), "下载测试: %d", 5);
    
        // 支持指定前缀tag（方便给tag分类）以及可以指定具体调用类的Log方式
        DLog.ti(DOWNLOAD_TAG, this, "下载测试 1");
        DLog.td(DOWNLOAD_TAG, this, "下载测试 " + 2);
        DLog.tw(DOWNLOAD_TAG, this, "下载测试 %d", 3);
        DLog.te(DOWNLOAD_TAG, this, new Exception("测试的Exception"), "下载测试 4");
        DLog.tv(DOWNLOAD_TAG, this, new Exception("测试的Exception"), "下载测试 %d", 5);
    
    }
}
```

## Blog

[如何正确优雅地使用Log](http://zhitaocai.github.io/2016/05/17/android-use-log-gracefully-and-correctly/)

## License

    Copyright 2016 Zhitao Cai
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.