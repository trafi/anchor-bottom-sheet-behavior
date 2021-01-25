/*
 * Copyright (C) 2016 Christian Langer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.trafi.anchorbottomsheetbehavior;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class BottomSheetUtils {

    public static void setupViewPager(ViewPager pager) {
        final View bottomSheetView = findBottomSheetView(pager);
        if (bottomSheetView != null) {
            pager.addOnPageChangeListener(new BottomSheetViewPagerListener(pager, bottomSheetView));
        }
    }

    public static void setupViewPager2(ViewPager2 pager) {
        final View bottomSheetView = findBottomSheetView(pager);
        if (bottomSheetView != null) {
            pager.registerOnPageChangeCallback(new BottomSheetViewPager2Listener(pager, bottomSheetView));
        }
    }

    private static class BottomSheetViewPager2Listener extends ViewPager2.OnPageChangeCallback {
        private final View pager;
        private final AnchorBottomSheetBehavior behavior;

        private BottomSheetViewPager2Listener(ViewPager2 pager, View bottomSheetView) {
            this.pager = pager;
            this.behavior = AnchorBottomSheetBehavior.from(bottomSheetView);
        }

        @Override
        public void onPageSelected(int position) {
            pager.post(new Runnable() {
                @Override
                public void run() {
                    behavior.invalidateScrollingChild();
                }
            });
        }
    }

    private static class BottomSheetViewPagerListener extends ViewPager.SimpleOnPageChangeListener {
        private final View pager;
        private final AnchorBottomSheetBehavior behavior;

        private BottomSheetViewPagerListener(ViewPager pager, View bottomSheetView) {
            this.pager = pager;
            this.behavior = AnchorBottomSheetBehavior.from(bottomSheetView);
        }

        @Override
        public void onPageSelected(int position) {
            pager.post(new Runnable() {
                @Override
                public void run() {
                    behavior.invalidateScrollingChild();
                }
            });
        }
    }

    private static View findBottomSheetView(View root) {
        View current = root;
        while (current != null) {
            final ViewGroup.LayoutParams params = current.getLayoutParams();
            if (params instanceof CoordinatorLayout.LayoutParams
                    && ((CoordinatorLayout.LayoutParams) params).getBehavior() instanceof AnchorBottomSheetBehavior) {
                return current;
            }
            final ViewParent parent = current.getParent();
            current = parent == null || !(parent instanceof View) ? null : (View) parent;
        }
        return null;
    }

}
