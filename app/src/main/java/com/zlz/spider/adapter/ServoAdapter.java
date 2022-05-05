package com.zlz.spider.adapter;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.zlz.spider.R;
import com.zlz.spider.entity.ServoData;
import com.xuexiang.xui.adapter.recyclerview.BaseRecyclerAdapter;
import com.xuexiang.xui.adapter.recyclerview.RecyclerViewHolder;

import java.util.List;

/**
 * @author XUE
 * @date 2017/9/10 15:28
 */
public class ServoAdapter extends BaseRecyclerAdapter<ServoData> {

    public ServoAdapter(List<ServoData> list) {
        super(list);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.layout_servo_item;
    }

    @Override
    public void bindData(@NonNull RecyclerViewHolder holder, int position, ServoData item) {
        holder.text(R.id.name, item.getName());
        LongClickButton reduce = holder.findViewById(R.id.reduce_button);
        LongClickButton add = holder.findViewById(R.id.add_button);
        TextView textView = holder.findViewById(R.id.servo_value);
        textView.setText(String.valueOf(item.getProcess()));
        reduce.setOnClickListener(v -> {
            reduce(item, textView);
        });

        add.setOnClickListener(v -> {
            add(item, textView);
        });

//        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                Log.e(item.getName(),seekBar.getProgress() + "");
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//            }
//        });
    }

    private void add(ServoData servoData, TextView textView) {
        if (servoData.getProcess() < 180) {
            servoData.setProcess(servoData.getProcess() + 1);
        }
        textView.setText(String.valueOf(servoData.getProcess()));
    }

    private void reduce(ServoData servoData, TextView textView) {
        if (servoData.getProcess() > 0) {
            servoData.setProcess(servoData.getProcess() - 1);
        }
        textView.setText(String.valueOf(servoData.getProcess()));
    }
}
