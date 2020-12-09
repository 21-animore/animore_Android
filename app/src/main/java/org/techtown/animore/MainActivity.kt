package org.techtown.animore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.animore.nework.RequestCardInterface

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var retrofitClient: RequestCardInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host)
        NavigationUI.setupWithNavController(bottomNavigationView, findNavController(R.id.nav_host)) //네비게이션바랑 메인 frag 셋 연결

    }
}