package com.xxzy.family.round.helper;

public interface RCAttrs {
    void setClipBackground(boolean clipBackground);

    void setRoundAsCircle(boolean roundAsCircle);

    void setRadius(int radius);

    void setTopLeftRadius(int topLeftRadius);

    void setTopRightRadius(int topRightRadius);

    void setBottomLeftRadius(int bottomLeftRadius);

    void setBottomRightRadius(int bottomRightRadius);

    void setStrokeWidth(int strokeWidth);

    void setStrokeColor(int strokeColor);

    boolean isClipBackground();

    boolean isRoundAsCircle();

    float getTopLeftRadius();

    float getTopRightRadius();

    float getBottomLeftRadius();

    float getBottomRightRadius();

    int getStrokeWidth();

    int getStrokeColor();
}
