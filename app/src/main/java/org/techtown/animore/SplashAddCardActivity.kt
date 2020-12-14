package org.techtown.animore

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activitiy_splash_add.*
import kotlinx.android.synthetic.main.activitiy_splash_finish.*
import kotlinx.android.synthetic.main.activitiy_splash_finish.finish_splash
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*
import kotlin.concurrent.timer

class SplashAddCardActivity : AppCompatActivity() {

    var timerTask : Timer? = null

    fun go_timer(){
        var ti = 0
        timerTask = timer(period = 850){
            ti +=1
            if(ti>=4) {
                timerTask?.cancel()
            }
            runOnUiThread{
                if(ti<=1)
                {
                    challenge_setting_title.visibility = View.GONE
                    challenge_setting_text.visibility = View.GONE
                }else{
                    challenge_setting_text.text = textData
                    challenge_setting_title.visibility = View.VISIBLE
                    challenge_setting_text.visibility = View.VISIBLE
                }
            }
        }
    }

    private lateinit var textData: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_splash_add)

        challenge_setting.playAnimation()
        textData = intent.getStringExtra("add_text")!!
        textData = textData.replace("\n", System.getProperty("line.separator")!!)
        go_timer()//애니메이션 시작 후 글자가 1초 후에 등장해야

        challenge_setting.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                val intent = Intent(this@SplashAddCardActivity, MainActivity::class.java)
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