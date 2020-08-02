package com.meicet.adapter.material

/**
 *
<CoordinatorLayout
    <AppBarLayout
        <CollapsingToolbarLayout        app:layout_scrollFlags="scroll|exitUntilCollapsed"
            <Toolbar                    app:layout_collapseMode="pin"
1.  CoordinatorLayout继承自viewgroup,但是使用类似于framLayout,有层次结构,后面的布局会覆盖在前面的布局之上,但跟behavior属性也有很大关系,的app:layout_behavior属性,只有CoordinatorLayout的直接子布局才能响应,所以不要做徒劳无功的事
2. CoordinatorLayout+AppBarLayout+CollapsingToolbarLayout结合起来
3. AppBarLayout:继承自LinearLayout
4. AppBarLayout的直接子控件可以设置的属性:layout_scrollFlags
    1.scroll|exitUntilCollapsed 如果AppBarLayout的直接子控件设置该属性,该子控件可以滚动,向上滚动NestedScrollView出父布局(一般为CoordinatorLayout)时,会折叠到顶端,向下滚动时NestedScrollView必须滚动到最上面的时候才能拉出该布局
    2.scroll|enterAlways:只要向下滚动该布局就会显示出来,只要向上滑动该布局就会向上收缩
    3.scroll|enterAlwaysCollapsed:向下滚动NestedScrollView到最底端时该布局才会显示出来
    4.如果不设置改属性,则改布局不能滑动
5.  CollapsingToolbarLayout,字面意思是折叠的toolbar,它确实是起到折叠作用的,可以把自己的自布局折叠 继承自frameLayout,
        所以它的直接子类可以设置layout_gravity来控制显示的位置,它的直接子布局可以使用的属性:app:layout_collapseMode(折叠模式):可取的值如下:
    1.pin:在滑动过程中,此自布局会固定在它所在的位置不动,直到CollapsingToolbarLayout全部折叠或者全部展开
    2.parallax: 这个参数是设置视差范围的,0-1,越大视差越大
    3.不设置:跟随NestedScrollView的滑动一起滑动,NestedScrollView滑动多少距离他就会跟着走多少距离
6. toobar 最好是放在CollapsingToolbarLayout 才能达到好的动画效果
7. CollapsingToolbarLayout里面包含有toolbar那么折叠后高度就是toolbar的高度,相当于设置了minHeight属性
8. CollapsingToolbarLayout折叠到最顶端时,它就是老大,会处于最上层,包括toolbar在内,所有的布局都会被他盖住,显示不出来.
9. CollapsingToolbarLayout 自己的属性 说明,不是直接子布局可用的,是自己可以用的属性
    contentScrim折叠后的颜色也是展开时的渐变颜色

10.  怎么实现固定表头,写一个布局放在CollapsingToolbarLayout之后,AppBarLayout之内即可,
    如果放在CollapsingToolbarLayout之前,AppBarLayout之内会怎么样?这样折叠布局就不起作用了.不会折叠了.
 */
object MaterialUtils {
}