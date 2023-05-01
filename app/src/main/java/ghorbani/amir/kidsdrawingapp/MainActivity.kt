package ghorbani.amir.kidsdrawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {

    private var drawingView: DrawingView? = null
    private var mImageButtonCurrentPaint : ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawing_view)
        drawingView?.setSizeForBrush(5.toFloat())

        val linearLayoutPaintColors = findViewById<LinearLayout>(R.id.ll_paint_colors)
        mImageButtonCurrentPaint = linearLayoutPaintColors[0] as ImageButton
//        mImageButtonCurrentPaint!!.setImageDrawable(
//            ContextCompat.getDrawable(this, R.drawable.pallet_selected))


        val ibButton : ImageButton = findViewById(R.id.ib_brush_size)

        ibButton.setOnClickListener {
            showBrushSizeChooserDialog()
        }

    }

    private fun showBrushSizeChooserDialog() {
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush size: ")
        val smallBtn: ImageButton = brushDialog.findViewById(R.id.ib_small_brush)
        smallBtn.setOnClickListener {
            drawingView?.setSizeForBrush(5.toFloat())
            brushDialog.dismiss()
        }
        val mediumBtn: ImageButton = brushDialog.findViewById(R.id.ib_medium_brush)
        mediumBtn.setOnClickListener {
            drawingView?.setSizeForBrush(7.5.toFloat())
            brushDialog.dismiss()
        }
        val largeBtn: ImageButton = brushDialog.findViewById(R.id.ib_large_brush)
        largeBtn.setOnClickListener {
            drawingView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }
        val xlargeBtn: ImageButton = brushDialog.findViewById(R.id.ib_xlarge_brush)
        xlargeBtn.setOnClickListener {
            drawingView?.setSizeForBrush(12.5.toFloat())
            brushDialog.dismiss()
        }
        val xxlargeBtn: ImageButton = brushDialog.findViewById(R.id.ib_xxlarge_brush)
        xxlargeBtn.setOnClickListener {
            drawingView?.setSizeForBrush(15.toFloat())
            brushDialog.dismiss()
        }
        val xxxlargeBtn: ImageButton = brushDialog.findViewById(R.id.ib_xxxlarge_brush)
        xxxlargeBtn.setOnClickListener {
            drawingView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.show()
    }

    fun paintClicked(view: View){
        if (view !== mImageButtonCurrentPaint){
            val imageButton = view as ImageButton
            val colorTag = imageButton.tag.toString()
            drawingView?.setColor(colorTag)

            imageButton.setImageDrawable(ContextCompat.getDrawable(
                this, R.drawable.pallet_selected))

            mImageButtonCurrentPaint?.setImageDrawable(ContextCompat.getDrawable(
                this, R.drawable.pallet_normal))

            mImageButtonCurrentPaint = view


        }
    }
}