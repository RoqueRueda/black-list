package rueda.roque.android.com.blacklist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import rueda.roque.android.com.blacklist.data.BlackListRepo;
import rueda.roque.android.com.blacklist.entities.BlackListContact;

/**
 * Fragment that will be used to display the black list items to the user.
 *
 * @author Roque Rueda
 * @version 1.0
 * @since 2/17/16
 */
public class BlackListFragment extends Fragment {

    private RecyclerView mBlackListRecyclerView;
    private BlackListAdapter mAdapter;

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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_black_list, container, false);

        mBlackListRecyclerView = (RecyclerView) v
                .findViewById(R.id.black_list_recycler_view);
        mBlackListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateRecyclerView();

        return v;
    }

    /**
     * Called when the activity is being resumed and the fragment needs also
     * to be resume.
     */
    @Override
    public void onResume() {
        super.onResume();
        updateRecyclerView();
    }

    /**
     * Updates the recycler view with the information of the repository of items.
     */
    private void updateRecyclerView() {
        BlackListRepo repo = BlackListRepo.get(getActivity());
        List<BlackListContact> items = repo.getBlackListContacts();

        if (mAdapter == null) {
            mAdapter = new BlackListAdapter(items);
            mBlackListRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    ////////////////////////////////////////////////////////////
    // Recycler view elements.
    // The following classes are used to display the elements
    // on the recycler view.
    ////////////////////////////////////////////////////////////

    /**
     *
     */
    private class BlackListHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {

        private BlackListContact mCurrentItem;

        /**
         * Reference to the widget that will display the name.
         */
        private TextView mName;

        /**
         * Reference to the widget that will display the date.
         */
        private TextView mDate;

        /**
         * Constructor that receives the view of the current item.
         * @param itemView View for the current item.
         */
        public BlackListHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mName = (TextView) itemView
                    .findViewById(R.id.list_item_black_list_name);
            mDate = (TextView) itemView
                    .findViewById(R.id.list_item_black_list_date);
        }

        /**
         * Set the values of the widgets based on the given item.
         * @param item Item that contains the data to be display to the user.
         */
        public void bindItem(BlackListContact item) {
            mCurrentItem = item;
            mName.setText(mCurrentItem.getName());
            mDate.setText(DateUtils.getRelativeTimeSpanString(item.getCreationDate().getTime(),
                new Date().getTime(), DateUtils.MINUTE_IN_MILLIS));
        }


        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),
                    "Item selected: " + mCurrentItem.getId().toString(), Toast.LENGTH_SHORT)
                    .show();
        }
    }

    /**
     * Adapter used to display the objects in a fashionable way on the recycler view.
     */
    private class BlackListAdapter extends RecyclerView.Adapter<BlackListHolder> {

        /**
         * List of items.
         */
        private List<BlackListContact> mItems;

        /**
         * Creates an instance of this adapter using the given list as parameter.
         * @param items
         */
        public BlackListAdapter(List<BlackListContact> items) {
            mItems = items;
        }

        /**
         * Called when the recycler view needs to create a view holder.
         * @param parent Parent view.
         * @param viewType Type of the view.
         * @return Holder instance.
         */
        @Override
        public BlackListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_black_list, parent, false);
            return new BlackListHolder(view);
        }

        /**
         * Binds the view holder with the current data at the specified position.
         * @param holder Holder that will be used to bind the view with the data.
         * @param position Position of the recycler view.
         */
        @Override
        public void onBindViewHolder(BlackListHolder holder, int position) {
            BlackListContact item = mItems.get(position);
            holder.bindItem(item);
        }

        /**
         * Returns the total number of items in the data set hold by the adapter.
         *
         * @return The total number of items in this adapter.
         */
        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }


}
