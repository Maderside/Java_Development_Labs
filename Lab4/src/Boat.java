/**
 * Class Boat is used to describe a boat instance with 5 characteristics
 */
public class Boat {
    private String name;
    private final float length;
    private final float mass;
    private final int crewCapacity;     //The max capacity of the crew
    private final boolean hasCabins;    //True, if a boat has a cabin rooms for the crew

    public Boat(String name, float length, float mass, int crewCapacity, boolean hasCabins){
        this.name = name;
        this.length = length;
        this.mass = mass;
        this.crewCapacity = crewCapacity;
        this.hasCabins = hasCabins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.contains(" ") && !name.isEmpty()){
            this.name = name;
        }
        else {
            throw  new IllegalArgumentException("Parameter must be a word");
        }
    }

    public float getLength() {
        return length;
    }

    public float getMass() {
        return mass;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public boolean hasCabins(){
        return hasCabins;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", mass=" + mass +
                ", crewCapacity=" + crewCapacity +
                ", hasCabins=" + hasCabins +
                '}';
    }
}
