package com.maxxipoint.layoutmanager.slide;



public final class ItemConfig {

    /**
     * 卡片滑动时不偏左也不偏右
     */
    public static final int SLIDING_NONE = 1;
    /**
     * 卡片向左滑动时
     */
    public static final int SLIDING_LEFT = 1 << 2;
    /**
     * 卡片向右滑动时
     */
    public static final int SLIDING_RIGHT = 1 << 3;
    /**
     * 卡片从左边滑出
     */
    public static final int SLIDED_LEFT = 1;
    /**
     * 卡片从右边滑出
     */
    public static final int SLIDED_RIGHT = 1 << 2;
    /**
     * 卡片堆叠数（层数）
     */
    public static final int DEFAULT_SHOW_ITEM = 2;
    /**
     * 默认缩放的比例
     */
    public static final float DEFAULT_SCALE = 0.1f;
    /**
     * 卡片（Y 或 X）轴偏移量时按照14等分计算 这个是堆叠两侧现实的宽度， 越小越宽，越大越窄
     */
    public static final int DEFAULT_TRANSLATE = 12;
    /**
     * 卡片滑动时默认倾斜的角度
     */
    public static final float DEFAULT_ROTATE_DEGREE = 0f;
}
