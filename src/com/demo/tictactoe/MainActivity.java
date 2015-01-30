package com.demo.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends Activity {

// test
	static int CELL_USED = 100;
	static int FREE = 0;
	static int TICK = 1;
	static int TOCK = 2;

	int moveCount = 0;
	int[] mGameMatrix = new int[9];
	private TableLayout mTl = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTl = (TableLayout) findViewById(R.id.TL);
    }

	public void onMove(View v) {
		ImageView imgv = (ImageView) v;
		int idx = Integer.parseInt((String) v.getTag());
		if (idx != CELL_USED) {
			mGameMatrix[idx] = 0 == moveCount % 2 ? TICK : TOCK;
			imgv.setImageResource(0 == moveCount % 2 ? R.drawable.tick
					: R.drawable.cross);
			imgv.setTag(CELL_USED + "");
			moveCount++;

		}
	}

	public void onReset(View v) {
		TableRow tr = null;
		ImageView imgV = null;
		for (int i = 0; i < 3; i++) {
			tr = (TableRow) mTl.getChildAt(i);
			for (int j = 0; j < 3; j++) {
				imgV = (ImageView) tr.getChildAt(j);
				imgV.setImageResource(R.drawable.free);
				imgV.setTag((i * 3 + j) + "");
				// System.out.println((i * 3 + j));
				mGameMatrix[i * 3 + j] = FREE;
			}
		}
		moveCount = 0;
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
