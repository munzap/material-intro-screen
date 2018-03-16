package agency.tango.materialintroscreen.animations;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;

import java.util.Arrays;

/**
 * Created by Petr on 15.3.2018.
 */

public class CircleButtonRippleDrawable {
    public static Drawable getAdaptiveRippleDrawable(
            int normalColor, int pressedColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return new RippleDrawable(ColorStateList.valueOf(pressedColor),
                    getContentkDrawable(normalColor), getRippleMask(normalColor));
        } else {
            return getStateListDrawable(normalColor, pressedColor);
        }
    }

    private static Drawable getRippleMask(int color) {

        OvalShape oval = new OvalShape();
        ShapeDrawable shapeDrawable = new ShapeDrawable(oval);
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    private static Drawable getContentkDrawable(int color) {

        OvalShape oval = new OvalShape();
        ShapeDrawable shapeDrawable = new ShapeDrawable(oval);
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }


    public static StateListDrawable getStateListDrawable(
            int normalColor, int pressedColor) {
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed},
                new ColorDrawable(pressedColor));
        states.addState(new int[]{android.R.attr.state_focused},
                new ColorDrawable(pressedColor));
        states.addState(new int[]{android.R.attr.state_activated},
                new ColorDrawable(pressedColor));
        states.addState(new int[]{},
                new ColorDrawable(normalColor));
        return states;
    }
}
