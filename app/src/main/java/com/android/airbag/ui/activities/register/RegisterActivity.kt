package com.android.airbag.ui.activities.register

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer

import com.android.airbag.R
import com.android.airbag.helpers.Constants
import com.android.airbag.helpers.SharedPreferencesManager

import com.android.airbag.models.RegisterBody
import com.blankj.utilcode.util.UriUtils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.emailET
import kotlinx.android.synthetic.main.activity_register.passwordET
import org.koin.androidx.viewmodel.ext.android.viewModel
import pub.devrel.easypermissions.EasyPermissions
import java.io.File

class RegisterActivity : AppCompatActivity() {

    private val READ_PERMISSION_CODE = 525
    private val GALLERY_CODE = 225
    private var avatar: File? = null
    private val viewModel: RegisterViewModel by viewModel()
    private var registerBody  = RegisterBody()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)



        uploadProfileIV.setOnClickListener { takePhoto() }
        submitBtn.setOnClickListener{
            if (validateInputs()){
                viewModel.register(registerBody).observe(this , Observer {
                    it?.let {
                        Toast.makeText(this,"Register Success" , Toast.LENGTH_SHORT).show()
                    }
                })
            }

        }

        viewModel.error.observe(this , Observer {
            it?.let {
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        })

        if (SharedPreferencesManager.getIntValue(this, Constants.USER_TYPE) == 1) {

            root_view_layout.background = ContextCompat.getDrawable(this,R.drawable.full_screen_background_orang)
            submitBtn.background = ContextCompat.getDrawable(this ,R.drawable.button_background_2)
        }
    }

    private fun takePhoto() {

        val perms = android.Manifest.permission.READ_EXTERNAL_STORAGE
        if (EasyPermissions.hasPermissions(this,perms)){

            val intent =  Intent()
            intent.type = "image/*"
            intent.action = (Intent.ACTION_GET_CONTENT)

            if (intent.resolveActivity(packageManager) != null) {

                startActivityForResult(Intent.createChooser(intent, "Select Picture"),GALLERY_CODE)

            }
        }else{
            EasyPermissions.requestPermissions(this , "Requesting Read Permission",READ_PERMISSION_CODE,perms)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this)
        if (requestCode == READ_PERMISSION_CODE && permissions.isNotEmpty()) takePhoto()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GALLERY_CODE && resultCode == Activity.RESULT_OK){
            data?.data?.let {
                avatar = UriUtils.uri2File(it!!)
                Glide.with(userProfileIV).load(it).circleCrop().placeholder(R.drawable.ic_user_profile).into(userProfileIV)
            }
        }
    }

    private fun validateInputs() : Boolean{

        if (fullNameET.text.isNullOrEmpty() || emailET.text.isNullOrEmpty()
                || passwordET.text.isNullOrEmpty() || phoneNumberET.text.isNullOrEmpty()){
            Toast.makeText(this,R.string.all_fields_required,Toast.LENGTH_SHORT).show()
            return false
        }

        registerBody.firstName = fullNameET.text.toString()
        registerBody.email = emailET.text.toString()
        registerBody.password = passwordET.text.toString()
        registerBody.phone = phoneNumberET.text.toString()
        registerBody.phoneCountry = "+20"

        return true
    }
    companion object {

        private val TAG = "RegisterActivity"
    }
}
