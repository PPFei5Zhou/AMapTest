package com.example.amaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.MyLocationStyle;

public class MainActivity extends AppCompatActivity {

    MapView mMapView = null;

    //定义一个UiSettings对象
    private UiSettings mUiSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取地图控件引用
        mMapView = findViewById(R.id.map);

        //在activity执行onCreate时执行mMapView.onCreate(saveInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);

        //初始化地图控制器对象
        AMap aMap = mMapView.getMap();

        //实例化UiSettings类对象
        mUiSettings = aMap.getUiSettings();

        //显示默认的定位按钮
        mUiSettings.setMyLocationButtonEnabled(true);
        //显示默认的定位按钮
        mUiSettings.setMyLocationButtonEnabled(true);
        //可触发定位并显示当前位置
        aMap.setMyLocationEnabled(true);

        //实现定位蓝点
        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();
        //连续定位、蓝点不会移动到地图中心点，定位点依照设备方向旋转，并且蓝点会跟随设备移动。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER);
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.getUiSettings().setMyLocationButtonEnabled(true);

        //指南针
        mUiSettings.setCompassEnabled(true);

        //显示室内地图
        aMap.showIndoorMap(true);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        //在activity执行onResume时执行mMapView.onResume()，重新绘制加载地图
        mMapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState(outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause()，暂停地图的绘制
        mMapView.onPause();
    }
}
