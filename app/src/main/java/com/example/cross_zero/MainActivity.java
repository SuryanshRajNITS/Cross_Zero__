package com.example.cross_zero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int player=0,j;
    boolean active=true;
    boolean finish=false;
    int [] arr={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int [][] WinningPositions={{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    public void fun(View view){
        if(active){
        ImageView counter= (ImageView)view;
        int tag=Integer.parseInt(counter.getTag().toString());
        if(arr[tag]==-1){
        counter.setTranslationY(-1000f);
        if(player==0){
        counter.setImageResource(R.drawable.cir);
        counter.animate().translationYBy(1000f).rotation(3600f).setDuration(300);
        arr[tag]=player;
        player=1;}
        else {
            counter.setImageResource(R.drawable.mlti);
            counter.animate().translationYBy(1000f).rotation(3600f).setDuration(300);
            arr[tag]=player;
            player = 0;
        }
        }
        for( int [] winner : WinningPositions){
            if(arr[winner[0]]==arr[winner[1]] && arr[winner[1]]==arr[winner[2]] && arr[winner[0]]!=-1)
            {    active=false;
                 finish = true;
                TextView tt= (TextView)findViewById(R.id.winner);
                tt.setText("Player "+arr[winner[0]]+" has won !!!");
                LinearLayout gameover = (LinearLayout)findViewById(R.id.playAgainLayout);
                gameover.setVisibility(View.VISIBLE);
            }
        }
        for(j=0;j<9;j++){
            if(arr[j]>=0){continue;}
            else {break;}
        }
        if(j==8 && finish==false){
            TextView tt= (TextView)findViewById(R.id.winner);
            tt.setText("IT'S A DRAW !!");
            LinearLayout gameover = (LinearLayout)findViewById(R.id.playAgainLayout);
            gameover.setVisibility(View.VISIBLE);
        }


        }
    }
    public void againPlay (View view){
        active=true;
        LinearLayout gameover = (LinearLayout)findViewById(R.id.playAgainLayout);
        gameover.setVisibility(View.INVISIBLE);//VISIBLE);
        player=0;
        for(int i=0;i<9;i++)
            arr[i]=-1;
        GridLayout gg = (GridLayout)findViewById(R.id.gridLayout);
        for(int i=0;i<gg.getChildCount();i++){
            ((ImageView)gg.getChildAt(i)).setImageResource(0);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
