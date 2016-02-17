package rueda.roque.android.com.blacklist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Base class for an Activity hosting a single fragment
 * as its content. It follows the template method pattern.
 *
 * @author Roque Rueda
 * @version 1.0
 * @since 2/17/16
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    /**
     * Generates the fragment that will be used as the content of this
     * activity.
     * @return Fragment instance to used as content of this activity.
     */
    protected abstract Fragment createFragment();

    /**
     * Handle the creation of the activity.
     * @param savedInstanceState Saved state of the previous activity.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single_fragment);
        FragmentManager fm = getSupportFragmentManager();

        // Check if the fragment exist or not.
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = createFragment();

            // Add the fragment because it doesn't exist.
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
