package rueda.roque.android.com.blacklist;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BlackListActivity extends SingleFragmentActivity {


    /**
     * Generates the fragment that will be used as the content of this
     * activity.
     *
     * @return Fragment instance to used as content of this activity.
     */
    @Override
    protected Fragment createFragment() {
        return BlackListFragment.newInstance();
    }
}
