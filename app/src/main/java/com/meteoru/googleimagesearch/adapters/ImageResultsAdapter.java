package com.meteoru.googleimagesearch.adapters;


import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.meteoru.googleimagesearch.R;
import com.meteoru.googleimagesearch.models.ImageResult;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageResultsAdapter extends ArrayAdapter<ImageResult> {

    public ImageResultsAdapter(Context context, int resource, List<ImageResult> images) {
        super(context, R.layout.item_image_result, images);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Follow instructions on video
        ImageResult imageResult = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_image_result, parent, false);
        }
        // Create references for views to be populated with data
        TextView textView1 = (TextView) convertView.findViewById(R.id.textView1);
        ImageView imageView1 = (ImageView) convertView.findViewById(R.id.imageView1);
        // Populate the data into the views
        imageView1.setImageResource(0);
        // Populate title and remote download image URL
        textView1.setText(Html.fromHtml(imageResult.title));
        Picasso.with(getContext()).load(imageResult.tbUrl).into(imageView1);

        return convertView;
    }
}
