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
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.zlz.spider.R;
import com.zlz.spider.core.BaseFragment;
import com.zlz.spider.databinding.FragmentControllerBinding;
import com.xuexiang.xpage.annotation.Page;

@Page(name = "手柄", extra = R.drawable.ic_widget_banner)
public class ControllerFragment extends BaseFragment<FragmentControllerBinding> {

    @NonNull
    @Override
    protected FragmentControllerBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentControllerBinding.inflate(inflater, container, false);
    }

    @Override
    protected void initViews() {

    }
}
