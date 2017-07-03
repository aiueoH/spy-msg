package studio.dowob.spymsg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button) findViewById(R.id.btn_mainActivity_send);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSendBtn();
            }
        });
    }

    private void onClickSendBtn() {
        NotificationHelper.send(this, "訊息:", "有內鬼終止交易");
        sendBtn.setText("QQ");
    }
}
