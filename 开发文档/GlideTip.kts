
import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.tiaooo.aaron.R
import io.rong.imlib.filetransfer.RequestOption
import java.io.File


//广告轮播图  小图 和 大图
fun ImageView.loadBannerThumb(path: String?, big: Boolean) {
    if (path.isNullOrEmpty()) return

}
fun ImageView.loadImage(path: String, maxSize: Boolean = false) {
    if (path.isEmpty()) return
    Glide.with(this)
        .load(path)
        .apply {
            if (maxSize) {
                override(Target.SIZE_ORIGINAL)
            }
        }
        .into(this)
}

fun ImageView.loadScaleWarp(path: String?) {
    if (path.isNullOrEmpty()) return
    //如果您希望ImageView调整其边界，请将其设置为true保留其可绘制对象的长宽比。加载图片宽度填满，高度自适应图片比列
    adjustViewBounds = true
    //全屏
    scaleType = ImageView.ScaleType.FIT_XY
    Glide.with(this)
        .load(path)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)

    Glide.with(this)
        .load(path)
        .apply(optionsCircle(100))
        .centerCrop()

}


//DiskCacheStrategy.NONE： 表示不缓存任何内容
//DiskCacheStrategy.DATA： 表示只缓存原始图片
//DiskCacheStrategy.RESOURCE： 表示只缓存转换过后的图片
//DiskCacheStrategy.ALL ： 表示既缓存原始图片，也缓存转换过后的图片
//DiskCacheStrategy.AUTOMATIC： 表示让Glide根据图片资源智能地选择使用哪一种缓存策略（默认选项）
//
//preload预加载  提前对图片进行一个预加载，等真正需要加载图片的时候就直接从缓存中读取
//into(imageView) //当需要加载此url时，会先从缓存里读取图片
//asGif 指定加载动态图片，如果加载静态图片将会显示加载失败或者显示异常时设定的占位图片
//asBitmap 指定加载静态图片,如果加载gif图片将会显示第一帧
//RequestOptions
//.skipMemoryCache(true) //禁用内存缓存
//.diskCacheStrategy(DiskCacheStrategy.NONE) //禁用硬盘缓存
//.onlyRetrieveFromCache(true)//只从缓存加载图片
//.override(100, 100) //设置加载的图片大小
//Glide会自动根据ImageView的大小来决定图片的大小，但是也可以指定加载图片的大小(view的宽高设定为wrap_content才可以指定尺寸)：
//其它方案
//compile 'jp.wasabeef:glide-transformations:3.0.1'
//.apply(bitmapTransform(new BlurTransformation(80))) //模糊度
//.apply(bitmapTransform(new RoundedCornersTransformation(50, 0, RoundedCornersTransformation.CornerType.ALL))) //第一个参数越大圆角越大
//.apply(bitmapTransform(new CropCircleTransformation())) //圆形图片
//.apply(bitmapTransform(new ColorFilterTransformation(0x7900CCCC)))//颜色叠加
//MultiTransformation对象可以存放多种效果
//thumbnail(0.1f) 缩略图0.1f会显示原图大小的10%
// .centerCrop()等比例缩放图片，直到图片的宽高都大于等于ImageView的宽度，然后截取中间的显示。
//.fitCenter()等比例缩放图片，宽或者是高等于ImageView的宽或者是高
@SuppressLint("CheckResult")
fun getOptions() {
}

fun placeHolderId(width: Int) = when (width) {
    in 0..120 -> R.drawable.place_small3
    in 120..150 -> R.drawable.place_small22
    else -> R.drawable.img_placeholder
}


fun optionsRound(width: Int, height: Int,radius: Int) = RequestOptions.bitmapTransform(RoundedCorners(radius))
    .override(width, height)
    .placeholder(placeHolderId(width))
    .error(placeHolderId(width))

fun optionsCircle(width: Int)= RequestOptions.bitmapTransform(CircleCrop())
//            .override(width, height)
    .placeholder(placeHolderId(width))
    .error(placeHolderId(width))




