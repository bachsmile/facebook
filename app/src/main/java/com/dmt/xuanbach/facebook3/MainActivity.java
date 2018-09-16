package com.dmt.xuanbach.facebook3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private Button mBt;
    private EditText mEmail,mPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        mTv=(TextView) findViewById(R.id.btn_sign_up);
        mBt=(Button) findViewById(R.id.bt_login);
        mEmail=(EditText) findViewById(R.id.edt_email);
        mPassword=(EditText) findViewById(R.id.edt_pass);



        String Noidung= mTv.getText().toString();
        SpannableString spannableString= new SpannableString(Noidung);
        spannableString.setSpan(new UnderlineSpan(),0,Noidung.length(),0);
        mTv.setText(spannableString);




        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                String password =mPassword.getText().toString();
                if((email.length()==0)||(isPasswordValid(email)==false))
                {
                    Toast.makeText(MainActivity.this,"Xin bạn kiểm tra lại thông tin gmail đăng nhập!!",Toast.LENGTH_LONG).show();
                }
                if((password.length()==0)||(!isPasswordValid(password)))
                {
                        Toast.makeText(MainActivity.this,"Mật khẩu quá ngắn xin kiểm tra lại Password!!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Xin bạn chào!! "+email,Toast.LENGTH_LONG).show();
                }

            }
            private boolean isEmailValid(String email) {
                return email.contains("@");
            };

            private boolean isPasswordValid(String password) {
                return password.length() > 4;
            };
        });



    }
}
