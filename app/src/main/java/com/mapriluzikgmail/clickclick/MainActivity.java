package com.mapriluzikgmail.clickclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int num[]=new int[12];
    int alpa[]=new int[12];
    int cha[]=new int [12];
    int rndom[]=new int[36];
    LinearLayout main;
    Button btn[]=new Button[12];
    Button start;
    TextView text1;
    TextView text2;
    int countfinal=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<12;i++){
            btn[i]=(Button)findViewById(R.id.button01+i);
            num[i]=0;
            alpa[i]=0;
            cha[i]=0;
        }
        for(int i=0; i<36; i++){
            rndom[i]=0;
        }

        for(int i=0;i<12;i++){
            btn[i].setAlpha((float) 0);
        }
        main=(LinearLayout)findViewById(R.id.layout_main);

        main.setBackgroundResource(R.drawable.bg1);

        text1=(TextView)findViewById(R.id.textView1);
        text2=(TextView)findViewById(R.id.textView2);
        start=(Button)findViewById(R.id.start);
        start.setBackgroundResource(R.drawable.start);

        start.setOnClickListener(listen);
    }

    View.OnClickListener listen1=new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            int check=Integer.parseInt(v.getTag().toString());

            if(check==countfinal){
                ((Button)v).setText("");
                ((Button)v).setBackgroundResource(0);
                if(countfinal==12){
                    setalpa();
                    main.setBackgroundResource(R.drawable.bg2);
                }else if(countfinal==24){
                    setcha();
                    main.setBackgroundResource(R.drawable.bg3);
                }
                countfinal++;
            }
            if(countfinal==37){
                main.setBackgroundResource(R.drawable.bg4);
                text1.setText("Congratulation!!");
                text2.setText("GameClear!!");
                start.setAlpha(0);
            }
        }
    };

    View.OnClickListener listen=new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            start.setClickable(false);
            start.setBackgroundResource(R.drawable.ing);
            // TODO Auto-generated method stub
            for(int i=0;i<12;i++){
                btn[i].setAlpha((float) 1);
            }
            for(int i=0;i<12;i++){
                btn[i].setOnClickListener(listen1);
            }
            Random rnd=new Random();
            int count=0;
            int r;
            text2.setText("숫자를 순서대로 누르세요!!");
            do{
                r=rnd.nextInt(12)+1;
                if(rndom[r-1]==0){
                    num[r-1]=r;
                    rndom[r-1]=r;
                    btn[count].setBackgroundResource(R.drawable.num01+(r-1));
                    btn[count].setTag(r);
                    count++;
                }
            }while(count<12);

        }
    };

    public void setalpa(){
        Random rnd=new Random();
        int count=0;
        int r;
        text2.setText("알파벳 순서대로 누르세요!!");

        do{
            r=rnd.nextInt(12)+13;
            if(rndom[r-1]==0){
                alpa[r-13]=r;
                rndom[r-1]=r;
                btn[count].setBackgroundResource(R.drawable.alpa01+(r-13));
                btn[count].setTag(r);
                count++;
            }
        }while(count<12);
    }

    public void setcha(){
        Log.d("셋차","셋차");
        Random rnd=new Random();
        int count=0;
        int r;
        text2.setText("십이지신 순서대로 누르세요!!");

        do{
            r=rnd.nextInt(12)+25;
            if(rndom[r-1]==0){
                cha[r-25]=r;
                rndom[r-1]=r;
                btn[count].setBackgroundResource(R.drawable.cha01+(r-25));
                btn[count].setTag(r);
                count++;
            }
        }while(count<12);
    }
}
