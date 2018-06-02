package comers_0890.httpsvk.simplechat;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.graphics.Color.parseColor;

public class MainActivity extends AppCompatActivity {
    boolean NickUsed=false;
    EditText nick;
    TextView welcomeText, nameText;
    RelativeLayout myLayout;

    void FirstPage(String name){
        ObjectAnimator obj = ObjectAnimator.ofInt(getWindow().getDecorView(), "backgroundColor", Color.WHITE, R.color.Pinky).setDuration(1000);
        obj.setEvaluator(new ArgbEvaluator());
        obj.start();
        nick.animate()
                .setDuration(500)
                .alpha(0)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                        nick.setVisibility(View.GONE);

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        myLayout.addView(welcomeText);
                        myLayout.addView(nameText);
                        ViewCompat.animate(nameText).withStartAction(new Runnable(){
                            @Override
                            public void run()
                            {
                                nameText.setVisibility(View.VISIBLE);
                            }
                        })
                                .alpha(1f)
                                .setInterpolator(new AccelerateDecelerateInterpolator())
                                .setDuration(3000)
                                .start();
                        ViewCompat.animate(welcomeText).withStartAction(new Runnable(){
                            @Override
                            public void run()
                            {
                                welcomeText.setVisibility(View.VISIBLE);
                            }
                        })
                                .alpha(1f)
                                .setInterpolator(new AccelerateDecelerateInterpolator())
                                .setDuration(3000)
                                .start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });


        ///// TODO: 15.10.2017
        //// need DELAY


    }
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (RelativeLayout) findViewById(R.id.layoutid1);
        welcomeText = new TextView(this);
        welcomeText.setText("WELCOME");
        welcomeText.setTextSize(72);
        welcomeText.setGravity(Gravity.LEFT);
        welcomeText.setTextColor(Color.parseColor("#ba0442"));
        welcomeText.setTypeface(Typeface.create("helvetica", Typeface.BOLD));
        welcomeText.setVisibility(View.INVISIBLE);
        welcomeText.setId(R.id.welcome);
        RelativeLayout.LayoutParams welcomeTextParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        welcomeTextParam.setMargins(20, 6, 0, 0);

        nameText = new TextView(this);
        nameText.setTextSize(72);
        nameText.setGravity(Gravity.CENTER);
        nameText.setTextColor(Color.parseColor("#ba0442"));
        nameText.setTypeface(Typeface.create("helvetica", Typeface.BOLD));
        nameText.setVisibility(View.INVISIBLE);

        RelativeLayout.LayoutParams nameTextParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        nameTextParam.addRule(RelativeLayout.BELOW,welcomeText.getId());
        nameTextParam.setMargins(20, 6, 0, 0);

        nameText.setLayoutParams(nameTextParam);

        nick = (EditText) findViewById(R.id.editText);

        nick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NickUsed==false) {
                    nick.setText("");
                    NickUsed=!NickUsed;
                }
            }
        });

        nick.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode==KeyEvent.KEYCODE_ENTER){
                    username = nick.getText().toString();
                    nameText.setText(username);
                    FirstPage(username);
                    enterClient();
                }
                return false;
            }
        });

    }
    //// TODO: 15.10.2017 client-server:socket
    void enterClient(){}
    
}
