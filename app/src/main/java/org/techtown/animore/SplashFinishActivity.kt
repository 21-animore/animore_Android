package org.techtown.animore

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activitiy_splash_finish.*
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*
import kotlin.concurrent.timer

class SplashFinishActivity : AppCompatActivity() {

    var timerTask : Timer? = null

    fun go_timer(){
        var ti = 0
        timerTask = timer(period = 900){
            ti +=1
            if(ti>=4) {
                timerTask?.cancel()
            }
            runOnUiThread{
                if(ti<=1)
                {
                    finish_title.visibility = View.GONE
                    finish_text.visibility = View.GONE
                }else{
                    finish_title.visibility = View.VISIBLE
                    finish_text.visibility = View.VISIBLE
                }
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_splash_finish)

        finish_splash.playAnimation()
        go_timer()//애니메이션 시작 후 글자가 1초 후에 등장해야


        finish_splash.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                val intent = Intent(this@SplashFinishActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
    }

}