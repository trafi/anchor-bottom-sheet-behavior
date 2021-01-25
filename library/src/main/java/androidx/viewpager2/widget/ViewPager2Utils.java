package androidx.viewpager2.widget;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class ViewPager2Utils {
    public static View getCurrentView(ViewPager2 viewPager) {
        final int currentItem = viewPager.getCurrentItem();
        RecyclerView recyclerView = (RecyclerView) viewPager.getChildAt(0);
        if (recyclerView.getChildCount() > currentItem) {
            return recyclerView.getChildAt(currentItem);
        }

        return null;
    }
}
