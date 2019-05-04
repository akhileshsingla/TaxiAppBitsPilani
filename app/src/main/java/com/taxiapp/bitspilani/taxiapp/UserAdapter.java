package com.taxiapp.bitspilani.taxiapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.Timestamp;
import com.taxiapp.bitspilani.pojo.Booking;
import com.taxiapp.bitspilani.pojo.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.security.AccessController.getContext;

public class UserAdapter extends ArrayAdapter<User>
{
    int[]  IMAGES = {R.drawable.user,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.b1,R.drawable.c1,R.drawable.d1,R.drawable.e1};

    private Context mContext;
    private List<User> userList = new ArrayList<>();

    public UserAdapter( Context context,  ArrayList<User> list) {
        super(context, 0 , list);
        mContext = context;
        userList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.da_item1,null);
        }
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView);
        TextView textView_username  = (TextView) convertView.findViewById(R.id.text_name);
        TextView textView_emailId  = (TextView) convertView.findViewById(R.id.text_dept);
        TextView textView_phone_no  = (TextView) convertView.findViewById(R.id.text_phone);
        TextView textView_city  = (TextView) convertView.findViewById(R.id.text_email);
        //TextView textView_department  = (TextView) convertView.findViewById(R.id.textView_dept);

        User b = getItem(position);

        imageView.setImageResource(IMAGES[0]);
        if(b.getName()!=null)
        textView_username.setText("Name : "+b.getName());
        if(b.getEmailId()!=null)
        textView_emailId.setText("Email: "+b.getDepartment());
        if(b.getPhoneNo()!=null)
        textView_phone_no.setText("phone: "+b.getPhoneNo());
        if(b.getDepartment()!=null)
            textView_city.setText(b.getEmailId());
        // textView_source.setTypeface(textView_source.getTypeface(), Typeface.BOLD);
        //textView_source.append("abc");


        return convertView;
    }

}
