/*
 * Copyright (C) 2019 xuexiangjys(xuexiangjys@163.com)
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

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.config.AppPageConfig;
import com.xuexiang.xpage.enums.CoreAnim;
import com.xuexiang.xpage.model.PageInfo;
import com.xuexiang.xpage.utils.Utils;
import com.xuexiang.xui.adapter.recyclerview.RecyclerViewHolder;
import com.xuexiang.xui.utils.DensityUtils;
import com.xuexiang.xui.utils.ResUtils;
import com.xuexiang.xui.utils.ThemeUtils;
import com.xuexiang.xui.utils.WidgetUtils;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.zlz.spider.R;
import com.zlz.spider.adapter.WidgetItemAdapter;
import com.zlz.spider.core.BaseFragment;
import com.zlz.spider.databinding.FragmentHomeBinding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xuexiang
 * @since 2019-10-30 00:19
 */
@Page(anim = CoreAnim.none)
public class HomeFragment extends BaseFragment<FragmentHomeBinding> implements RecyclerViewHolder.OnItemClickListener<PageInfo> {

    @NonNull
    @Override
    protected FragmentHomeBinding viewBindingInflate(LayoutInflater inflater, ViewGroup container) {
        return FragmentHomeBinding.inflate(inflater, container, false);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initViews() {
        initRecyclerView();
    }

    @Override
    protected TitleBar initTitle() {
        return null;
    }

    @Override
    public void onItemClick(View itemView, PageInfo item, int position) {
        openNewPage(item.getName());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initRecyclerView() {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        WidgetUtils.initGridRecyclerView(mRecyclerView, 3, DensityUtils.dp2px(2), ThemeUtils.resolveColor(getContext(), R.attr.xui_config_color_separator_light, ResUtils.getColor(R.color.xui_config_color_separator_light_phone)));

        WidgetItemAdapter mWidgetItemAdapter = new WidgetItemAdapter(sortPageInfo(getPageContents(addPage())));
        mWidgetItemAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mWidgetItemAdapter);
    }

    /**
     * 进行排序
     *
     * @param pageInfoList
     * @return
     */
    private List<PageInfo> sortPageInfo(List<PageInfo> pageInfoList) {
        Collections.sort(pageInfoList, (o1, o2) -> o1.getClassPath().compareTo(o2.getClassPath()));
        return pageInfoList;
    }

    /**
     * 获取页面
     *
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<PageInfo> getPageContents(Set<Class<? extends BaseFragment>> pages) {
        Set<String> names = new HashSet<>();
        pages.forEach(aClass -> {
            Page page = Utils.checkNotNull(aClass.getAnnotation(Page.class), "Page == null，请检测页面是否漏加 @Page 进行修饰！");
            names.add(TextUtils.isEmpty(page.name()) ? aClass.getSimpleName() : page.name());
        });

        return AppPageConfig.getInstance().getPages().stream().filter(pageInfo -> names.contains(pageInfo.getName())).collect(Collectors.toList());
    }

    private Set<Class<? extends BaseFragment>> addPage(){
        Set<Class<? extends BaseFragment>> pages = new HashSet<>();
        pages.add(ServoInitFragment.class);
        pages.add(ControllerFragment.class);
        pages.add(VideoFragment.class);
        return pages;
    }
}
