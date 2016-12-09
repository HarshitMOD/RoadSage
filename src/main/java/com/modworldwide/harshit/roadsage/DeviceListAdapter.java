package com.modworldwide.harshit.roadsage;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by moddeveloper on 12/8/16.
 */

public class DeviceListAdapter extends BaseAdapter {

    private ArrayList<BluetoothDevice> LeDevices;
    private LayoutInflater Inflator;

    public DeviceListAdapter() {
        super();
        LeDevices = new ArrayList<>();
         //Inflator = Connect.this.getLayoutInflater();
    }

    // Check if the device already exists, otherwise add to list

    public void addDevice(BluetoothDevice device) {
        if(!LeDevices.contains(device)){
            LeDevices.add(device);
        }
    }

    public BluetoothDevice getDevice(int position) {
        return LeDevices.get(position);
    }

    public void clear() {
        LeDevices.size();
    }

    @Override
    public int getCount() {
        return LeDevices.size();
    }

    @Override
    public BluetoothDevice getItem(int i){
        return LeDevices.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = Inflator.inflate(R.layout.activity_connect, null);
            viewHolder = new ViewHolder();
            viewHolder.deviceAddress = (TextView) view.findViewById(R.id.device_address);
            viewHolder.deviceName = (TextView) view.findViewById(R.id.device_address);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        BluetoothDevice device = LeDevices.get(i);
        String deviceName = device.getName();
        if (deviceName != null && deviceName.length() > 0){
            viewHolder.deviceName.setText(deviceName);
        } else {
            viewHolder.deviceName.setText(R.string.unknown_device);
            viewHolder.deviceAddress.setText(device.getAddress());
        }
        return view;
    }

    static class ViewHolder {
        TextView deviceName;
        TextView deviceAddress;
    }
}
