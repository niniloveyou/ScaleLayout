# ScaleLayout
a viewgroup which can scale child view dynamically .
you can set top View, bottom View, center View as your wish

![](https://github.com/niniloveyou/ScaleLayout/blob/master/scale_gif1.gif)

![](https://github.com/niniloveyou/ScaleLayout/blob/master/scale_gif2.gif)
#System Requirement

Android API 11+， Because of the use of ValueAnimation， if you want use it on API 8, please use NineoldAndroids library in your project.

#Usage

    <resources>
    <!--你需要给top view ，center view ，bottom view
    分别设置以下三个id，才有效-->
    <item type="id" name="scaleLayout_top" />
    <item type="id" name="scaleLayout_center" />
    <item type="id" name="scaleLayout_bottom" />

    <declare-styleable name="ScaleLayout">
               
       <!--default state 默认是缩小的还是？-->
        <attr name="state">
            <flag name="open" value="0" />
            <flag name="close" value="1" />
        </attr>

        <!--是否启用推荐的minScale, 启用的话会覆盖原有的minScale-->
        <attr name="suggestScaleEnable" format="boolean"/>

        <!--默认是上滑缩小，下滑放大， 也可以设置为上滑放大，下滑缩小-->
        <attr name="slideUpOrDownEnable" format="boolean"/>

        <!--是否启用滑动缩放功能-->
        <attr name="slideScaleEnable" format="boolean"/>
    </declare-styleable>
</resources>



    //设置可缩放到的最小比例
    public void setMinScale(float minScale);
    
    public float getMinScale();
    
    //获取当前scale值
    public float getCurrentScale()；
    
    是否启用推荐的minScale, 启用的话会覆盖原有的minScale
    public void setSuggestScaleEnable(boolean enable);
    
    是否启用滑动缩放功能
    public void setSlideScaleEnable(boolean enable);
    
    默认是上滑缩小，下滑放大， 也可以设置为上滑放大，下滑缩小
    public void setSlideUpOrDownEnable(boolean enable);
    
    设置关闭开启可设置是否启用动画
    public void setState(final int state, boolean animationEnable);
    
    
    
    
     /**
     * 当centerView 的scale变化的时候，通过这个
     * 接口外部的View可以做一些同步的事情，
     * 比如，你有一个其他的view要根据centerView的变化而变化
     */
    public interface OnScaleChangedListener{

        void onScaleChanged(float currentScale);
    }

    /**
     * state == false 当完全关闭（scale == 1f）
     * state == true  或当完全开启的时候(scale = mMinScale)
     */
    public interface OnStateChangedListener{

        void onStateChanged(boolean state);
    }

    /**
     * 返回是否可以scale,主要为了适配部分有滑动冲突的view
     * 如TouchImageView, 甚至webView等
     * isScrollSown = true  代表向下，
     * isScrollSown = false 代表向上
     */
    public interface OnGetCanScaleListener{

        boolean onGetCanScale(boolean isScrollSown);
    }

    


#我的博客
http://www.jianshu.com/users/25e80ace21b8/latest_articles
