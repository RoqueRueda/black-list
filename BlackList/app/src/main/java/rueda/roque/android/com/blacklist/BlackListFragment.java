package rueda.roque.android.com.blacklist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment that will be used to display the black list items to the user.
 *
 * @author Roque Rueda
 * @version 1.0
 * @since 2/17/16
 */
public class BlackListFragment extends Fragment {

    /**
     * Convenience method used to create instances of this fragment
     * and pass any arguments.
     * @return BlackListFragment instance with the default arguments.
     */
    public static BlackListFragment newInstance() {
        BlackListFragment fragment = new BlackListFragment();
        // Set any arguments?
        // fragment.setArguments();

        return fragment;
    }


    /**
     * Called by the activity when the fragment view needs to be created.
     * @param inflater Inflater object used to create the widgets.
     * @param container Container view of the widgets.
     * @param savedInstanceState Previous state of the fragment if any.
     * @return View that will be display to the user.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_black_list, container, false);
        return v;
    }
}
