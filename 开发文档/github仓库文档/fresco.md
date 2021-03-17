```
 fresco:placeholderImage="@drawable/img_placeholder"
 fresco:overlayImage="@drawable/img_placeholder"

测试圆图  fresco:roundWithOverlayColor="@color/dark_slate_gray"
圆角 fresco:roundedCornerRadius="3dp"
    fresco:roundWithOverlayColor="@color/red"
    fresco:viewAspectRatio="1"
    fresco:roundingBorderWidth="1"
    fresco:roundingBorderColor=""



图片属性    fresco         http://fresco-cn.org/
   <declare-styleable name="GenericDraweeHierarchy">

      阴影图
           <attr name="overlayImage" format="reference" />
        <attr name="fadeDuration" format="integer" />
        <attr name="viewAspectRatio" format="float" />
        <attr name="placeholderImage" format="reference" />
        <attr name="placeholderImageScaleType">
            <enum name="none" value="-1" />
            <enum name="fitXY" value="0" />
            <enum name="fitStart" value="1" />
            <enum name="fitCenter" value="2" />
            <enum name="fitEnd" value="3" />
            <enum name="center" value="4" />
            <enum name="centerInside" value="5" />
            <enum name="centerCrop" value="6" />
            <enum name="focusCrop" value="7" />
        </attr>
        <attr name="retryImage" format="reference" />
        <attr name="retryImageScaleType">
            <enum name="none" value="-1" />
            <enum name="fitXY" value="0" />
            <enum name="fitStart" value="1" />
            <enum name="fitCenter" value="2" />
            <enum name="fitEnd" value="3" />
            <enum name="center" value="4" />
            <enum name="centerInside" value="5" />
            <enum name="centerCrop" value="6" />
            <enum name="focusCrop" value="7" />
        </attr>
        <attr name="failureImage" format="reference" />
        <attr name="failureImageScaleType">
            <enum name="none" value="-1" />
            <enum name="fitXY" value="0" />
            <enum name="fitStart" value="1" />
            <enum name="fitCenter" value="2" />
            <enum name="fitEnd" value="3" />
            <enum name="center" value="4" />
            <enum name="centerInside" value="5" />
            <enum name="centerCrop" value="6" />
            <enum name="focusCrop" value="7" />
        </attr>
        <attr name="progressBarImage" format="reference" />
        <attr name="progressBarImageScaleType">
            <enum name="none" value="-1" />
            <enum name="fitXY" value="0" />
            <enum name="fitStart" value="1" />
            <enum name="fitCenter" value="2" />
            <enum name="fitEnd" value="3" />
            <enum name="center" value="4" />
            <enum name="centerInside" value="5" />
            <enum name="centerCrop" value="6" />
            <enum name="focusCrop" value="7" />
        </attr>
        <attr name="progressBarAutoRotateInterval" format="integer" />
        <attr name="actualImageScaleType">
            <enum name="none" value="-1" />
            <enum name="fitXY" value="0" />
            <enum name="fitStart" value="1" />
            <enum name="fitCenter" value="2" />
            <enum name="fitEnd" value="3" />
            <enum name="center" value="4" />
            <enum name="centerInside" value="5" />
            <enum name="centerCrop" value="6" />
            <enum name="focusCrop" value="7" />
        </attr>
        <attr name="backgroundImage" format="reference" />

        <attr name="pressedStateOverlayImage" format="reference" />
        <attr name="roundAsCircle" format="boolean" />
        <attr name="roundedCornerRadius" format="dimension" />
        <attr name="roundTopLeft" format="boolean" />
        <attr name="roundTopRight" format="boolean" />
        <attr name="roundBottomRight" format="boolean" />
        <attr name="roundBottomLeft" format="boolean" />
        <attr name="roundWithOverlayColor" format="color" />
        <attr name="roundingBorderWidth" format="dimension" />
        <attr name="roundingBorderColor" format="color" />
        <attr name="roundingBorderPadding" format="dimension" />
    </declare-styleable>

<com.facebook.drawee.view.SimpleDraweeView
  android:id="@+id/my_image_view"
  android:layout_width="20dp"
  android:layout_height="20dp"
  fresco:fadeDuration="300"
  fresco:actualImageScaleType="focusCrop"
  fresco:placeholderImage="@color/wait_color"
  fresco:placeholderImageScaleType="fitCenter"
  fresco:failureImage="@drawable/error"
  fresco:failureImageScaleType="centerInside"
  fresco:retryImage="@drawable/retrying"
  fresco:retryImageScaleType="centerCrop"
  fresco:progressBarImage="@drawable/progress_bar"
  fresco:progressBarImageScaleType="centerInside"
  fresco:progressBarAutoRotateInterval="1000"
  fresco:backgroundImage="@color/blue"
  fresco:overlayImage="@drawable/watermark"
  fresco:pressedStateOverlayImage="@color/red"
  fresco:roundAsCircle="false"
  fresco:roundedCornerRadius="1dp"
  fresco:roundTopLeft="true"
  fresco:roundTopRight="false"
  fresco:roundBottomLeft="false"
  fresco:roundBottomRight="true"
  fresco:roundWithOverlayColor="@color/corner_color"
  fresco:roundingBorderWidth="2dp"
  fresco:roundingBorderColor="@color/border_color"
/>
```