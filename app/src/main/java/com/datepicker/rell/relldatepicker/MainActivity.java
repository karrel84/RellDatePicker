package com.datepicker.rell.relldatepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.datepicker.rell.datapickerlib.RellDatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView mMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMemo = (TextView) findViewById(R.id.memo);
        findViewById(R.id.selectDate).setOnClickListener(onSelectDateListener);
    }

    private View.OnClickListener onSelectDateListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            RellDatePicker picker = createDatePicker();
            picker.show(getSupportFragmentManager(), onDatePickeListener);
        }

        public RellDatePicker.OnDatePickListener onDatePickeListener = new RellDatePicker.OnDatePickListener() {
            @Override
            public void onDatePick(Calendar calendar) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                mMemo.setText(format.format(calendar.getTime()));
            }
        };
    };

    private RellDatePicker createDatePicker() {
        RellDatePicker picker = new RellDatePicker.Builder(MainActivity.this)
                .setDate(Calendar.getInstance())
                .setMinDate(Calendar.getInstance().getTimeInMillis())
                .create();
        return picker;
    }
}
