## AnchorBottomSheetBehavior

An interaction behavior plugin for a child view of `CoordinatorLayout` to make it work as a
bottom sheet with collapsed, expanded and anchored states. [Looking for iOS?][slide-outable-ios]

![AnchorBottomSheetBehavior in action][sample-gif]

### Usage
Just add the attribute below to the `View` you want to act as the anchorable bottom sheet.
```xml
app:layout_behavior="com.trafi.anchorbottomsheetbehavior.AnchorBottomSheetBehavior"
```

In a layout file, you could specify it like this.
```xml
<android.support.design.widget.CoordinatorLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <!-- background content -->

    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@android:color/black"
        app:layout_behavior="com.trafi.anchorbottomsheetbehavior.AnchorBottomSheetBehavior">

        <!-- bottom sheet content -->

    </FrameLayout>
        
</android.support.design.widget.CoordinatorLayout>
```
Or try out the [included sample][sample].

### Installation
```groovy
// top-level build.gradle
allprojects {
    repositories {
        // ..
        maven { url 'https://jitpack.io' }
    }
}

// module build.gradle
dependencies {
    // ..
    implementation 'com.trafi:anchor-bottom-sheet-behavior:0.13-alpha'
}
```


### Advanced usage
```xml
<FrameLayout
    android:id="@+id/bottom_sheet"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@android:color/black"
    app:behavior_anchorOffset="320dp"
    app:behavior_peekHeight="192dp"
    app:behavior_defaultState="collapsed"
    app:layout_behavior="com.trafi.anchorbottomsheetbehavior.AnchorBottomSheetBehavior">
```

```kotlin
val behavior = AnchorBottomSheetBehavior.from(bottom_sheet)
behavior.state = AnchorBottomSheetBehavior.STATE_EXPANDED
behavior.allowUserDragging = false
behavior.anchorOffset = 200
behavior.peekHeight = 100
behavior.addBottomSheetCallback(object : AnchorBottomSheetBehavior.BottomSheetCallback() {
    override fun onSlide(view: View, offset: Float) {
        // offset == 0f when bottom sheet is collapsed
        // offset == 1f when bottom sheet is expanded
    }
    
    override fun onStateChanged(view: View, oldState: Int, newState: Int) {
        when (newState) {
            STATE_COLLAPSED -> TODO()
            STATE_ANCHORED -> TODO()
            STATE_EXPANDED -> TODO()
        }
    }
})
```


[slide-outable-ios]: https://github.com/trafi/SlideOutable
[sample]: https://github.com/trafi/anchor-bottom-sheet-behavior/tree/master/sample
[sample-gif]: http://i.giphy.com/l2JhIAM4Osl5MdZV6.gif
