package com.elenoon.davatname;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class AppAnimation {

	Context mContext;
	Activity mActivity;
	private static LayoutAnimationController lac;
	private static Animation[] animations = new Animation[22];
	private static int defaultAnimation = 14;

	public AppAnimation(Context context) {
		mContext = context;
		mActivity = (Activity) context;

		setAnimationsArray();

		lac =  AnimationUtils.loadLayoutAnimation(mContext, R.anim.layout_random_fade);
		lac.setAnimation(animations[defaultAnimation]);
	}

	private void setAnimationsArray(){					
		animations[0] = AnimationUtils.loadAnimation(mContext, R.anim.a00_anim_alpha_);
		animations[1] = AnimationUtils.loadAnimation(mContext, R.anim.a01_anim_alpha_rotate_);
		animations[2] = AnimationUtils.loadAnimation(mContext, R.anim.a02_anim_alpha_rotate_scale_);
		animations[3] = AnimationUtils.loadAnimation(mContext, R.anim.a03_anim_alpha_rotate_scale_translate_);
		animations[4] = AnimationUtils.loadAnimation(mContext, R.anim.a04_anim_alpha_rotate_translate_);
		animations[5] = AnimationUtils.loadAnimation(mContext, R.anim.a05_anim_alpha_scale_);
		animations[6] = AnimationUtils.loadAnimation(mContext, R.anim.a06_anim_alpha_scale_translate_);
		animations[7] = AnimationUtils.loadAnimation(mContext, R.anim.a07_anim_alpha_translate_);
		animations[8] = AnimationUtils.loadAnimation(mContext, R.anim.a08_anim_rotate_);
		animations[9] = AnimationUtils.loadAnimation(mContext, R.anim.a09_anim_rotate_scale_);
		animations[10] = AnimationUtils.loadAnimation(mContext, R.anim.a10_anim_rotate_scale_translate_);
		animations[11] = AnimationUtils.loadAnimation(mContext, R.anim.a11_anim_rotate_translate_);
		animations[12] = AnimationUtils.loadAnimation(mContext, R.anim.a12_anim_scale_);
		animations[13] = AnimationUtils.loadAnimation(mContext, R.anim.a13_anim_scale_translate_);
		animations[14] = AnimationUtils.loadAnimation(mContext, R.anim.a14_anim_translate_);
		animations[15] = AnimationUtils.loadAnimation(mContext, R.anim.a15_anim_translate_x_);
		animations[16] = AnimationUtils.loadAnimation(mContext, R.anim.a16_anim_translate_x_2);
		animations[17] = AnimationUtils.loadAnimation(mContext, R.anim.a17_anim_translate_y);
		animations[18] = AnimationUtils.loadAnimation(mContext, R.anim.a18_anim_translate_x_2_r);
		animations[19] = AnimationUtils.loadAnimation(mContext, R.anim.a19_anim_translate_x_3);
		animations[20] = AnimationUtils.loadAnimation(mContext, R.anim.a20_anim_translate_x_3_r);
		animations[21] = AnimationUtils.loadAnimation(mContext, R.anim.a21_anim_translate_y);
	}

	public void setAnimation(LinearLayout v){
		if (v==null) return;
		v.setLayoutAnimation(lac);
	}

	public void setAnimation(RelativeLayout v) {
		if (v==null) return;
		v.setLayoutAnimation(lac);
	}

	public void setAnimation(TextView v) {
		if (v==null) return;
		v.setAnimation(animations[defaultAnimation]);		
	}

	public void setAnimation(ImageView v) {
		if (v==null) return;
		v.setAnimation(animations[defaultAnimation]);				
	}

	public void setAnimation(CheckBox v) {
		if (v==null) return;
		v.setAnimation(animations[defaultAnimation]);				
	}

	public void setAnimation(View v) {
		if (v==null) return;
		v.setAnimation(animations[defaultAnimation]);				
	}

	public void startAnimation(View v) {
		if (v==null) return;
		v.setAnimation(animations[defaultAnimation]);	
		v.startAnimation(animations[defaultAnimation]);
	}

	public void startAnimation(View v, int animation) {
		if (v==null) return;
		v.setAnimation(animations[animation]);	
		v.startAnimation(animations[animation]);
	}	
}
