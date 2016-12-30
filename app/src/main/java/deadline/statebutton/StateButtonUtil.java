package deadline.statebutton;

import android.support.annotation.ColorInt;

/**
 * Created by hkq325800 on 2016/12/30.
 */

public class StateButtonUtil {

    private @ColorInt int first;
    private @ColorInt int second;

    public StateButtonUtil(@ColorInt int first,@ColorInt int second){
        this.first = first;
        this.second = second;
    }
    /**
     * 设为对立状态 保存于tag中
     * @param btn
     */
    public void set(StateButton btn) {
        boolean flag = btn.getTag() != null && (boolean) btn.getTag();
        btn.setNormalStrokeColor(flag ? first : second);
        btn.setNormalTextColor(flag ? first : second);
        btn.setTag(!flag);
    }

    /**
     * 强制设为某一状态
     * @param btn
     * @param targetFlag
     */
    public void set(StateButton btn, boolean targetFlag) {
        btn.setNormalStrokeColor(!targetFlag ? first : second);
        btn.setNormalTextColor(!targetFlag ? first : second);
        btn.setTag(targetFlag);
    }
}
