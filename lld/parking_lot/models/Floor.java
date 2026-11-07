package SystemDesignRoadmap.lld.parking_lot.models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private List<Section> sections;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.sections = new ArrayList<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }
}
