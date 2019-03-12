package aidl;

//TestData 所引用的类型必须 相同的实体类包名 重写TestData.aidl
import com.xdf.llh.designdemo.TestData;
interface AidlService{
    String getString();
    TestData getData();
}