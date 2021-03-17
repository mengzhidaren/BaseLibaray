```
<CoordinatorLayout
    <AppBarLayout
        <CollapsingToolbarLayout        app:layout_scrollFlags="scroll|exitUntilCollapsed"
            <Toolbar                    app:layout_collapseMode="pin"
1.  CoordinatorLayout继承自viewgroup,但是使用类似于framLayout,有层次结构,后面的布局会覆盖在前面的布局之上,但跟behavior属性也有很大关系,的app:layout_behavior属性,只有CoordinatorLayout的直接子布局才能响应,所以不要做徒劳无功的事
2. CoordinatorLayout+AppBarLayout+CollapsingToolbarLayout结合起来
3. AppBarLayout:继承自LinearLayout
4. AppBarLayout 的直接子控件可以设置的属性:
    layout_scrollFlags
        scroll    Child View可以滚动
                向上优先childView滚出屏幕，然后ScrollView才开始滚动,下滚动的时候，优先滚动的ScrollView到顶后 childView滚入屏幕
        scroll|enterAlways:   enterAlways一旦手指向下滑动这个view就可见
                            向上优先滚动childView滚出屏幕，
                             向下优先滚动childView滚入屏幕

        scroll|enterAlways|enterAlwaysCollapsed    enterAlwaysCollapsed这个flag定义的是已经消失之后何时再次显示
                                                  这里涉及到Child View的高度和最小高度，
                                                  向下优先滚动Child View先向下滚动至最小高度值，然后Scrolling View开始滚动，到达边界时，Child View再向下滚动，直至显示完全。
                                                  enterAlwaysCollapsed:它是enterAlways的附加值。要使用它，必须三者一起使用；->使用CollapsingToolbarLayout
        scroll|exitUntilCollapsed  这里涉及到Child View的最小高度，有exitUntilCollapsed属性,childView的最小高度最后会固定在头部
                            向上优先滚动childView退出直至最小高度,然后Scrolling View开始滚动
                            向下优先滚动ScrollView到顶后childView滚入屏幕

        scroll|snap   snap确保childView不会滑动停止在中间的状态,有点类似ViewPager的左右滑动
            当我们松开手指时，Child View要么向上全部滚出屏幕，要么向下全部滚进屏幕，

5.  CollapsingToolbarLayout,字面意思是折叠的toolbar,它确实是起到折叠作用的,可以把自己的自布局折叠 继承自frameLayout,
        所以它的直接子类可以设置layout_gravity来控制显示的位置,
        它的直接子布局可以使用的属性:app:layout_collapseMode(折叠模式):可取的值如下:
            1.pin:(固定不动) 在滑动过程中,此自布局会固定在它所在的位置不动,直到CollapsingToolbarLayout全部折叠或者全部展开
            2.parallax:(跟随滑动) 在CollapsingToolbarLayout滚动时，childView也可以同时滚动 和视差因子搭配使用
              layout_collapseParallaxMultiplier这个参数是设置视差范围的,0-1,越大视差越大
            3.不设置:跟随NestedScrollView的滑动一起滑动,NestedScrollView滑动多少距离他就会跟着走多少距离


6. toobar 最好是放在CollapsingToolbarLayout 才能达到好的动画效果
7. CollapsingToolbarLayout里面包含有toolbar那么折叠后高度就是toolbar的高度,相当于设置了minHeight属性
8. CollapsingToolbarLayout折叠到最顶端时,它就是老大,会处于最上层,包括toolbar在内,所有的布局都会被他盖住,显示不出来.
9. CollapsingToolbarLayout 自己的属性 说明,不是直接子布局可用的,是自己可以用的属性
    contentScrim折叠后的颜色也是展开时的渐变颜色,当CollapsingToolbarLayout完全折叠后的背景颜色

app:layout_anchor="@id/appbar"
提供了一个layout_anchor的属性，连同layout_anchorGravity一起，可以用来放置与其他视图关联在一起的悬浮视图（如FloatingActionButton）。
app:layout_anchorGravity="bottom | right | end" 悬浮视图的位置

10.  怎么实现固定表头,写一个布局放在CollapsingToolbarLayout之后,AppBarLayout之内即可,
    如果放在CollapsingToolbarLayout之前,AppBarLayout之内会怎么样?这样折叠布局就不起作用了.不会折叠了.



BottomSheetBehavior     底部抽屉控件
app:behavior_hideable="true"
app:behavior_peekHeight="300dp"    //表示弹出后显示的高度为300dp。
app:layout_behavior="@string/bottom_sheet_behavior"


SwipeDismissBehavior   滑动消失


自定义Behavior
第一种是通过监听一个View的状态，如位置、大小的变化，来改变其他View的行为，这种只需要重写2个方法就可以了，
分别是layoutDependsOn 和onDependentViewChanged, layoutDependsOn方法判断是指定依赖的View时，返回true,
然后在onDependentViewChanged 里，被依赖的View做需要的行为动作。
第二种就是重写onStartNestedScroll、onNestedPreScroll、onNestedScroll等一系列方法

```