/*
 * Copyright (C) 2022 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.zlz.spider.fragment.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xui.adapter.recyclerview.RecyclerViewHolder;
import com.xuexiang.xui.utils.DensityUtils;
import com.xuexiang.xui.utils.ResUtils;
import com.xuexiang.xui.utils.WidgetUtils;
import com.zlz.spider.R;
import com.zlz.spider.adapter.ServoAdapter;
import com.zlz.spider.core.BaseFragment;
import com.zlz.spider.databinding.FragmentServoInitBinding;
import com.zlz.spider.entity.ServoData;

import java.util.ArrayList;
import java.util.List;

@Page(name = "舵机调整", extra = R.drawable.ic_widget_button)
public class ServoInitFragment extends BaseFragment<FragmentServoInitBinding> implements  RecyclerViewHolder.OnItemClickListener<ServoData>{

    @NonNull
    @Override
    protected FragmentServoInitBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentServoInitBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        WidgetUtils.initGridRecyclerView(mRecyclerView,
                1,
                DensityUtils.dp2px(2),
                ResUtils.getColor(R.color.xui_config_color_red));

        ServoAdapter servoAdapter = new ServoAdapter(initServo());
        servoAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(servoAdapter);
    }

    private List<ServoData> initServo() {
        List<ServoData> lists = new ArrayList<>();
        for (int i = 0; i < 16; i++){
            ServoData servoData = new ServoData();
            servoData.setId(i);
            servoData.setProcess(90);
            servoData.setName("舵机" + (i + 1));
            lists.add(servoData);
        }
        return lists;
    }

    @Override
    public void onItemClick(View itemView, ServoData item, int position) {

    }
}
