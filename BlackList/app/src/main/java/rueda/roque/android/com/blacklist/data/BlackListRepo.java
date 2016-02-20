package rueda.roque.android.com.blacklist.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import rueda.roque.android.com.blacklist.entities.BlackListContact;

/**
 * Class used to get the items of the black list, is in charge of the operations
 * that manipulates the set of BlackList items.
 *
 * @author Roque Rueda
 * @version 1.0
 * @since 2/17/16
 */
public class BlackListRepo {

    /**
     * Reference to the instance of this class.
     */
    private static BlackListRepo sBlackListRepo;

    /**
     * List that contains the black list items.
     */
    private List<BlackListContact> mBlackListContacts;

    /**
     * Method used to get access to the instance of this class.
     * @param context Context of the application.
     * @return Instance of this class.
     */
    public static BlackListRepo get(Context context) {

        // Lazy load.
        if (sBlackListRepo == null) {
            return sBlackListRepo = new BlackListRepo(context);
        }

        return sBlackListRepo;
    }

    /**
     * Private constructor, the constructor is private to restrict
     * the access to the instance of this class only by the get
     * method above.
     * @param context Context of the application.
     */
    private BlackListRepo(Context context) {

        // Create the list.
        mBlackListContacts = new ArrayList<>(20);

        // Fill the list with some static information.
        for (int i=0; i<20; i++) {
            BlackListContact item = new BlackListContact();
            item.setName("Black list item #" + i);

            mBlackListContacts.add(item);
        }
    }

    /**
     * Gets the list of items that exist on the current repository.
     */
    public List<BlackListContact> getBlackListContacts() { return mBlackListContacts; }

}
