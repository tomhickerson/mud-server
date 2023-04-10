package mud.utils.xml;

import java.util.ArrayList;
import java.util.List;

import mud.misc.Zone;
import mud.objects.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AreaHandler extends DefaultHandler {
    private List<Room> areList = null;
    private List<Exit> exitList = null;
    private List<Creature> mobList = null;
    private Room area = null;
    private Exit areaExit = null;
    private Zone areaZone = null;
    private StringBuilder data = null;
    private Creature mob = null;
    private Thing thing = null;
    private Item item = null;

    public List<Room> getAreaList() {
        return areList;
    }

    public List<Exit> getExitList() {
        return exitList;
    }

    public List<Creature> getMobList() { return mobList; }

    public Zone getAreaZone() {
        return areaZone;
    }

    boolean bId = false;
    boolean bZoneName = false;
    boolean bTitle = false;
    boolean bDescription = false;
    boolean inExits = false;
    boolean inMobs = false;
    boolean inMobText = false;
    boolean bDirection = false;
    boolean bDestination = false;
    boolean bInven = false;
    boolean bItem = false;
    boolean bItemData = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("AROOM")) {
            // create a new Area and put it in Map

            // initialize object
            area = new Room();
            areaZone = new Zone("Blank", null);

            // initialize list
            if (areList == null)
                areList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("ROOMID")) {
            // set boolean values for fields, will be used in setting variables
            bId = true;
        } else if (qName.equalsIgnoreCase("RAREA")) {
            bZoneName = true;
        } else if (qName.equalsIgnoreCase("RDISP")) {
            bTitle = true;
        } else if (qName.equalsIgnoreCase("RDESC")) {
            bDescription = true;
        } else if (qName.equalsIgnoreCase("ROOMEXITS")) {
            // initialize list of exits

            exitList = new ArrayList<>();
            inExits = true;
        } else if (qName.equalsIgnoreCase("ROOMMOBS")) {
            // initiate list of monsters
            inMobs = true;
            mobList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("RMOB")) {
            mob = new Creature();
        } else if (qName.equalsIgnoreCase("REXIT")) {
            areaExit = new Exit();
        } else if (qName.equalsIgnoreCase("XDIRE")) {
            bDirection = true;
        } else if (qName.equalsIgnoreCase("XDOOR")) {
            bDestination = true;
        } else if (qName.equalsIgnoreCase("MTEXT")) {
            inMobText = true;
        } else if (qName.equalsIgnoreCase("INVEN")) {
            bInven = true;
        } else if (qName.equalsIgnoreCase("ITEM")) {
            bItem = true;
            item = new Item("", "");
        } else if (qName.equalsIgnoreCase("IDATA")) {
            bItemData = true;
        }
        // create the data container
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bId) {
            area.setName(data.toString());
            // area.setId(data.toString());
            bId = false;
        } else if (bZoneName) {
            areaZone.setName(data.toString());
            area.setZone(areaZone);
            // area.setZoneName(data.toString());
            bZoneName = false;
        } else if (bTitle) {
            area.setDesc(data.toString());
            // area.setTitle(data.toString());
            bTitle = false;
        } else if (bDescription) {
            area.setLongDescription(data.toString());
            // set more detail here
            // area.setDescription(data.toString());
            bDescription = false;
        } else if (bDirection) {
            // areaExit.setLocation(Integer.parseInt(data.toString()));
            // so you actually need to set the name here
            // areaExit.setDirection(Integer.parseInt(data.toString()));
            Integer direction = Integer.parseInt(data.toString());
            areaExit.setName(getExitName(direction));
            bDirection = false;
        } else if (bDestination) {
            // so we set the origin and the destination here
            areaExit.setDestinationFlag(data.toString());
            areaExit.setOriginFlag(area.getName());
            bDestination = false;
        }

        if (qName.equalsIgnoreCase("AROOM")) {
            // add Room object to list
            areList.add(area);
            areaZone.addRoom(area);
        }

        if (qName.equalsIgnoreCase("REXIT")) {
            // exitList.add(areaExit);
            area.addExit(areaExit);
            // note: avoid duplicates
            exitList.add(areaExit);
        }

        if (qName.equalsIgnoreCase("ROOMEXITS")) {
            area.setExits(exitList);
            inExits = false;
        }

        if (qName.equalsIgnoreCase("ROOMMOBS")) {
            mob.setTextLocation(area.getName());
            inMobs = false;
        }

        if (qName.equalsIgnoreCase("RMOB")) {
            mobList.add(mob);
            areaZone.addMob(mob);
        }

        if (qName.equalsIgnoreCase("MLEVL")) {
            mob.setLevel(Integer.parseInt(data.toString()));
        }

        if (qName.equalsIgnoreCase("MTEXT")) {
            inMobText = false;
        }

        if (inMobs && inMobText && qName.equalsIgnoreCase("NAME")) {
            mob.setName(data.toString());
        }

        if (inMobs && inMobText && qName.equalsIgnoreCase("DESC")) {
            mob.setDesc(data.toString());
        }

        if (inMobs && inMobText && qName.equalsIgnoreCase("DISP")) {
            mob.setDisplay(data.toString());
        }

        if (inMobText && inMobs && qName.equalsIgnoreCase("MONEY")) {
            mob.setProperty("gold", data.toString());
        }

        if (inMobs && inMobText && qName.equalsIgnoreCase("INVEN")) {
            bInven = false;
        }

        if (bInven && qName.equalsIgnoreCase("ITEM")) {
            mob.addItem(item);
            //make sure to add name and desc first
            bItem = false;
        }

        if (bInven && qName.equalsIgnoreCase("ICLASS")) {
            item.setItemType(getItemType(data.toString()));
        }

        if (bInven && qName.equalsIgnoreCase("IDATA")) {
            bItemData = false;
        }

        if (bItemData && qName.equalsIgnoreCase("NAME")) {
            item.setName(data.toString());
        }

        if (bItemData && qName.equalsIgnoreCase("DISP")) {
            item.setDesc(data.toString());
            // is it description or display?
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    private ItemType getItemType(String type) {
        switch (type) {
            case "GenArmor":
                return ItemTypes.ARMOR;
                // to be updated
            case "GenFood":
                return ItemTypes.FOOD;
            case "GenDrink":
                return ItemTypes.DRINK;
            case "GenPotion":
                return ItemTypes.POTION;
            case "GenContainer":
                return ItemTypes.CONTAINER;
            case "GenWand":
                return ItemTypes.WAND;
            case "GenWeapon":
                return ItemTypes.WEAPON;
        }
        return ItemTypes.NONE;
    }

    private String getExitName(Integer dir) {
        switch (dir) {
            case 0:
                return "north";
            case 1:
                return "south";
            case 2:
                return "east";
            case 3:
                return "west";
            case 4:
                return "up";
            case 5:
                return "down";
            case 6:
                return "gate";
            case 7:
                return "northwest";
            case 8:
                return "northeast";
            case 9:
                return "southwest";
            case 10:
                return "southeast";
        }
        return "";
    }
}

