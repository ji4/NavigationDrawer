package yzu.money.navigationdrawerpractice;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout layDrawer;
    private ListView lstDrawer;

    private ActionBarDrawerToggle drawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActionBar();
        initDrawer();
        initDrawerList();
    }

    private void initActionBar()
    {
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    private void initDrawer(){
        setContentView(R.layout.drawer);

        layDrawer=findViewById(R.id.drawer);
        lstDrawer=findViewById(R.id.left_drawer);

        layDrawer.setDrawerShadow(R.drawable_shadow, GravityCompat.START);

        mTitle=mDrawerTitle=getTitle();
        drawerToggle = new ActionBarDrawerToggle(
                this,
                layDrawer,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
            }
        };
        drawerToggle.syncState();
        layDrawer.setDrawerListener(drawerToggle);
    }
    private void initDrawerList(){
        String[] drawer_menu = this.getResources().getStringArray(R.array.drawer_menu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.drawer_list_item, drawer_menu);
        lstDrawer.setAdapter(adapter);
    }
}
