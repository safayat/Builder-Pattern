/**
 * Created by safayat on 11/22/16.
 */
class Building {
    //Walls, Doors, Windows, Floors, Rooms
    private String walls;
    private String Doors;
    private String Floors;
    private String Rooms;

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public String getDoors() {
        return Doors;
    }

    public void setDoors(String doors) {
        Doors = doors;
    }

    public String getFloors() {
        return Floors;
    }

    public void setFloors(String floors) {
        Floors = floors;
    }

    public String getRooms() {
        return Rooms;
    }

    public void setRooms(String rooms) {
        Rooms = rooms;
    }

    @Override
    public String toString() {
        return "Building{" +
                "walls='" + walls + '\'' +
                ", Doors='" + Doors + '\'' +
                ", Floors='" + Floors + '\'' +
                ", Rooms='" + Rooms + '\'' +
                '}';
    }
}

abstract class BuildingBuilder {
    protected Building building;

    public Building getBuilding() { return building; }
    public void createNewBuilding() { building = new Building(); }

    public abstract void buildWalls();
    public abstract void buildDoors();
    public abstract void buildFloors();
    public abstract void buildRooms();
}

class ConcreteGlassBuildingBuilder extends BuildingBuilder {

    @Override
    public void buildWalls() {
        building.setWalls("glass wall");
    }

    @Override
    public void buildDoors() {
        building.setDoors("glass door");
    }

    @Override
    public void buildFloors() {
        building.setFloors("glass floor");

    }

    @Override
    public void buildRooms() {
        building.setRooms("glass room");
    }
}

class ConcreteBrickHouseBuilder extends BuildingBuilder {

    @Override
    public void buildWalls() {
        building.setWalls("brick walls");
    }

    @Override
    public void buildDoors() {
        building.setDoors("brick door");
    }

    @Override
    public void buildFloors() {
        building.setFloors("brick floor");

    }

    @Override
    public void buildRooms() {
        building.setRooms("brick room");
    }
}

class BuildingDirector {
    private BuildingBuilder buildingBuilder;

    public void setBuildingBuilder(BuildingBuilder pb) { buildingBuilder = pb; }
    public Building getBuilding() { return buildingBuilder.getBuilding(); }

    public void constructBuilding() {
        buildingBuilder.createNewBuilding();
        buildingBuilder.buildWalls();
        buildingBuilder.buildFloors();
        buildingBuilder.buildDoors();
        buildingBuilder.buildRooms();
    }
}

public class BuilderExample {
    public static void main(String[] args) {

        BuildingDirector buildingDirector = new BuildingDirector();
        BuildingBuilder concreteBrickHouseBuilder = new ConcreteBrickHouseBuilder();
        buildingDirector.setBuildingBuilder(concreteBrickHouseBuilder);
        buildingDirector.constructBuilding();
        Building brick_building = buildingDirector.getBuilding();
        System.out.println(brick_building);

        BuildingBuilder  concreteGlassBuildingBuilder = new ConcreteGlassBuildingBuilder();
        buildingDirector.setBuildingBuilder(concreteGlassBuildingBuilder);
        buildingDirector.constructBuilding();
        Building glass_building = buildingDirector.getBuilding();
        System.out.println(glass_building);
    }
}
