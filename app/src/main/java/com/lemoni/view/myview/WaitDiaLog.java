package com.lemoni.view.myview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dellit.lemonlivei.R;

/**
 * Created by dellit on 2017/2/20.
 */

public class WaitDiaLog {

    private static WaitDiaLog mWaitDiaLog;
    private Context mContext;
    private Dialog mDialog;
    private DialogListener onCanListener;

    private WaitDiaLog(Context context,DialogListener onCanListener){
        this.mContext = context;
        this.onCanListener = onCanListener;
        initDialog();
    }

    private void initDialog() {
        mDialog = new Dialog(mContext,R.style.loadstyle);
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_dialog,null);
//        ImageView image = (ImageView) view.findViewById(R.id.loadimageView);
//        Glide.with(mContext).load(R.drawable.pic).asGif().into(image);
        mDialog.setCancelable(true);//返回按键Dialog消失
        mDialog.setCanceledOnTouchOutside(false); //点击外部不会消失Dialog
        mDialog.setContentView(view);
        mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                //回调Dialog消失的方法
                onCanListener.dialogListener();
            }
        });
    }

    public static WaitDiaLog getInstance(Context context,DialogListener onCanceListener){
        if(mWaitDiaLog == null){
            synchronized (WaitDiaLog.class){
                if(mWaitDiaLog == null){
                    mWaitDiaLog = new WaitDiaLog(context,onCanceListener);
                }
            }
        }
        return mWaitDiaLog;
    }

    public interface DialogListener{
        void dialogListener();
    }

    public void DialogShow(){
        if(mDialog!=null&&!mDialog.isShowing()){
            mDialog.show();
        }
    }
    public void DialogDissmiss(){
        if(mDialog !=null &&mDialog.isShowing()){
            mDialog.dismiss();
        }

    }


}
