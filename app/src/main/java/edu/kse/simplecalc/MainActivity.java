package edu.kse.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;

    boolean isDotAllowed = true;
    boolean isPlusAllowed = true;
    boolean isMinusAllowed = true;
    boolean isMulAllowed = true;
    boolean isDivAllowed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
    }

    public void onACBtnClicked(View view) {
        textView1.setText("");
        textView2.setText("0");
    }

    public void onPlusMinusBtnClicked(View view) {
//        textView2.append("");
    }

    public void onPerBtnClicked(View view) {
    }

    public void onDivBtnClicked(View view) {
        if(isDivAllowed)
            textView2.append("/");
        isPlusAllowed = false;
        isMulAllowed = false;
        isDivAllowed = false;
        isDotAllowed = true;
    }

    public void onMulBtnClicked(View view) {
        if(isMulAllowed)
            textView2.append("*");
        isPlusAllowed = false;
        isMulAllowed = false;
        isDivAllowed = false;
        isDotAllowed = true;
    }

    public void onPlusBtnClicked(View view) {
        if(isPlusAllowed)
            textView2.append("+");
        isPlusAllowed = false;
        isMulAllowed = false;
        isDivAllowed = false;
        isDotAllowed = true;
    }


    public void onMinusBtnClicked(View view) {
        if(isMinusAllowed)
            textView2.append("-");
        isMinusAllowed = false;
        isPlusAllowed = false;
        isMulAllowed = false;
        isDivAllowed = false;
        isDotAllowed = true;
    }

    public void onZeroBtnClicked(View view) {
        numberBtnClicked("0");
    }

    public void onOneBtnClicked(View view) {
        numberBtnClicked("1");
    }

    public void onTwoBtnClicked(View view) {
        numberBtnClicked("2");
    }

    public void onThreeBtnClicked(View view) {
        numberBtnClicked("3");
    }

    public void onFourBtnClicked(View view) {
        numberBtnClicked("4");
    }

    public void onFiveBtnClicked(View view) {
        numberBtnClicked("5");
    }

    public void onSixBtnClicked(View view) {
        numberBtnClicked("6");
    }

    public void onSevenBtnClicked(View view) {
        numberBtnClicked("7");
    }

    public void onEaghtBtnClicked(View view) {
        numberBtnClicked("8");
    }

    public void onNineBtnClicked(View view) {
        numberBtnClicked("9");
    }

    public void onDotBtnClicked(View view) {
        if(isDotAllowed) {
            CharSequence text = textView2.getText();
            switch (text.charAt(text.length() - 1)){
                case '+':
                case '-':
                case 'x':
                case '\\':
                    numberBtnClicked("0");
            }
            textView2.append(".");
        }
        isDotAllowed = false;
    }

    public void onEqualsBtnClicked(View view) {
        ExpressionBuilder builder = new ExpressionBuilder(textView2.getText().toString());
        Expression expression = builder.build();
        double result = expression.evaluate();
        textView1.setText(String.valueOf(result));
    }

    private void numberBtnClicked(CharSequence number){
        textView2.append(number);

        isPlusAllowed = true;
        isMinusAllowed = true;
        isMulAllowed = true;
        isDivAllowed = true;
    }
}
