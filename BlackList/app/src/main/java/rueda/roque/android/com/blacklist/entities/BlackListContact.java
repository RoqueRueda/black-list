package rueda.roque.android.com.blacklist.entities;

import java.util.Date;
import java.util.UUID;

/**
 * Represents an item of the black list.
 *
 * @author Roque Rueda
 * @version 1.0
 * @since 2/17/16
 */
public class BlackListContact {

    private UUID mId;
    private String mName;
    private Date mCreationDate;

    /**
     * Creates an instance with the default values.
     */
    public BlackListContact() {
        mId = UUID.randomUUID();
        mCreationDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    public void setCreationDate(Date creationDate) {
        mCreationDate = creationDate;
    }
}
