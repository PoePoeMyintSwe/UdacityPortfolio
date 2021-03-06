package com.poepoemyintswe.myappportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private Button[] mButtons;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mButtons = new Button[6];
    for (int i = 0; i < mButtons.length; i++) {
      String b = "button" + (i + 1);
      mButtons[i] = (Button) findViewById(getResources().getIdentifier(b, "id", getPackageName()));
      mButtons[i].setOnClickListener(this);
    }
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  /**
   * Called when a view has been clicked.
   *
   * @param v The view that was clicked.
   */
  @Override public void onClick(View v) {
    for (int i = 0; i < mButtons.length; i++) {
      if (v.getId() == mButtons[i].getId()) {
        Toast.makeText(MainActivity.this,
            getResources().getString(R.string.toast_message) + " " + mButtons[i].getText()
                .toString()
                .toLowerCase(), Toast.LENGTH_SHORT).show();
      }
    }
  }
}
