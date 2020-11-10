package com.srx.discussion.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.discussion.R;
import com.srx.discussion.entity.DTO.PyqList;
import com.srx.discussion.entity.base.AndroidPyq;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyHolder> {

    List<AndroidPyq> pyqList;

    public UserAdapter(List<AndroidPyq> pyqList) {
        this.pyqList = pyqList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pyq_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        AndroidPyq androidPyq = pyqList.get(position);
        holder.pyqContent.setText(androidPyq.getPyqContext());
        holder.pyqTime.setText(androidPyq.getCreateTime());
        holder.userNickname.setText(androidPyq.getNickname());
    }

    @Override
    public int getItemCount() {
        return pyqList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {

        private TextView pyqContent,userNickname,pyqTime;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            pyqContent=itemView.findViewById(R.id.pyq_content);
            userNickname=itemView.findViewById(R.id.user_nickname);
            pyqTime=itemView.findViewById(R.id.pyq_time);
        }
    }
}
