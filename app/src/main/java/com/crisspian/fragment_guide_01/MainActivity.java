package com.crisspian.fragment_guide_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.crisspian.fragment_guide_01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean isFragmentDisplayed =false;
    private BlankFragment blankFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        setContentView(binding.getRoot());
        setupClicklistener();
    }

    private void setupClicklistener() {
        binding.btnMain.setOnClickListener(v ->{
            if(isFragmentDisplayed){
                closeFragment();
            }else{
                showFragment();

            }
        });
    }

    private void closeFragment() {
        FragmentManager fragmentManager=getSupportFragmentManager();
        BlankFragment blankFragment=(BlankFragment)fragmentManager.findFragmentById(R.id.content);
        if(blankFragment !=null){
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.remove(blankFragment).commit();
            binding.btnMain.setText(R.string.open);
            isFragmentDisplayed = false;
        }
    }

    private void showFragment() {
        BlankFragment blankFragment =BlankFragment.newInstance();
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content,blankFragment).addToBackStack(null).commit();
        binding.btnMain.setText(R.string.close);
        isFragmentDisplayed= true;
    }

    private void initBinding() {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
    }

}