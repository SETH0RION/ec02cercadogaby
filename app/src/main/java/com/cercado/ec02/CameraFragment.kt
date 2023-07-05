package com.cercado.ec02

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.cercado.ec02.databinding.FragmentCameraBinding



class CameraFragment : Fragment() {
    private lateinit var binding: FragmentCameraBinding
    private lateinit var openCameraLauncher : ActivityResultLauncher<Intent>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_camera, container, false)

        val btncamera : Button = view.findViewById(R.id.camera_add_photo)
        btncamera.setOnClickListener {
            Toast.makeText(view.context, "Take a photo", Toast.LENGTH_SHORT).show()
            if(permissionValidated()) {
                openCamera()
            }
        }

        openCameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                val photo: Bitmap = result.data?.extras?.get("data") as Bitmap
                binding.cameraPhoto.setImageBitmap(photo)
            }
        }

        return view
    }

    private fun permissionValidated(): Boolean{


        val cameraPermission = ContextCompat.checkSelfPermission( requireContext(), Manifest.permission.CAMERA)
        val permissionList: MutableList<String> = mutableListOf()

        if (cameraPermission != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.CAMERA)
        }
        if (permissionList.isNotEmpty()){
            ActivityCompat.requestPermissions(requireActivity(),permissionList.toTypedArray(),1000)

            return false
        }
        return true
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) :Unit {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode){
            1000->{
                if (ContextCompat.checkSelfPermission(requireContext() , Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    openCamera()
                }else{
                    Toast.makeText(requireContext(), "Permisos de camara denegado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun openCamera(){
        val intent = Intent()
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE)
        openCameraLauncher.launch(intent)
    }
}