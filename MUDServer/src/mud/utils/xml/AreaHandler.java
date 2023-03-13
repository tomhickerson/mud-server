package mud.utils.xml;

import java.util.ArrayList;
import java.util.List;

import mud.misc.Zone;
import mud.objects.Exit;
import mud.objects.Room;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AreaHandler extends DefaultHandler {
    private List<Room> areList = null;
    private List<Exit> exitList = null;
    private Room area = null;
    private Exit areaExit = null;
    private Zone areaZone = null;
    private StringBuilder data = null;

    public List<Room> getAreaList() {
        return areList;
    }

    public Zone getAreaZone() {
        return areaZone;
    }

    boolean bId = false;
    boolean bZoneName = false;
    boolean bTitle = false;
    boolean bDescription = false;
    boolean inExits = false;
    boolean bDirection = false;
    boolean bDestination = false;

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
            // set boolean values for fields, will be used in setting Employee variables
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
        } else if (qName.equalsIgnoreCase("REXIT")) {
            areaExit = new Exit();
        } else if (qName.equalsIgnoreCase("XDIRE")) {
            bDirection = true;
        } else if (qName.equalsIgnoreCase("XDOOR")) {
            bDestination = true;
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
            // set more detail here
            // area.setDescription(data.toString());
            bDescription = false;
        } else if (bDirection) {
            areaExit.setLocation(Integer.parseInt(data.toString()));
            // areaExit.setDirection(Integer.parseInt(data.toString()));
            bDirection = false;
        } else if (bDestination) {
            // hmm so we need to pull out the other room as the destination
            // areaExit.setDestination(data.toString());
            bDestination = false;
        }

        if (qName.equalsIgnoreCase("AROOM")) {
            // add Employee object to list
            areList.add(area);
        }

        if (qName.equalsIgnoreCase("REXIT")) {
            // exitList.add(areaExit);
            area.addExit(areaExit);
        }

        if (qName.equalsIgnoreCase("ROOMEXITS")) {
            area.setExits(exitList);
            inExits = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}

