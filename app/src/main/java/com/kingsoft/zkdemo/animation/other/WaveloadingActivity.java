package com.kingsoft.zkdemo.animation.other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.kingsoft.zkdemo.R;
import com.race604.drawable.wave.WaveDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WaveloadingActivity extends AppCompatActivity {

    @BindView(R.id.iv_wavaloading)
    ImageView ivWavaloading;
    @BindView(R.id.seekBar)
    SeekBar seekBar;

    private WaveDrawable mWaveDrawable;

    //https://github.com/race604/WaveLoading
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waveloading);
        ButterKnife.bind(this);
//        mWaveDrawable = new WaveDrawable(this,ContextCompat.getDrawable(this, R.drawable.avatardefault));
        mWaveDrawable = new WaveDrawable(this, R.mipmap.ic_launcher);
//        mWaveDrawable.setIndeterminate(true);
//        mWaveDrawable.setLevel(40);

        ivWavaloading.setImageDrawable(mWaveDrawable);
        mWaveDrawable.setWaveAmplitude(32);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mWaveDrawable.setLevel(progress);
                Log.d("zk",""+progress);
//                mWaveDrawable.setLevel()
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
