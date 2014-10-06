package ru.ifmo.md.lesson4;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    public TextView ans;
    public EditText field;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ans = (TextView) findViewById(R.id.textView3);
        field = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void EditTextOnClick(View v) {
        field.setText("");
        field.setTextColor(0xFF000000);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(field, InputMethodManager.SHOW_IMPLICIT);
        field.requestFocus();
    }

    public void buttonOnClick(View v) {
        try {
            ans.setText(String.valueOf(CalculationEngineFactory.defaultEngine().calculate(field.getText().toString())));
        } catch (CalculationException e) {
            ans.setText(e.getMessage());
        }

    }
}
