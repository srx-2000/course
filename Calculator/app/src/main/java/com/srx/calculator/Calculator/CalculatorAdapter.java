package com.srx.calculator.Calculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.srx.calculator.R;

import java.util.List;

/**
 * @author srx
 * @description
 * @create 2020-09-15 10:24:54
 */
public class CalculatorAdapter extends RecyclerView.Adapter<CalculatorAdapter.ViewHolder> {

    private List<Calculator> list;

    public CalculatorAdapter(List<Calculator> list) {
        this.list = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView formula, result;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            formula = itemView.findViewById(R.id.formula);
            result = itemView.findViewById(R.id.result_item);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calculater_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Calculator calculator = list.get(position);
        holder.formula.setText(calculator.getFormula());
        holder.result.setText(calculator.getResult());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
