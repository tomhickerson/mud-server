package mud.utils.services;

import mud.Constants;
import mud.ObjectDB;
import mud.ObjectFlag;
import mud.objects.Creature;
import mud.objects.Item;
import mud.objects.items.Armor;
import mud.objects.items.Book;
import mud.objects.items.Weapon;

import java.util.*;

public class CreationService {
    private ObjectDB objectDB = null;
    private Map<String, Item> prototypes = null;

    public CreationService(ObjectDB objectDB) {
        this.objectDB = objectDB;
        this.prototypes = new Hashtable<String, Item>();
        // instantiation of class
        // do we have to return object db?
    }

    public CreationService(ObjectDB objectDB, Hashtable<String, Item> prototypes) {
        this.objectDB = objectDB;
        this.prototypes = prototypes;
    }

    public Creature createCreature() {
        final Creature cre = new Creature();

        cre.setFlags(EnumSet.noneOf(ObjectFlag.class));
        cre.setLocation(Constants.VOID);

        objectDB.addAsNew(cre);
        objectDB.addCreature(cre);

        return cre;
    }

    /**
     * create a new basic, untyped Item for us to modify and work on
     *
     * @return
     */
    private Item createItem() {
        final Item item = new Item(-1);

        item.setName("");
        item.setFlags(EnumSet.noneOf(ObjectFlag.class));
        item.setDesc("");
        item.setLocation(-1);

        // TODO remember to make the created items get passed through init
        // objectDB.addAsNew(item);
        // objectDB.addItem(item);

        return item;
    }

    public Item createItem(String name, String description, int location) {
        final Item item = new Item(-1);

        item.setName(name);
        item.setFlags(EnumSet.noneOf(ObjectFlag.class));
        item.setDesc(description);
        item.setLocation(location);

        return item;
    }

    /**
     * Create an Item based on an existing prototype, identified by a string.
     *
     * @param prototype
     * @return
     */
    public Item createItem(final String prototype) {
        return createItem(prototype, true);
    }

    /**
     * Create an Item based on an existing prototype, identified by a string.
     *
     * @param prototype id of an existing prototype
     * @param init      should we initialize this item (add to database)
     * @return
     */
    public Item createItem(final String prototype, final boolean init) {
        final Item template = prototypes.get(prototype);

        if (template != null) {
            final Item newItem = template.getCopy();

            if (init) {
                objectDB.addAsNew(newItem);
                objectDB.addItem(newItem);
            }

            return newItem;
        }
        else {
            System.out.println("ERROR: null template?!");
        }

        return null;
    }

    /**
     * Create new items using an existing item as a template. More or less a
     * means to make multiple copies of an item
     *
     * <br />
     * <br />
     *
     * <b>NOTE:</b> internal use only
     *
     * @param template the item to base the new ones on
     * @param numItems how many new items to make.
     * @return         the new items we just created
     */
    private ArrayList<Item> createItems(final Weapon template, final Integer numItems) {
        ArrayList<Item> items = new ArrayList<Item>(numItems);

        for (int i = 0; i < numItems; i++) {
            final Weapon item = template.getCopy();
            items.add(item);
            initCreatedItem(item);
        }

        return items;
    }

    private ArrayList<Item> createItems(final Book template, final Integer numItems) {
        final ArrayList<Item> items = new ArrayList<Item>(numItems);

        for (int i = 0; i < numItems; i++) {
            final Book book = template.getCopy();
            items.add(book);
            initCreatedItem(book);
        }

        return items;
    }

    private ArrayList<Item> createItems(final Armor template, final Integer numItems) {
        final ArrayList<Item> items = new ArrayList<Item>(numItems);

        for (int i = 0; i < numItems; i++) {
            final Armor armor = template.getCopy();
            items.add(armor);
            initCreatedItem(armor);
        }

        return items;
    }

    private void initCreatedItem(final Item item) {
        this.objectDB.addAsNew(item);
        this.objectDB.addItem(item);
    }


}
