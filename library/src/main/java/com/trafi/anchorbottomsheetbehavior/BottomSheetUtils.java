package com.trafi.anchorbottomsheetbehavior;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class BottomSheetUtils {

    public static void setupViewPager(ViewPager viewPager) {
        final View bottomSheetParent = findBottomSheetView(viewPager);
        if (bottomSheetParent != null) {
            viewPager.addOnPageChangeListener(new BottomSheetViewPagerListener(bottomSheetParent));
        }
    }

    private static class BottomSheetViewPagerListener extends ViewPager.SimpleOnPageChangeListener {
        private final AnchorBottomSheetBehavior<View> behavior;

        public BottomSheetViewPagerListener(View bottomSheetParent) {
            this.behavior = AnchorBottomSheetBehavior.from(bottomSheetParent);
        }

        @Override
        public void onPageSelected(int position) {
            behavior.invalidateScrollingChild();
        }
    }

    private static View findBottomSheetView(final View view) {
        View current = view;
        while (current != null) {
            final ViewGroup.LayoutParams params = current.getLayoutParams();
            if (params instanceof CoordinatorLayout.LayoutParams && ((CoordinatorLayout.LayoutParams) params).getBehavior() instanceof AnchorBottomSheetBehavior) {
                return current;
            }
            final ViewParent parent = current.getParent();
            current = parent == null || !(parent instanceof View) ? null : (View) parent;
        }
        return null;
    }

}
