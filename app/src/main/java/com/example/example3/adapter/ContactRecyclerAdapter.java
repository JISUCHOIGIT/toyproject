package com.example.example3.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example3.R;
import com.example.example3.VO.ContactItem;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactRecyclerAdapter extends RecyclerView.Adapter<ContactRecyclerAdapter.ViewHolder> {

    Context context;
    private ArrayList<ContactItem> contactList;
    ImageView phoneImageView;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item_list, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(contactList.get(position));
    }

    public void setContactList(ArrayList<ContactItem> list) {
        this.contactList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView profile;
        TextView name;
        TextView contact;
        ImageView phoneImageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profile = (ImageView) itemView.findViewById(R.id.profile);
            name = (TextView) itemView.findViewById(R.id.name);
            contact = (TextView) itemView.findViewById(R.id.contact);

            phoneImageView = itemView.findViewById(R.id.phoneImageView);
            phoneImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    phoneImageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String telNum;
                            telNum = contact.getText().toString();
                            Intent dialIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + telNum));
                            context.startActivity(dialIntent);
                        }
                    });

                }
            });
        }

        void onBind(ContactItem item) {
            //profile.setImageResource(item.getResourceId());
            name.setText(item.getName());
            contact.setText(item.getContact());

        }

    }


}
