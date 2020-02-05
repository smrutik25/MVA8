package com.example.mva8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageAdapter extends PagerAdapter {

    private Context mcontext;
    private int[] e = new int[]{R.drawable.a,R.drawable.resetb,R.drawable.b,R.drawable.c,R.drawable.resetb,R.drawable.d,
    R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.resetb,R.drawable.h,R.drawable.i,R.drawable.j,
    R.drawable.k,R.drawable.resetb,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p,R.drawable.resetb,
    R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.resetb,R.drawable.v,
    R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z,R.drawable.z1,R.drawable.z2,R.drawable.resetb,
    R.drawable.z3,R.drawable.z4,R.drawable.z5,R.drawable.z6,R.drawable.z7,R.drawable.z8,
    R.drawable.z9,R.drawable.z10,R.drawable.resetb,R.drawable.z11,R.drawable.z12,R.drawable.z13,
    R.drawable.z14,R.drawable.z15,R.drawable.z16,R.drawable.z17,R.drawable.z18};

    ImageAdapter(Context context){
        mcontext = context;
    }
    @Override
    public int getCount() {
        return e.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mcontext);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(e[position]);
        container.addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
