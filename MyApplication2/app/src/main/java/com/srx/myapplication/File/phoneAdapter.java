package com.srx.myapplication.File;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.myapplication.R;

import java.util.List;

/**
 * @author srx
 * @description
 * @create 2020-09-14 20:18:17
 */
public class phoneAdapter extends RecyclerView.Adapter<phoneAdapter.ViewHolder> {

    private List<Phone> phoneList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView phoneName,phoneNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            phoneNumber=itemView.findViewById(R.id.number);
            phoneName=itemView.findViewById(R.id.name);
        }
    }

    public phoneAdapter(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_item, parent, false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Phone phone = phoneList.get(position);
        holder.phoneName.setText(phone.getPhoneName());
        holder.phoneNumber.setText(phone.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }
}
