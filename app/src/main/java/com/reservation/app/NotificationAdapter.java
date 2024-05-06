package com.reservation.app;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
public class NotificationAdapter extends ArrayAdapter<ItemNotificationPatient> {
    private Context mContext;
    private int mResource;

    public NotificationAdapter(@NonNull Context context, int resource, @NonNull List<ItemNotificationPatient> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        }

        ItemNotificationPatient currentItem = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.imageView4);
        TextView nameTextView = listItemView.findViewById(R.id.textView15);
        TextView dateTextView = listItemView.findViewById(R.id.textView18);
        TextView timeTextView = listItemView.findViewById(R.id.textView17);

        imageView.setImageResource(currentItem.getImageResource());
        nameTextView.setText(currentItem.getName());
        dateTextView.setText(currentItem.getDate());
        timeTextView.setText(currentItem.getTime());

        return listItemView;
    }
}
