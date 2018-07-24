package com.example.nilufer.db_android_watch;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ListView btListView;
    private ArrayList<String> btDeviceList;
    private ArrayAdapter btArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeBTDiscoverable();
        findDevice();

    }

    //Bluetoothu diger cihazlar tarafindan gorunur yapar
    private void makeBTDiscoverable() {
        Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivityForResult(discoverableIntent, BT_VISIBLE_ENABLE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BT_VISIBLE_ENABLE) {
            //Cihaz başarılı bir şekilde bulunabilir hale getirildi.
        } else {
            //Cihaz bulunabilir hale getirilirken bir hata ile karşılaşıldı!
        }
    }


    public void findDevice()    {
        //bu işlemleri cihazları bulma işlemini başlatacağınız Listener içerisinde gerçekleştirebilirsiniz.
        btListView = (ListView) findViewById(R.id.btListView);
        btDeviceList = new ArrayList<String>();
        btArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, btDeviceList);
    }

    //Bu fonksiyon ile cihazları tarama işlemini gerçekleştirebilirsiniz.
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            //Cihaz bulunduğunda ne yapılacağını bu adımda gerçekleştiriyoruz
            if(BluetoothDevice.ACTION_FOUND.equals(action)) {

                String deviceInfo = "";
                Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();

                //Intent sınıfından BluetoothDevice nesnesini alıyoruz
                BluetoothDevice btDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                deviceInfo += btDevice.getName() + "\n" + btDevice.getAddress();
                btDeviceList.add(String.valueOf(btDevice));

                if(btDevice.getBondState() == BONDED_DEVICE) {
                    Log.d("BluetoothDevice", "Eslestirilmis cihaz bulundu.");
                    deviceInfo += " (ESLESTIRILMIS)";
                    isPaired = true;
                }
                btDeviceList.add(deviceInfo);
                btListView.setAdapter(btArrayAdapter);
                btListView.refreshDrawableState();
            }
        }
    };

}
