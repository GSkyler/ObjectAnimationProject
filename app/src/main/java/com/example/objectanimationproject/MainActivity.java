package com.example.objectanimationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private float numYval;
    private float blockPlaceX = 0;
    private ObjectAnimator blockAnimX;
    private ObjectAnimator blockAnimY;
    private ObjectAnimator blockAnimRotate;
    private AnimatorSet blockAnimSet;
    private int numsUsed = 0;
    private int opsUsed = 0;
    private float[] numXVals = new float[4];
    private float[] opXVals = new float[3];
//    private ArrayList<TextView> entries = new ArrayList<TextView>();
    private ArrayList<String> entries = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numXVals[0] = 49f;
        numXVals[1] = 364f;
        numXVals[2] = 684f;
        numXVals[3] = 1010f;
        opXVals[0] = 207f;
        opXVals[1] = 524f;
        opXVals[2] = 847f;
    }

    public void selectNum(View view){
        numYval = view.getY()-30;
        blockPlaceX = numXVals[numsUsed] - view.getX();
        TextView tv = (TextView)view;

//        entries.set((int)(numsUsed*2), (TextView)view);
        entries.add(String.valueOf(tv.getText()));

        blockAnimX = ObjectAnimator.ofFloat(view, "TranslationX", 0, blockPlaceX);
        blockAnimY = ObjectAnimator.ofFloat(view, "TranslationY", 0, -view.getY());
        blockAnimRotate = ObjectAnimator.ofFloat(view, "Rotation", 0, 360);
        blockAnimSet = new AnimatorSet();
        blockAnimSet.playTogether(blockAnimX, blockAnimY, blockAnimRotate);
        blockAnimSet.start();

        numsUsed++;
    }

    public void selectOp(View view){
        if(opsUsed < 3) {
            numYval = view.getY() - 30;
            blockPlaceX = opXVals[opsUsed] - view.getX();
            TextView tv = (TextView)view;

//            entries.set((int)(numsUsed*2+1), (TextView)view);
            entries.add(String.valueOf(tv.getText()));

            blockAnimX = ObjectAnimator.ofFloat(view, "TranslationX", 0, blockPlaceX);
            blockAnimY = ObjectAnimator.ofFloat(view, "TranslationY", 0, -view.getY());
            blockAnimRotate = ObjectAnimator.ofFloat(view, "Rotation", 0, 360);
            blockAnimSet = new AnimatorSet();
            blockAnimSet.playTogether(blockAnimX, blockAnimY, blockAnimRotate);
            blockAnimSet.start();

            opsUsed++;
        }
    }

    public void checkAns(View view){
        TextView tv = findViewById(R.id.textView);
        for(int i = 0; i < 3; i++) {
            if (entries.get(1).equals("*")) {
                float product = Float.parseFloat(entries.get(1 - 1)) * Float.parseFloat(entries.get(1 + 1));
                entries.add(1 + 2, String.valueOf(product));
                entries.remove(1);
                entries.remove(1);
                entries.remove(1 - 1);
            } else if (entries.get(1).equals("/")) {
                float quotient = Float.parseFloat(entries.get(1 - 1)) / Float.parseFloat(entries.get(1 + 1));
                entries.add(1 + 2, String.valueOf(quotient));
                entries.remove(1);
                entries.remove(1);
                entries.remove(1 - 1);
            } else if (entries.get(1).equals("+")) {
                float product = Float.parseFloat(entries.get(1 - 1)) + Float.parseFloat(entries.get(1 + 1));
                entries.add(1 + 2, String.valueOf(product));
                entries.remove(1);
                entries.remove(1);
                entries.remove(1 - 1);
            } else if (entries.get(1).equals("_")) {
                float quotient = Float.parseFloat(entries.get(1 - 1)) - Float.parseFloat(entries.get(1 + 1));
                entries.add(1 + 2, String.valueOf(quotient));
                entries.remove(1);
                entries.remove(1);
                entries.remove(1 - 1);
            }
        }

/*        if(entries.get(1).equals("*")){
            float product = Float.parseFloat(entries.get(1-1)) * Float.parseFloat(entries.get(1+1));
            entries.add(1+2, String.valueOf(product));
            entries.remove(1);
            entries.remove(1);
            entries.remove(1-1);
        }
        else if(entries.get(1).equals("/")){
            float quotient = Float.parseFloat(entries.get(1-1)) / Float.parseFloat(entries.get(1+1));
            entries.add(1+2, String.valueOf(quotient));
            entries.remove(1);
            entries.remove(1);
            entries.remove(1-1);
        }
        else if(entries.get(1).equals("+")){
            float product = Float.parseFloat(entries.get(1-1)) + Float.parseFloat(entries.get(1+1));
            entries.add(1+2, String.valueOf(product));
            entries.remove(1);
            entries.remove(1);
            entries.remove(1-1);
        }
        else if(entries.get(1).equals("_")){
            float quotient = Float.parseFloat(entries.get(1-1)) - Float.parseFloat(entries.get(1+1));
            entries.add(1+2, String.valueOf(quotient));
            entries.remove(1);
            entries.remove(1);
            entries.remove(1-1);
        }*/


        tv.setText(entries.get(0));
//        displayEntries();

/*        displayEntries();

        int i = 1;
        while(i < 6){
            if(entries.get(i).equals("*")){
                float product = Float.parseFloat(entries.get(i-1)) * Float.parseFloat(entries.get(i+1));
                entries.add(i+2, String.valueOf(product));
                entries.remove(i);
                entries.remove(i);
                entries.remove(i-1);
                displayEntries();
            }
            else if(entries.get(i).equals("/")){
                float quotient = Float.parseFloat(entries.get(i-1)) / Float.parseFloat(entries.get(i+1));
                entries.add(i+2, String.valueOf(quotient));
                entries.remove(i);
                entries.remove(i);
                entries.remove(i-1);
                displayEntries();
            }
            else{
                i += 2;
            }
        }

        i = 1;
        while(i < 6){
            if(entries.get(i).equals("+")){
                float product = Float.parseFloat(entries.get(i-1)) + Float.parseFloat(entries.get(i+1));
                entries.add(i+2, String.valueOf(product));
                entries.remove(i);
                entries.remove(i);
                entries.remove(i-1);
                displayEntries();
            }
            else if(entries.get(i).equals("_")){
                float quotient = Float.parseFloat(entries.get(i-1)) - Float.parseFloat(entries.get(i+1));
                entries.add(i+2, String.valueOf(quotient));
                entries.remove(i);
                entries.remove(i);
                entries.remove(i-1);
                displayEntries();
            }
            else{
                i += 2;
            }
        }

        tv.setText(entries.get(0));*/
    }

    public void displayEntries(){
        TextView tv = findViewById(R.id.textView);

        String entriesCont = "";
        for (int x = 0; x < 7; x++){
            entriesCont += entries.get(x);
        }

        tv.setText(entriesCont);
        entriesCont = "";
    }

}
