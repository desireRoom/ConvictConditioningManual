
package com.desire.ConvictConditioningManual;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.slidingmenu.lib.SlidingMenu;

public class MainActivity extends Activity {

    private SlidingMenu mSlidingMenu;

    private ExpandableListView mLeftList;

    private String[] mSixTechStrs;

    private String[][] mChildStrs = new String[6][];

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initDate();
        initSlidingMenu();
    }

    private void initDate() {
        Resources res = getResources();
        mSixTechStrs = res.getStringArray(R.array.ccm_six_tech_strs);
        mChildStrs[0] = res.getStringArray(R.array.ccm_push_up_strs);
        mChildStrs[1] = res.getStringArray(R.array.ccm_leg_raise_strs);
        mChildStrs[2] = res.getStringArray(R.array.ccm_pull_up_strs);
        mChildStrs[3] = res.getStringArray(R.array.ccm_deep_aquat_strs);
        mChildStrs[4] = res.getStringArray(R.array.ccm_on_hold_strs);
        mChildStrs[5] = res.getStringArray(R.array.ccm_bridge_strs);
    }

    private void initSlidingMenu() {
        mSlidingMenu = new SlidingMenu(this);
        mSlidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        mLeftList = (ExpandableListView) LayoutInflater.from(this).inflate(R.layout.main_left_menu_list, null);
        mSlidingMenu.setMenu(mLeftList);

        TextView tv2 = new TextView(this);
        tv2.setBackgroundColor(Color.GRAY);
        tv2.setText("1234 \n 5678");
        mSlidingMenu.setSecondaryMenu(tv2);

        mSlidingMenu.setBehindOffset(400);
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
    }

    private static class SixTechAdapter extends BaseExpandableListAdapter {
        private String[] sGroupStrs;

        private String[][] sChildStrs;

        public SixTechAdapter(String[] groupStrs, String[][] childStrs) {
            sGroupStrs = groupStrs;
            sChildStrs = childStrs;
        }

        @Override
        public int getGroupCount() {
            return sGroupStrs.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return sChildStrs[groupPosition].length;
        }

        @Override
        public String getGroup(int groupPosition) {
            if (groupPosition < 0 || groupPosition >= getGroupCount()) {
                return null;
            }
            return sGroupStrs[groupPosition];
        }

        @Override
        public String getChild(int groupPosition, int childPosition) {
            if (groupPosition < 0 || childPosition < 0 || groupPosition >= getGroupCount()
                    || childPosition >= getChildrenCount(groupPosition)) {
                return null;
            }
            return sChildStrs[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            // TODO Auto-generated method stub
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return groupPosition * 100 + childPosition;
        }

        @Override
        public boolean hasStableIds() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
                ViewGroup parent) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return false;
        }

    }
}
