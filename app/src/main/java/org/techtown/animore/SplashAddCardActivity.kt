package org.techtown.animore

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activitiy_splash_add.*
import kotlinx.android.synthetic.main.activitiy_splash_finish.*
import kotlinx.android.synthetic.main.activitiy_splash_finish.finish_splash
import kotlinx.android.synthetic.main.activity_splash.*

class SplashAddCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_splash_add)

        challenge_setting.playAnimation()
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