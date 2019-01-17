package com.bugscript.gallerymotionlayout.elasticDismiss;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import com.bugscript.gallerymotionlayout.elasticDismiss.ElasticDragDismissCallback;


@TargetApi(21)
public class SystemChromeFader extends ElasticDragDismissCallback {

    private final Activity activity;
    private final int statusBarAlpha;
    private final int navBarAlpha;
    private final boolean fadeNavBar;

    public SystemChromeFader(Activity activity) {
        this.activity = activity;
        statusBarAlpha = Color.alpha(activity.getWindow().getStatusBarColor());
        navBarAlpha = Color.alpha(activity.getWindow().getNavigationBarColor());
        fadeNavBar = isNavigationBarOnBottom(activity);
    }

    @Override
    public void onDrag(float elasticOffset, float elasticOffsetPixels,
                       float rawOffset, float rawOffsetPixels) {
        if (elasticOffsetPixels > 0) {
            // dragging downward, fade the status bar in proportion
            activity.getWindow().setStatusBarColor(ColorUtils.modifyAlpha(activity.getWindow()
                    .getStatusBarColor(), (int) ((1f - rawOffset) * statusBarAlpha)));
        } else if (elasticOffsetPixels == 0) {
            // reset
            activity.getWindow().setStatusBarColor(ColorUtils.modifyAlpha(
                    activity.getWindow().getStatusBarColor(), statusBarAlpha));
            activity.getWindow().setNavigationBarColor(ColorUtils.modifyAlpha(
                    activity.getWindow().getNavigationBarColor(), navBarAlpha));
        } else if (fadeNavBar) {
            // dragging upward, fade the navigation bar in proportion
            activity.getWindow().setNavigationBarColor(
                    ColorUtils.modifyAlpha(activity.getWindow().getNavigationBarColor(),
                            (int) ((1f - rawOffset) * navBarAlpha)));
        }
    }

    public void onDragDismissed() {
        activity.finishAfterTransition();
    }

    private static boolean isNavigationBarOnBottom(@NonNull Context context) {
        final Resources res = context.getResources();
        final Configuration cfg = context.getResources().getConfiguration();
        final DisplayMetrics dm = res.getDisplayMetrics();
        boolean canMove = (dm.widthPixels != dm.heightPixels &&
                cfg.smallestScreenWidthDp < 600);
        return (!canMove || dm.widthPixels < dm.heightPixels);
    }
}